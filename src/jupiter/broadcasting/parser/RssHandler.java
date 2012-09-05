/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jupiter.broadcasting.parser;

import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.List;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author shane
 */
public class RssHandler extends DefaultHandler{
    private Vector rssTitles;
    private Vector rssLinks;
    private boolean isLink = false;
    private boolean isTitle = false;
    
    public RssHandler() {
        rssTitles = new Vector();
        rssLinks = new Vector();
    }
           
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        isLink = qName.equalsIgnoreCase("link");
        isTitle = qName.equalsIgnoreCase("title");
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }
    
    public void characters(char ch[], int start, int length) throws SAXException {
        if (isLink) {
            rssLinks.addElement(new String(ch, start, length));
            isLink = false;
        }else if(isTitle){
            rssTitles.addElement(new String(ch, start, length));
            isTitle = false;
        }
    }
    
    public Hashtable getTable(){
        Hashtable output = new Hashtable();
        for(int i =0; i< rssTitles.size(); i++){
            output.put(rssTitles.elementAt(i), rssLinks.elementAt(i));
        }
        return output;
    }
    
    public Vector getTitles(){
        return rssTitles;
    }
}
