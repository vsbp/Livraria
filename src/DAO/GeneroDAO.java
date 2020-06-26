package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.ConnectionFactory;
import Model.Genero;

public class GeneroDAO implements Persistencia<Genero> {

	public int create(Genero genero) {
		int id = 0;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "INSERT INTO Genero (idgenero, descricao) values (?, ?)";
		try {
			pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, genero.getIdGenero());
			pst.setString(2, genero.getDescricao());
			pst.execute();
			rs = pst.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException ex) {
			id = 0;
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
		return id;
	}

	public List<Genero> read() {
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Genero";
		List<Genero> lista = new ArrayList<Genero>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int idGenero = rs.getInt("IDGENERO");
				String descricao = rs.getString("DESCRICAO");
				System.out.println(idGenero + " | " + descricao);
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Erro no SELECT");
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
		return lista;
	}

	public int update(Genero genero) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "UPDATE Genero SET descricao= ? where idgenero= ?";
		try {
			pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, genero.getDescricao());
			pst.setInt(2, genero.getIdGenero());
			pst.execute();
			pst.close();
		} catch (SQLException ex) {
			System.out.println("a");
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
		return 0;
	}

	public int delete(Genero genero) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "DELETE FROM Genero where idGenero = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, genero.getIdGenero());
			pst.executeUpdate();
		} catch (SQLException ex) {
			throw new Exception("Erro ao excluir. Exceção:" + ex.getMessage());
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
		return 0;
	}

	public int findByCodigo(Genero genero) {
		Connection con;
		con = ConnectionFactory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Genero where idGenero = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, genero.getIdGenero());
			rs = pst.executeQuery();
			while (rs.next()) {
				int idGenero = rs.getInt("IDGENERO");
				String descricao = rs.getString("DESCRICAO");
				System.out.println(idGenero + " | " + descricao);
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Erro no SELECT");
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
		return 0;
	}
}
