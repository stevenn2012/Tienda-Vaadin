package co.edu.usa.adf.TiendaVaadin;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import co.edu.usa.adf.datos.Producto;

@SuppressWarnings("serial")
public class ProductoForm extends FormLayout{
	
	private TextField productoId = new TextField("Identificacion");
	private TextField nombre = new TextField("Nombre");
	private TextField descripcion = new TextField("Descripcion");
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
	
	public ProductoForm(MyUI myUI){
		this.myUI=myUI;
		
		titulo.setStyleName(ValoTheme.LABEL_LARGE);
		save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		save.setClickShortcut(KeyCode.ENTER);
		
		precioUnitario.setStyleName(ValoTheme.LABEL_COLORED);
		save.addClickListener(e -> save());
		delete.addClickListener(e -> delete());
		agregar.addClickListener(e -> prueba());
		
		setSizeUndefined();
		
		CssLayout buttons = new CssLayout(save, delete, agregar);
		buttons.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		
		addComponents(titulo, productoId, nombre, descripcion, precioUnitario, cantidadStock, rutaImagen, buttons);
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
		BeanFieldGroup.bindFieldsBuffered(producto, this);
		delete.setVisible(producto.isPersisted());
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
		
		service.save(producto);
		service.guardarDatos();
		myUI.updateList();
		setVisible(false);
		System.out.println("Guardado con exito!");
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
		
		service.delete(producto);
		service.guardarDatos();
		myUI.updateList();
		setVisible(false);
		System.out.println("-------------->");
		
	}

	private void prueba(){
		System.out.println(service.datosSize());
	}
}
