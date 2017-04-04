/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.ejb;

import interJob.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fuynfactory
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "InterJob-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User loginUser (User user) {
        User userLogin =null; // new User(); 
        try { 
            Query query =
                getEntityManager().createQuery("SELECT u FROM User u WHERE u.username = :username");
           query.setParameter("username", user.getUsername());
        } catch (Exception e){
            
        }
        
           
        return userLogin;
    }
    
}
