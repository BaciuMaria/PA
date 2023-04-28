public class Lab5 {
    public static void main(String args[]) {
        Lab5 app = new Lab5();
        app.compulsory();
    }
    private void compulsory() {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1","2684ad4","C:\Users\a\Documents");
        var article = new Document("book1","adec231a","C:\Users\a\Documents");
    }

}