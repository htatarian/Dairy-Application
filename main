AccountLogin objAccountLogin = new AccountLogin();
AccountRemover objAccountRemover = new AccountRemover();
AccountCreator objAccountCreator = new AccountCreator();
Accounts objAccounts = new Accounts();
Exit objExit = new Exit();

public static void main(String[] args) {

        Diary d = new Diary();
        d.startDiary();

    }

public void startDiary(){
    objAccounts.loadAccounts();
    while(true){
    showMainMenu();
    usersChoice();
    }
}

public void showMainMenu(){
    System.out.println("");
    System.out.println("Welcome to Diary!");
    System.out.println("1- New Account");
    System.out.println("2- Login To Your Account");
    System.out.println("3- Remove Account");
    System.out.println("4- Exit");
    System.out.println("");
}

public void usersChoice(){
    int choice = 0;
    Scanner scan = new Scanner(System.in);
    while(true){
        try{
            scan = new Scanner(System.in);
            System.out.print("Choose an option: ");
            choice = scan.nextInt();
            break;
        }
        catch(Exception e){
            System.out.println("Invalid Input!\n");
            }
        }

    switch (choice){
        case 1:
            choiceNewAccount(scan);
            break;
        case 2:
            choiceLogin(scan);
            break;
        case 3:
            choiceRemoveAccount(scan);
            break;
        case 4:
            exit(scan);
            break;
        default:
            System.out.println("Invalid Input!\n");
            break;     
   }

}


public void choiceNewAccount(Scanner scan){
    objAccountCreator.createAccount(scan);
}

public void choiceLogin(Scanner scan){
    objAccountLogin.login(scan);
}

public void choiceRemoveAccount(Scanner scan){
    objAccountRemover.removeAccount(scan);       
}

public void exit(Scanner scan){
    objExit.tryExit(scan);
    }                    
}
