package funciones;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Funciones {
	
	public static String fechaAFormatoBarras(GregorianCalendar fecha){
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		int mes = fecha.get(Calendar.MONTH) + 1;
		int anio = fecha.get(Calendar.YEAR);
		
		String diaTexto = (dia < 10) ? "0" + dia : Integer.toString(dia);
		String mesTexto = (mes < 10) ? "0" + mes : Integer.toString(mes);
		String anioTexto = Integer.toString(anio);
		
		String fechaBarras = diaTexto + "/" + mesTexto + "/" + anioTexto;
		
		return fechaBarras;
		
	}
	
	public static String formatearFloat(float num) {
		Locale loc = new Locale("es","AR");
		String formato = String.format(loc, "%.2f", num);
		return formato;
	}
	
	public static String booleanoATexto(boolean var) {
		if(var)
			return "Si";
		else
			return "No";
	}
	
	public static GregorianCalendar textoAFecha(String fecha){
		int dia = Integer.parseInt(fecha.split("/")[0]);
		int mes = Integer.parseInt(fecha.split("/")[1]) - 1;
		int anio= Integer.parseInt(fecha.split("/")[2]);
		return new GregorianCalendar(anio, mes, dia);
	}
	
}
