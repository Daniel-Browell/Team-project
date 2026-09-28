// Useful imports
import java.util.ArrayList;

// Storing the accounts
ArrayList<Account> userAccounts = new ArrayList<>();


void main() {


    // Run Account Creation System
    createNewAccount();


}

        void Accountmanager() {
            String Username = "Placeholder";
            // Need to replace Placeholder with the name of the User pulled from Login
            IO.println("Hello there "+(Username)+", this is the account management page. Below are your accounts:");
            // Need to replac the following place holders with things that pull the acccount details from storage.
            String AccountName = "PlaceHolder";
            String AccountType = "PlaceHolder";
            String AccountSortcode = "1234";
            int AccountNumber = 1234;
            IO.println("Account Name: "+AccountName+"\nAccount Type: "+AccountType+"\nAccount Sortcode: "+AccountSortcode+"\nAccount Number: "+AccountNumber);
            String answer =IO.readln("PLease select a numbered option: \n 1. Select an Account\n 2. Create a new Account\n 3. Exit\n");
            if(answer.equalsIgnoreCase("1")){
                String Accountchoice = IO.readln("Please enter your choice: ");
                if(Accountchoice.equalsIgnoreCase("Placeholder")){
                    IO.readln("Moving to account!");
                    // need to go to the account here
                }
            }
            else if(answer.equalsIgnoreCase("2")){
                IO.readln("Moving to account creation!");
                //need to go to account creation here
            }
            else if(answer.equalsIgnoreCase("3")){
                IO.readln("Goodbye");
                //Exit here
            }


        }

 void selectUserAccounts() {
    for(int i = 0; i < userAccounts.size(); i++) {
        IO.print("Your accounts: " + userAccounts.get(i).getAccountType());
    }
}


void createNewAccount() {
    String enteredAccountType = IO.readln("Please enter the type of account you'd like to create: ");
    String enteredAccountName = IO.readln("Please enter a name for this account: ");

    if(checkIfAccountTypeIsValid(enteredAccountType) == Boolean.TRUE) {
        Account newAccount = new Account(enteredAccountType, enteredAccountName);
        IO.println(enteredAccountType + " Account created successfully.");
        userAccounts.add(newAccount);
        selectUserAccounts();
        // WE NEED TO RETURN BACK TO A HOME SCREEN / MENU
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
    else {
        return Boolean.FALSE;
    }
}