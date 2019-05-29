package spotify;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class MusicComponent extends JComponent {
    Audio songAudio;
    int width = 60;
    int fullSize = 100;
    int x = 40;
    int space = 40;
    int y = 300;
    String[] pitch ={"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
    public void setAudio(Audio audio){
        songAudio = audio;
        x = 40;
        y = 300;
        repaint();
    }
    DecimalFormat df = new DecimalFormat("###.##");
    @Override
    protected void paintComponent(Graphics graphics) {
        if(songAudio==null){
            return;
        }
        graphics.setColor(Color.cyan);
        graphics.fillRect(x,
                y - (int)(fullSize * songAudio.getDanceability()),
                width,
                (int)(fullSize*songAudio.getDanceability()));
        graphics.setFont(Font.getFont("Monospaced"));
        graphics.drawString("Danceability: "+df.format(songAudio.getDanceability()*100)+"%",x, y+30);

        x = x+width+space;
        graphics.setColor(Color.green);
        graphics.fillRect(x,
                y - (int)(fullSize * songAudio.getEnergy()),
                width,
                (int)(fullSize*songAudio.getEnergy()));
        graphics.drawString("Energy: " + df.format(songAudio.getEnergy()*100+"%"),x, y+30);

        x = x+width+space;
        graphics.setColor(Color.red);
        graphics.fillRect(x,
                y - (int)(fullSize * songAudio.getValence()),
                width,
                (int)(fullSize*songAudio.getValence()));
        graphics.drawString("Positivity: " + df.format(songAudio.getValence()*100)+"%",x, y+30);

        x = x+width+space;
        graphics.setColor(Color.pink);
        graphics.fillRect(x,
                y - (int)(fullSize * songAudio.getLiveness()),
                width,
                (int)(fullSize*songAudio.getLiveness()));
        graphics.drawString(df.format(songAudio.getLiveness()*100)+"% Live",x, y+30);

        x = 40;
        y += 60;
        int fullMilliseconds = songAudio.getDurationMs();
        int milliseconds = fullMilliseconds%1000;
        int seconds = fullMilliseconds/1000;
        int minutes = seconds/60;
        seconds = seconds%60;
        String time = "time: "+ minutes +" minutes "+ seconds + " seconds "+ milliseconds+" milliseconds";
        graphics.setColor(Color.MAGENTA);
        graphics.drawString(time,x, y);

        y+= 30;
        graphics.setColor(Color.blue);
        graphics.drawString("the key is " + pitch[songAudio.getKey()]+" ",x, y);

        y+=30;
        graphics.setColor(Color.yellow);
        graphics.drawString(df.format(songAudio.getTempo())+" BPM ",x, y);


    }


}
