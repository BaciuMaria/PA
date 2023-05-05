package org.example;
import org.example.entities.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Genre findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where name='" + name + "'")) {
            if (rs.next()) {
                int id = rs.getInt("id");
                return new Genre(id, name);
            } else {
                return null;
            }
        }
    }
    public Genre findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where id=" + id)) {
            if (rs.next()) {
                String name = rs.getString("name");
                return new Genre(id,name);
            } else {
                return null;
            }
        }
    }
    public List<Genre> findAll() throws SQLException {
        List<Genre> genres = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM genres")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
        }
        return genres;
    }

}
