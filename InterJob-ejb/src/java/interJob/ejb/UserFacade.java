/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.ejb;

import interJob.entity.User;
import java.util.List;
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
    
    public User loginUser (String username, String password) {        
        Query queryFindByUsernameAndPassword = em.createNamedQuery("User.findByUsernameAndPassword");
        queryFindByUsernameAndPassword.setParameter("username", username);
        queryFindByUsernameAndPassword.setParameter("password", password);
        List<User> users = queryFindByUsernameAndPassword.getResultList();
        
        if(users != null) {
            if(!users.isEmpty() && (users.size() == 1)) {
                User user = users.get(0);
                return user;
            }
        }
        
        return null;
    }
    
    public User getUser(Integer UserID) {
        Query queryfindById = em.createNamedQuery("User.findById");
        queryfindById.setParameter("id", UserID);
        List<User> users = queryfindById.getResultList();
        
        if(users != null) {
            if(!users.isEmpty() && (users.size() == 1)) {
                User user = users.get(0);
                return user;
            }
        }
        
        return null;
    }
    
    public List<User> getFriends(Integer UserID) {
        Query queryFindFriends = em.createQuery("SELECT u FROM User u WHERE u.id IN (SELECT (CASE WHEN f.userId != :id THEN f.userId ELSE f.userId1 END) AS userId FROM Friendship f WHERE f.confirmed = 1 AND (f.userId = :id OR f.userId1 = :id))");
        queryFindFriends.setParameter("id", UserID);
        List<User> friends = queryFindFriends.getResultList();
        
        if((friends != null) && !friends.isEmpty())
            return friends;
        
        return null;
    }
    
}
