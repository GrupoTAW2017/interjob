/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.ejb;

import interJob.entity.WorkExperience;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
