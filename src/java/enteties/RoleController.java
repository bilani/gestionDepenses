package enteties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;

@ManagedBean(name = "roleController")
@ViewScoped
public class RoleController extends AbstractController<Role> {

    @EJB
    private RoleFacade ejbFacade;

    /**
     * Initialize the concrete Role controller bean. The AbstractController
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

    public RoleController() {
        // Inform the Abstract parent controller of the concrete Role?cap_first Entity
        super(Role.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of User entities that are
     * retrieved from Role?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for User page
     */
    public String navigateUserCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("User_items", this.getSelected().getUserCollection());
        }
        return "/user/index";
    }

}
