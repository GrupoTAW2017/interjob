package interjob.webForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author fuynfactory
 */
public class LoginForm {
    private String login=""; 
    private String password="";
    private boolean accessDenied= false; 
    private boolean writelogin = false; 
    private boolean writepassword = false; 

    
    
    public LoginForm() {
        this.login=""; 
        this.password="";
        this.accessDenied= false; 
        this.writelogin = false; 
        this.writepassword = false; 

    }

    


    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the accessDenied
     */
    public boolean isAccessDenied() {
        return accessDenied;
    }

    /**
     * @param accessDenied the accessDenied to set
     */
    public void setAccessDenied(boolean accessDenied) {
        this.accessDenied = accessDenied;
    }

    /**
     * @return the wirtelogin
     */
    public boolean isWritelogin() {
        return writelogin;
    }

    /**
     * @param wirtelogin the wirtelogin to set
     */
    public void setWritelogin(boolean wirtelogin) {
        this.writelogin = wirtelogin;
    }

    /**
     * @return the writepassword
     */
    public boolean isWritepassword() {
        return writepassword;
    }

    /**
     * @param writepassword the writepassword to set
     */
    public void setWritepassword(boolean writepassword) {
        this.writepassword = writepassword;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }
    
    
}
