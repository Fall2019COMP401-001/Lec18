package lec18.v3;

import javax.swing.JFrame;


/**
 * Displays a basic song playlist GUI
 */
public class Main {
	public static void main(String[] args) {
		// Create the main window
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Playlist View Example");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the playlist
		Playlist plist = new Playlist();
		plist.addSong(new Song("Saint Simon", "The Shins", 4));
		plist.addSong(new Song("No Sunlight", "Death Cab For Cutie", 3));
		plist.addSong(new Song("Wake Up", "Arcade Fire", 4));
		plist.addSong(new Song("Brand New Love", "Superchunk", 5));
		plist.addSong(new Song("32 Flavors", "Ani Di Franco", 2));

		// Create a PlaylistView
		PlaylistView plist_view = new PlaylistView(plist);
		
		// Add the PlaylistView to the main window
		main_frame.setContentPane(plist_view);

		// Display the main window
		main_frame.pack();
		main_frame.setVisible(true);
	}

}
