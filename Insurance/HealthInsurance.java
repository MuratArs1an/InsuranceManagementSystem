package insuranceManamentSystem.Insurance;

import insuranceManamentSystem.users.User;

import java.time.LocalDate;

public class HealthInsurance extends Insurance{

    private User user;
    public HealthInsurance(String name, double price, LocalDate insuranceStart, LocalDate insuranceEnd) {
        super(name, price, insuranceStart, insuranceEnd);
    }

    @Override
    public void calculate(User user) {
        this.setPrice(getPrice()+(user.getAge()*5)/100);
    }

}
