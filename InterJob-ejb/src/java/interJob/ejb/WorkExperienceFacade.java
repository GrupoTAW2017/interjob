/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.ejb;

import interJob.entity.User;
import interJob.entity.WorkExperience;

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
public class WorkExperienceFacade extends AbstractFacade<WorkExperience> {

    @PersistenceContext(unitName = "InterJob-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorkExperienceFacade() {
        super(WorkExperience.class);
    }
    
    public List<WorkExperience> findWorkExperiencesByUser(User user) {
        Query queryFindWorkExperiencesByUser = em.createQuery("SELECT w "
                                                            + "FROM WorkExperience w "
                                                            + "WHERE w.userId = :user "
                                                            + "ORDER BY w.startDate DESC");
        queryFindWorkExperiencesByUser.setParameter("user", user);
        return queryFindWorkExperiencesByUser.getResultList();
    }
    
}
