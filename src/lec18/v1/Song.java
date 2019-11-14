package lec18.v1;


/**
 * Represents a song
 */
public class Song {
	// Encapsulates the song's title, artist, and rating
	private String title;
	private String artist;
	private int rating;
	
	// Constructor
	public Song(String title, String artist, int rating) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}
	
	// Gets the title of the song
	public String getTitle() {
		return title;
	}
	
	// Gets the artist of the song
	public String getArtist() {
		return artist;
	}
	
	// Gets the rating of the song
	public int getRating() {
		return rating;
	}
	
	// Generates a string representation of the song
	public String toString() {
		String rating_string = "";
		
		for (int i=0; i<5; i++) {
			if (rating > i) {
				rating_string += "\u2605"; // Filled star
			} else {
				rating_string += "\u2606"; // Outlined star
			}
		}
		
		return title + " by " + artist + " (" + rating_string + ")";
	}
}
