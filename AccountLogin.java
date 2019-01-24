protected String loginName(Scanner scan){
    System.out.print("Enter Username: ");
    String username = scan.next();
    System.out.print("Enter Password: ");
    String password = scan.next();

    if(getUsernamesList().contains(username)){
        if(password.equals(getPasswordsList().get(getUsernamesList().indexOf(username)))) return username;
        return "-1";
    }
    return "-1";
}

public void login(Scanner scan){
    String username = loginName(scan);
    if(username.equals("-1")) System.out.println("Can Not Log In!");
    else{
        System.out.printf("%s Has Logged In! \n",username);
        System.out.println("");
        outerloop:
        while(true){
        showLoginMenu();
        int usersLoginChoice = usersChoice(scan,username);
        if(usersLoginChoice == 3) break;
        switchTo(usersLoginChoice,scan,username);
        }
    }      
}

private void showLoginMenu(){
    System.out.println("");
    System.out.println("1- Write Diary");
    System.out.println("2- Read Diary");
    System.out.println("3- Logout");
    System.out.println("");

}

private int usersChoice(Scanner scan , String username){
    System.out.print("Choose An Option: "); 
    while(true){
        try{
            return scan.nextInt();
        } catch(Exception e){
            System.out.println("Invalid Input!");
            return -1;
        }
    }
}

private void switchTo(int usersLoginChoice, Scanner scan, String username){
    switch(usersLoginChoice){
        case 1:
            writeDiary(scan,username);
            break;
        case 2:
            readDiary(username);
            break;
        default:
            System.out.println("Invalid Input!");
            break;
    }
}

private void writeDiary(Scanner scan, String username){
    File diaryFile = new File("D:"+username+".txt");
    String input = "1";
    System.out.println("Start Writing Your Diary (-1 to stop): ");
    while(!input.equals("-1")){           
        try (PrintWriter writeDiary = new PrintWriter(new BufferedWriter(new FileWriter(diaryFile, true)))){
            input = scan.nextLine();
            if(!input.equals("-1")) writeDiary.println(input);
        } catch(Exception e){
            System.out.println("Could Not Write Diary!");
            break;
        }
    }
    System.out.println("");
    System.out.println("Diary Saved!");
}

private void readDiary(String username){       
    File diaryFile = new File("D:"+username+".txt");
    try(Scanner readDiary = new Scanner(diaryFile)){
        while(readDiary.hasNext()) System.out.println(readDiary.nextLine());
    } catch(Exception e){
        System.out.println("Could Not Open Diary File!");
    }               
}
