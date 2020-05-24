import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

public class AlmacenamientoArchivosTexto implements Almacenamiento{
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
			
	public void guardarCDR(CDR cdr) {
		try {
			File f = new File("cdrs.txt");
			FileWriter fw;
			BufferedWriter bw;
			if(f.exists()){
				fw = new FileWriter(f,true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(cdr.getNumeroLlamante() + "%" + cdr.getNumeroLlamado() + "%" + cdr.getHoraLlamada() + "%" + cdr.getDuracionLlamada() + "%" + cdr.getTarifa());
			}else {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				bw.write("NumeroLlamante%NumeroLlamado%HoraLlamada%DuracionLlamada%Tarifa\n");
				bw.write(cdr.getNumeroLlamante() + "%" + cdr.getNumeroLlamado() + "%" + cdr.getHoraLlamada() + "%" + cdr.getDuracionLlamada() + "%" + cdr.getTarifa());
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
				Plan plan = null;
				while((linea = br.readLine()) != null) {
					String [] datoPlan = linea.split("%");
					//Plan plan = null;
					//System.out.println(datoPlan[0]);		
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
					//System.out.println(plan.getDatosPlan().get(0));
				
					planes.add(plan);
				}
				br.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return planes;
	}
			
			
	public List<CDR> cargarCDRs() {
		List<CDR> cdrs = new ArrayList<CDR>();
		try {
			File f = new File("cdrs.txt");
			if(f.exists()) {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				linea = br.readLine();//skip header
				while((linea = br.readLine()) != null) {
					String [] contacto = linea.split("%");
					CDR cdr = new CDR();
					
					cdr.setNumeroLlamante(contacto[0]);
					cdr.setNumeroLlamado(contacto[1]);
					cdr.setHoraLlamada(Integer.parseInt(contacto[2]));
					cdr.setDuracionLlamada(Float.parseFloat(contacto[3]));
					
					//System.out.println(cdr.getNumeroLlamante());
					//System.out.println(cdr.getNumeroLlamado());
					//System.out.println(cdr.getHoraLlamada());
					//System.out.println(cdr.getDuracionLlamada());
					//System.out.println("******************");
					cdrs.add(cdr);
				}
				br.close();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return cdrs;
	}

	@Override
	public void guardarPlan(PlanDTO plan) {
		// TODO Auto-generated method stub
		
	}

}
