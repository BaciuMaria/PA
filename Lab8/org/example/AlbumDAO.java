package org.example;

import org.example.entities.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    public void create(int year,String title, String artistName , String genres) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year,title,artist) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setString(3, artistName);

            String[] genreNames = genres.split(",");
            List<Integer> id_genres = new ArrayList<>();
            for (String genreName : genreNames) {
                try (PreparedStatement pstmt1 = con.prepareStatement(
                        "SELECT id FROM genres WHERE name = ?")) {
                    pstmt1.setString(1, genreName);
                    try (ResultSet rs = pstmt1.executeQuery()) {
                        if (rs.next()) {
                            id_genres.add(rs.getInt("id"));
                        }
                    }
                }
            }
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (!rs.next()) {
                    throw new SQLException("Failed to get generated id_album");
                }
                int id_album = rs.getInt(1);

                try (PreparedStatement pstmt2 = con.prepareStatement(
                        "INSERT INTO album_genres (id_album, id_genre) VALUES (?, ?)")) {
                    for (Integer id_genre : id_genres) {
                        pstmt2.setInt(1, id_album);
                        pstmt2.setInt(2, id_genre);
                        pstmt2.executeUpdate();
                    }
                }
            }
        }
    }

    public Album findByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT a.id, a.release_year, a.title, ar.name as artist, string_agg(g.name,',') AS genres " +
                        "FROM albums a JOIN artists ar ON a.artist = ar.name JOIN album_genres ag ON a.id = ag.id_album " +
                        "JOIN genres g ON ag.id_genre = g.id WHERE a.title = ? GROUP BY a.id,ar.name")) {
            pstmt.setString(1, title);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    int year = rs.getInt("release_year");
                    String artist = rs.getString("artist");
                    String genres = rs.getString("genres");
                    return new Album(id, year, title, artist, genres);
                } else {
                    return null;
                }
            }
       }
    }

    public Album findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT a.id, a.release_year, a.title, ar.name as artist,string_agg(g.name,',') AS genres " +
                        "FROM albums a JOIN artists ar ON a.artist = ar.name JOIN album_genres ag ON a.id = ag.id_album " +
                        "JOIN genres g ON ag.id_genre = g.id WHERE a.id = ? GROUP BY a.id,ar.name")) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int year = rs.getInt("release_year");
                    String title = rs.getString("title");
                    String artist = rs.getString("artist");
                    String genres = rs.getString("genres");
                    return new Album(id, year, title, artist, genres);
                } else {
                    return null;
                }
            }
        }
    }
    public List<Album> findAll() throws SQLException {
        List<Album> albums = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT a.id, a.release_year, a.title, ar.name AS artist, string_agg(g.name,',') AS genres " +
                             "FROM albums a JOIN artists ar ON a.artist = ar.name JOIN album_genres ag ON a.id = ag.id_album " +
                             "JOIN genres g ON ag.id_genre = g.id GROUP BY a.id,ar.name")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int year = rs.getInt("release_year");
                String title = rs.getString("title");
                String artistName = rs.getString("artist");
                String genres = rs.getString("genres");
                Album album = new Album(id, year, title, artistName, genres);
                albums.add(album);
            }
        }
        return albums;
    }
}