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
 * @author Andreas Blume <bluman91>
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
    
    public User findUserById(Integer UserID) {
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
    
    public User findByUsername(String username) {
        Query queryfindByUsername = em.createNamedQuery("User.findByUsername");
        queryfindByUsername.setParameter("username", username);
        List<User> users = queryfindByUsername.getResultList();
        
        if(users != null) {
            if(!users.isEmpty() && (users.size() == 1)) {
                User user = users.get(0);
                return user;
            }
        }
        
        return null;
    }
    
    public List<User> getFriends(Integer UserID) {
        Query queryFindFriends = em.createNativeQuery("SELECT u.* "
                                                    + "FROM User AS u "
                                                    + "WHERE u.id IN (SELECT (CASE WHEN f.USER_ID != ?1 THEN f.USER_ID "
                                                                                + "ELSE f.USER_ID1 END) AS userId "
                                                                   + "FROM Friendship AS f "
                                                                   + "WHERE f.confirmed = 1 "
                                                                     + "AND (f.USER_ID = ?1 OR f.USER_ID1 = ?1)) "
                                                    + "ORDER BY u.username", User.class);
        queryFindFriends.setParameter(1, UserID);
        List<User> friends = queryFindFriends.getResultList();
        
        if((friends != null) && !friends.isEmpty())
            return friends;
        
        return null;
    }
    
    public List<User> getUserListByUsername(String username) {
        Query queryFindUsers = em.createQuery("SELECT u FROM User u WHERE u.username LIKE :username");
        queryFindUsers.setParameter("username", "%" + username + "%");
        List<User> userList = queryFindUsers.getResultList();
        
        if ((userList != null) && !userList.isEmpty()) return userList;
        
        return null;
    }
}
