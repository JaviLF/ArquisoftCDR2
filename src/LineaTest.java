import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class LineaTest {

	@Test
	void testForLinea() {
		Linea linea=new Linea();
		
		linea.setNumero("2222");
		
		linea.setNombreUsuario("Andres");
		
		Plan plan = new PlanPostpago();
		
		linea.setPlan(plan);
		Assert.assertEquals("2222",linea.getNumero());
		Assert.assertEquals("Andres",linea.getNombreUsuario());
		Assert.assertEquals(plan,linea.getPlan());
		
	}

}
