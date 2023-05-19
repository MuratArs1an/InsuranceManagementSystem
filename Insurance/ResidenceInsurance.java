package insuranceManamentSystem.Insurance;

import insuranceManamentSystem.users.User;

import java.time.LocalDate;

public class ResidenceInsurance extends Insurance{

    private int residenceAge;

    public ResidenceInsurance(String name, double price, LocalDate insuranceStart, LocalDate insuranceEnd, int residenceAge) {
        super(name, price, insuranceStart, insuranceEnd);
        this.residenceAge=residenceAge;
    }

    @Override
    public void calculate(User user) {
        this.setPrice(getPrice()+(getResidenceAge()*20)/100);
    }

    public int getResidenceAge() {
        return residenceAge;
    }

    public void setResidenceAge(int residenceAge) {
        this.residenceAge = residenceAge;
    }
}
