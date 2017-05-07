/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.ejb;

import interJob.entity.Hobby;
import interJob.entity.User;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Francisco Ruiz <pacorf>
 */
@Stateless
public class HobbyFacade extends AbstractFacade<Hobby> {

    @PersistenceContext(unitName = "InterJob-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HobbyFacade() {
        super(Hobby.class);
    }
    
    public List<Hobby> findHobbiesByUser(User user) {
        Query queryFindHobbiesByUser = em.createQuery("SELECT h "
                                                    + "FROM Hobby h "
                                                    + "WHERE :user MEMBER OF h.userCollection");
        queryFindHobbiesByUser.setParameter("user", user);
        return queryFindHobbiesByUser.getResultList();
    }
    
}
