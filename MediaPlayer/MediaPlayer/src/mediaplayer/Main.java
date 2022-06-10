/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mediaplayer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author mahasiswa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        // create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        // show open file dialog
        int result = fileChooser.showOpenDialog( null );
        if ( result == JFileChooser.APPROVE_OPTION ) { // user choose a file
        URL mediaURL = null;
        try {
        // get the file as URL
        mediaURL = fileChooser.getSelectedFile().toURL();
        } catch (MalformedURLException malformedURLException) {
        System.err.println( "Could not create URL for the file" );
        }
        if ( mediaURL != null ) { // only display if there is a valid URL
        JFrame mediaTest = new JFrame( "Media Player" );
        mediaTest.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        MediaPanel mediaPanel = new MediaPanel( mediaURL );
        mediaTest.add( mediaPanel );
        mediaTest.setSize( 300, 300 );
        mediaTest.setVisible( true );
        }
       }
    }

}
