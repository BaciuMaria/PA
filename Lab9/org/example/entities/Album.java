package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "albums")
@NamedQueries({@NamedQuery(name = "Album.findAll", query = "select e from albums e order by e.id"),})
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private int year;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "genres")
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
