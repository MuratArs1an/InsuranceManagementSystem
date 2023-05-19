package insuranceManamentSystem.Insurance;

import insuranceManamentSystem.users.User;

import java.time.LocalDate;

public class TravelInsurance extends Insurance{

    private User user;
    public TravelInsurance(String name, double price, LocalDate insuranceStart, LocalDate insuranceEnd) {
        super(name, price, insuranceStart, insuranceEnd);
    }

    @Override
    public void calculate(User user) {
        this.setPrice(getPrice()+(user.getAge()*2)/100);
    }
}
