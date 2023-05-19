package insuranceManamentSystem;

import insuranceManamentSystem.Insurance.*;
import insuranceManamentSystem.address.AddressManager;
import insuranceManamentSystem.address.HomeAddress;
import insuranceManamentSystem.address.WorkAddress;
import insuranceManamentSystem.users.*;


import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeSet;

public class SystemManagement {
    AccountManager accountManager = new AccountManager();
    Scanner input = new Scanner(System.in);
    Scanner src = new Scanner(System.in);

    private String carModel;
    private int carAge;
    private int residanceAge;

    Insurance healthInsurance=new HealthInsurance("Saglik sigortasi",1000,LocalDate.now(),LocalDate.now().plusYears(1));
    Insurance carInsurance=new CarInsurance("Araba sigortasi",800,LocalDate.now(),LocalDate.now().plusYears(1),carModel,carAge);
    Insurance residence= new ResidenceInsurance("Ev Sigortasi",2000,LocalDate.now(),LocalDate.now().plusYears(1),residanceAge);
    Insurance travel=new TravelInsurance("Seyahat Sigortasi",300,LocalDate.now(),LocalDate.now().plusMonths(2));


    public void start() {
        System.out.println("Welcome Insurance Management System");
        boolean isEntered = true;
        while (isEntered) {
            System.out.println("1-Login Insurance System");
            System.out.println("2-Create Account");
            System.out.println("0-Exit");
            int selected = input.nextInt();
            switch (selected) {
                case 1:
                    System.out.println("----------------------");
                    System.out.println("Login");
                    login();
                    break;
                case 2:
                    System.out.println("----------------------");
                    System.out.println("Create");
                    createAccount();
                    break;
                case 0:
                    System.out.println("=====GOOD BYE====");
                    isEntered = false;
                    break;
            }
        }
    }

    public void createAccount() {
        System.out.println("Name : ");
        String name = src.nextLine();
        System.out.println("Surname : ");
        String surname = src.nextLine();
        System.out.println("Email : ");
        String email = src.nextLine();
        System.out.println("Password : ");
        String pass = src.nextLine();
        System.out.println("Profession : ");
        String pro = src.nextLine();
        System.out.println("Age : ");
        int age = input.nextInt();
        User user = new User(name, surname, email, pass, pro, age, LocalDate.now());
        System.out.println("1-Indiviual Account");
        System.out.println("2-Enterprise Account");
        int accSelect = input.nextInt();
        if (accSelect == 1) {
            Account account = new Individual(user);
            accountManager.addAccount(account);
        } else if (accSelect == 2) {
            System.out.println("Company Name : ");
            String companyName = src.nextLine();
            Account account = new Enterprise(user, companyName);
            accountManager.addAccount(account);
        } else {
            System.out.println("Please Enter Valid Number");
            createAccount();
        }
        System.out.println("Account Created");
        accountList(accountManager);
    }

    public void accountList(AccountManager accountManager){
        TreeSet<Account> accounts=accountManager.listAccounts();
        String format = "| %-15s | %-15s | %-25s |%-15s | %-20s | %-8s | %-25s | %-15s |\n";
        System.out.format(format, "Name", "Surname", "Email", "Password", "Profession", "Age", "Last login date",
                "Type");
        for (Account a : accounts) {
            System.out.format(format, a.getUser().getName(), a.getUser().getSurname(), a.getUser().getEmail(),
                    a.getUser().getPassword(), a.getUser().getProfession(), a.getUser().getAge(),
                    a.getUser().getLastLogin(), a.getClass().getSimpleName());
        }
    }

    public void login(){

        System.out.println("Email adresinizi giriniz : ");
        String email=src.nextLine();
        System.out.println("Sifrenizi giriniz : ");
        String password=src.nextLine();
        Account account= accountManager.login(email,password);
        if (account!=null){
            account.showUserInfo();
            if(account.getAuthenticationStatus()== Account.AuthenticationStatus.SUCCESS){
                userOperations(account.getUser(),account);
            }
        }

    }

    public void userOperations(User user, Account account){
        boolean operations=true;
        while(operations){
            System.out.println();
            System.out.println("==========Kullanici Islemleri===========");
            System.out.println("1- Sigorta Satin Alma");
            System.out.println("2- Ev Adresi Ekleme");
            System.out.println("3- Is Adresi Ekleme");
            System.out.println("4- Exit");

            int selectOperation=input.nextInt();
            switch (selectOperation){
                case 1:
                    insuranceMenu(user,account);
                    break;
                case 2:
                    addAddress(user,selectOperation);
                    break;
                case 3:
                    addAddress(user,selectOperation);
                    break;
                case 4:
                    operations=false;
                    break;
            }
        }

    }

    public void addAddress(User user, int selected){
        System.out.println();
        System.out.println("==========Adresi Ekleme Menusu===========");
        System.out.println("Sokak Ismini Giriniz: ");
        String street=src.nextLine();
        System.out.println("Sehir Ismini Giriniz: ");
        String city=src.nextLine();
        System.out.println("Ulke ismini Giriniz: ");
        String country=src.nextLine();
        if(selected==2){
            AddressManager.addAddress(user, new HomeAddress(street,city,country));
            System.out.println("Ev Adresiniz Eklendi");
        }else{
            System.out.println("Sirket Adini giriniz :");
            String companyName=src.nextLine();
            AddressManager.addAddress(user, new WorkAddress(street,city,country,companyName));
            System.out.println("Is Adresiniz Eklendi");
        }

    }

    public void insuranceMenu(User user, Account account){
        boolean insuranceMenu=true;
        while(insuranceMenu){
            System.out.println("=========Sigorta Yonetim Menusu===========");
            System.out.println("1- Araba Sigortasi");
            System.out.println("2- Saglik Sigortasi");
            System.out.println("3- Ev sigortasi");
            System.out.println("4- Seyehat Sigortasi");
            System.out.println("5- Exit");
            int insurance=input.nextInt();
            switch (insurance){
                case 1:
                    System.out.println("Araba Modelini giriniz :");
                    carModel=src.nextLine();
                    System.out.println("Arabanin yasini giriniz :  ");
                    carAge=input.nextInt();
                    account.addInsurance(carInsurance);
                    System.out.println("Araba Sigortaniz Olusturuldu");
                    account.insuranceToString(carInsurance,user);
                    break;
                case 2:
                    account.addInsurance(healthInsurance);
                    System.out.println("Saglik Sigortaniz Olusturuldu");
                    account.insuranceToString(healthInsurance,user);
                    break;
                case 3:
                    System.out.println("Evinizin Yasini Giriniz: ");
                    residanceAge=src.nextInt();
                    account.addInsurance(residence);
                    System.out.println("Ev Sigortaniz olusturuldu");
                    account.insuranceToString(residence,user);
                    break;
                case 4:
                    account.addInsurance(travel);
                    System.out.println("Seyehat Sigortaniz Olusturuldu");
                    account.insuranceToString(travel,user);
                    break;
                case 5:
                    insuranceMenu=false;
                    break;

            }
        }
    }

}


