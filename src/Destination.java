public class Destination {

    private String name;
    private String country;
    private double price;
    private int priority;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getPrice() {
        return price;
    }

    public int getPriority() {
        return priority;
    }

    public Destination(String name, String country, double price, int priority) {
        this.name = name;
        this.country = country;
        this.price = price;
        this.priority = priority;



    }
}
