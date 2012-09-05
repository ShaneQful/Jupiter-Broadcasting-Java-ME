package jupiter.broadcasting.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.List;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author shane
 */
public class SaxRssParser {
    private SAXParserFactory factory;
    private SAXParser saxParser;
    private RssHandler handler;
    private Vector titles;
    
    public SaxRssParser() {
        try {
            factory = SAXParserFactory.newInstance();
            saxParser = factory.newSAXParser();
            handler = new RssHandler();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
    }
    
    public Hashtable parse(String rssfeed){
        StreamConnection networkStream;
        InputStream inputStream;
        try {
            networkStream = (StreamConnection) Connector.open(rssfeed);        
            inputStream = networkStream.openInputStream();
            InputSource feedSource = new InputSource(inputStream);
            saxParser.parse(feedSource, (DefaultHandler) handler);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SAXException ex){
            ex.printStackTrace();
        }
        titles = handler.getTitles();
        return handler.getTable();
    }
    
    public Vector getTitles(){
        return titles;
    }
    
}
