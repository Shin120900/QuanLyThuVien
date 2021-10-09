package DAL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;



public class DAL {
	private static DAL instance;
	Connection con;
	private Statement st;
	private HashMap<String, String> values;
	private DAL() {
		try (BufferedReader br = new BufferedReader(new FileReader("appconfig.txt"))){
			
			String line;

			values = new HashMap<String, String>();
			while((line = br.readLine()) != null) {
				
				String []temp = line.split(":=");
				
				values.put(temp[0], temp[1]);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static DAL getInstance() {
		if(instance == null)
			instance = new DAL();
		return instance;
	}
	
	
	public boolean connectToDatabase() {
		try {
			String connect= values.get("con")+";databasename="+values.get("db")+";username="+values.get("user")+";password="+values.get("pass");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = (Connection) DriverManager.getConnection(connect);
			st=con.createStatement();
			System.out.println("Thành công");
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
//
//	 Thá»±c hiá»‡n cho Update, delete, add
//	 Return int cho so hÃ ng bá»‹ thay Ä‘á»•i
//	 Return 0 náº¿u khÃ´ng cÃ³ hÃ ng nÃ o thay Ä‘á»•i
	public int executeQueryUpdate(String query) {
		try {

			if (con == null)
				connectToDatabase();
			return st.executeUpdate(query);
			
		}
		catch(Exception ex) {
			return -1;
		}
	}
	
	public boolean executeQuery(String query) {
		try {

			if (con == null)
				connectToDatabase();
			st.execute(query);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	// Tráº£ vá»� ResultSet tÆ°Æ¡ng á»©ng vá»›i báº£ng dá»¯ liá»‡u trong table
	public ResultSet executeQueryToGetData(String query) {
		try {
			if (con == null)
				connectToDatabase();
			return st.executeQuery(query);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
