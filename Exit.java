public char readExit(Scanner scan){
    System.out.print("Are you sure you want to exit? (y/n): ");
    return scan.next().charAt(0);
}

public void tryExit(Scanner scan){
    boolean invalidExitInput = true;
    while(invalidExitInput){
        invalidExitInput = false;
        char userConfirmedExit = readExit(scan);
        if(userConfirmedExit == 'y') System.exit(0);
        else if(userConfirmedExit != 'n') {
            System.out.println("Invalid Input");
            invalidExitInput = true;
        }
    }
}
