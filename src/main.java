import java.util.ArrayList;
import java.util.List;

public class main {

	public static void guardarCDR() {
		
		Archivo archivo = new Archivo();
		CDR cdr = new CDR();
		String llamante = "1111111";
		String llamado = "2222222";
		int horaLlamada = 12;
		double duracionLlamada = 1.2;
		double tarifa = 10;
		
		cdr.setNumeroLlamante(llamante);
		cdr.setNumeroLlamado(llamado);
		cdr.setHoraLlamada(horaLlamada);
		cdr.setDuracionLlamada(duracionLlamada);
		
		archivo.guardarCDR(cdr);
	}
	
	public static void cargarCDRs() {
		Archivo archivo = new Archivo();
		List<CDR> cdrs = new ArrayList<CDR>();
		cdrs = archivo.cargarCDRs();
		for (CDR cdr : cdrs) 
		{ 
			System.out.println(cdr.getNumeroLlamante());
			System.out.println(cdr.getNumeroLlamado());
			System.out.println(cdr.getHoraLlamada());
			System.out.println(cdr.getDuracionLlamada());
			System.out.println("******************");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//guardarCDR();
		cargarCDRs();
	}

}
