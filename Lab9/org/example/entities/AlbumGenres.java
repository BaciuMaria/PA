package org.example.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "album_genres")
@NamedQueries({@NamedQuery(name = "AlbumGenres.findAll", query = "select e from album_genres e order by e.id_album"),})
public class AlbumGenres implements Serializable {
    @Column(name = "id_album")
    private int id_album;
    @Column(name = "id_genre")
    private int id_genre;
}
