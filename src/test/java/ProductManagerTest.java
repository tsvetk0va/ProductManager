import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Product product1 = new Product(11, "Lenovo", 80_000);
    Product product2 = new Product(22, "Dell", 100_000);
    Product product3 = new Product(33, "Mac", 250_000);

    Product book1 = new Book(1, "One", 100, "Ivanov A.A.");
    Product book2 = new Book(2, "Two", 200, "Petrov A.A.");
    Product book3 = new Book(3, "Three", 300, "Sidorov A.A.");
    Product book4 = new Book(4, "Four", 400, "Vasilyev A.A.");

    Product smartphone1 = new Smartphone(111, "Sumsung A101", 56700, "Japan LTD Co");
    Product smartphone2 = new Smartphone(222, "iPhone 12", 100500, "Apple Inc.");
    Product smartphone3 = new Smartphone(333, "iPhone 13", 150000, "Apple Inc.");
    Product smartphone4 = new Smartphone(444, "Xiaomi", 32500, "HuaHong LLC");

    ProductRepository productRepository = new ProductRepository();
    ProductManager manager = new ProductManager(productRepository);

    @BeforeEach
    public void setup() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);

    }

    @Test
    public void shouldAddProduct(){
        manager.addProduct(book4);
        manager.addProduct(smartphone4);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3, product1, product2, product3, book4, smartphone4,};
        Product[] actual = productRepository.findAll();

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchSmartphoneByProducer(){

        Product[] expected = {smartphone2, smartphone3};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByAuthor() {

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("sidorov");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchSmartphoneByName(){

        Product[] expected = {smartphone2, smartphone3};
        Product[] actual = manager.searchBy("iphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductByName() {

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("el");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchAnyProductByName() {

        Product[] expected = {book1, smartphone2, smartphone3};
        Product[] actual = manager.searchBy("one");

        assertArrayEquals(expected, actual);

    }




}