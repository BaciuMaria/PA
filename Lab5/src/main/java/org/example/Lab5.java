package org.example;
import java.io.IOException;

public class Lab5 {
    public static void main(String[] args) {
        Lab5 app = new Lab5();
        app.compulsory();
        app.homework();
    }
    private void compulsory() {
        Catalog catalog = new Catalog("MyDocuments");
        Catalog copieCatalog = new Catalog();
        Document book = new Document("article1","2684ad4","C:\\Users\\a\\Documents");
        Document article = new Document("book1","adec231a","C:\\Users\\a\\Documents");

        CatalogManager manager= new CatalogManager();
        manager.add(catalog,book);
        manager.add(catalog,article);
        try {
            manager.save(catalog,"D:");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            copieCatalog = manager.load("D:\\catalog.json");
        } catch (InvalidCatalogException e) {
            throw new RuntimeException(e);
        }
       System.out.println(manager.toString(copieCatalog));
    }
    private void homework(){

        Catalog catalog = new Catalog("FirstyCatalog");
        Document book = new Document("article2","111111","C:\\Users\\a\\Documents");
        Document article = new Document("book2","2132313","C:\\Users\\a\\Documents");
        AddCommand addCatalog = new AddCommand(catalog,book);
        addCatalog.execute();
        addCatalog = new AddCommand(catalog,article);
        addCatalog.execute();
        SaveCommand saveCatalog = new SaveCommand(catalog,"D:");
        try {
            saveCatalog.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Catalog catalog1 = new Catalog("SecondCatalog");
        LoadCommand loadCatalog = new LoadCommand(catalog1,"D:\\catalog.json");
        try {
            loadCatalog.execute();
        } catch (InvalidCatalogException e) {
            throw new RuntimeException(e);
        }
        ListCommand listCatalog = new ListCommand(catalog);
        try {
            listCatalog.execute();
        } catch (InvalidCatalogException e) {
            throw new RuntimeException(e);
        }
        ViewCommand viewCatalog = new ViewCommand("C:\\catalog.json");
        try {
            viewCatalog.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}