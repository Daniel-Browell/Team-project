void main() {
    String Username = "Placeholder";
    // Need to replace Placeholder with the name of the User pulled from Login
    IO.readln("Hello there "+(Username)+", this is the account management page. Below are your accounts:");
    // Need to replac the following place holders with things that pull the acccount details from storage.
    String AccountName = "PlaceHolder";
    String AccountType = "PlaceHolder";
    String AccountSortcode = "1234";
    int AccountNumber = 1234;
    IO.readln("Account Name: "+AccountName+"\nAccount Type: "+AccountType+"\nAccount Sortcode: "+AccountSortcode+"\nAccount Number: "+AccountNumber);
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