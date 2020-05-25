import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlmacenamientoSQL implements Almacenamiento{
	
	
	private boolean tableExists(String name) {
		Connection con = null;
	    boolean answer = false;
		try {
	      Class.forName("org.sqlite.JDBC");
	      con = DriverManager.getConnection("jdbc:sqlite:test.db");

	      DatabaseMetaData meta = con.getMetaData();
	      
	      //ResultSet res = meta.getTables(null, null, null,new String[] {"TABLE"});
	      ResultSet tables = meta.getTables(null, null, name, null);
	      System.out.println("List of tables: ");
	      //while (tables.next()) {
		  		if (tables.next())
		  		  answer =  true;
	         /*
	    	  System.out.println(
	            "   "+res.getString("TABLE_CAT")
	           + ", "+res.getString("TABLE_SCHEM")
	           + ", "+res.getString("TABLE_NAME")
	           + ", "+res.getString("TABLE_TYPE")
	           + ", "+res.getString("REMARKS"));
	           */
	     // }
	      //res.close();
	      con.close();
	    } catch (Exception e) {
	      System.err.println("Exception: "+e.getMessage());
	    }
		return answer;
		/* Connection con;
		con.
		DatabaseMetaData dbm = con.getMetaData();
		ResultSet tables = dbm.getTables(null, null, name, null);
		if (tables.next()) {
		  return true;
		}
		else {
		  return false;
		}*/
	}
	
	public void connect() {
		Connection c = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	}
	
	public void createCDRTable() {
		Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "CREATE TABLE CDR " +
	                        "(ID INT PRIMARY KEY     NOT NULL," +
	                        " NUMEROLLAMANTE	TEXT  		NOT NULL, " + 
	                        " NUMEROLLAMADO		TEXT  		NOT NULL, " + 
	                        " HORALLAMADA		INT     	NOT NULL, " + 
	                        " DURACIONLLAMADA	DOUBLE     	NOT NULL, " +
	                        " TARIFA			DOUBLE     	NOT NULL )"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}
	
	public void createPlanesTable() {
		Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "CREATE TABLE PLANES " +
	                        "(ID INT PRIMARY KEY     NOT NULL," +
	                        " NOMBRE	TEXT  		NOT NULL, " + 
	                        " CARACTERISTICA		TEXT  		NOT NULL, " + 
	                        " PROPIAS		TEXT     	NOT NULL)"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( "Exception in 66 createPlanesTable(), " + e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}
	
	public void guardarPlan(PlanDTO dto) {
		this.connect();
		this.createPlanesTable();
		Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         
	         String sql = "INSERT INTO PLANES (ID,NOMBRE,CARACTERISTICA,PROPIAS) " + "VALUES ('3','"+ dto.getNombre() + "','" + dto.getCaracteristica() + "','" + dto.getPropias() + "');" ;
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.commit();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println("Exception in 95 guardarPlan(), " + e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	}
	
	public List<CDR> cargarCDRs(){
		List<CDR> CDRs = new ArrayList<CDR>();
		
		Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM CDR;" );
		      
		      while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  name = rs.getString("NUMEROLLAMANTE");
		         String  name2 = rs.getString("NUMEROLLAMADO");
		         int age  = rs.getInt("HORALLAMADA");
		         double  address = rs.getDouble("DURACIONLLAMADA");
		         double salary = rs.getDouble("TARIFA");
		         
		         System.out.println( "ID = " + id );
		         System.out.println( "NUMEROLLAMANTE = " + name );
		         System.out.println( "NUMEROLLAMADO = " + name2 );
		         System.out.println( "HORALLAMADA = " + age );
		         System.out.println( "DURACIONLLAMADA = " + address );
		         System.out.println( "TARIFA = " + salary );
		         System.out.println();
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   System.out.println("Operation done successfully");
		   
		return CDRs;
	}
	
	public List<Plan> cargarPlanes(){
		List<Plan> planes = new ArrayList<Plan>();
		
		if (this.tableExists("PLANES"))
			System.out.println("PLANES table exists");
		else 
			System.out.println("PLANES doesn't exist");
		
		Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM PLANES;" );
		      int id;
		      String  name;
		      String  characteristic;
		      String propias;  
		      
		      while ( rs.next() ) {
		         id = rs.getInt("id");
		         name = rs.getString("NOMBRE");
		         characteristic = rs.getString("CARACTERISTICA");
		         propias = rs.getString("PROPIAS"); 
		         System.out.println( "ID = " + id );
		         System.out.println( "NOMBRE = " + name );
		         System.out.println( "CARACTERISTICA = " + characteristic );
		         System.out.println( "PROPIAS = " + propias );
		         System.out.println();
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   System.out.println("Operation done successfully");
		   
		return null;

	}

	@Override
	public void guardarCDR(CDR cdr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarPlan(Plan plan) {
		// TODO Auto-generated method stub
		
	}
	
}
