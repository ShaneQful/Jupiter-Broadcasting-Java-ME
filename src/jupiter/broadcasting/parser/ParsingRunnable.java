/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jupiter.broadcasting.parser;

import jupiter.broadcasting.JupiterMIDlet;

/*
 * Copyright (c) 2012 Shane Quigley
 *
 * This software is MIT licensed see link for details
 * http://www.opensource.org/licenses/MIT
 * 
 * @author Shane Quigley
 */
public class ParsingRunnable implements Runnable{
    private JupiterMIDlet toModify;
    private SaxRssParser parser;
    private String feed;
    public ParsingRunnable(JupiterMIDlet t,SaxRssParser p,String f) {
        toModify = t;
        parser = p;
        feed = f;        
    }
    
    public void run() {
        toModify.parseAndDisplayFeed(parser, feed);
    }
    
}
