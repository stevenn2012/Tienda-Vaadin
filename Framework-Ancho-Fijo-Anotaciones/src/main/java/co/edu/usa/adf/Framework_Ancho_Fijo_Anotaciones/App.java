package co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public class App {
	public static void main(String[] args) {
		try {
			correrTomate("Datos/Descriptores/Descriptor_Contacto.txt");
			correrTomate("Datos/Descriptores/Descriptor_Evento.txt");
			correrTomate("Datos/Descriptores/Descriptor_Contacto2.txt");
			correrTomate("Datos/Descriptores/Descriptor_Pais.txt");
			correrTomate("Datos/Descriptores/Descriptor_Pelicula.txt");
			correrTomate("Datos/Descriptores/Descriptor_Series.txt");
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
	
	private static void correrTomate(String descriptor) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException, ParseException {
		System.out.println("Tomate Descriptor: "+descriptor.split("/")[descriptor.split("/").length-1]);
		franfia prueba = new franfia(descriptor);
		prueba.leerArchivo();
		prueba.escribirArchivo();
		System.out.println("-----------------------------------------------");
	}
}
