package lec18.v3;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;


/**
 * A JPanel that displays and manages
 *     a widget to add a song
 */
public class AddSongWidget extends JPanel {
	// Encapsulates a playlist
	private Playlist plist;
	
	// Also encapsulates various UI components
	private JTextField song_field;
	private JTextField artist_field;
	private JSlider rating_slider;
	private JButton add_song_button;
	
	// Constructor
	public AddSongWidget(Playlist plist) {
		// Store the playlist
		this.plist = plist;
		
		// Song field
		song_field = new JTextField(10);
		add(new JLabel("Song: "));		
		add(song_field);
		
		// Artist field
		artist_field = new JTextField(10);
		add(new JLabel("Artist: "));
		add(artist_field);
		
		// Rating slider
		rating_slider = new JSlider(0, 5, 0);
		rating_slider.setPaintTicks(true);
		rating_slider.setSnapToTicks(true);
		rating_slider.setPaintLabels(true);
		rating_slider.setMajorTickSpacing(1);
		add(new JLabel("Rating: "));
		add(rating_slider);
		
		// Add song button
		add_song_button = new JButton("+");
		add_song_button.setActionCommand("add");
		add(add_song_button);
	}
}
