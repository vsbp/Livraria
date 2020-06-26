package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:~/desafioDB;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE", "sa", "");
		} catch (Exception e) {
			throw new RuntimeException("Erro na conexão");
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			throw new RuntimeException("Erro no fechamento do banco");
		}
	}

	public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			closeConnection(con, pst);
		} catch (Exception e) {
			throw new RuntimeException("Erro no fechamento do result set");
		}
	}

	public static void closeConnection(Connection con, PreparedStatement pst) {
		try {
			if (pst != null)
				pst.close();
			closeConnection(con);
		} catch (Exception e) {
			throw new RuntimeException("Erro no fechamento do statement");
		}
	}
}
