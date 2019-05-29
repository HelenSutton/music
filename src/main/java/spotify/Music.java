package spotify;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Objects;

public class Music extends JFrame{
    MusicComponent musicComponent = new MusicComponent();
    SpotifyClient client = new SpotifyClient();
    JPanel root = new JPanel();

    DecimalFormat df = new DecimalFormat("###.##");

    public void displayFeatures(Audio songAudio){
        musicComponent.setAudio(songAudio);
    }

    public void searchForSong(String songTitle){
        Disposable disposable = client.getSpotifySearchResponse(songTitle)
                .map(response -> response.getFirstSongId())
                .flatMap( songId -> client.getAudio(songId))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(this::displayFeatures);
    }

    public Music (){
        setTitle("Music");
        setSize(900, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setLayout(new BorderLayout());
        JPanel search = new JPanel();
        JLabel enterSong = new JLabel ("Enter a song title:");
        search.add(enterSong);
        JTextField searchSong = new JTextField(12);
        search.add(searchSong);
        searchSong.addActionListener(e->{
            String songTitle = searchSong.getText();
            searchForSong(songTitle);
        });
        JButton searchButton = new JButton("Search");
        search.add(searchButton);
        searchButton.addActionListener(e->{
            String songTitle = searchSong.getText();
            searchForSong(songTitle);
        });

root.add(musicComponent, BorderLayout.CENTER);
        root.add(search, BorderLayout.NORTH);
        setContentPane(root);

    }
    public static void main(String[] args) {
        new Music().setVisible(true);
    }}
