package com.Jeremy;

import java.util.Scanner;

public class Main {
        private static MusicPlayer musicPlayer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose music Player Name");
        String musicPlayerName = scanner.nextLine();
        musicPlayer = new MusicPlayer(musicPlayerName);
        printMenu();
        chooseOptions();

    }


    public static void chooseOptions() {
        Scanner scanner = new Scanner(System.in);
        switch(scanner.nextInt()) {
            case 1:
                addAlbum();
                break;
            case 2:
                addSong();
                break;
            case 3:
                addSongToPlaylist();
                break;
            case 4:
                listAlbums();
                break;
            case 5:
                listSongs();
                break;
            case 6:
                printPlaylistMenu();
                choosePlaylistOptions();


        }
    }

    public static void addAlbum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an album name");
        String album = scanner.nextLine();
        musicPlayer.addAlbum(album);
        printMenu();
        chooseOptions();
    }

    public static void addSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a Album");
        String albumName = scanner.nextLine();
        System.out.println("Please Enter a song...");
        String songName = scanner.nextLine();
        System.out.println("Please Enter a Duration (ex: 4.50)");
        Double duration = scanner.nextDouble();
        int foundAlbum = findAlbum(albumName);
        if (foundAlbum > -1) {
            musicPlayer.addSongToAlbum(albumName, songName, duration);
        } else {
            System.out.println("Album " + albumName + " could not be found");

        }

        printMenu();
        chooseOptions();
    }

    public static int findAlbum(String album) {
        return musicPlayer.findAlbum(album);
    }

    public static void listAlbums() {
        System.out.println("Listing Albums...");
        musicPlayer.listAlbums();
        printMenu();
        chooseOptions();
    }

    public static void listSongs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a album name to get a list of songs");
        String album = scanner.nextLine();
        musicPlayer.listSongs(album);
        printMenu();
        chooseOptions();
    }

    public static void addSongToPlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an existing album");
        String album = scanner.nextLine();
        System.out.println("Please enter an existing song");
        String song = scanner.nextLine();
        musicPlayer.addSongToPlaylist(album, song);
        printMenu();
        chooseOptions();
    }

    public static void viewPlaylistSongs() {
        musicPlayer.listPlaylistSongs();
        printPlaylistMenu();
        choosePlaylistOptions();
    }

    public static void playSong() {
        musicPlayer.playSong();
        printPlaylistMenu();
        choosePlaylistOptions();
    }


    public static void printMenu() {
        System.out.println("==========================");
        System.out.println("Choose An option:");
        System.out.println("1. Add an album");
        System.out.println("2. Add a song to an Album");
        System.out.println("3. Add a song to a playlist");
        System.out.println("4. List Albums");
        System.out.println("5. List Songs");
        System.out.println("6. View and Control Playlist");
        System.out.println("==========================");

    }

    public static void printPlaylistMenu() {
        System.out.println("==========================");
        System.out.println("Playlist Menu:");
        System.out.println("1. View Songs in playlist");
        System.out.println("2. View Playlist controls");
        System.out.println("3. View main menu");
        System.out.println("==========================");
    }

    public static void choosePlaylistOptions() {
        Scanner scanner = new Scanner(System.in);
        switch(scanner.nextInt()) {
            case 1:
                viewPlaylistSongs();
                break;
            case 2:
                playSong();
                break;
            case 3:
                printMenu();
                chooseOptions();
        }
    }
}
