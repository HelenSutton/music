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
    SpotifyClient client = new SpotifyClient();
    JTextArea textArea = new JTextArea();
    Audio songAudio;
    JPanel root = new JPanel();
    String[] pitch ={"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};

    DecimalFormat df = new DecimalFormat("###.##");

    public void displayFeatures(){
        String dance = "dancebility "+df.format(songAudio.getDanceability()*100)+"%\n";
        String energy = "energy " + df.format(songAudio.getEnergy()*100)+"%\n";
        String valence = "this track is " +df.format(songAudio.getValence()*100)+"% positive\n";
        String liveness = "this track has a " +df.format(songAudio.getLiveness()*100)+"% chance of being live\n";
        String tempo = "the tempo is "+ df.format(songAudio.getTempo())+"\n";
        String mode= "the key is " + pitch[songAudio.getKey()]+" ";
        if (songAudio.getMode()==1){
            mode += "major\n";
        }
        else{
            mode+= "minor\n";
        }
        String fulltext = mode + dance + energy + valence + liveness + tempo;
        textArea.setText(fulltext);
    }


    public void getSongInfo(String songId){
        Disposable disposable = client.getAudio(songId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(audio -> {
                    songAudio = audio;
                    displayFeatures();
                });
    }


    public void searchForSong(String songTitle){
        Disposable disposable = client.getSpotifySearchResponse(songTitle)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(spotifySearchResponse -> {
                    String songId = spotifySearchResponse.getTracks().getItems().get(1).getId();
                    getSongInfo(songId);
                });
    }
    public Music (){
        setTitle("Music");
        setSize(900, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setLayout(new BorderLayout());
        JPanel search = new JPanel();
        JTextField searchSong = new JTextField(12);
        search.add(searchSong);
        JButton searchButton = new JButton("Search");
        search.add(searchButton);
        searchButton.addActionListener(e->{
                String songTitle = searchSong.getText();
                searchForSong(songTitle);
        });

        textArea.setMinimumSize(new Dimension(400, 700));
        textArea.setPreferredSize(new Dimension(400, 700));
        textArea.setMaximumSize(new Dimension(400, 700));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(UIManager.getColor("Label.background"));
        textArea.setFont(UIManager.getFont("Label.font"));
        textArea.setBorder(UIManager.getBorder("Label.border"));

        root.add(search, BorderLayout.NORTH);
        root.add(textArea, BorderLayout.CENTER);
        setContentPane(root);

    }
    public static void main(String[] args) {
        new Music().setVisible(true);
    }}
