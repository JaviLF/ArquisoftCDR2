
public class Linea {
	private String numero;
	private String tipoDePlan;
	private String nombrePropietario;
	private Plan plan;
	
	public Linea(){
		numero="0000";
		tipoDePlan="prepago";
		nombrePropietario="Pepe";
		plan=new PlanPrepago();
	}
	public Linea(String tipoPlan,String numero,String nombrePropietario,Plan plan) {
		this.numero=numero;
		this.tipoDePlan=tipoPlan;
		this.nombrePropietario=nombrePropietario;
		this.plan=plan;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipoDePlan() {
		return tipoDePlan;
	}
	public void setTipoDePlan(String plan) {
		this.tipoDePlan = plan;
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
