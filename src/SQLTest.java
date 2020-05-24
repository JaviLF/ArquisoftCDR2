import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class SQLTest {

	@Test
	void test() {
		Almacenamiento alm=new AlmacenamientoSQL();
		CDR cdr = new CDR("1111","2222222",12,2.5);
		Plan planDeJavier = new PlanPrepago();
		Linea lineaDeJavier=new Linea("1111","Javier Loayza",planDeJavier);
		Assert.assertEquals(3.625,cdr.calcularTarifaParaLinea(lineaDeJavier));
		//alm.guardarCDR(cdr);
		alm.cargarCDRs();
	}
	
	@Test
	void testCreatePlanesTable() {
		Almacenamiento alm=new AlmacenamientoSQL();
		Plan wow = new PlanWow();
		//alm.guardarPlan(wow);
	}
	
	@Test
	void testGuardarPlanDTOaPlanes() {
		Almacenamiento alm=new AlmacenamientoSQL();
		PlanDTO dto = new PlanDTO("PREPAGO","HorarioReducido+HorarioNormal+HorarioSuperReducido","1.45+0.95+0.70");
		alm.guardarPlan(dto);
		assertNull("Llego a Guardar 36 testGuardarPlanDTO", null);
	}
	
	
	@Test
	void testCargarPlanes() {
		Almacenamiento alm=new AlmacenamientoSQL();
		//Plan wow = new PlanWow();
		//alm.guardarPlan(wow);
		assertNull("Llego a Cargar 45 testCargarPlanes", alm.cargarPlanes());
		
	}
	
	
}
