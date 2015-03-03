package enteties;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "transactionController")
@ViewScoped
public class TransactionController extends AbstractController<Transaction> {

    @EJB
    private TransactionFacade ejbFacade;
    private UserController iDuserController;
    private ExpensiveController iDExpensController;
    private List<Object[]> listbyc;

    /**
     * Initialize the concrete Transaction controller bean. The
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
        iDuserController = context.getApplication().evaluateExpressionGet(context, "#{userController}", UserController.class);
        iDExpensController = context.getApplication().evaluateExpressionGet(context, "#{expensiveController}", ExpensiveController.class);
    }

    public TransactionController() {
        // Inform the Abstract parent controller of the concrete Transaction?cap_first Entity
        super(Transaction.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        iDuserController.setSelected(null);
        iDExpensController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the User controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIDuser(ActionEvent event) {
        if (this.getSelected() != null && iDuserController.getSelected() == null) {
            iDuserController.setSelected(this.getSelected().getIDuser());
        }
    }

    /**
     * Sets the "selected" attribute of the Expensive controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIDExpens(ActionEvent event) {
        if (this.getSelected() != null && iDExpensController.getSelected() == null) {
            iDExpensController.setSelected(this.getSelected().getIDExpens());
        }
    }
     public List<Object[]> getListbyc() {
        listbyc = ejbFacade.bycate();
        return listbyc;
    }
    
        public void setListbyc(List<Object[]> listbyc) {
        this.listbyc = listbyc;
    }
}
