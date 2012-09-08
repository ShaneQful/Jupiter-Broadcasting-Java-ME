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
import jupiter.broadcasting.parser.ParsingRunnable;
import jupiter.broadcasting.parser.RssHandler;
import jupiter.broadcasting.parser.SaxRssParser;
import org.netbeans.microedition.lcdui.SplashScreen;
import org.netbeans.microedition.lcdui.pda.FileBrowser;

/**
 * @author shane
 */
public class JupiterMIDlet extends MIDlet implements CommandListener {
    
    private boolean midletPaused = false;
    Player player;
    Hashtable rssTable;
    Hashtable showToFeedTable;
    String FEEDSTATUS = "Youtube Feed";
//<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command backCommand;
    private SplashScreen splashScreen;
    private List list;
    private List episodeList;
    private FileBrowser fileBrowser;
    private List showList;
    private Image image1;
//</editor-fold>//GEN-END:|fields|0|

    /**
     * The JupiterMIDlet constructor.
     */
    public JupiterMIDlet() {
        showToFeedTable = new Hashtable();
        //Second Feed burner call breaks app
        //Should really be doing the networking in a separate thread 
        //but this still shouldn't be occuring debug in morning
        showToFeedTable.put("Youtube Feed", "http://www.youtube.com/rss/user/JupiterBroadcasting/videos.rss");
        showToFeedTable.put("All Shows", "http://feeds.feedburner.com/JupiterBroadcasting");
        showToFeedTable.put("Coder Radio", "http://feeds.feedburner.com/coderradiomp3");
        showToFeedTable.put("Faux Show", "http://www.jupiterbroadcasting.com/feeds/FauxShowMP3.xml");
        showToFeedTable.put("Linux Action Show", "http://feeds.feedburner.com/TheLinuxActionShow");
        showToFeedTable.put("SciByte", "http://feeds.feedburner.com/scibyteaudio");
        showToFeedTable.put("Techsnap", "http://feeds.feedburner.com/techsnapmp3");
        showToFeedTable.put("Unfilter", "http://www.jupiterbroadcasting.com/feeds/unfilterMP3.xml");
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
        if (displayable == episodeList) {//GEN-BEGIN:|7-commandAction|1|56-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|56-preAction
                // write pre-action user code here
                episodeListAction();//GEN-LINE:|7-commandAction|2|56-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|3|65-preAction
                // write pre-action user code here
                isYoutube();//GEN-LINE:|7-commandAction|4|65-postAction
                // write post-action user code here
                episodeList = null;//This isn't effiecient but will do for the moment
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|5|121-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|6|121-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|78-preAction
        } else if (displayable == fileBrowser) {
            if (command == FileBrowser.SELECT_FILE_COMMAND) {//GEN-END:|7-commandAction|7|78-preAction
                // write pre-action user code here
                try {
                    Player player = Manager.createPlayer(fileBrowser.getSelectedFileURL());
                    player.start();
                }catch(IOException ioe) {
                    ioe.printStackTrace();
                } 
                catch(MediaException e) {
                    e.printStackTrace();
                }
//GEN-LINE:|7-commandAction|8|78-postAction
                
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|9|81-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|10|81-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|11|82-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|12|82-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|40-preAction
        } else if (displayable == list) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|13|40-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|14|40-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|15|48-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|16|48-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|92-preAction
        } else if (displayable == showList) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|17|92-preAction
                // write pre-action user code here
                showListAction();//GEN-LINE:|7-commandAction|18|92-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|19|108-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|20|108-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|21|111-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|22|111-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|23|24-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|23|24-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|24|24-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|25|7-postCommandAction
        }//GEN-END:|7-commandAction|25|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|26|
//</editor-fold>//GEN-END:|7-commandAction|26|




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
            list.append("Youtube Feed", null);
            list.append("Mp3 Feeds", null);
            list.append("Donate", null);
            list.addCommand(getExitCommand());
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
        String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-BEGIN:|38-action|1|43-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Youtube Feed")) {//GEN-END:|38-action|1|43-preAction
                // write pre-action user code here
                FEEDSTATUS = __selectedString;
                switchDisplayable(null, getEpisodeList());//GEN-LINE:|38-action|2|43-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Mp3 Feeds")) {//GEN-LINE:|38-action|3|71-preAction
                // write pre-action user code here
                switchDisplayable(null, getShowList());//GEN-LINE:|38-action|4|71-postAction
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





//<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initialized instance of exitCommand component.
     *
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|47-getter|1|47-postInit
            // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return exitCommand;
    }
//</editor-fold>//GEN-END:|47-getter|2|



//<editor-fold defaultstate="collapsed" desc=" Generated Getter: episodeList ">//GEN-BEGIN:|55-getter|0|55-preInit
    /**
     * Returns an initialized instance of episodeList component.
     *
     * @return the initialized component instance
     */
    public List getEpisodeList() {
        if (episodeList == null) {//GEN-END:|55-getter|0|55-preInit
            // write pre-init user code here
            episodeList = new List("Shows", Choice.IMPLICIT);//GEN-BEGIN:|55-getter|1|55-postInit
            episodeList.addCommand(getBackCommand());
            episodeList.addCommand(getExitCommand());
            episodeList.setCommandListener(this);
            episodeList.setSelectedFlags(new boolean[]{});//GEN-END:|55-getter|1|55-postInit
            SaxRssParser parser = new SaxRssParser();
            String feedUrl = (String)showToFeedTable.get(FEEDSTATUS);
            RssHandler customhandler = new RssHandler("title", "enclosure", 15);
            if(FEEDSTATUS.equalsIgnoreCase("Youtube Feed")){
                System.out.println("@@@@@@@@@@@@@@ Youtuebe feed called ");
                customhandler = new RssHandler();
            }
            System.out.println(FEEDSTATUS);
            System.out.println(feedUrl);            
            parser.setRssHadler(customhandler);
            Runnable runable = new ParsingRunnable(this, parser, feedUrl);
            Thread t = new Thread(runable);
            t.start();
        }//GEN-BEGIN:|55-getter|2|
        return episodeList;
    }
//</editor-fold>//GEN-END:|55-getter|2|

    public void parseAndDisplayFeed(SaxRssParser parser,String feed){
        episodeList.append("Loading ...", null);
        rssTable = parser.parse(feed);
        episodeList.delete(0);
        for(int i =0;i < parser.getTitles().size();i++){
            episodeList.append((String)parser.getTitles().elementAt(i), null);
        }
    }
//<editor-fold defaultstate="collapsed" desc=" Generated Method: episodeListAction ">//GEN-BEGIN:|55-action|0|55-preAction

    /**
     * Performs an action assigned to the selected list element in the
     * episodeList component.
     */
    public void episodeListAction() {//GEN-END:|55-action|0|55-preAction
        // enter pre-action user code here
        String __selectedString = getEpisodeList().getString(getEpisodeList().getSelectedIndex());//GEN-LINE:|55-action|1|55-postAction
        if(rssTable.containsKey(__selectedString)){
            try {
                this.platformRequest((String)rssTable.get(__selectedString));
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





//<editor-fold defaultstate="collapsed" desc=" Generated Getter: fileBrowser ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initialized instance of fileBrowser component.
     *
     * @return the initialized component instance
     */
    public FileBrowser getFileBrowser() {
        if (fileBrowser == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            fileBrowser = new FileBrowser(getDisplay());//GEN-BEGIN:|76-getter|1|76-postInit
            fileBrowser.setTitle("File Browser");
            fileBrowser.setCommandListener(this);
            fileBrowser.addCommand(getBackCommand());
            fileBrowser.addCommand(FileBrowser.SELECT_FILE_COMMAND);
            fileBrowser.addCommand(getExitCommand());//GEN-END:|76-getter|1|76-postInit
            // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return fileBrowser;
    }
//</editor-fold>//GEN-END:|76-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Getter: showList ">//GEN-BEGIN:|91-getter|0|91-preInit
    /**
     * Returns an initialized instance of showList component.
     *
     * @return the initialized component instance
     */
    public List getShowList() {
        if (showList == null) {//GEN-END:|91-getter|0|91-preInit
            // write pre-init user code here
            showList = new List("Shows", Choice.IMPLICIT);//GEN-BEGIN:|91-getter|1|91-postInit
            showList.append("All Shows", null);
            showList.append("Coder Radio", null);
            showList.append("Faux Show", null);
            showList.append("Linux Action Show", null);
            showList.append("SciByte", null);
            showList.append("Techsnap", null);
            showList.append("Unfilter", null);
            showList.addCommand(getBackCommand());
            showList.addCommand(getExitCommand());
            showList.setCommandListener(this);
            showList.setSelectedFlags(new boolean[]{false, false, false, false, false, false, false});//GEN-END:|91-getter|1|91-postInit
            // write post-init user code here
        }//GEN-BEGIN:|91-getter|2|
        return showList;
    }
//</editor-fold>//GEN-END:|91-getter|2|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: showListAction ">//GEN-BEGIN:|91-action|0|91-preAction
    /**
     * Performs an action assigned to the selected list element in the showList
     * component.
     */
    public void showListAction() {//GEN-END:|91-action|0|91-preAction
        FEEDSTATUS = getShowList().getString(getShowList().getSelectedIndex());
        String __selectedString = getShowList().getString(getShowList().getSelectedIndex());//GEN-BEGIN:|91-action|1|99-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("All Shows")) {//GEN-END:|91-action|1|99-preAction
                // write pre-action user code here
                switchDisplayable(null, getEpisodeList());//GEN-LINE:|91-action|2|99-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Coder Radio")) {//GEN-LINE:|91-action|3|95-preAction
                // write pre-action user code here
                switchDisplayable(null, getEpisodeList());//GEN-LINE:|91-action|4|95-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Faux Show")) {//GEN-LINE:|91-action|5|97-preAction
                // write pre-action user code here
                switchDisplayable(null, getEpisodeList());//GEN-LINE:|91-action|6|97-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Linux Action Show")) {//GEN-LINE:|91-action|7|94-preAction
                // write pre-action user code here
                switchDisplayable(null, getEpisodeList());//GEN-LINE:|91-action|8|94-postAction
                // write post-action user code here
            } else if (__selectedString.equals("SciByte")) {//GEN-LINE:|91-action|9|100-preAction
                // write pre-action user code here
                switchDisplayable(null, getEpisodeList());//GEN-LINE:|91-action|10|100-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Techsnap")) {//GEN-LINE:|91-action|11|96-preAction
                // write pre-action user code here
                switchDisplayable(null, getEpisodeList());//GEN-LINE:|91-action|12|96-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Unfilter")) {//GEN-LINE:|91-action|13|98-preAction
                // write pre-action user code here
                switchDisplayable(null, getEpisodeList());//GEN-LINE:|91-action|14|98-postAction
                // write post-action user code here
            }//GEN-BEGIN:|91-action|15|91-postAction
        }//GEN-END:|91-action|15|91-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|91-action|16|
//</editor-fold>//GEN-END:|91-action|16|

//<editor-fold defaultstate="collapsed" desc=" Generated Method: isYoutube ">//GEN-BEGIN:|112-if|0|112-preIf
    /**
     * Performs an action assigned to the isYoutube if-point.
     */
    public void isYoutube() {//GEN-END:|112-if|0|112-preIf
        // enter pre-if user code here
        if (FEEDSTATUS.equalsIgnoreCase("Youtube Feed")) {//GEN-LINE:|112-if|1|113-preAction
            // write pre-action user code here
            switchDisplayable(null, getList());//GEN-LINE:|112-if|2|113-postAction
            // write post-action user code here
        } else {//GEN-LINE:|112-if|3|114-preAction
            // write pre-action user code here
            switchDisplayable(null, getShowList());//GEN-LINE:|112-if|4|114-postAction
            // write post-action user code here
        }//GEN-LINE:|112-if|5|112-postIf
        // enter post-if user code here
    }//GEN-BEGIN:|112-if|6|
//</editor-fold>//GEN-END:|112-if|6|



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
