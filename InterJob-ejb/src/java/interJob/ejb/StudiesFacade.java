/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.ejb;

import interJob.entity.Studies;
import interJob.entity.User;
import java.util.List;


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
public class StudiesFacade extends AbstractFacade<Studies> {

    @PersistenceContext(unitName = "InterJob-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudiesFacade() {
        super(Studies.class);
    }
    
    public List<Studies> findStudiesByUser(User user) {
        Query queryFindStudiesByUser = em.createQuery("SELECT s "
                                                    + "FROM Studies s "
                                                    + "WHERE s.userId = :user "
                                                    + "ORDER BY s.startDate DESC");
        queryFindStudiesByUser.setParameter("user", user);
        return queryFindStudiesByUser.getResultList();
    }
}
