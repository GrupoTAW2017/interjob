package interjob.user;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author fuynfactory
 */
public class User {
    private long id = 0;
    private String username = null; 
    private boolean loggedIn= false;
    
    public User() {
        /*
        this.username = null; 
        this.id = 0;
        this.loggedIn= false; 
        */
    }


    /**
     * @return the id
     */
    public Long getID() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setID(Long id) {
        this.id = id;
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
}
