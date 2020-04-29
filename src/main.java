
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
		archivo.cargarCDRs();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//guardarCDR();
		cargarCDRs();
	}

}
