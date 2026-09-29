import java.util.random.RandomGenerator;

class Account {

    private int accountNumber;
    private String accountSortCode;
    private String accountType;
    private String accountName;
    private double balance;

    Account () {
        balance = 0;
    }

    Account(String accountType, String accountName) {
        this.accountNumber = generateAccountNumber();
        this.accountSortCode = generateAccountSortCode();
        this.accountType = accountType;
        this.accountName = accountName;
        this.balance = getBalance();
    }

    private int generateAccountNumber() {
        int generatedAccountNumber = RandomGenerator.getDefault().nextInt(10000000,99999999);
        return generatedAccountNumber;
    }

    private String generateAccountSortCode() {
        int partOne = RandomGenerator.getDefault().nextInt(10,99);
        int partTwo = RandomGenerator.getDefault().nextInt(10,99);
        int partThree = RandomGenerator.getDefault().nextInt(10,99);
        String generatedAccountSortCode = partOne + "-" + partTwo + "-" + partThree;
        return generatedAccountSortCode;
    }

    int getAccountNumber() {
        return accountNumber;
    }

    String getAccountSortCode() {
        return accountSortCode;
    }

    String getAccountType() {
        return accountType;
    }

    void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    String getAccountName() {
        return accountName;
    }

    void setAccountNumber(String accountName) {
        this.accountName = accountName;
    }

   double getBalance() {
        return balance;
   }

   boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        }
        else {
            IO.println("Deposit amount must be more than 0");
            return false;
        }
    }

    boolean withdraw(double amount) {
        if (amount <= 0) {
            IO.println("Withdrawal amount must be more than 0: ");
            return false;
        }
        else if (amount > balance) {
            IO.println("You don't have enough money for that, your balance is: " + balance);
            return false;
        }
        else {
            balance = balance - amount;
            return true;
        }
    }

    boolean transferTo(Account otherAccount, double amount) {
        if (withdraw(amount)) {
            otherAccount.deposit(amount);
            IO.println("Transfer successful.");
            return true;
        }
        else {
            return false;
        }
    }

}