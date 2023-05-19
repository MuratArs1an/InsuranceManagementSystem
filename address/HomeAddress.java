package insuranceManamentSystem.address;

public class HomeAddress implements Address{
    private String street;
    private String city;
    private String country;

    public HomeAddress(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }
}
