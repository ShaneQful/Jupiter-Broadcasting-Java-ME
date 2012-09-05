package jupiter.broadcasting.parser;

import java.util.Hashtable;
import java.util.Vector;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author shane
 */
public class RssHandler extends DefaultHandler{
    private Vector rssTitles;
    private Vector rssLinks;
    private String linkString;
    private String titleString;
    private int counter = 0;
    private int maxRecords = 15;
    private boolean isLink = false;
    private boolean isTitle = false;
    private boolean ifInsideItem = false;
    
    /**
     * Constructor
     */
    public RssHandler() {
        linkString = "link";
        titleString = "title";
        rssTitles = new Vector();
        rssLinks = new Vector();
    }
    
    /**
     * Constructer that allows a little more control over parsing the feed
     * @param title
     * @param link
     * @param numberOfRecords The max number of item to be parsed.
     */
    public RssHandler(String title,String link,int numberOfRecords) {
        titleString = title;
        linkString = link;
        rssTitles = new Vector();
        rssLinks = new Vector();
        maxRecords = numberOfRecords;
    }
           
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    		if(ifInsideItem){
            isLink = qName.equalsIgnoreCase(linkString);
            isTitle = qName.equalsIgnoreCase(titleString);
        }else{
            ifInsideItem = qName.equalsIgnoreCase("item");
        }
        if(isTitle){
            if(counter > maxRecords){
                throw new SAXException("Parsing limit of "+maxRecords+" items reached");
            }
            counter++;
        }
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