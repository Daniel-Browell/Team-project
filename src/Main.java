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
                AccountCheck(user);
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
        void AccountCheck(User user) {
            String enteredUserAccount = IO.readln("Please enter an account name you'd like to select: ");
            Account findAccount = findAccountByName(enteredUserAccount);
            //Above you need a loop to pull all the details of the account from the globale variable
            IO.println("Current account view: "+findAccount.getAccountName());
            IO.println("Account Type: "+findAccount.getAccountType());
            IO.println("Account Number: "+findAccount.getAccountNumber());
            IO.println("Account Sort Code: "+findAccount.getAccountSortCode());
            IO.println("Balance: "+findAccount.getBalance());
            int ans = Integer.parseInt(IO.readln("\nPlease enter the number of the operation you wish to perform:\n1. Deposit\n2. Withdraw\n3. Transfer Money\n4. Exit\n"));
            if (ans == 1) {
                int depositamount = Integer.parseInt(IO.readln("Please enter the amount you wish to deposit:\n"));
                IO.readln("Please enter your card number:\n");
                IO.readln("Please enter your card's expiry date:\n");
                IO.readln("Please enter your card's CVV:\n");
                IO.println("The sum of"+depositamount+" has been deposited into your account");
                // need to add the actual deposit function
                String nextstep = IO.readln("Please enter either Return to return to the account manager or Stay to stay on this account:\n");
                if (nextstep.equalsIgnoreCase("Return")){
                    Accountmanager(user);
                }
                else{
                    AccountCheck(user);
                }
            } else if (ans ==2) {
                int withdrawamount = Integer.parseInt(IO.readln("Please enter the amount you wish to withdraw:\n"));
                IO.readln("Please enter your sort code:\n");
                IO.readln("Please enter your account number:\n");
                IO.println("The sum of"+withdrawamount+" has been withdrawn from your account");
                //need to add actual withdraw function
                String nextstep = IO.readln("Please enter either Return to return to the account manager or Stay to stay on this account:\n");
                if (nextstep.equalsIgnoreCase("Return")){
                    Accountmanager(user);
                }
                else{
                    AccountCheck(user);
                }

            } else if (ans ==3) {
                int transferamount = Integer.parseInt(IO.readln("Please enter the amount you wish to transfer:\n"));
                String transferdestination = IO.readln("Please enter the destination you wish to transfer:\n");
                IO.println("The sum of"+transferamount+" has been withdrawn from this account and transferred to "+transferdestination);
                // need to add actual transfer functionality
                String nextstep = IO.readln("Please enter either Return to return to the account manager or Stay to stay on this account:\n");
                if (nextstep.equalsIgnoreCase("Return")){
                    Accountmanager(user);
                }
                else{
                    AccountCheck(user);
                }

            }
            else if (ans == 4) {
                Accountmanager(user);

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