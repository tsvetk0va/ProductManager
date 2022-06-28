public class Book extends Product {
    private String nameAuthor;


    public Book(int id, String name, int price, String nameAuthor) {
        super(id, name, price);
        this.nameAuthor = nameAuthor;
    }

}
