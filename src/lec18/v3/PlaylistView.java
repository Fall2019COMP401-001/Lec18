package lec18.v3;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 * A JPanel that displays and manages
 *     a Playlist object
 */
public class PlaylistView extends JPanel {
	// Encapsulates a playlist
	private Playlist plist;
	
	// Encapsulates a JPanel to display the songs
	private JPanel list_panel;

	// Constructor
	public PlaylistView(Playlist plist) {
		// Store the playlist
		this.plist = plist;

		// Specify how the JPanel looks
		setLayout(new BorderLayout());
		
		// Insert the shuffle button
		JButton shuffle_button = new JButton("Shuffle");
		JPanel button_panel = new JPanel();
		button_panel.add(shuffle_button);
		add(button_panel, BorderLayout.NORTH);

		// Insert the song list
		list_panel = new JPanel();
		list_panel.setLayout(new GridLayout(0, 1));
		buildListPanel();
		add(new JScrollPane(list_panel), BorderLayout.CENTER);
		
		// Add the song widget
		AddSongWidget add_song_widget = new AddSongWidget(plist);
		add(add_song_widget, BorderLayout.SOUTH);
	}

	// Private function to insert the
	//     songs into the GUI
	private void buildListPanel() {
		for (int i=0; i<plist.getSize(); i++) {
			SongListingWidget song_listing = new SongListingWidget(plist, i);
			list_panel.add(song_listing);
		}				
	}
}
