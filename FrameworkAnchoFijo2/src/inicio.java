

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;

import Fanfia.franfia;

public class inicio {

	public static void main(String[] args) {
		try {
			tomateContacto();
			tomateEventos();
			tomatePaises();
			tomateSeries();
			tomatePeliculas();
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
	
	private static void tomatePeliculas() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ParseException {
		System.out.println("Leyendo Descriptor Pelicula...\n");
		franfia prueba = new franfia("Datos/Descriptores/Descriptor_Pelicula.txt");
		
		System.out.println("Leyendo Datos...");
		System.out.println(prueba.leerArchivo());
		
		System.out.println("Guardando Datos...");
		prueba.escribirArchivo();
		
		System.out.println("-----------------------------------------------");
	}

	private static void tomateSeries() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException, ParseException {
		System.out.println("Leyendo Descriptor Serie...\n");
		franfia prueba = new franfia("Datos/Descriptores/Descriptor_Series.txt");
		
		System.out.println("Leyendo Datos...");
		System.out.println(prueba.leerArchivo());
		
		System.out.println("Guardando Datos...");
		prueba.escribirArchivo();
		
		System.out.println("-----------------------------------------------");
	}

	private static void tomatePaises() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException, ParseException {
		System.out.println("Leyendo Descriptor Pais...\n");
		franfia prueba = new franfia("Datos/Descriptores/Descriptor_Pais.txt");
		
		System.out.println("Leyendo Datos...");
		System.out.println(prueba.leerArchivo());
		
		System.out.println("Guardando Datos...");
		prueba.escribirArchivo();
		
		System.out.println("-----------------------------------------------");
	}

	public static void tomateContacto() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ParseException{
		System.out.println("Leyendo Descriptor Contacto...\n");
		franfia prueba = new franfia("Datos/Descriptores/Descriptor_Contacto.txt");
		
		System.out.println("Leyendo Datos...");
		System.out.println(prueba.leerArchivo());
		
		System.out.println("Guardando Datos...");
		prueba.escribirArchivo();
		
		System.out.println("-----------------------------------------------");
	}
	
	public static void tomateEventos() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ParseException{
		System.out.println("Leyendo Descriptor Evento...\n");
		franfia prueba = new franfia("Datos/Descriptores/Descriptor_Evento.txt");
		
		System.out.println("Leyendo Datos...");
		System.out.println(prueba.leerArchivo());
		
		System.out.println("Guardando Datos...");
		prueba.escribirArchivo();
		
		System.out.println("-----------------------------------------------");
	}
}
