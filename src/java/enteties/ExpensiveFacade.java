/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteties;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mohamad Bilani
 */
@Stateless
public class ExpensiveFacade extends AbstractFacade<Expensive> {
    @PersistenceContext(unitName = "depensePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExpensiveFacade() {
        super(Expensive.class);
    }
    
}
