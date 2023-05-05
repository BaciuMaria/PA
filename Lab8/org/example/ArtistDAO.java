package org.example;

import org.example.entities.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Artist findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where name='"+ name +"'")) {
            if (rs.next()) {
                int id = rs.getInt("id");
                return new Artist(id,name);
            } else {
                return null;
            }
        }
    }

    public Artist findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where id=" + id)) {
            if (rs.next()) {
                String name = rs.getString("name");
                return new Artist(id,name);
            } else {
                return null;
            }
        }
    }
    public List<Artist> findAll() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM artists")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Artist artist = new Artist(id, name);
                artists.add(artist);
            }
        }
        return artists;
    }
}