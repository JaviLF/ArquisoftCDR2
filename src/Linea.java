
public class Linea {
	private String numero;
	private String nombrePropietario;
	private Plan plan;
	
	public Linea(){
		numero="0000";
		nombrePropietario="Pepe";
		plan=new PlanPrepago();
	}
	public Linea(String numero,String nombrePropietario,Plan plan) {
		this.numero=numero;
		this.nombrePropietario=nombrePropietario;
		this.plan=plan;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNombreUsuario() {
		return nombrePropietario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombrePropietario = nombreUsuario;
	}
	public void setPlan(Plan plan) {
		this.plan=plan;
	}
	public Plan getPlan() {
		return plan;
	}
	
	public double getTarifaMinuto(int Hora,String Numero) {
		return this.plan.calcularTarifaPorMinuto(Hora,Numero);
	}
}
