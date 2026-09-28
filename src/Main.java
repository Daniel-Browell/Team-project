// Useful imports
import java.util.ArrayList;

// Storing the accounts
ArrayList<Account> userAccounts = new ArrayList<>();


void main() {


    // Run Account Creation System
    createNewAccount();


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