package com.Jeremy;

import java.util.LinkedList;
import java.util.ListIterator;

public class MusicPlayer {
    private String name;
    private LinkedList<Album> albums = new LinkedList();
    private PlayList playlist = new PlayList();

    public MusicPlayer(String name) {
        this.name = name;
    }

    public void addAlbum(String album) {
        int findExistingAlbum = findAlbum(album);
        if (findExistingAlbum == -1) {
            albums.add(new Album(album));
            System.out.println("Album has been added");

        } else {
            System.out.println("Album already exists");
        }

    }

    public void addSongToAlbum(String album, String name, double duration) {
        int albumFound = findAlbum(album);
        if (albumFound > -1) {
            albums.get(albumFound).addSong(name, duration);
        }
    }


    public int findAlbum(String album) {
        for (int i =0; i < albums.size(); i++) {
            if (albums.get(i).getAlbum().equals(album)) {
                return i;
            }
        }
        return -1;
    }

    public void listAlbums() {
        for (int i = 0; i < albums.size(); i++) {
            System.out.println(i + "." + " " + albums.get(i).getAlbum());
        }

    }

    public void addSongToPlaylist(String album, String song) {
        for (int i=0; i < albums.size(); i++) {
            if (albums.get(i).getAlbum().equals(album)) {
                if (albums.get(i).findSong(song)) {
                    Song songToBeAdded = albums.get(i).getSong(song);
                    playlist.addSong(songToBeAdded);
                    System.out.println("Song " + song + " has been added");
                } else {
                    System.out.println("Song does not exists");

                }
            } else {
                System.out.println("Album does not exists");

            }
        }
    }

    public void listSongs(String album) {
        for (int i=0; i < albums.size(); i++) {
            if (albums.get(i).getAlbum().equals(album)) {
                System.out.println("Songs for " + album + ":");
                albums.get(i).listSongs();
            }
        }
    }

    public void listPlaylistSongs() {
        System.out.println("Songs added to playlist: ");
        playlist.listSongs();
    }

    public void playSong(){
        playlist.playSong();
    }
}
