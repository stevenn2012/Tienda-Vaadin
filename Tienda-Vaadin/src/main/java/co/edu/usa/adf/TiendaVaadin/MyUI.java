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
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import co.edu.usa.adf.datos.Producto;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class MyUI extends UI {
	
	private ProductoService serviceProductos = ProductoService.getInstance();
	
	private Grid grid = new Grid();
	
	private TextField filterText = new TextField();
	private ProductoForm form = new ProductoForm(this);

	private boolean nuevoActivo = false;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        
        filterText.setInputPrompt("Filter by name...");
        filterText.addTextChangeListener(e -> {
        	grid.setContainerDataSource(new BeanItemContainer<>(Producto.class, 
        			serviceProductos.findAll(e.getText())));
        });
        
        grid.setColumns("productoId", "nombre", "precioUnitario", "cantidadStock");
        
        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
        clearFilterTextBtn.addClickListener(e -> {
        	filterText.clear();
        	updateList();
        });
        
        CssLayout filtering = new CssLayout();
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        filtering.addComponents(filterText, clearFilterTextBtn);     
        
        HorizontalLayout main = new HorizontalLayout(grid, form);
        
        main.setSpacing(true);
        main.setSizeFull();
        grid.setSizeFull();
        main.setExpandRatio(grid, 1);
        
        HorizontalLayout cabecera = new HorizontalLayout();
        cabecera.setSpacing(true);
        
        Button nuevoProducto = new Button(FontAwesome.CARET_RIGHT);
        
        nuevoProducto.addClickListener(e -> {
        	if(!nuevoActivo){
        		nuevoProducto.setIcon(FontAwesome.CARET_LEFT);
        		grid.deselect(grid.getSelectedRow());
        		form.setProducto(new Producto());
        		nuevoActivo=true;
        	}else{
        		nuevoProducto.setIcon(FontAwesome.CARET_RIGHT);
        		form.setVisible(false);
        		nuevoActivo=false;
        	}
        	
        });
        
        
        cabecera.addComponents(filtering, nuevoProducto);
        
        
        layout.addComponents(cabecera, main);
        
        updateList();
        
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
        
        form.setVisible(false);
        
        grid.addSelectionListener(e -> {
        	if(e.getSelected().isEmpty()){
        		form.setVisible(false);
        	}else{
        		nuevoProducto.setIcon(FontAwesome.CARET_RIGHT);
        		Producto Producto = (Producto) e.getSelected().iterator().next();
        		form.setProducto(Producto);
        		nuevoActivo = false;
        	}
        });
    }
    
    public void updateList(){
    	List<Producto> productos = serviceProductos.findAll();
    	grid.setContainerDataSource(new BeanItemContainer<>(Producto.class, productos));
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
