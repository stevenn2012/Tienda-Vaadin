package co.edu.usa.adf.Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones.franfia;
import co.edu.usa.adf.tomates.Producto;
import co.edu.usa.adf.tomates.Venta;

public class App {
	

	private static String[] rutasDescriptores = {
			"Datos/Descriptores/Descriptor_Contacto.txt",
			"Datos/Descriptores/Descriptor_Evento.txt",
			"Datos/Descriptores/Descriptor_Contacto2.txt",
			"Datos/Descriptores/Descriptor_Pais.txt",
			"Datos/Descriptores/Descriptor_Pelicula.txt",
			"Datos/Descriptores/Descriptor_Series.txt",
			"Datos/Descriptores/Descriptor_Producto.txt",
			"Datos/Descriptores/Descriptor_Venta.txt"
	};
	
	public static void main(String[] args) {
		try {
			for (int i = 0; i < rutasDescriptores.length; i++) {
				correrFramework(rutasDescriptores[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private static void correrFramework(String descriptor) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException, ParseException {
		franfia<Object> prueba = new franfia<Object>(descriptor);
		imprimirLista(prueba.leerArchivo());
		prueba.escribirArchivo(false);
		System.out.println("------------------------------------------------------------------------>\n");
	}
	
	private static void imprimirLista(ArrayList<Object> datos) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException, ParseException{
		for (int i = 0; i < datos.size(); i++) {
			System.out.println(datos.get(i));
		}
	}
}
