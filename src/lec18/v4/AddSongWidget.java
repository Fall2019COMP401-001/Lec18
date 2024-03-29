package lec18.v4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;


/**
 * A JPanel that displays and manages
 *     a widget to add a song
 */
public class AddSongWidget extends JPanel implements ActionListener {
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
		
		// Listen to the add song button
		add_song_button.addActionListener(this);
	}

	// Is executed when the user presses the
	//     add song button to add the
	//     new song to the playlist
	@Override
	public void actionPerformed(ActionEvent e) {
		// Pull the new song data from the UI
		String song_name = song_field.getText();
		String artist_name = artist_field.getText();
		int rating = rating_slider.getValue();
		
		// Create the song and add it
		Song song_to_add = new Song(song_name, artist_name, rating);
		plist.addSong(song_to_add);
		
		// Clear the add song form
		song_field.setText("");
		artist_field.setText("");
		rating_slider.setValue(0);
	}
}
