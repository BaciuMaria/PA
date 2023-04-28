package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class CatalogManager {
    public String toString(Catalog catalog) {
        return "Catalog{" +
                "name='" + catalog.getName() + '\'' +
                ", docs=" + catalog.docs +
                '}';
    }
    public static Catalog load(String path)
            throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    new File(path),
                    Catalog.class);
        }catch (IOException ex)
        {
            throw new InvalidCatalogException(ex);
        }
    }
    public void add(Catalog catalog, Document doc) {
        catalog.docs.add(doc);
    }
    public void save(Catalog catalog, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path + "\\catalog.json");
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.writeValue(
                file ,
                catalog);
    }
}
