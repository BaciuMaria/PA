public class CatalogManager {
    public static void add(Catalog catalog,Document doc) {
        catalog.docs.add(doc);
    }

    public String toString(Catalog catalog) {
        return "Catalog{" +
                "name='" + catalog.getName() + '\'' +
                ", docs=" + catalog.docs +
                '}';
    }
}
