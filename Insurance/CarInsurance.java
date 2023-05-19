package insuranceManamentSystem.Insurance;

import insuranceManamentSystem.users.User;

import java.time.LocalDate;

public class CarInsurance extends Insurance{

    private String carModel;
    private int carAge;

    public CarInsurance(String name, double price, LocalDate insuranceStart, LocalDate insuranceEnd, String carModel, int carAge) {
        super(name, price, insuranceStart, insuranceEnd);
        this.carModel=carModel;
        this.carAge=carAge;
    }

    @Override
    public void calculate(User user) {
        this.setPrice(getPrice()+(getCarAge()*10)/100);
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarAge() {
        return carAge;
    }

    public void setCarAge(int carAge) {
        this.carAge = carAge;
    }
}
