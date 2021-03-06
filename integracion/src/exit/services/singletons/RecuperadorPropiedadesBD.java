package exit.services.singletons;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import exit.services.fileHandler.ConstantesGenerales;

public class RecuperadorPropiedadesBD {
	private String driverType;
	private String user;
	private String password;
	private String database;
	private String puerto;
	private String ipConexion;
	private String conexion;
	
	private static RecuperadorPropiedadesBD instance;
	
	private RecuperadorPropiedadesBD() {
		  Properties props = new Properties();
	        try{
	        
			props.load(new FileReader(ConstantesGenerales.PATH_CONFIGURACION+"/Bd.properties"));
			 this.driverType= props.getProperty("driverType");
			 this.user= props.getProperty("user");
			 this.password= props.getProperty("password");
			 this.database= props.getProperty("database");
			 this.puerto= props.getProperty("puerto");
			 this.ipConexion= props.getProperty("ipConexion");
			 this.conexion= props.getProperty("conexion");			 
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        	try(FileWriter fw= new FileWriter(new File("ErrorTemprano.txt"))) {
	        		e.printStackTrace();
					fw.write("Error al recuperar las propierdades del fichero: ConfiguracionGeneral.properties");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
	}
	
	public static synchronized RecuperadorPropiedadesBD getInstance(){
		if(instance==null)
			instance=new RecuperadorPropiedadesBD();
		return instance;
	}
	
	
	
	public String getConexion() {
		return conexion;
	}

	public void setConexion(String conexion) {
		this.conexion = conexion;
	}

	public String getIpConexion() {
		return ipConexion;
	}

	public void setIpConexion(String ipConexion) {
		this.ipConexion = ipConexion;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getDriverType() {
		return driverType;
	}
	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	
	
}
