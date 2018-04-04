package com.Jeremy;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlayList {
    private String name;
    private LinkedList<Song> songs = new LinkedList();


    public void addSong(Song song) {
        boolean songExist = songExist(song.getName());
        if (!songExist) {
            songs.add(song);
        } else {
            System.out.println("Song " + song + " already exists in playlist");
        }

    }

    public boolean songExist(String song) {
        for (int i =0; i < songs.size(); i++) {
            if (songs.get(i).getName().equals(song)) {
                return true;
            }
        }
        return false;
    }

    public void listSongs() {
        ListIterator<Song> listIterator = songs.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().getName());
        }
    }

    public void displayMenu() {
        System.out.println("==========================");
        System.out.println("Playlist Controls:");
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Repeat Song");
        System.out.println("4. Quit");
        System.out.println("==========================");
    }

    public void playSong() {
        Boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        displayMenu();
        int choice = scanner.nextInt();
        Boolean forwards = true;
        ListIterator<Song> listIterator = songs.listIterator();
        while (!quit) {
            if (choice == 1) {
                if (!forwards && listIterator.hasNext()) {
                    listIterator.next();
                    forwards = true;
                } else if (!listIterator.hasNext()) {
                    System.out.println("Reached the end of the  playlist");
                    displayMenu();
                    choice = scanner.nextInt();
                } else {

                    System.out.println("Playing next song...");
                    Song currentSong = listIterator.next();
                    System.out.println(currentSong.getName() + " is now playing");
                    displayMenu();
                    choice = scanner.nextInt();
                }
            } else if (choice == 2) {
                if (forwards && listIterator.hasPrevious()) {
                    listIterator.previous();
                    forwards = false;
                } else if (!listIterator.hasPrevious()) {
                    System.out.println("Reached the beginning of the playlist");
                    displayMenu();
                    choice = scanner.nextInt();
                } else {

                    System.out.println("Playing previous song...");
                    System.out.println(listIterator.previous().getName() + " is now playing");
                    displayMenu();
                    choice = scanner.nextInt();
                }
            } else if (choice == 3) {
                if (forwards) {
                    listIterator.previous();
                    System.out.println("Repeating Song...");
                    System.out.println(listIterator.next().getName() + " is now playing");
                    displayMenu();
                    choice = scanner.nextInt();
                } else {
                    listIterator.next();
                    System.out.println("Repeating Song...");
                    System.out.println(listIterator.previous().getName() + " is now playing");
                    displayMenu();
                    choice = scanner.nextInt();
                }

            } else {
                quit = true;
            }
        }
    }
}
