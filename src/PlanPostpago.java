
public class PlanPostpago implements Plan{
	//propiedades plan
	private double tarifa=0.99;
		
	PlanPostpago(){	}
		
	public double calcularTarifaPorMinuto(int horaLlamada,String numeroLlamado) {
		return tarifa;
	}
}
