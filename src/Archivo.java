import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Archivo {
	public void guardarPlan(Plan plan) {
		try {
			File f = new File("planes.txt");
			FileWriter fw;
			BufferedWriter bw;
			
			LinkedList<String> datosPlan=plan.getDatosPlan();
			String lineaArchivo = "";
			
			if(f.exists()){
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				
				for(int i=0;i<datosPlan.size();i++) {
					lineaArchivo+=(datosPlan.get(i));
					if(i+1<datosPlan.size())
						lineaArchivo+="%";
				}
				System.out.println(lineaArchivo);
				bw.write(lineaArchivo);
			}else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				
				for(int i=0;i<datosPlan.size();i++) {
					lineaArchivo+=(datosPlan.get(i));
					if(i+1<datosPlan.size())
						lineaArchivo+="%";
				}
				
				bw.write(lineaArchivo);
			}
			bw.close();
			fw.close(); 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Plan> cargarPlanes() {
		List<Plan> planes = new ArrayList<Plan>();
		try {
			File f = new File("planes.txt");
			if(f.exists()) {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while((linea = br.readLine()) != null) {
					String [] datoPlan = linea.split("%");
					Plan plan = null;
					if(datoPlan[0]=="prepago") {
						PlanPrepago planPre=new PlanPrepago();
						planPre.setTarifaHorarioNormal(Double.parseDouble(datoPlan[1]));
						planPre.setTarifaHorarioReducido(Double.parseDouble(datoPlan[2]));
						planPre.setTarifaHorarioSuperReducido(Double.parseDouble(datoPlan[3]));
						plan=planPre;
					}
					if(datoPlan[0]=="postpago") {
						PlanPostpago planPost=new PlanPostpago();
						planPost.setTarifa(Double.parseDouble(datoPlan[1]));
						plan=planPost;
					}
					if(datoPlan[0]=="wow") {
						PlanWow planWow=new PlanWow();
						planWow.setTarifa(Double.parseDouble(datoPlan[1]));
						int cantAmigos=Integer.parseInt(datoPlan[2]);
						for(int i=0;i<cantAmigos;i++) {
							planWow.addNumeroAmigo(datoPlan[3+i]);
						}
						plan=planWow;
					}
					planes.add(plan);
				}
				br.close();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return planes;
	}
}
