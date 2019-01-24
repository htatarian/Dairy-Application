public void removeAccount(Scanner scan){
        remove(scan);
        refresh(); 
}

public void remove(Scanner scan){
    String accountName = loginName(scan);
    if(!accountName.equals("-1")){
    removeFile(accountName);
    removeFromList(accountName);
    System.out.println("Account Has Been Successfully Removed!");
    }
    else System.out.println("Could Not Remove Account!");
}

public void removeFile(String accountName){
    File deleteUsername = new File("D:"+accountName+".txt");
    deleteUsername.delete();         
}

public void removeFromList(String accountName){               
    if(!accountName.equals("-1")) { 
        for(int i = 0; i < getUsernamesList().size();i++)              
            if(getUsernamesList().get(i).equals(accountName)){
                getUsernamesList().remove(i);
                getPasswordsList().remove(i);
                break;
            }
    }
    else System.out.println("Can Not Erase Account!");
}


public void refresh(){
    refreshUsernames();
    refreshPasswords();
}

public void refreshUsernames(){
    try (PrintWriter usernamesOverWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.usernamesFile)))){
        getUsernamesList().stream().forEach((b) -> {
        usernamesOverWriter.println(b);            
    });
    usernamesOverWriter.flush();
    } catch (IOException ex) {
        Logger.getLogger(AccountRemover.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void refreshPasswords(){
    try (PrintWriter passwordsOverWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.passwordsFile)))){
        getPasswordsList().stream().forEach((b) -> {
        passwordsOverWriter.println(b);            
    });
    passwordsOverWriter.flush();
    } catch (IOException ex) {
        Logger.getLogger(AccountRemover.class.getName()).log(Level.SEVERE, null, ex);
    }
}
