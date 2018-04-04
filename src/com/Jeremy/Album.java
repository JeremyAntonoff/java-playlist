package com.Jeremy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String album;
    private LinkedList<Song> songs = new LinkedList<Song>();

    public Album(String album) {
        this.album = album;


    }

    public void addSong(String name, double duration) {
        ListIterator<Song> listIterator = songs.listIterator();
        Boolean foundSong = this.findSong(name);
        if (!foundSong) {
            songs.add(new Song(name, duration));
        } else {
            System.out.println("Song " + name + " already exists");

        }

    }

    public boolean findSong(String song) {
        for (int i =0; i < songs.size(); i++) {
            Song currentSong = songs.get(i);
            if (currentSong.getName().equals(song)) {
                return true;
            }
        }
        return false;


    }

    public Song getSong(String song) {
        for (int i=0; i < songs.size(); i++) {
            if (songs.get(i).getName().equals(song)) {
                return songs.get(i);
            }
        }
        return null;
    }

    public void listSongs() {
        for (int i=0; i<songs.size(); i++) {
            System.out.println((i + 1) +"." + " " + songs.get(i).getName() + " - " + songs.get(i).getDuration());
        }
    }

    public String getAlbum() {
        return album;
    }
}
