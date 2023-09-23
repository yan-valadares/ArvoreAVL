package ArvoreAVL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import No.No;

class ArvoreAVLTeste {

	private ArvoreAVL arvoreAVL;
	
	@BeforeEach
	void inicializarArvoreAVL() {
		arvoreAVL = new ArvoreAVL();
	}
	
	@Test
	void adicionarNoArvoreVazia() {
		arvoreAVL.adicionaNo(2);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 2);
		assertEquals(arvoreAVL.getRaiz().getPai(), null);
	}

	@Test
	void adicionarNoArvoreComElementosFilhoDireito() {
		arvoreAVL.adicionaNo(2);
		arvoreAVL.adicionaNo(5);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 2);
		assertEquals(arvoreAVL.getRaiz().getPai(), null);
		
		assertEquals(arvoreAVL.getRaiz().getDireito().getValor(), 5);
		assertEquals(arvoreAVL.getRaiz(), arvoreAVL.getRaiz().getDireito().getPai());
	}
	
	@Test
	void adicionarNoArvoreComElementosFilhoEsquerdo() {
		arvoreAVL.adicionaNo(2);
		arvoreAVL.adicionaNo(1);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 2);
		assertEquals(arvoreAVL.getRaiz().getPai(), null);
		
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getValor(), 1);
		assertEquals(arvoreAVL.getRaiz(), arvoreAVL.getRaiz().getEsquerdo().getPai());
	}
	
	@Test
	void removerNoArvoreVazia() {
		
		assertThrows(IllegalArgumentException.class, () -> arvoreAVL.removerNoPorValor(2));
	}

	@Test
	void removerNoArvoreUmElemento() {
		arvoreAVL.adicionaNo(2);
		
		arvoreAVL.removerNoPorValor(2);
		
		assertEquals(arvoreAVL.getRaiz(), null);
		assertFalse(arvoreAVL.contem(2));
	}

	@Test
	void removerNoArvoreUmMaisElementos() {
		arvoreAVL.adicionaNo(2);
		arvoreAVL.adicionaNo(5);
		
		arvoreAVL.removerNoPorValor(2);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 5);
		assertFalse(arvoreAVL.contem(2));
	}

	@Test
	void conferirBalancemanentoDosNoSoRaiz() {
		arvoreAVL.adicionaNo(1);
		
		No noUm = arvoreAVL.pegarNoArvorePorValor(1);
		
		assertEquals(noUm.getBalanceamento(), 0);
	}
	
	@Test
	void conferirBalancemanentoDosNosFilhoDireito() {
		arvoreAVL.adicionaNo(1);
		arvoreAVL.adicionaNo(2);
		
		
		No noUm = arvoreAVL.pegarNoArvorePorValor(1);
		No noDois = arvoreAVL.pegarNoArvorePorValor(2);
		
		assertEquals(noUm.getBalanceamento(), -1);
		assertEquals(noDois.getBalanceamento(), 0);
	}
	
	@Test
	void conferirBalancemanentoDosNosFilhoEsquero() {
		arvoreAVL.adicionaNo(20);
		arvoreAVL.adicionaNo(10);
		
		
		No noDez = arvoreAVL.pegarNoArvorePorValor(10);
		No noVinte = arvoreAVL.pegarNoArvorePorValor(20);
		
		assertEquals(noDez.getBalanceamento(), 0);
		assertEquals(noVinte.getBalanceamento(), 1);
	}

	@Test
	void rotacaoSimplesEsquerdaNaRaiz() {
		arvoreAVL.adicionaNo(3);
		arvoreAVL.adicionaNo(4);
		arvoreAVL.adicionaNo(5);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 4);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getValor(), 3);
		assertEquals(arvoreAVL.getRaiz().getDireito().getValor(), 5);
	}
	
	@Test
	void rotacaoSimplesEsquerdaNaoRaiz() {
		arvoreAVL.adicionaNo(10);
		arvoreAVL.adicionaNo(5);
		arvoreAVL.adicionaNo(11);
		arvoreAVL.adicionaNo(12);
		arvoreAVL.adicionaNo(13);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 10);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getValor(), 5);
		assertEquals(arvoreAVL.getRaiz().getDireito().getValor(), 12);
		
		assertEquals(arvoreAVL.getRaiz().getDireito().getEsquerdo().getValor(), 11);
		assertEquals(arvoreAVL.getRaiz().getDireito().getDireito().getValor(), 13);
	}
	
	@Test
	void rotacaoSimplesDireitaNaRaiz() {
		arvoreAVL.adicionaNo(5);
		arvoreAVL.adicionaNo(4);
		arvoreAVL.adicionaNo(3);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 4);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getValor(), 3);
		assertEquals(arvoreAVL.getRaiz().getDireito().getValor(), 5);
	}
	
	@Test
	void rotacaoSimplesDireitaNaoRaiz() {
		arvoreAVL.adicionaNo(60);
		arvoreAVL.adicionaNo(70);
		arvoreAVL.adicionaNo(30);
		arvoreAVL.adicionaNo(20);
		arvoreAVL.adicionaNo(10);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 60);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getValor(), 20);
		assertEquals(arvoreAVL.getRaiz().getDireito().getValor(), 70);
		
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getEsquerdo().getValor(), 10);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getDireito().getValor(), 30);
	}
	
	@Test
	void rotacaoDuplaEsquerdaNaRaiz() {
		arvoreAVL.adicionaNo(5);
		arvoreAVL.adicionaNo(8);
		arvoreAVL.adicionaNo(6);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 6);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getValor(), 5);
		assertEquals(arvoreAVL.getRaiz().getDireito().getValor(), 8);
	}
	
	@Test
	void rotacaoDuplaEsquerdaNaoRaiz() {
		arvoreAVL.adicionaNo(10);
		arvoreAVL.adicionaNo(5);
		arvoreAVL.adicionaNo(15);
		arvoreAVL.adicionaNo(20);
		arvoreAVL.adicionaNo(17);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 10);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getValor(), 5);
		assertEquals(arvoreAVL.getRaiz().getDireito().getValor(), 17);
		
		assertEquals(arvoreAVL.getRaiz().getDireito().getEsquerdo().getValor(), 15);
		assertEquals(arvoreAVL.getRaiz().getDireito().getDireito().getValor(), 20);
	}
	
	@Test
	void rotacaoDuplaDireitaNaRaiz() {
		arvoreAVL.adicionaNo(5);
		arvoreAVL.adicionaNo(2);
		arvoreAVL.adicionaNo(4);
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 4);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getValor(), 2);
		assertEquals(arvoreAVL.getRaiz().getDireito().getValor(), 5);
	}
	
	@Test
	void rotacaoDuplaDireitaNaoRaiz() {
		arvoreAVL.adicionaNo(10);
		arvoreAVL.adicionaNo(15);
		arvoreAVL.adicionaNo(5);
		arvoreAVL.adicionaNo(2);
		arvoreAVL.adicionaNo(3);
		
		
		assertEquals(arvoreAVL.getRaiz().getValor(), 10);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getValor(), 3);
		assertEquals(arvoreAVL.getRaiz().getDireito().getValor(), 15);
		
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getEsquerdo().getValor(), 2);
		assertEquals(arvoreAVL.getRaiz().getEsquerdo().getDireito().getValor(), 5);
	}

	@Test
	void limparArvore() {
		arvoreAVL.adicionaNo(10);
		
		arvoreAVL.limparArvore();
		
		assertEquals(arvoreAVL.getRaiz(), null);
	}
}
