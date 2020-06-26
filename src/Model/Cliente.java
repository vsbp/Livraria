package Model;

public class Cliente {
	private int IDCLIENTE;
	private String NOME;
	private String TELEFONE;

	public int getIDCLIENTE() {
		return IDCLIENTE;
	}

	public void setIDCLIENTE(int iDCLIENTE) {
		IDCLIENTE = iDCLIENTE;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public String getTELEFONE() {
		return TELEFONE;
	}

	public void setTELEFONE(String tELEFONE) {
		TELEFONE = tELEFONE;
	}

	public Cliente(int idCliente, String nome, String telefone) {
		setIDCLIENTE(idCliente);
		setNOME(nome);
		setTELEFONE(telefone);
	}
}
