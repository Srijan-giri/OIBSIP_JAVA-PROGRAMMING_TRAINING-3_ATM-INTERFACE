import java.util.Scanner;

class BankAccount {


    String userName;
    String user_password;
    String user_accountNo;
    float user_balance = 5000f;
    int transactions = 0;
    String user_transactionHistory = "";

    Scanner sc = new Scanner(System.in);

    public void user_register() {

        System.out.print("\nEnter Your Username - ");
        this.userName = sc.nextLine();
        System.out.print("\nEnter Your Password - ");
        this.user_password = sc.nextLine();
        System.out.print("\nEnter Your Account Number - ");
        this.user_accountNo = sc.nextLine();
        System.out.println("\nRegistration completed......");
    }

    public boolean user_login() {
        boolean isLogin = false;

        while ( !isLogin ) {
            System.out.print("\nEnter Your Username - ");
            String Username = sc.nextLine();
            if ( Username.equalsIgnoreCase(userName) ) {
                System.out.print("\nEnter Your Password - ");
                String Password = sc.nextLine();
                if ( Password.equals(user_password) ) {
                    System.out.print("\nLogin successful!!");
                    isLogin = true;
                }
                else {
                    System.out.println("\nIncorrect Password");
                }

            }
            else {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {

        System.out.print("\nEnter amount to withdraw - ");
        float amount = sc.nextFloat();

        if ( user_balance >= amount ) {
            transactions++;
            user_balance -= amount;
            System.out.println("\nWithdraw Successfully");
            String str = amount + " Rs Withdrawed\n";
            user_transactionHistory = user_transactionHistory.concat(str);

        }
        else {
            System.out.println("\n Balance is not available");
        }

    }


    public void deposit() {

        System.out.print("\nEnter amount to deposit - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        transactions++;
        user_balance += amount;
        System.out.println("\nSuccessfully Deposited");
        String str = amount + " Rs deposited\n";
        user_transactionHistory = user_transactionHistory.concat(str);
    }


    public void transfer() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Receipent's Name - ");
        String receipent = sc.nextLine();
        System.out.print("\nEnter amount to transfer - ");
        float amount = sc.nextFloat();


        if ( user_balance >= amount ) {
            if ( amount <= 10000f ) {
                transactions++;
                user_balance -= amount;
                System.out.println("\nSuccessfully Transfered to " + receipent);
                String str = amount + " Rs transfered to " + receipent + "\n";
                user_transactionHistory = user_transactionHistory.concat(str);
            }
            else {
                System.out.println("\nLimit is 100000.00.So Sorry ....");
            }
        }
        else {
            System.out.println("\n Balance is not sufficient");
        }


    }

    public void checkBalance() {
        System.out.println("\n" + user_balance + " Rs");
    }

    public void transHistory() {
        if ( transactions == 0 ) {
            System.out.println("\nNo transactions");
        }
        else {
            System.out.println("\n Transaction : " + user_transactionHistory);
        }
    }
}


class atmInterface {

    public static void main(String[] args) {

        System.out.println("\n---------WELCOME TO ATM SYSTEM----------\n");
        System.out.println("1.Register \n2.Exit from the system");
        System.out.print("Enter Your Choice : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if ( choice == 1 ) {
            BankAccount b = new BankAccount();
            b.user_register();
            while(true) {
                System.out.println("\n1.Login User \n2.Exit from the system");
                System.out.print("Enter Your Choice : ");
                int ch = sc.nextInt();
                if ( ch == 1 ) {
                    if (b.user_login()) {
                        System.out.println("\n\n------------WELCOME BACK " + b.userName + " ---------------\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice : ");
                            int c = sc.nextInt();
                            switch(c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.out.println("Thank You................ ");
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }



    }
}