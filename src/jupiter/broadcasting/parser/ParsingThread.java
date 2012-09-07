/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jupiter.broadcasting.parser;

import jupiter.broadcasting.JupiterMIDlet;

/**
 *
 * @author shane
 */
public class ParsingThread extends Thread{
    private JupiterMIDlet toModify;
    private SaxRssParser parser;
    private String feed;
    public ParsingThread(JupiterMIDlet t,SaxRssParser p,String f) {
        toModify = t;
        parser = p;
        feed = f;        
    }
    
    public void parse(){
        toModify.parseAndDisplayFeed(parser, feed);
    }
}
