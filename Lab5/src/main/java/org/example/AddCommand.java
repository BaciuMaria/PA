package org.example;

public class AddCommand implements Commands {
    private Catalog catalog;
    private Document doc;
    public AddCommand(Catalog catalog,Document doc){
      this.catalog=catalog;
      this.doc=doc;
    }
    public void execute() {
        catalog.docs.add(doc);
    }
}
