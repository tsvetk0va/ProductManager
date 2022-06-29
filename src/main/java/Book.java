import java.util.Locale;

public class Book extends Product {
    private String nameAuthor;


    public Book(int id, String name, int price, String nameAuthor) {
        super(id, name, price);
        this.nameAuthor = nameAuthor;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search.toLowerCase()) || nameAuthor.toLowerCase().contains(search.toLowerCase());
    }


}
