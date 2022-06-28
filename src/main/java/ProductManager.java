public class ProductManager {

    private ProductRepository productRepository;

    public ProductManager(ProductRepository repo) {
        this.productRepository = repo;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : productRepository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1]; // "добавляем в конец" массива result продукт product
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;

            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return product.getName().toLowerCase().contains(search.toLowerCase());

    }


}
