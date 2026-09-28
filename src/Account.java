import java.util.random.RandomGenerator;

class Account {

    private int accountNumber;
    private String accountSortCode;
    private String accountType;
    private String accountName;
    public double balance;

    Account(String accountType, String accountName) {
        this.accountNumber = generateAccountNumber();
        this.accountSortCode = generateAccountSortCode();
        this.accountType = accountType;
        this.accountName = accountName;
        this.balance = setBalanceToZero();
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

    double setBalanceToZero() {
        balance = 0;
        return balance;
    }

   double getBalance() {
        return balance;
   }

}