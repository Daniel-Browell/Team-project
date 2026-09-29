import java.util.ArrayList;

class User {
    String username;
    String password;
    private ArrayList<Account> accounts = new ArrayList<>();

    User() {
        username = "accenture";
        password = "password123";

    }

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    void setUsername(String username) {
        this.username = username;
    }

    void setPassword(String password) {
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    ArrayList<Account> getAccounts() {
        return accounts;
    }

    }
