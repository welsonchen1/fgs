package fgsweb;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named // CDI 用法
// @ManagedBean jsf 用法
@SessionScoped
public class ButtonView {

    private MenuModel model;
    @Inject
    private Conversation conversation;

    @PostConstruct
    public void init() {
	model = new DefaultMenuModel();
	// First submenu
	DefaultSubMenu firstSubmenu = DefaultSubMenu.builder().label("Dynamic Submenu").build();
	DefaultMenuItem item = DefaultMenuItem.builder().value("External").url("http://www.primefaces.org").icon("pi pi-home")
		.build();
	firstSubmenu.getElements().add(item);
	model.getElements().add(firstSubmenu);
	// Second submenu
	DefaultSubMenu secondSubmenu = DefaultSubMenu.builder().label("Dynamic Actions").build();
	item = DefaultMenuItem.builder().value("Save").icon("pi pi-save").command("#{menuView.save}").update("messages").build();
	secondSubmenu.getElements().add(item);
	item = DefaultMenuItem.builder().value("Delete").icon("pi pi-times").command("#{menuView.delete}").ajax(false).build();
	secondSubmenu.getElements().add(item);
	item = DefaultMenuItem.builder().value("Redirect").icon("pi pi-search").command("#{menuView.redirect}").build();
	secondSubmenu.getElements().add(item);
	model.getElements().add(secondSubmenu);
    }

    public MenuModel getModel() {
	return model;
    }

    public String save() {
	addMessage("Data saved");
	return null;
    }

    public void update() {
	addMessage("Data updated");
    }

    public void delete() {
	addMessage("Data deleted");
    }

    public void buttonAction() {
	addMessage("Welcome to PrimeFaces33" + conversation.getId());
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void addMessage(String summary) {
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
	FacesContext.getCurrentInstance().addMessage(null, message);
    }
}