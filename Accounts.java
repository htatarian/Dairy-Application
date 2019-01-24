protected File usernamesFile = new File("D:Usernames.txt");
protected File passwordsFile = new File("D:Passwords.txt");

private static ArrayList<String> accounts_Usernames = new ArrayList<>();
private static ArrayList<String> accounts_Passwords = new ArrayList<>();  

protected void addToAccountsList(String username, String password){       
    addToAccounts(username,password);
    loadAccounts();
}


private void addToAccounts(String username,String password){
    addToUsernames(username);
    addToPasswords(password);
}

private void addToUsernames(String username){
    if(usernamesFile.exists()){
        try (PrintWriter usernamesWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.usernamesFile, true)))) {
            usernamesWriter.println(username);
            usernamesWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else System.err.println("File: Usernames Does Not Exist!");       
}

private void addToPasswords(String password){
    if(passwordsFile.exists()){
            try (PrintWriter passwordsWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.passwordsFile, true)))) {
                passwordsWriter.println(password);
                passwordsWriter.flush();
            } catch (IOException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else System.err.println("File: Passwords Does Not Exist!");  
}


protected void loadAccounts(){
    loadUsernames();
    loadPasswords();
}

private void loadUsernames(){       
    try (Scanner usernamesScanner = new Scanner(usernamesFile)) {
        while(usernamesScanner.hasNext()){
            String username = usernamesScanner.next();
            if(!accounts_Usernames.contains(username))accounts_Usernames.add(username);
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void loadPasswords(){
    try (Scanner passwordsScanner = new Scanner(passwordsFile)) {
        while(passwordsScanner.hasNext()){
            String password = passwordsScanner.next();
            if(!accounts_Passwords.contains(password))accounts_Passwords.add(password);
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
    }
}


protected ArrayList<String> getUsernamesList(){
    return accounts_Usernames;
}

protected ArrayList<String> getPasswordsList(){
    return accounts_Passwords;
} 
