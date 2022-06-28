public class ProductRepository {

    private Product[] products = new Product[0];

    public void save(Product product) {               //метод, сохраняющий продукты в массив
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }


    public Product[] findAll() {   // метод, позволяющий получить массив всех сохрнаненных продуктов
        return products;
    }

    public void removeById(int id) {                //метод удаления товара по id
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }


}
