package org.example.entities;

public class Album extends Entity{
    private int id;
    private int year;
    private String title;
    private String artist;
    private String genres;

    public Album(int id,int year, String title, String artist,String genres) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.artist = artist;
        this.genres=genres;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
