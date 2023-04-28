package org.example;
public class FileNotFoundException extends Exception {
        public FileNotFoundException(Exception ex) {
            super("File not found.", ex);
        }
    }
