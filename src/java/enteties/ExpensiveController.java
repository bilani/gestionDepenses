package enteties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "expensiveController")
@ViewScoped
public class ExpensiveController extends AbstractController<Expensive> {

    @EJB
    private ExpensiveFacade ejbFacade;

    /**
     * Initialize the concrete Expensive controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     * <p>
     * In addition, this controller also requires references to controllers for
     * parent entities in order to display their information from a context
     * menu.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
        FacesContext context = FacesContext.getCurrentInstance();
    }

    public ExpensiveController() {
        // Inform the Abstract parent controller of the concrete Expensive?cap_first Entity
        super(Expensive.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Transaction entities that
     * are retrieved from Expensive?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Transaction page
     */
    public String navigateTransactionCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Transaction_items", this.getSelected().getTransactionCollection());
        }
        return "/transaction/index";
    }

}
