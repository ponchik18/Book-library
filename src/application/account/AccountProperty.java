package application.account;

public class AccountProperty {
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    private String login;
    private String passwordHash;
    private String email;
    private AccountType accountType;

    public AccountProperty(String login, String password) {
        this.login = login;
        this.passwordHash = password;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object obj) {
        AccountProperty info=null;
        if(obj instanceof AccountProperty){
            info=(AccountProperty)obj;
        }
        else throw new IllegalArgumentException("Not AccountProperty class");
        if(login.equals(info.login) && passwordHash.equals(info.passwordHash)){
            return true;
        }
        else return false;
    }
}
