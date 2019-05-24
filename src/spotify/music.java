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
    String songTitleRewritten;
    TracksList TracksList;
    public void rewriteSongTitle(){
        songTitleRewritten = songTitle.replaceAll("\\s+", "%20");
    }

    public void searchForSong(){
        JsonClient client = new JsonClient();
        Disposable disposable = client.getTracksList(songTitle)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(new Consumer<TracksList>() {
                    @Override
                    public void accept(TracksList tracks) throws Exception {

                        TracksList = tracks;

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
            rewriteSongTitle();
            searchForSong();


        });



        root.add(search, BorderLayout.NORTH);
        setContentPane(root);

    }
    public static void main(String[] args) throws MalformedURLException {
        new music().setVisible(true);
    }}
