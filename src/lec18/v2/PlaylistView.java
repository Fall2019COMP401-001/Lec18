package lec18.v2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


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
		this.plist = plist;
		
		setLayout(new BorderLayout());

		list_panel = new JPanel();
		list_panel.setLayout(new GridLayout(0, 1));
		for (Song s : plist.getSongs()) {
			JLabel song_label = new JLabel(s.toString());
			list_panel.add(song_label);
		}
		
		add(list_panel, BorderLayout.CENTER);
	}
}
