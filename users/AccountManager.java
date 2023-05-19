package insuranceManamentSystem.users;

import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        accounts =new TreeSet<>();
    }

    public TreeSet<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(TreeSet<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void removeAccount(Account account){
        this.accounts.remove(account);
    }

    public Account login(String email, String password){
        for (Account a: accounts){
            try {
                a.login(email,password);
                if(a.getAuthenticationStatus()== Account.AuthenticationStatus.SUCCESS){
                    System.out.println("Giris Basarili");
                    return a;
                }
            }catch (InvalidAuthenticationException e){
                System.out.println(e.getMessage());

            }
        }
        return null;
    }

    public TreeSet<Account> listAccounts(){
        return accounts;
    }
}
