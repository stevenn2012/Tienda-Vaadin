package co.edu.usa.adf.TiendaVaadin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FileResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import co.edu.usa.adf.datos.Producto;

@SuppressWarnings("serial")
public class ProductoForm extends HorizontalLayout{
	
	private TextField productoId = new TextField("Identificacion");
	private TextField nombre = new TextField("Nombre");
	private TextArea descripcion = new TextArea("Descripcion");
	private TextField precioUnitario = new TextField("Precio Unitario");
	private TextField cantidadStock = new TextField("Cantidad en Stock");
	private TextField rutaImagen = new TextField("Ruta de imagen");
	
	private Label titulo = new Label("Producto:");
	private Button save = new Button(FontAwesome.CHECK);
	private Button delete = new Button(FontAwesome.TIMES);
	private Button agregar = new Button(FontAwesome.SHOPPING_CART);
	
	private ProductoService service = ProductoService.getInstance();
	private Producto producto;
	private MyUI myUI;
	
	private Image image;
	private boolean imgInit = false;
	public ProductoForm(MyUI myUI){
		this.myUI=myUI;
		
		titulo.setStyleName(ValoTheme.LABEL_LARGE);

		save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		save.setClickShortcut(KeyCode.ENTER);
		
		precioUnitario.setStyleName(ValoTheme.LABEL_COLORED);
		save.addClickListener(e -> save());
		delete.addClickListener(e -> delete());
		agregar.addClickListener(e -> agregarCarro());
		
		setSizeUndefined();
		
		Button cerrarVentana = new Button(FontAwesome.CARET_LEFT);
		CssLayout buttons = new CssLayout(save, delete, agregar, cerrarVentana);
		
		cerrarVentana.addClickListener(e ->{
			myUI.form.setVisible(false);
			myUI.nuevoProducto.setIcon(FontAwesome.PLUS);
			myUI.grid.deselect(myUI.grid.getSelectedRow());
		});
		
		buttons.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		
		FormLayout lay = new FormLayout(titulo, productoId, nombre, descripcion, precioUnitario, cantidadStock, rutaImagen, buttons);
		
		lay.setMargin(false);
		
		addComponents(lay);
		this.setSpacing(true);
		this.setMargin(false);
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
		BeanFieldGroup.bindFieldsBuffered(producto, this);
		delete.setVisible(producto.isPersisted());
		
		if(imgInit){
			this.removeComponent(image);
		}else{
			imgInit=true;
		}
		
		Path path = Paths.get(producto.getRutaImagen());
		if(producto.getRutaImagen()==null || producto.getRutaImagen().isEmpty() || Files.notExists(path)){
			image = new Image("", new FileResource(new File(VaadinService.getCurrent().getBaseDirectory().getAbsolutePath()+"/Imagenes/notExistImage.jpg")));
		}else{
			image = new Image("", new FileResource(new File(producto.getRutaImagen())));
		}
		
		image.setSizeFull();;
		image.setSizeUndefined();
		image.setWidth("300");
		image.setHeight("300");
		this.addComponent(image);
		setVisible(true);
		nombre.selectAll();
	}
	
	private void save(){
		System.out.println("Guardando...");
		producto.setProductoId(productoId.getValue());
		producto.setNombre(nombre.getValue());
		producto.setDescripcion(descripcion.getValue());
		
		String precio=precioUnitario.getValue().replace(".", "").replace(",", ".");
		
		producto.setPrecioUnitario(Double.parseDouble(precio));
		producto.setCantidadStock(Integer.parseInt(cantidadStock.getValue()));
		producto.setRutaImagen(rutaImagen.getValue());
		
		if(service.save(producto)){
			service.guardarDatos();
			myUI.updateList();
			setVisible(false);
			System.out.println("Guardado con exito!");
			Notification.show("Guardado Con exito!");
		}
		System.out.println("---------->");
	}
	
	private void delete(){
		System.out.println("Eliminando...");
		producto.setProductoId(productoId.getValue());
		producto.setNombre(nombre.getValue());
		producto.setDescripcion(descripcion.getValue());
		
		String precio=precioUnitario.getValue().replace(".", "").replace(",", ".");
		
		producto.setPrecioUnitario(Double.parseDouble(precio));
		
		producto.setCantidadStock(Integer.parseInt(cantidadStock.getValue()));
		
		producto.setRutaImagen(rutaImagen.getValue());
		
		if(service.delete(producto)){
			service.guardarDatos();
			myUI.updateList();
			setVisible(false);
		}
		System.out.println("-------------->");
		
	}

	private void agregarCarro(){
		service.agregarProductoVenta(producto);
		myUI.updateVenta();
	}
}
