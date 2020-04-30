import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ArchivoTest {

	@Test
	void testForSavePlanes() {
		Plan planPre=new PlanPrepago();
		Plan planPost=new PlanPostpago();
		List<String> numerosAmigos = new ArrayList<String>();
		numerosAmigos.add("0000");
		numerosAmigos.add("1111");
		Plan planWow = new PlanWow(numerosAmigos);
		Archivo archive = new Archivo();
		archive.guardarPlan(planPre);
		archive.guardarPlan(planPost);
		archive.guardarPlan(planWow);
		List<Plan> planes = archive.cargarPlanes();
		Assert.assertEquals(3,planes.size());
	}

}
