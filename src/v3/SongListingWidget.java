package lec18.v3;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * A JPanel that displays and manages
 *     a single song in a playlist
 */
class SongListingWidget extends JPanel {
	// Encapsulates a playlist
	private Playlist plist;
	
	// Encapsulates an index representing
	//     which song to display
	private int index;
	
	// Constructor
	public SongListingWidget(Playlist plist, int index) {
		// Initialize instance variables
		this.plist = plist;
		this.index = index;

		// Define how the JPanel looks
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new BorderLayout());
		
		// Add the song string to the JPanel
		String song_string = plist.getSong(index).toString();
		JLabel slabel = new JLabel(song_string); 
		add(slabel, BorderLayout.CENTER);
		
		// Make another JPanel to store buttons
		JPanel button_panel = new JPanel();
		
		// Remove button
		JButton remove_button = new JButton("X");
		button_panel.add(remove_button);
		
		// Up button
		JButton up_button = new JButton("\u25b2");
		button_panel.add(up_button);
		
		// Down button
		JButton down_button = new JButton("\u25bc");
		button_panel.add(down_button);

		// Add the button panel to the JPanel
		add(button_panel, BorderLayout.WEST);
	}
}
