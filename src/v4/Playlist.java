package lec18.v4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import lec18.v4.Song;


/**
 * Represents an ordered playlist of Song objects
 */
public class Playlist extends Observable {
	// Encapsulates a List of Song objects
	private List<Song> songs;
	
	// Constructor
	public Playlist() {
		songs = new ArrayList<Song>();
	}
	
	// Gets the number of songs in the playlist
	public int getSize() {
		return songs.size();
	}
	
	// Gets the actual list of songs
	// Note: This method returns a duplicate of the array
	//     so that the internal one is protected
	public Song[] getSongs() {
		return songs.toArray(new Song[songs.size()]);
	}

	// Adds a song to the playlist
	public void addSong(Song s) {
		songs.add(s);
		setChanged();
		notifyObservers();
	}
	
	// Removes a song from the playlist
	public void removeSong(Song s) {
		songs.remove(s);
		setChanged();
		notifyObservers();
	}

	// Gets a song by index
	public Song getSong(int index) {
		return songs.get(index);
	}

	// Randomizes the order of the songs in the playlist
	public void shuffle() {
		Collections.shuffle(songs);
		setChanged();
		notifyObservers();
	}
	
	// Repositions a song in the playlist
	public void moveSong(int start, int end) {
		if (start < 0 || start >= songs.size()) {
			return;
		}
		if (end < 0 || end >= songs.size()) {
			return;
		}
		Song temp = songs.get(start);
		songs.set(start, songs.get(end));
		songs.set(end, temp);
		setChanged();
		notifyObservers();
	}
}
