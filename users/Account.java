package insuranceManamentSystem.users;

import insuranceManamentSystem.Insurance.Insurance;

import java.util.ArrayList;

public abstract class Account implements Comparable<Account> {

    private User user;
    private ArrayList<Insurance> insurances=new ArrayList<>();
    private AuthenticationStatus authenticationStatus;

    public enum AuthenticationStatus {
        SUCCESS, FAIL
    }
    public Account(User user) {
        this.user = user;
        this.insurances=insurances;
        this.authenticationStatus=authenticationStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public final void showUserInfo(){
        System.out.println("==============================");
        System.out.println("Name : "+this.user.getName());
        System.out.println("Surname : "+this.user.getSurname());
        System.out.println("Email : "+this.user.getEmail());
        System.out.println("Age : "+this.user.getAge());
        System.out.println("Profession : "+this.user.getProfession());
        System.out.println("Last Login : "+this.user.getLastLogin());
    }

    public void login(String email, String password) throws InvalidAuthenticationException{
        if(this.user.getEmail().equals(email) && this.user.getPassword().equals(password)){
            this.authenticationStatus=AuthenticationStatus.SUCCESS;
        }else{
            throw  new InvalidAuthenticationException("UserName or Password is Wrong");
        }
    }

    @Override
    public int hashCode() {
        return user.getEmail().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Account other) {
        return this.user.getEmail().compareTo(other.user.getEmail());
    }

    public void addInsurance(Insurance insurance){
        this.insurances.add(insurance);
    }

    public void removeInsurance(Insurance insurance){
        this.insurances.remove(insurance);
    }

    public void insuranceToString(Insurance insurance, User user){
        System.out.println("Sigorta Adi : "+insurance.getName());
        insurance.calculate(user);
        System.out.println("Sigorta Ucreti : "+insurance.getPrice());
        System.out.println("Sigorat Baslangici : "+ insurance.getInsuranceStart());
        System.out.println("Sigorta Bitisi : "+insurance.getInsuranceEnd());
    }
}
