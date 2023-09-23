package ArvoreBB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import No.No;

class ArvoreBinariaTest {

	private ArvoreBB arvore = new ArvoreBB();
	private ArvoreBBBuilder builder = new ArvoreBBBuilder();

	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBB();
	}

	@Test
	void deveRetornarEhVaziaSemRaiz() {
		assertTrue(arvore.ehVazia());
	}

	@Test
	void deveRetornarNaoEhVaziaComRaiz() {
		No noUm = new No(1, null, null);
		arvore.setRaiz(noUm);

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(2, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(2, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(3, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(4, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(4, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(5, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(7, arvore.pegaQuantidadeNos());

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarAlturaSubNosComElementos() {

		arvore = builder.montaArvoreCheiaDoisNiveis();
		No noTres = arvore.getRaiz().getEsquerdo();

		assertEquals(1, arvore.pegaAlturaDoNo(noTres));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		No noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarNullSePegarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertNull(arvore.pegarNoArvorePorValor(20));
	}

	@Test
	void deveRetornarNullSePegarNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertNull(arvore.pegarNoArvorePorValor(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertNull(arvore.pegarNoArvorePorValor(20));
	}

	@Test
	void deveRetornarNoSePegarRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		No noRetornado = arvore.pegarNoArvorePorValor(5);

		assertNotNull(noRetornado);
		assertEquals(5, noRetornado.getValor());
	}

	@Test
	void deveRetornarNoSePegarOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();

		No noRetornado = arvore.pegarNoArvorePorValor(3);

		assertNotNull(noRetornado);
		assertEquals(3, noRetornado.getValor());
	}

	@Test
	void deveRetornarFalseContemArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertFalse(arvore.contem(20));
	}

	@Test
	void deveRetornarFalseContemNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertFalse(arvore.contem(20));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertFalse(arvore.contem(20));
	}

	@Test
	void deveRetornarTrueContemSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertTrue(arvore.contem(5));
	}

	@Test
	void deveRetornarNoComtemOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertTrue(arvore.contem(3));
		assertTrue(arvore.contem(4));
		assertTrue(arvore.contem(1));
	}
	
	@Test
	void deveAdicionarNaRaizQuandoVazia() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionaNo(13);
		
		assertEquals(13, arvore.getRaiz().getValor());
	}
	
	@Test
	void deveAdicionarNaRaizQuandoSoFilhoDireito() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		
		arvore.adicionaNo(13);
		arvore.adicionaNo(1);
		
		assertEquals(2, arvore.pegaAlturaDaArvore());
		assertEquals(1, arvore.getRaiz().getEsquerdo().getValor());
		
	}
	
	@Test
	void deveAdicionarNaRaizQuandoSoFilhoEsquerdo() {
		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		
		arvore.adicionaNo(13);
		arvore.adicionaNo(1);
		
		assertEquals(2, arvore.pegaAlturaDaArvore());
		assertEquals(13, arvore.getRaiz().getDireito().getValor());
		
	}
	
	@Test
	void deveAdicionarNaRaizQuandoSoFilhoDireitoEsquerdo() {
		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		
		arvore.adicionaNo(13);
		arvore.adicionaNo(1);
		
		assertEquals(2, arvore.pegaAlturaDaArvore());
		assertEquals(13, arvore.getRaiz().getDireito().getDireito().getValor());
		assertEquals(1, arvore.getRaiz().getEsquerdo().getEsquerdo().getValor());
		
	}
	
	@Test
	void deveAdicionarNaRaizQuandoSoDoisFilhosDireitoUmEsquerdo() {
		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		
		arvore.adicionaNo(13);
		arvore.adicionaNo(1);
		
		assertEquals(3, arvore.pegaAlturaDaArvore());
		
		assertEquals(1, arvore.getRaiz().getEsquerdo().getEsquerdo().getValor());
		assertEquals(13, arvore.getRaiz().getDireito().getDireito().getDireito().getValor());
		
	}
	
	@Test
	void deveAdicionarNaRaizQuandoSoUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		arvore.adicionaNo(13);
		arvore.adicionaNo(1);
		
		assertEquals(3, arvore.pegaAlturaDaArvore());
		
		assertEquals(1, arvore.getRaiz().getEsquerdo().getEsquerdo().getDireito().getValor());
		assertEquals(13, arvore.getRaiz().getDireito().getDireito().getValor());
		
	}
	
	@Test
	void deveAdicionarNaRaizQuandoSoDoisFilhosDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		
		arvore.adicionaNo(13);
		arvore.adicionaNo(-1);
		
		assertEquals(3, arvore.pegaAlturaDaArvore());
		
		assertEquals(-1, arvore.getRaiz().getEsquerdo().getEsquerdo().getEsquerdo().getValor());
		assertEquals(13, arvore.getRaiz().getDireito().getDireito().getDireito().getValor());
		
	}
	
	@Test
	void deveAdicionarNaArvoreQuandoCheia() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		arvore.adicionaNo(13);
		arvore.adicionaNo(-1);
		
		assertEquals(3, arvore.pegaAlturaDaArvore());
		
		assertEquals(-1, arvore.getRaiz().getEsquerdo().getEsquerdo().getEsquerdo().getValor());
		assertEquals(13, arvore.getRaiz().getDireito().getDireito().getDireito().getValor());
		
	}
	
	@Test
	void deveRemoverDaArvoreQuandoVazia() {
		arvore = builder.montaArvoreVazia();
		
		assertThrows(IllegalArgumentException.class, () -> arvore.removerNoPorValor(7));
	}
	
	@Test
	void deveRemoverDaArvoreQuandoSoFilhoDireito() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		
		arvore.removerNoPorValor(7);
		
		assertEquals(0, arvore.pegaAlturaDaArvore());
		assertNull(arvore.getRaiz().getDireito());
		
	}
	
	@Test
	void deveRemoverDaArvoreSoFilhoEsquerdo() {
		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		
		arvore.removerNoPorValor(3);
		
		assertEquals(0, arvore.pegaAlturaDaArvore());
		assertNull(arvore.getRaiz().getEsquerdo());
		
	}
	
	@Test
	void deveRemoverDaArvoreSoFilhoDireitoEsquerdo() {
		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		
		arvore.removerNoPorValor(7);
		arvore.removerNoPorValor(3);
		
		assertEquals(0, arvore.pegaAlturaDaArvore());
		assertNull(arvore.getRaiz().getEsquerdo());
		assertNull(arvore.getRaiz().getDireito());
		
	}
	
	@Test
	void deveRemoverDaArvoreSoDoisFilhosDireitoUmEsquerdo() {
		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		
		arvore.removerNoPorValor(7);
		
		assertEquals(1, arvore.pegaAlturaDaArvore());
		
		assertEquals(8, arvore.getRaiz().getDireito().getValor());
		
	}
	
	@Test
	void deveRemoverDaArvoreQuandoSoUmFilhoDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		arvore.removerNoPorValor(3);
		
		assertEquals(1, arvore.pegaAlturaDaArvore());
		
		assertEquals(1, arvore.getRaiz().getEsquerdo().getValor());
		
	}
	
	@Test
	void deveRemoverDaArvoraQuandoSoDoisFilhosDireitoDoisEsquerdo() {
		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		
		arvore.removerNoPorValor(3);
		arvore.removerNoPorValor(7);
		
		assertEquals(1, arvore.pegaAlturaDaArvore());
		
		assertEquals(8, arvore.getRaiz().getDireito().getValor());
		assertEquals(1, arvore.getRaiz().getEsquerdo().getValor());
		
	}
	
	@Test
	void deveRemoverDaArvoreQuandoCheia() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		
		arvore.removerNoPorValor(3);
		arvore.removerNoPorValor(7);
		
		assertEquals(2, arvore.pegaAlturaDaArvore());
		
		assertEquals(8, arvore.getRaiz().getDireito().getValor());
		assertEquals(4, arvore.getRaiz().getEsquerdo().getValor());
		
	}
	
//	@Test
//	void visualizarPreOrder() {
//		arvore = builder.montaArvoreCheiaDoisNiveis();
//		
//		arvore.imprimirConsolePreOrder();
//		
//	}
//	
//	@Test
//	void visualizarInOrder() {
//		arvore = builder.montaArvoreCheiaDoisNiveis();
//		
//		arvore.imprimirConsoleInOrder();
//	
//	}
//	
//	@Test
//	void visualizarPosOrder() {
//		arvore = builder.montaArvoreCheiaDoisNiveis();
//		
//		arvore.imprimirConsolePosOrder();
//		
//	}
	
}
