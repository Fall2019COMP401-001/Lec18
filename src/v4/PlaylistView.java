package lec18.v4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 * A JPanel that displays and manages
 *     a Playlist object
 */
public class PlaylistView extends JPanel implements Observer, ActionListener {
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
		
		// Listen to the shuffle button
		shuffle_button.addActionListener(this);
		
		// Listen to the playlist model
		plist.addObserver(this);
	}

	// Private function to insert the
	//     songs into the GUI
	private void buildListPanel() {
		for (int i=0; i<plist.getSize(); i++) {
			SongListingWidget song_listing = new SongListingWidget(plist, i);
			list_panel.add(song_listing);
		}				
	}

	// Is executed when the user presses the
	//     shuffle button to notify the model
	@Override
	public void actionPerformed(ActionEvent arg0) {
		plist.shuffle();
	}
	
	// Is executed when the model changes
	//     and re-paints the GUI
	@Override
	public void update(Observable arg0, Object arg1) {
		list_panel.removeAll();
		buildListPanel();
		list_panel.revalidate();
	}
}
