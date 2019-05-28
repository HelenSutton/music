package spotify;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class music extends JFrame{
    private String songTitle;
    //String songTitleRewritten;
    SpotifySearchResponse spotifyResponse;
    Audio songAudio;
    String songId = "3GCL1PydwsLodcpv0Ll1ch";

   // public void rewriteSongTitle(){
   //     songTitleRewritten = songTitle.replaceAll("\\s+", "%20");
   // }
//    public void getSongId(){
//        boolean flag = false;
//        int i = 0;
//        while ( i < spotifyResponse.getTracks().getItems().size() && flag == false){
//            if (spotifyResponse.getTracks().getItems().get(i).getName().toLowerCase()== songTitle.toLowerCase()&&
//                    spotifyResponse.getTracks().getItems().get(i).getType()=="track"){
//                songId =spotifyResponse.getTracks().getItems().get(i).getId();
//                System.out.println(songId);
//                flag = true;
//            }
//            i++;
//            System.out.println("not found");
//        }
//    }
    public void getSongInfo(){
        JsonClient client = new JsonClient();
        Disposable disposable = client.getAudio(songId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(new Consumer<Audio>() {
                    @Override
                    public void accept(Audio audio) throws Exception {
                        songAudio = audio;


                    }


                });
    }


    public void searchForSong(){
        JsonClient client = new JsonClient();
        Disposable disposable = client.getSpotifySearchResponse(songTitle)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(new Consumer<SpotifySearchResponse>() {
                    @Override
                    public void accept(SpotifySearchResponse spotifySearchResponse) throws Exception {
                        spotifyResponse = spotifySearchResponse;
                        System.out.println("worked");
                        // getSongId();
                        getSongInfo();


                    }


                });
    }
    public music (){
        setTitle("Music");

        setSize(900, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        JPanel search = new JPanel();
        JTextField searchSong = new JTextField(12);
        search.add(searchSong);
        JButton searchButton = new JButton("Search");
        search.add(searchButton);
        searchButton.addActionListener(e->{
                songTitle = searchSong.getText();

                searchForSong();



        });



        root.add(search, BorderLayout.NORTH);
        setContentPane(root);

    }
    public static void main(String[] args) throws MalformedURLException {
        new music().setVisible(true);
    }}
