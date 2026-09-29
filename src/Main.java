// Useful imports
import java.util.ArrayList;

// Storing the accounts
ArrayList<Account> userAccounts = new ArrayList<>();


        void main() {

            // Creates a new user login
            User currentUser = new User();

            // Go to Login Page
            loginSystem(currentUser);


        }

        void loginSystem(User user) {

            IO.println("Welcome to NUMI BANK");
            String enteredUsername = IO.readln("Please enter your username: ");
            String enteredPassword = IO.readln("Please enter your account password: ");

            // Run a password check
            if(enteredPassword.equals(user.getPassword())) {
                IO.println("Login was succesfull, welcome " + enteredUsername);

                // Check if they have an account
                if(user.getAccounts().isEmpty()) {
                    IO.println("You don't have an account, let's get you one.");
                    createNewAccount(user);
                }
                else {
                    Accountmanager(user);
                }

            }

            else {
                IO.println("Something went wrong, that's not the right password or username.");
            }

        }

        void selectUserAccounts(User user) {
            for(int i = 0; i < userAccounts.size(); i++) {
                IO.println("Your accounts: " + userAccounts.get(i).getAccountName());
            }
            String enteredUserAccount = IO.readln("Please enter an account name you'd like to select: ");
            Account findAccount = findAccountByName(enteredUserAccount);
            IO.println("You've selected the following account: ");
            IO.print(findAccount.getAccountName() + " " + findAccount.getAccountType() + " " + findAccount.getAccountNumber() + " " + findAccount.getAccountSortCode() + " " + findAccount.getBalance());

        }

        // You can then use this method to get any other attribute of an object based off name
        Account findAccountByName(String name) {
            for(int i = 0; i < userAccounts.size(); i++) {
                if(userAccounts.get(i).getAccountName().equals(name)) {
                    return userAccounts.get(i);
                }
            }
            return null;
        }

        void Accountmanager(User user) {
            // Need to replace Placeholder with the name of the User pulled from Login
            IO.println("Hello there " + user.getUsername() + ", this is the account management page. Below are your accounts:");
            // Need to replac the following place holders with things that pull the acccount details from storage.
            for(int i = 0; i < userAccounts.size(); i++) {
                IO.print("Account "+(i+1)+" name: " + userAccounts.get(i).getAccountName());
                IO.print("\n");
            }
            String answer =IO.readln("\nPlease select a numbered option: \n 1. Select an Account\n 2. Create a new Account\n 3. Exit\n");
            if(answer.equalsIgnoreCase("1")){
                String Accountchoice = IO.readln("Please enter your choice: ");
                if(Accountchoice.equalsIgnoreCase("Placeholder")){
                    IO.println("Moving to account!");
                    selectUserAccounts(user);
                }
            }
            else if(answer.equalsIgnoreCase("2")){
                IO.println("Moving to account creation!");
                createNewAccount(user);
            }
            else if(answer.equalsIgnoreCase("3")){
                IO.println("Goodbye");
                //Exit here
            }


        }


        void createNewAccount(User user) {
            String enteredAccountType = IO.readln("Please enter the type of account you'd like to create: ");
            String enteredAccountName = IO.readln("Please enter a name for this account: ");

            if(checkIfAccountTypeIsValid(enteredAccountType) == Boolean.TRUE) {
                Account newAccount = new Account(enteredAccountType, enteredAccountName);
                IO.println(enteredAccountType + " Account created successfully.");
                userAccounts.add(newAccount);
                Accountmanager(user);
            }
            else {
                IO.println("This is not a valid account type: ");
            }
        }

        Boolean checkIfAccountTypeIsValid(String enteredAccountType) {
            if(enteredAccountType.equals("Community")) {
                return Boolean.TRUE;
            }
            if (enteredAccountType.equals("Small Business")) {
                return Boolean.TRUE;
            }
            if (enteredAccountType.equals( "Client")) {
                return Boolean.TRUE;
            }
            if(enteredAccountType.equals("community")) {
                return Boolean.TRUE;
            }
            if (enteredAccountType.equals("small Business")) {
                return Boolean.TRUE;
            }
            if (enteredAccountType.equals( "client")) {
                return Boolean.TRUE;
            }
            else {
                return Boolean.FALSE;
            }
        }