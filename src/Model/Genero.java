package Model;

import DAO.GeneroDAO;

public class Genero {

	private int idGenero = 0;
	private String descricao = null;

	public Genero() throws Exception {
		setIdGenero(idGenero);
		setDescricao(descricao);
		selecionarTudo();
	}
	
	public Genero(int idGenero, String descricao) throws Exception {
		setIdGenero(idGenero);
		setDescricao(descricao);
		alterar();
	}

	public Genero(int idGenero) throws Exception {
		setIdGenero(idGenero);
		excluir();
	}
	
//	public Genero(int idGenero, String descricao) throws Exception {
//		setIdGenero(idGenero);
//		setDescricao(descricao);
//		gravar();
//	}

	public void alterar() throws Exception {
		GeneroDAO dao = new GeneroDAO();
		int codigo = dao.update(this);
		if (codigo > 0)
			setIdGenero(idGenero);
	}

	public void excluir() throws Exception {
		GeneroDAO dao = new GeneroDAO();
		int codigo = dao.delete(this);
		if (codigo > 0)
			setIdGenero(idGenero);
	}

	public void gravar() {
		GeneroDAO dao = new GeneroDAO();
		int codigo = dao.create(this);
		if (codigo > 0)
			setIdGenero(idGenero);
	}

	public void selecionarTudo() {
		GeneroDAO dao = new GeneroDAO();
		dao.read();
	}

	public void procurar() {
		GeneroDAO dao = new GeneroDAO();
		int codigo = dao.findByCodigo(this);
		if (codigo > 0)
			setIdGenero(idGenero);
	}

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		String ret = null;
		ret = "ID: " + getIdGenero() + "\n" + "Descrição: " + getDescricao() + "\n";
		return ret;
	}
}