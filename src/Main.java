
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
        Account findAccountByName(User user, String name) {
            for(int i = 0; i < user.getAccounts().size(); i++) {
                if(user.getAccounts().get(i).getAccountName().equals(name)) {
                    return user.getAccounts().get(i);
                }
            }
            return null;
        }

        void Accountmanager(User user) {
            // Need to replace Placeholder with the name of the User pulled from Login
            IO.println("Hello there " + user.getUsername() + ", this is the account management page. Below are your accounts:");
            // Need to replac the following place holders with things that pull the acccount details from storage.
            for(int i = 0; i < user.getAccounts().size(); i++) {
                IO.print("Account "+(i+1)+" name: " + user.getAccounts().get(i).getAccountName());
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
            Account findAccount = findAccountByName(user, enteredUserAccount);
            //Above you need a loop to pull all the details of the account from the global variable
            IO.println("Current account view: "+findAccount.getAccountName());
            IO.println("Account Type: "+findAccount.getAccountType());
            IO.println("Account Number: "+findAccount.getAccountNumber());
            IO.println("Account Sort Code: "+findAccount.getAccountSortCode());
            IO.println("Balance: "+findAccount.getBalance());
            IO.println("Overdraft Available: "+overdraftcheck(user, findAccount));
            int ans = Integer.parseInt(IO.readln("\nPlease enter the number of the operation you wish to perform:\n1. Deposit\n2. Withdraw\n3. Transfer Money\n4. Exit\n"));

            if (ans == 1) {
                // DEPOSIT SYSTEM
                int depositamount = Integer.parseInt(IO.readln("Please enter the amount you wish to deposit:\n"));
                IO.readln("Please enter your card number:\n");
                IO.readln("Please enter your card's expiry date:\n");
                IO.readln("Please enter your card's CVV:\n");

                // CHECK IF SUCCESSFULL
                if(findAccount.deposit(depositamount)) {
                    IO.println("The sum of" + depositamount + " has been deposited into your account.");
                    IO.println("Your new balance is: " + findAccount.getBalance());
                }
                else {
                    IO.println("Your balance hasn't been changed.");
                }

                String nextstep = IO.readln("Please enter either Return to return to the account manager or Stay to stay on this account:\n");
                if (nextstep.equalsIgnoreCase("Return")){
                    Accountmanager(user);
                }
                else{
                    AccountCheck(user);
                }
            } else if (ans ==2) {
                // WITHDRAW SYSTEM
                int withdrawamount = Integer.parseInt(IO.readln("Please enter the amount you wish to withdraw:\n"));
                IO.readln("Please enter your sort code:\n");
                IO.readln("Please enter your account number:\n");

                // Check if withdraw was successful:
                if(findAccount.withdraw(withdrawamount)) {
                    IO.println("The sum of "+withdrawamount+" has been withdrawn from your account");
                    IO.println("Your new balance is: " + findAccount.getBalance());
                }
                else {
                    IO.println("Your balance hasn't been changed.");
                }
                // Return Back
                String nextstep = IO.readln("Please enter either Return to return to the account manager or Stay to stay on this account:\n");
                if (nextstep.equalsIgnoreCase("Return")){
                    Accountmanager(user);
                }
                else{
                    AccountCheck(user);
                }

            } else if (ans ==3) {
                // TRANSFER SYSTEM
                int transferamount = Integer.parseInt(IO.readln("Please enter the amount you wish to transfer:\n"));

                // Get the destination account
                String transferdestination = IO.readln("Please enter the destination you wish to transfer:\n");
                Account destinationAccount = findAccountByName(user,transferdestination);

                // CHECK IF TRANSFER WAS SUCCESSFUL
                if (findAccount.transferTo(destinationAccount, transferamount)) {
                    IO.println("Transfer successful.");
                    IO.println(findAccount.getAccountName() + " balance: " + destinationAccount.getBalance());
                    IO.println(findAccount.getAccountName() + " balance: " + findAccount.getBalance());
                }
                else {
                    IO.println("Transfer failed.");
                }
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
    int overdraftcheck(User user, Account account) {
        if (account.getAccountType().equalsIgnoreCase("Client")){
            int overdraft = 1500;
            return (overdraft);
        }
        else if (account.getAccountType().equalsIgnoreCase("Community")){
            int overdraft = 2500;
            return (overdraft);
        }
        else if (account.getAccountType().equalsIgnoreCase("Small Business")){
            int overdraft = 1000;
            return (overdraft);
        }
        int overdraft =0;
        return overdraft;
    }
        void createNewAccount(User user) {
            String enteredAccountType = IO.readln("Please enter the type of account you'd like to create: ");
            String enteredAccountName = IO.readln("Please enter a name for this account: ");

            if(checkIfAccountTypeIsValid(enteredAccountType) == Boolean.TRUE) {
                Account newAccount = new Account(enteredAccountType, enteredAccountName);
                IO.println(enteredAccountType + " Account created successfully.");
                user.getAccounts().add(newAccount);
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

