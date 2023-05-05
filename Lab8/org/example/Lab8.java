package org.example;

import org.example.entities.Album;
import org.example.entities.Artist;
import org.example.entities.Genre;

import java.sql.SQLException;
import java.util.List;

public class Lab8 {
    public static void main(String[] args) throws SQLException {
        try {
            var artists = new ArtistDAO();
            //artists.create("Pink Floyd");
            //artists.create("Michael Jackson");
            //artists.create("NCT 127");
            var genres = new GenreDAO();
            //genres.create("Rock");
            //genres.create("Funk");
            //genres.create("Soul");
            //genres.create("Pop");
            //genres.create("Hip Hop");
            //genres.create("R&B");
            //Database.getConnection().commit();
            var albums = new AlbumDAO();
            //albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            //albums.create(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");
            //albums.create(2020, "Neo Zone", "NCT 127", "Hip Hop,R&B");
            //Database.getConnection().commit();
            List<Album> allAlbums = albums.findAll();
            List<Artist> allArtists = artists.findAll();
            List<Genre> allGenres = genres.findAll();
            for (Album album : allAlbums) {
                System.out.println(album);
            }
            for (Artist artist : allArtists) {
                System.out.println(artist);
            }
            for (Genre genre : allGenres) {
                System.out.println(genre);
            }
            System.out.println(albums.findByTitle("The Wall"));
            System.out.println(albums.findById(7));
            System.out.println(artists.findById(4));
            System.out.println(artists.findByName("Pink Floyd"));
            System.out.println(genres.findById(17));
            System.out.println(genres.findByName("Rock"));
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.getConnection().rollback();
        }
    }
}