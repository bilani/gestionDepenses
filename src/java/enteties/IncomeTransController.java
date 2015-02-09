package enteties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "incomeTransController")
@ViewScoped
public class IncomeTransController extends AbstractController<IncomeTrans> {

    @EJB
    private IncomeTransFacade ejbFacade;
    private UserController iDUserController;
    private IncomeTypeController iDIncomeTypeController;

    /**
     * Initialize the concrete IncomeTrans controller bean. The
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
        iDUserController = context.getApplication().evaluateExpressionGet(context, "#{userController}", UserController.class);
        iDIncomeTypeController = context.getApplication().evaluateExpressionGet(context, "#{incomeTypeController}", IncomeTypeController.class);
    }

    public IncomeTransController() {
        // Inform the Abstract parent controller of the concrete IncomeTrans?cap_first Entity
        super(IncomeTrans.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        iDUserController.setSelected(null);
        iDIncomeTypeController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the User controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIDUser(ActionEvent event) {
        if (this.getSelected() != null && iDUserController.getSelected() == null) {
            iDUserController.setSelected(this.getSelected().getIDUser());
        }
    }

    /**
     * Sets the "selected" attribute of the IncomeType controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIDIncomeType(ActionEvent event) {
        if (this.getSelected() != null && iDIncomeTypeController.getSelected() == null) {
            iDIncomeTypeController.setSelected(this.getSelected().getIDIncomeType());
        }
    }
}
