package insuranceManamentSystem.Insurance;

import insuranceManamentSystem.users.User;

import java.time.LocalDate;

public abstract class Insurance {
    private String name;
    private double price;
    private LocalDate insuranceStart;
    private LocalDate insuranceEnd;

    public Insurance(String name, double price, LocalDate insuranceStart, LocalDate insuranceEnd) {
        this.name = name;
        this.price = price;
        this.insuranceStart = insuranceStart;
        this.insuranceEnd = insuranceEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getInsuranceStart() {
        return insuranceStart;
    }

    public void setInsuranceStart(LocalDate insuranceStart) {
        this.insuranceStart = insuranceStart;
    }

    public LocalDate getInsuranceEnd() {
        return insuranceEnd;
    }

    public void setInsuranceEnd(LocalDate insuranceEnd) {
        this.insuranceEnd = insuranceEnd;
    }

    public abstract void calculate(User user);
}
