package co.edu.usa.adf.TiendaVaadin;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	private CustomerService service = CustomerService.getInstance();
    private Grid grid = new Grid();
    private TextField filterText = new TextField();
    
	@Override
    protected void init(VaadinRequest vaadinRequest) {
    	VerticalLayout layout = new VerticalLayout();
    	
    	filterText.setInputPrompt("Filter by Name...");
    	filterText.addTextChangeListener(e ->{
    		grid.setContainerDataSource(new BeanItemContainer<>(Customer.class, 
    				service.findAll(e.getText())));	
    	});
    	
    	Button clearFilterText = new Button(FontAwesome.TIMES);
    	clearFilterText.addClickListener(e->{
    		filterText.clear();
    		updateList();
    	});
    	
    	CssLayout filtering = new CssLayout();
    	filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
    	filtering.addComponents(filterText,clearFilterText);
    	
    	grid.setColumns("firstName", "lastName", "email");
    	layout.addComponents(filtering,grid);
    	
    	updateList();
    	
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
    }
	
	public void updateList(){
		List<Customer> customers = service.findAll(filterText.getValue());
    	grid.setContainerDataSource(new BeanItemContainer<>(Customer.class, customers));
	}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
