package ArvoreBB;

import No.No;

public class ArvoreBBBuilder {
	
	private ArvoreBB arvore;
		
	public ArvoreBB montaArvoreVazia() {
		this.arvore = new ArvoreBB();
		return arvore;
	}

	public ArvoreBB montaArvoreSoRaiz() {
		No noCinco = new No(5, null, null);
		this.arvore = new ArvoreBB();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBB montaArvoreRaizFilhoDireito() {
		No noSete = new No(7, null, null);
		No noCinco = new No(5, noSete, null);
		this.arvore = new ArvoreBB();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBB montaArvoreRaizFilhoEsquerdo() {
		No noTres = new No(3, null, null);
		No noCinco = new No(5, null, noTres);
		this.arvore = new ArvoreBB();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBB montaArvoreRaizFilhoDireitoEsquerdo() {
		No noSete = new No(7, null, null);
		No noTres = new No(3, null, null);
		No noCinco = new No(5, noSete, noTres);
		this.arvore = new ArvoreBB();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBB montaArvoreRaizDoisFilhoDireitoUmEsquerdo() {
		No noOito = new No(8, null, null);
		No noSete = new No(7, noOito, null);
		No noTres = new No(3, null, null);
		No noCinco = new No(5, noSete, noTres);
		this.arvore = new ArvoreBB();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBB montaArvoreRaizUmFilhoDireitoDoisEsquerdo() {
		No noSete = new No(7, null, null);
		No noUm = new No(1, null, null);
		No noTres = new No(3, null, noUm);
		No noCinco = new No(5, noSete, noTres);
		this.arvore = new ArvoreBB();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBB montaArvoreRaizDoisFilhoDireitoDoisEsquerdo() {
		No noUm = new No(1, null, null);
		No noTres = new No(3, null, noUm);
		No noOito = new No(8, null, null);
		No noSete = new No(7, noOito, null);
		No noCinco = new No(5, noSete, noTres);
		this.arvore = new ArvoreBB();
		arvore.setRaiz(noCinco);
		return arvore;
	}

	public ArvoreBB montaArvoreCheiaDoisNiveis() {
		No noUm = new No(1, null, null);
		No noQuatro = new No(4, null, null);
		No noTres = new No(3, noQuatro, noUm);
		No noOito = new No(8, null, null);
		No noSeis = new No(6, null, null);
		No noSete = new No(7, noOito, noSeis);
		No noCinco = new No(5, noSete, noTres);
		this.arvore = new ArvoreBB();
		arvore.setRaiz(noCinco);
		return arvore;
	}
	

}
