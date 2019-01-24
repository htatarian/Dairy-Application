public void createAccount(Scanner scan){
    try{
        System.out.print("Enter Your Username: ");
        String username = scan.next();       
        if(!isValidUsername(username)) System.out.println("Username Already Exists!");
        else{
            while(true){
                System.out.print("Enter Your Password: ");
                String pass1 = scan.next();
                System.out.print("Re-Enter Your Passowrd: ");
                String pass2 = scan.next();
                if(!arePasswordsMatch(pass1,pass2)) System.out.println("Passowrds Don't Match!");
                else {
                    addToAccountsList(username,pass1);
                    createTheUsersFile(username);
                    System.out.println("The Account Has Been Successfully Created!");
                    break;
                }
            }
        }
        } catch(Exception e){
            System.out.println("Could Not Create Account!");
        }    

}

private boolean isValidUsername(String username){      
        return getUsernamesList().stream().noneMatch((valid) -> (valid.equals(username)));
}

private boolean arePasswordsMatch(String pass1, String pass2){       
    return pass1.equals(pass2); 
}

private boolean createTheUsersFile(String username){
    File newUserFile = new File("D:"+username+".txt");
    try {
        newUserFile.createNewFile();
    } catch (IOException ex) {
        Logger.getLogger(AccountCreator.class.getName()).log(Level.SEVERE, null, ex);
    }
    return newUserFile.exists();
}
