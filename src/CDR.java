
public class CDR {
	private String numeroLlamante;
	private String numeroLlamado;

	private int horaLlamada = 0;
	private double duracionLlamada= 0;
	private double tarifa;
	
	public CDR() { 
		numeroLlamante="0000";
		numeroLlamado="1111";
		horaLlamada = 0;
		duracionLlamada= 0.0;
	}
	
	public CDR(String numeroLlamante, String numeroLlamado,int horaLlamada,double duracionLlamada) {
		this.numeroLlamante=numeroLlamante;
		this.numeroLlamado=numeroLlamado;
		this.horaLlamada=horaLlamada;
		this.duracionLlamada=duracionLlamada;
	}
	
	public double calcularTarifaParaLinea(Linea linea) {
		tarifa=duracionLlamada*linea.getTarifaMinuto(horaLlamada, numeroLlamado);
		return tarifa;
	}
	
	public void setHoraLlamada(int horaLlamada) {
		this.horaLlamada=horaLlamada;
	}
	public int getHoraLlamada() {
		return horaLlamada;
	}
	public void setDuracionLlamada(double tiempoLlamada) {
		this.duracionLlamada=tiempoLlamada;
	}
	public double getDuracionLlamada() {
		return duracionLlamada;
	}
	public void setNumeroLlamante(String numeroLlamante) {
		this.numeroLlamante=numeroLlamante;
	}
	public String getNumeroLlamante() {
		return numeroLlamante;
	}
	public void setNumeroLlamado(String numeroLlamado) {
		this.numeroLlamado=numeroLlamado;
	}
	public String getNumeroLlamado() {
		return numeroLlamado;
	}
	public double getTarifa() {
		return this.tarifa;
	}
}
