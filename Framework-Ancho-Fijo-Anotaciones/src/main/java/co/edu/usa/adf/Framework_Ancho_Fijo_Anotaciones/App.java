package co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;

public class App {
	

	private static String[] rutasDescriptores = {
			"Datos/Descriptores/Descriptor_Contacto.txt",
			"Datos/Descriptores/Descriptor_Evento.txt",
			"Datos/Descriptores/Descriptor_Contacto2.txt",
			"Datos/Descriptores/Descriptor_Pais.txt",
			"Datos/Descriptores/Descriptor_Pelicula.txt",
			"Datos/Descriptores/Descriptor_Series.txt"
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
		System.out.println("Inicio------------------------------------------------------------------>");
		franfia prueba = new franfia(descriptor);
		ArrayList<Object> datos = prueba.leerArchivo();
		for (int i = 0; i < datos.size(); i++) {
			System.out.println(datos.get(i));
		}
		System.out.println("Guardando--------------------------------------------------------------->");
		prueba.escribirArchivo();
		System.out.println("------------------------------------------------------------------------>\n");
	}
}
