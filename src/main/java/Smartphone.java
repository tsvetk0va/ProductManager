public class Smartphone extends Product {


    private String producer;

    public String getProducer() {
        return producer;
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }


    @Override
    public boolean matches(String search) {
        return super.matches(search.toLowerCase()) || producer.toLowerCase().contains(search.toLowerCase());
    }
}
