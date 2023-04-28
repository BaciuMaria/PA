package org.example;
import java.io.IOException;

public class ListCommand implements Commands{
    private Catalog catalog;
    public ListCommand(Catalog catalog){
        this.catalog=catalog;
    }
    @Override
    public void execute()
            throws InvalidCatalogException {
        for(Document doc : catalog.docs )
          System.out.println(doc.toString());
    }
}
