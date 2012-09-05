/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jupiter.broadcasting;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.Connector;
import javax.microedition.io.InputConnection;
import javax.microedition.io.StreamConnection;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import jupiter.broadcasting.parser.RssHandler;
import jupiter.broadcasting.parser.SaxRssParser;
import org.netbeans.microedition.lcdui.SplashScreen;

/**
 * @author shane
 */
public class JupiterMIDlet extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    Player player;
    Hashtable youtubeRSS;
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand1;
    private Command exitCommand2;
    private Command backCommand;
    private Command stopCommand;
    private SplashScreen splashScreen;
    private List list;
    private List showList;
    private Image image1;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The JupiterMIDlet constructor.
     */
    public JupiterMIDlet() {
        
    }

//<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
//</editor-fold>//GEN-END:|methods|0|
//<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initializes the application. It is called only once when the MIDlet is
     * started. The method is called before the
     * <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
//</editor-fold>//GEN-END:|0-initialize|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getSplashScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
//</editor-fold>//GEN-END:|3-startMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
//</editor-fold>//GEN-END:|4-resumeMIDlet|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The
     * <code>display</code> instance is taken from
     * <code>getDisplay</code> method. This method is used by all actions in the
     * design for switching displayable.
     *
     * @param alert the Alert which is temporarily set to the display;
     * if <code>null</code>, then <code>nextDisplayable</code> is set
     * immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
//</editor-fold>//GEN-END:|5-switchDisplayable|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a
     * particular displayable.
     *
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == list) {//GEN-BEGIN:|7-commandAction|1|40-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|40-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|2|40-postAction
                // write post-action user code here
            } else if (command == exitCommand1) {//GEN-LINE:|7-commandAction|3|48-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|4|48-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|56-preAction
        } else if (displayable == showList) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|5|56-preAction
                // write pre-action user code here
                showListAction();//GEN-LINE:|7-commandAction|6|56-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|7|65-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|8|65-postAction
                // write post-action user code here
            } else if (command == exitCommand2) {//GEN-LINE:|7-commandAction|9|60-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|10|60-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|24-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|11|24-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|12|24-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|7-postCommandAction
        }//GEN-END:|7-commandAction|13|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|14|
//</editor-fold>//GEN-END:|7-commandAction|14|




//<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initialized instance of splashScreen component.
     *
     * @return the initialized component instance
     */
    public SplashScreen getSplashScreen() {
        if (splashScreen == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|22-getter|1|22-postInit
            splashScreen.setTitle("");
            splashScreen.setCommandListener(this);
            splashScreen.setImage(getImage1());//GEN-END:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return splashScreen;
    }
//</editor-fold>//GEN-END:|22-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initialized instance of image1 component.
     *
     * @return the initialized component instance
     */
    public Image getImage1() {
        if (image1 == null) {//GEN-END:|27-getter|0|27-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|27-getter|1|27-@java.io.IOException
                image1 = Image.createImage("/jupiter_broadcasting.png");
            } catch (java.io.IOException e) {//GEN-END:|27-getter|1|27-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|27-getter|2|27-postInit
            // write post-init user code here
        }//GEN-BEGIN:|27-getter|3|
        return image1;
    }
//</editor-fold>//GEN-END:|27-getter|3|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initialized instance of list component.
     *
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            list = new List("Jupiter Broadcasting", Choice.IMPLICIT);//GEN-BEGIN:|38-getter|1|38-postInit
            list.append("Play Live Stream", null);
            list.append("Shows", null);
            list.append("Donate", null);
            list.addCommand(getExitCommand1());
            list.setCommandListener(this);
            list.setSelectedFlags(new boolean[]{false, false, false});//GEN-END:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return list;
    }
//</editor-fold>//GEN-END:|38-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|38-action|0|38-preAction
    /**
     * Performs an action assigned to the selected list element in the list
     * component.
     */
    public void listAction() {//GEN-END:|38-action|0|38-preAction
        // enter pre-action user code here
        String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-BEGIN:|38-action|1|42-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Play Live Stream")) {//GEN-END:|38-action|1|42-preAction
                // write pre-action user code here
//GEN-LINE:|38-action|2|42-postAction
                // write post-action user code here
                try{
                    String url = "http://jbradio.out.airtime.pro:8000/jbradio_b";
                    if(player == null){
                        player = Manager.createPlayer(url);
                        player.start();
                    }else{
                        player.stop();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            } else if (__selectedString.equals("Shows")) {//GEN-LINE:|38-action|3|43-preAction
                // write pre-action user code here
                switchDisplayable(null, getShowList());//GEN-LINE:|38-action|4|43-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Donate")) {//GEN-LINE:|38-action|5|45-preAction
                // write pre-action user code here
//GEN-LINE:|38-action|6|45-postAction
                try {    
                    this.platformRequest("http://www.jupiterbroadcasting.com/support-us/");
                // write post-action user code here
                }catch(ConnectionNotFoundException e){
                    System.out.println(e.getMessage());
                }
            }//GEN-BEGIN:|38-action|7|38-postAction
        }//GEN-END:|38-action|7|38-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|38-action|8|
//</editor-fold>//GEN-END:|38-action|8|


//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initialized instance of exitCommand1 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return exitCommand1;
    }
//</editor-fold>//GEN-END:|47-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand2 ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initialized instance of exitCommand2 component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand2() {
        if (exitCommand2 == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            exitCommand2 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return exitCommand2;
    }
//</editor-fold>//GEN-END:|59-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: showList ">//GEN-BEGIN:|55-getter|0|55-preInit
    /**
     * Returns an initialized instance of showList component.
     *
     * @return the initialized component instance
     */
    public List getShowList() {
        if (showList == null) {//GEN-END:|55-getter|0|55-preInit
            // write pre-init user code here
            showList = new List("Shows", Choice.IMPLICIT);//GEN-BEGIN:|55-getter|1|55-postInit
            showList.addCommand(getExitCommand2());
            showList.addCommand(getBackCommand());
            showList.setCommandListener(this);
            showList.setSelectedFlags(new boolean[]{});//GEN-END:|55-getter|1|55-postInit
            SaxRssParser parser = new SaxRssParser();
            youtubeRSS = parser.parse("http://www.youtube.com/rss/user/JupiterBroadcasting/videos.rss");
            for(int i = 2;i < parser.getTitles().size(); i++){
                showList.append((String)parser.getTitles().elementAt(i), null);
            }
        }//GEN-BEGIN:|55-getter|2|
        return showList;
    }
//</editor-fold>//GEN-END:|55-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: showListAction ">//GEN-BEGIN:|55-action|0|55-preAction
    /**
     * Performs an action assigned to the selected list element in the showList
     * component.
     */
    public void showListAction() {//GEN-END:|55-action|0|55-preAction
        // enter pre-action user code here
        String __selectedString = getShowList().getString(getShowList().getSelectedIndex());//GEN-LINE:|55-action|1|55-postAction
        if(youtubeRSS.containsKey(__selectedString)){
            try {
                this.platformRequest((String)youtubeRSS.get(__selectedString));
            } catch (ConnectionNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-BEGIN:|55-action|2|
//</editor-fold>//GEN-END:|55-action|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initialized instance of backCommand component.
     *
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return backCommand;
    }
//</editor-fold>//GEN-END:|64-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: stopCommand ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initialized instance of stopCommand component.
     *
     * @return the initialized component instance
     */
    public Command getStopCommand() {
        if (stopCommand == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            stopCommand = new Command("Stop", Command.STOP, 0);//GEN-LINE:|70-getter|1|70-postInit
            // write post-init user code here
        }//GEN-BEGIN:|70-getter|2|
        return stopCommand;
    }
//</editor-fold>//GEN-END:|70-getter|2|



    /**
     * Returns a display instance.
     *
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started. Checks whether the MIDlet have been
     * already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     *
     * @param unconditional if true, then the MIDlet has to be unconditionally
     * terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
}
