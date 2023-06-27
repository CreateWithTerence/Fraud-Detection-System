package creditcardfraud;

public class Payment {
    private String country;
    private double amount;

    public Payment(String country, double amount) {
        this.country = country;
        this.amount = amount;
    }

    public String getCountry() {
        return country;
    }

    public double getAmount() {
        return amount;
    }
}
