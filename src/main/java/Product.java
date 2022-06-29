public class Product {

    protected int id;
    protected String name;
    protected int price;

    private Product[] products = new Product[0];

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    // метод определения соответствия товара product запросу search
    public boolean matches(String search) {
        return getName().toLowerCase().contains(search.toLowerCase());

    }

}
