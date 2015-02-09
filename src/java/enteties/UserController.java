package enteties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "userController")
@ViewScoped
public class UserController extends AbstractController<User> {

    @EJB
    private UserFacade ejbFacade;
    private RoleController roleIDController;

    /**
     * Initialize the concrete User controller bean. The AbstractController
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
        roleIDController = context.getApplication().evaluateExpressionGet(context, "#{roleController}", RoleController.class);
    }

    public UserController() {
        // Inform the Abstract parent controller of the concrete User?cap_first Entity
        super(User.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        roleIDController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of IncomeTrans entities that
     * are retrieved from User?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for IncomeTrans page
     */
    public String navigateIncomeTransCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("IncomeTrans_items", this.getSelected().getIncomeTransCollection());
        }
        return "/incomeTrans/index";
    }

    /**
     * Sets the "selected" attribute of the Role controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRoleID(ActionEvent event) {
        if (this.getSelected() != null && roleIDController.getSelected() == null) {
            roleIDController.setSelected(this.getSelected().getRoleID());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Transaction entities that
     * are retrieved from User?cap_first and returns the navigation outcome.
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
