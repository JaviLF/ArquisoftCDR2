import java.util.List;

public interface Almacenamiento {
	public void guardarPlan(Plan plan);
	public void guardarCDR(CDR cdr);
	public List<Plan> cargarPlanes();
	public List<CDR> cargarCDRs();
}
