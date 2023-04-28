package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class LoadCommand implements Commands {
    private Catalog catalog;
    private String path;
    public LoadCommand(Catalog catalog,String path){
        this.path=path;
        this.catalog=catalog;
    }
    @Override
    public void execute()
            throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            catalog = objectMapper.readValue(
                    new File(path) ,
                    Catalog.class);
        }catch (IOException ex)
        {
            throw new InvalidCatalogException(ex);
        }
    }
}
