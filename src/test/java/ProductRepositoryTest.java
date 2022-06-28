import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    Book book1 = new Book(1, "One", 100, "Ivanov A.A.");
    Book book2 = new Book(2, "Two", 200, "Petrov A.A.");
    Book book3 = new Book(3, "Three", 300, "Sidorov A.A.");
    Book book4 = new Book(4, "Four", 400, "Vasilyev A.A.");

    Smartphone smartphone1 = new Smartphone(111, "Sumsung A101", 56700, "Japan LTD Co");
    Smartphone smartphone2 = new Smartphone(222, "iPhone 12", 100500, "Apple Inc.");
    Smartphone smartphone3 = new Smartphone(333, "iPhone 13", 150000, "Apple Inc.");
    Smartphone smartphone4 = new Smartphone(444, "Xiaomi", 32500, "HuaHong LLC");

    ProductRepository productRepository = new ProductRepository();

    @Test
    public void shouldSaveProduct() {

        productRepository.save(book4);
        assertArrayEquals(new Product[]{book4}, productRepository.findAll());
    }

    @Test
    public void shouldFinAllProducts() {
        productRepository.save(book1);
        productRepository.save(smartphone1);
        productRepository.save(smartphone2);

        assertArrayEquals(new Product[]{book1, smartphone1, smartphone2}, productRepository.findAll());
    }

    @Test
    public void shouldRemoveById() {
        productRepository.save(book1);
        productRepository.save(smartphone1);
        productRepository.save(smartphone2);

        productRepository.removeById(111);
        assertArrayEquals(new Product[]{book1, smartphone2}, productRepository.findAll());

    }


}