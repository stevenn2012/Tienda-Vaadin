package co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class franfia<T> {

	private String nombreClase;
	private String rutaArchivo;
	private String rutaGuardar;
	private HashMap<Integer, AtribDat> datosAtributos = new HashMap<Integer, AtribDat>();
	private ArrayList<T> datos = new ArrayList<T>();
	
	public franfia(String rutaDescriptor) throws IOException, ClassNotFoundException{
		BufferedReader leer= new BufferedReader(new FileReader(rutaDescriptor));
			this.nombreClase=leer.readLine();
			this.rutaArchivo=leer.readLine();
			this.rutaGuardar=leer.readLine();
		leer.close();
		Class<?> miClase = Class.forName(nombreClase);
		for (int i = 0; i < miClase.getDeclaredFields().length; i++) {
			String nombre=(miClase.getDeclaredFields()[i].getName().charAt(0)+"").toUpperCase()+(miClase.getDeclaredFields()[i].getName().substring(1));
			String tipo=miClase.getDeclaredFields()[i].getType().getSimpleName();
			String dt[] = (miClase.getDeclaredFields()[i].getDeclaredAnnotations()[0]+"").split("=");
			int posicion=Integer.parseInt(dt[1].substring(0, dt[1].length()-7));
			int ancho=Integer.parseInt(dt[2].substring(0, dt[2].length()-1));
			datosAtributos.put(posicion, new AtribDat(nombre, tipo, ancho));
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> leerArchivo() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ParseException{
		ArrayList<T> datos = new ArrayList<T>();
		BufferedReader leer = new BufferedReader(new FileReader(rutaArchivo));
		Class<?> cls = Class.forName(nombreClase);
		String cadena="";
		while((cadena=leer.readLine())!=null){
			Object inst = cls.newInstance();
			int indexAtrib = cls.getDeclaredFields().length;
			for (int i = 0; i < indexAtrib; i++) {
				AtribDat datAtrib = datosAtributos.get(i);
				String info="";
				if(i==(indexAtrib-1)){
					info = cadena.substring(0, datAtrib.getAncho()).trim();
				}else{
					info = cadena.substring(0, datAtrib.getAncho()-1).trim();
				}
				cadena= cadena.substring(datAtrib.getAncho());
				retorno datMethod = getClass(datAtrib.getTipo(), info);
				Method m = cls.getMethod("set"+datAtrib.getNombre(), datMethod.getClase());
				m.invoke(inst, datMethod.getDato());
			}
			datos.add(validarObjeto((T)inst));
		}
		leer.close();
		this.datos=datos;
		return datos;
	}
	
	public retorno getClass(String tipo, String dato) throws ParseException{
		Class<?> cls = null;
		Object d = null;
		if(tipo.equalsIgnoreCase("boolean")){
			cls = boolean.class;
			d = Boolean.parseBoolean(dato);
		}
		
		if(tipo.equalsIgnoreCase("int")){
			cls = int.class;
			d = Integer.parseInt(dato);
		}
		
		if(tipo.equalsIgnoreCase("integer")){
			cls = java.lang.Integer.class;
			d = Integer.parseInt(dato);
		}
		
		if(tipo.equalsIgnoreCase("long")){
			cls = long.class;
			d = Long.parseLong(dato);
		}
		
		if(tipo.equalsIgnoreCase("char")){
			cls = char.class;
			d = (dato+"").charAt(0);
		}
		
		if(tipo.equalsIgnoreCase("string")){
			cls = java.lang.String.class;
			d = (dato+"");
		}
		
		if(tipo.equalsIgnoreCase("double")){
			cls = double.class;
			d = Double.parseDouble(dato);
		}
		
		if(tipo.equalsIgnoreCase("float")){
			cls = float.class;
			d = Float.parseFloat(dato);
		}
		
		if(tipo.equalsIgnoreCase("date")){
			cls = Date.class;
			SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		    d = formato.parse(dato);	     
		}
		return new retorno(cls, d);
	}

	public class retorno{
		private Class<?> clase;
		private Object dato;
		
		public retorno(Class<?> clase, Object dato){
			this.clase=clase;
			this.dato=dato;
		}

		public Class<?> getClase() {
			return clase;
		}

		public void setClase(Class<?> clase) {
			this.clase = clase;
		}

		public Object getDato() {
			return dato;
		}

		public void setDato(Object dato) {
			this.dato = dato;
		}
	}

	public void escribirArchivo() throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		datos=reordenarArray(datos);
		Class<?> cls = Class.forName(nombreClase);
		BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaGuardar));
			for (int i = 0; i < datos.size(); i++) {
				String info="";
				for (int j = 0; j < datosAtributos.size(); j++) {
					Method m = cls.getMethod("get"+datosAtributos.get(j).getNombre());
					if(!datosAtributos.get(j).getTipo().equalsIgnoreCase("date")){
						info+=String.format("%1$-"+datosAtributos.get(j).getAncho()+"s", m.invoke(datos.get(i)));
					}else{
						SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
						info+=String.format("%1$-"+datosAtributos.get(j).getAncho()+"s", formato.format(m.invoke(datos.get(i))));
					}
				}
				System.out.println("Guardando --> "+info);
				escribir.write(info);
				escribir.newLine();
			}
		escribir.close();
	}
	
	public ArrayList<T> reordenarArray(ArrayList<T> datos){
		for (int i = 0; i < (datos.size()/2); i++) {
			//System.out.println("Cambiando posicion --> "+datos.get(i));
			datos.add(datos.remove(i));
		}
		return datos;
	}

	public ArrayList<T> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<T> datos) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
		for (int i = 0; i < datos.size(); i++) {
			datos.add((T)validarObjeto(datos.remove(i)));
		}
		this.datos = datos;
	}
	
	public Object getDato(int i) {
		return datos.get(i);
	}

	public void setDatos(int i, T dato) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
		this.datos.set(i, validarObjeto(dato));
	}
	
	public void add(T dato) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
		this.datos.add(validarObjeto(dato));
	}
	
	private T validarObjeto(T dato) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException{
		Class<?> cls = Class.forName(nombreClase);
		for (int i = 0; i < datosAtributos.size(); i++) {
			Method m = cls.getMethod("get"+datosAtributos.get(i).getNombre());
			String info = m.invoke(dato)+"";
			int n = info.length();
			if(n>datosAtributos.get(i).getAncho() && !datosAtributos.get(i).getTipo().equalsIgnoreCase("date")){
				info=info.substring(0, datosAtributos.get(i).getAncho());
				retorno datMethod = getClass(datosAtributos.get(i).getTipo(), info);
				m = cls.getMethod("set"+datosAtributos.get(i).getNombre(), datMethod.getClase());
				m.invoke(dato, datMethod.getDato());
			}
		}
		return dato;
	}
}
