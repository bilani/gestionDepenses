package enteties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "incomeTypeController")
@ViewScoped
public class IncomeTypeController extends AbstractController<IncomeType> {

    @EJB
    private IncomeTypeFacade ejbFacade;

    /**
     * Initialize the concrete IncomeType controller bean. The
     * AbstractController requires the EJB Facade object for most operations.
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

    public IncomeTypeController() {
        // Inform the Abstract parent controller of the concrete IncomeType?cap_first Entity
        super(IncomeType.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of IncomeTrans entities that
     * are retrieved from IncomeType?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for IncomeTrans page
     */
    public String navigateIncomeTransCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("IncomeTrans_items", this.getSelected().getIncomeTransCollection());
        }
        return "/incomeTrans/index";
    }

}
