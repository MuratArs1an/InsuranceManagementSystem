package insuranceManamentSystem.users;

public class Enterprise extends  Account{
    private String companyName;
    public Enterprise(User user, String companyName ) {
        super(user);
        this.companyName=companyName;
    }
}
