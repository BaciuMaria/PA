
CREATE TABLE artists (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(45) NOT NULL
)
/
CREATE TABLE genres (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(200) NOT NULL
)
/
CREATE TABLE albums (
    id INT NOT NULL PRIMARY KEY,
    release_year INT NOT NULL,
    title VARCHAR(45) NOT NULL,
    artist VARCHAR(45) NOT NULL
)
/
CREATE TABLE album_genres (
    album_id INT NOT NULL,
    genre_id INT NOT NULL,
    PRIMARY KEY (album_id, genre_id),
    FOREIGN KEY (album_id) REFERENCES albums(id),
    FOREIGN KEY (genre_id) REFERENCES genres(id)
)
/