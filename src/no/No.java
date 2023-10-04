package no;

public class No {

	private int valor;
	private No direito;
	private No esquerdo;
	private int balanceamento;
	private No pai;

	public No(int valor, No direito, No esquerdo) {
		this.valor = valor;
		this.direito = direito;
		this.esquerdo = esquerdo;
		this.balanceamento = 0;
		this.pai = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}
	
	public No getPai() {
		return pai;
	}
	
	public void setPai (No pai) {
		this.pai = pai;
	}
	
	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int valor) {
		this.balanceamento = valor;
	}

	public boolean ehFolha() {
		return (direito == null && esquerdo == null);
	}
}
