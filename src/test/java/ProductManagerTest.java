import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Book book1 = new Book(1, "One", 100, "Ivanov A.A.");
    Book book2 = new Book(2, "Two", 200, "Petrov A.A.");
    Book book3 = new Book(3, "Three", 300, "Sidorov A.A.");
    Book book4 = new Book(4, "Four", 400, "Vasilyev A.A.");

    Smartphone smartphone1 = new Smartphone(111, "Sumsung A101", 56700, "Japan LTD Co");
    Smartphone smartphone2 = new Smartphone(222, "iPhone 12", 100500, "Apple Inc.");
    Smartphone smartphone3 = new Smartphone(333, "iPhone 13", 150000, "Apple Inc.");
    Smartphone smartphone4 = new Smartphone(444, "Xiaomi", 32500, "HuaHong LLC");

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

    }

    @Test
    public void shouldAddProduct(){
        manager.addProduct(book4);
        manager.addProduct(smartphone4);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3, book4, smartphone4};
        Product[] actual = productRepository.findAll();

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchByName(){

        Product[] expected = {smartphone2, smartphone3};
        Product[] actual = manager.searchBy("ip");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameOfBookAndSmartphone() {

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("two");

        assertArrayEquals(expected, actual);

    }




}