package co.edu.usa.adf.TiendaVaadin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.edu.usa.adf.datos.Producto;
import co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones.franfia;

public class ProductoService {

	private static ProductoService instance;
	private static final Logger LOGGER = Logger.getLogger(ProductoService.class.getName());
	private final HashMap<String, Producto> contacts = new HashMap<>();
	
	private ProductoService() {
	}

	public static ProductoService getInstance() {
		if (instance == null) {
			instance = new ProductoService();
			instance.ensureTestData();
		}
		return instance;
	}

	public synchronized List<Producto> findAll() {
		return findAll(null);
	}

	public synchronized List<Producto> findAll(String stringFilter) {
		ArrayList<Producto> arrayList = new ArrayList<>();
		for (Producto contact : contacts.values()) {
			try {
				//--------
				boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())	|| contact.toString().toLowerCase().contains(stringFilter.toLowerCase());
				if (passesFilter) {
					arrayList.add(contact.clone());
				}
			} catch (CloneNotSupportedException ex) {
				Logger.getLogger(ProductoService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		Collections.sort(arrayList, new Comparator<Producto>() {

			@Override
			public int compare(Producto o1, Producto o2) {
				return (int) (o2.getProductoId().compareTo(o1.getProductoId()));
			}
		});
		return arrayList;
	}

	public synchronized List<Producto> findAll(String stringFilter, int start, int maxresults) {
		ArrayList<Producto> arrayList = new ArrayList<>();
		for (Producto contact : contacts.values()) {
			try {
				boolean passesFilter = (stringFilter == null || stringFilter.isEmpty()) || contact.toString().toLowerCase().contains(stringFilter.toLowerCase());
				if (passesFilter) {
					arrayList.add(contact.clone());
				}
			} catch (CloneNotSupportedException ex) {
				Logger.getLogger(ProductoService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		Collections.sort(arrayList, new Comparator<Producto>() {

			@Override
			public int compare(Producto o1, Producto o2) {
				return (int) (o2.getProductoId().compareTo(o1.getProductoId()));
			}
		});
		int end = start + maxresults;
		if (end > arrayList.size()) {
			end = arrayList.size();
		}
		return arrayList.subList(start, end);
	}

	public synchronized long count() {
		return contacts.size();
	}

	public void delete(Producto value) {
		System.out.println("Eliminando: "+value);
		if(contacts.get(value.getProductoId())!=null){
			contacts.remove(value.getProductoId());
			System.out.println("Dato eliminado con exito!");
		}
	}

	public synchronized void save(Producto entry) {
		if (entry == null) {
			LOGGER.log(Level.SEVERE,"Producto is null.");
			return;
		}
		try {
			entry = (Producto) entry.clone();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		contacts.put(entry.getProductoId(), entry);
	}

	public void ensureTestData() {
		System.out.println("Leyendo datos de persistencia...");
		if (findAll().isEmpty()) {
			try {
				ArrayList<Producto> productos = new franfia<Producto>("Datos/Descriptores/Descriptor_Producto.txt").leerArchivo();	
				for (int i = 0; i < productos.size(); i++) {
					save(productos.get(i));
				}
			} catch (Exception e) {
				System.out.println("Error cargando datos Franfia: "+e);
			}
		}
		System.out.println("Datos leidos con exito!");
		System.out.println("----------------->");
	}
	
	public void guardarDatos(){
		System.out.println("Guardando en persistencia...");
		try {
			ArrayList<Producto> productos = new ArrayList<Producto>();
			for (Producto contact : contacts.values()) {
				productos.add(contact);
			}
			franfia<Producto> prod = new franfia<Producto>("Datos/Descriptores/Descriptor_Producto.txt");
			Collections.sort(productos, new Comparator<Producto>() {
				@Override
				public int compare(Producto o1, Producto o2) {
					return (int) (o2.getProductoId().compareTo(o1.getProductoId()));
				}
			});
			
			prod.setDatos(productos);
			prod.escribirArchivo(false);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE,"Error guardando");
		}
		System.out.println("Datos guardados en persistencia con exito!");
	}
	
	public int datosSize(){
		return contacts.size();
	}
}
