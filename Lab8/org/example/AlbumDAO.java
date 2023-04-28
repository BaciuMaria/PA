package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumDAO {
    public void create(int year,String title, String artistName , String genres) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (title, artist_name, genres) values (?, ?, ?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setString(3, artistName);
            pstmt.setString(4, genres);
            pstmt.executeUpdate();
        }
    }

    public Integer findByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + title + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
    public List<Album> findAll() throws SQLException {
        List<Album> albums = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM albums")) {
            while (rs.next()) {
                Album album = new Album(
                        rs.getInt("year"),
                        rs.getString("title"),
                        rs.getString("artist_name"),
                        rs.getString("genres")
                );
                albums.add(album);
            }
        }
        return albums;
    }
}