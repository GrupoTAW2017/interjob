/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.ejb;

import interJob.entity.Friendship;
import interJob.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Francisco Ruiz <pacorf>
 * @author Andreas Blume <bluman91>
 */
@Stateless
public class FriendshipFacade extends AbstractFacade<Friendship> {

    @PersistenceContext(unitName = "InterJob-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FriendshipFacade() {
        super(Friendship.class);
    }
    
    public int deleteFriend(User myself, User friend) {
        Query query = em.createQuery("DELETE FROM Friendship f "
                                   + "WHERE (f.userId = :myself AND f.userId1 = :friend) "
                                      + "OR (f.userId = :friend AND f.userId1 = :myself)");
        query.setParameter("myself", myself);
        query.setParameter("friend", friend);
        
        return query.executeUpdate();
    }
    
}
