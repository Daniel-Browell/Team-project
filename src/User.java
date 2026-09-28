
class User {
    String username;
    String password;

    User() {
        username = " ";
        password = " ";
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

        }