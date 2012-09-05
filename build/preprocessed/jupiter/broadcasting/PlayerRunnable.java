/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jupiter.broadcasting;

import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/**
 *
 * @author shane
 */
public class PlayerRunnable implements Runnable{
    private Player player;
    private boolean isReady;
    private StreamConnection networkStream;
    public void run() {
        try {
            networkStream = (StreamConnection) Connector.open("http://jbradio.out.airtime.pro:8000/jbradio_b");
            player = Manager.createPlayer(networkStream.openInputStream(),"audio/mpeg");
            player.realize();
            player.prefetch();
            isReady = true;
        } catch (IOException e) {
            e.printStackTrace();
            try {
                networkStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (MediaException e) {
            e.printStackTrace();
            try {
                networkStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean isReady(){
        return isReady;
    }
    
    public Player getPlayer(){
        return player;
    }
    
}
