package it.interlogica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.interlogica.model.Telefono;

public class DataAccessLayer {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ilsudafricatel?user=root&password=123qweASD.0";
	private static Connection _con = null;
	
	public static Connection connDb() {
		if(_con!=null)
			return _con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			_con= DriverManager.getConnection(JDBC_URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _con;
	}

//	private static void loadDriver() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

//	public static Connection openConnDb() {
//		try {
//			if (conn != null)
//				return conn;
//			loadDriver();
//			conn = DriverManager.getConnection(JDBC_URL);
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		return conn;
//	}

//	public static void closeConnDb() {
//		try {
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}

	private static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			st = null;
		}
	}

//	public static ArrayList<Telefono> queryGetRisultatoNumeri() {
//		ArrayList<Telefono> lista = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("SELECT foo FROM bar");
//			if (stmt.execute("SELECT foo FROM bar")) {
//				rs = stmt.getResultSet();
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException ex) {
//					ex.printStackTrace();
//				}
//				rs = null;
//			}
//			closeStatement(st);
//		}
//		return lista;
//	}

	public static void pulisciTblTelefoniRis() {
		PreparedStatement pst = null;
		String sql = "DELETE FROM TelefonoRis";
		try {
			pst = connDb().prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStatement(pst);
		}
	}

	public static void salvaTelefoni(ArrayList<Telefono> lista) {
		int n = lista.size();
		for (int i = 0; i < n; i++) {
			PreparedStatement pst = null;
			Telefono tel = lista.get(i);
			System.out.println("Insert");
			System.out.println("smsPhone=" + tel.getSmsPhone());
			String sql = "INSERT INTO TelefonoRis(Id,SmsPhone,Risultato) VALUES (?, ?, ?)";
			try {
				pst = connDb().prepareStatement(sql);
				pst.setString(1, tel.getId());
				pst.setString(2, tel.getSmsPhone());
				pst.setString(3, tel.getRisultato());
				pst.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {
				closeStatement(pst);
			}
		}
	}

	public static List<Telefono> leggiRisultato() {
		List<Telefono> lista = new ArrayList<Telefono>();
		PreparedStatement pst = null;
		String sql = "SELECT Id,SmsPhone,Risultato FROM TelefonoRis";
		try {
			pst = connDb().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String Id = rs.getString(1);
				String SmsPhone = rs.getString(2);
				String Risultato = rs.getString(3);
				Telefono tel = new Telefono();
				tel.setId(Id);
				tel.setSmsPhone(SmsPhone);
				tel.setRisultato(Risultato);
				lista.add(tel);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStatement(pst);
		}
		return lista;
	}
}
