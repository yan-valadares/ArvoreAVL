package ArvoreAVL;

import ArvoreBB.ArvoreBB;
import No.No;

public class ArvoreAVL extends ArvoreBB {
	
	@Override
	public void adicionaNo(int valorNoAdicionado) {
		
		if (ehVazia()) {
			this.raiz = new No(valorNoAdicionado, null, null);
			this.raiz.setPai(null);
		}
		else {
			insereNovoNoArvoreRercursivamente(raiz, valorNoAdicionado);
		}	
	}
	
	@Override
	protected void insereNovoNoArvoreRercursivamente(No noReferencia, int valorNoAcionado) {
		No novoNo = null;
		
		if (noReferencia != null) {
			
			if (valorNoAcionado < noReferencia.getValor()) {
				
				 if (noReferencia.getEsquerdo() == null) {
					 novoNo = new No(valorNoAcionado, null, null);
					 novoNo.setPai(noReferencia);
					 noReferencia.setEsquerdo(novoNo);
					 this.calcularBalanceamento(raiz);
				     verificaBalanceamento(novoNo);
				 }
				 else {
					 insereNovoNoArvoreRercursivamente(noReferencia.getEsquerdo(), valorNoAcionado);
				 }
			}
			else {
				
				 if (noReferencia.getDireito() == null) {
					 novoNo = new No(valorNoAcionado, null, null);
					 novoNo.setPai(noReferencia);
					 noReferencia.setDireito(novoNo);
					 this.calcularBalanceamento(raiz);
				     verificaBalanceamento(novoNo);
				 }
				 else {
					 insereNovoNoArvoreRercursivamente(noReferencia.getDireito(), valorNoAcionado);
				 }
			}
			
		}
	}
	
	@Override
	public void removerNoPorValor(int valorRemovido) {
		
		if (ehVazia()) {
			throw new IllegalArgumentException(OPERACAO_INVALIDA_ARVORE_VAZIA);
		}
		else {
			raiz = removerNoArvoreRecursivamente(raiz, valorRemovido);
			percorrerArvoreDeBaixoPraCimaBalanceando(raiz);
		}
	}

//	private void balancearArvore() {
//		if(this.raiz == null) {
//			throw new IllegalArgumentException(OPERACAO_INVALIDA_ARVORE_VAZIA);
//		}
//		calcularBalanceamento(this.raiz);
//		percorrerArvoreDeBaixoPraCimaBalanceando(this.raiz);
//	}
	
	private void percorrerArvoreDeBaixoPraCimaBalanceando(No noReferencia) {
		if(noReferencia != null) {
			percorrerArvoreDeBaixoPraCimaBalanceando(noReferencia.getEsquerdo());
			percorrerArvoreDeBaixoPraCimaBalanceando(noReferencia.getDireito());
			
			if(noReferencia.ehFolha()) {
				verificaBalanceamento(noReferencia);
			}
		}
	}
	
	private void calcularBalanceamento(No noReferencia) {
		if(noReferencia != null) {

			if (noReferencia.ehFolha()) {
				noReferencia.setBalanceamento(0);
			}
			else if (noReferencia.getEsquerdo() == null && noReferencia.getDireito() != null) {
				int alturaNo = this.pegaAlturaDoNo(noReferencia);
				noReferencia.setBalanceamento(alturaNo * -1);
			}
			else if (noReferencia.getEsquerdo() != null && noReferencia.getDireito() == null) {
				int alturaNo = this.pegaAlturaDoNo(noReferencia);
				noReferencia.setBalanceamento(alturaNo);
			}
			else {
				int alturaNoEsquerdo = this.pegaAlturaDoNo(noReferencia.getEsquerdo());
				int alturaNoDireito = this.pegaAlturaDoNo(noReferencia.getDireito());
				
				noReferencia.setBalanceamento(alturaNoEsquerdo - alturaNoDireito);
			}
			
			calcularBalanceamento(noReferencia.getEsquerdo());
			calcularBalanceamento(noReferencia.getDireito());
		}
		
	}
	
	private void verificaBalanceamento(No noReferencia) {
		if(noReferencia != null) {
			
			// verifica se a árvore está balanceada
			if(noReferencia.getBalanceamento() >= 2 || noReferencia.getBalanceamento() <= -2) {
				// verificação de qual tipo de rotação necessária
				
				if(noReferencia.getBalanceamento() < 0 && noReferencia.getDireito().getBalanceamento() < 0){
					// P -> Balanceamento: negativo // U -> Balanceamento: negativo
					
					System.out.println("Rotação simples para esquerda (" + noReferencia.getValor() + ", " + noReferencia.getDireito().getValor() + ")");
					rotacaoSimplesEsquerda(noReferencia);
				}
				
				else if(noReferencia.getBalanceamento() > 0 && noReferencia.getEsquerdo().getBalanceamento() > 0){
					// P -> Balanceamento: positivo // U -> Balanceamento: positivo
					
					System.out.println("Rotação simples para direita (" + noReferencia.getValor() + ", " + noReferencia.getEsquerdo().getValor() + ")");
					rotacaoSimplesDireita(noReferencia);
				}
				
				else if(noReferencia.getBalanceamento() < 0 && noReferencia.getDireito().getBalanceamento() > 0){
					// P -> Balanceamento: negativo // U -> Balanceamento: positivo
					
					System.out.println("Rotação dupla para esquerda (" + noReferencia.getValor() + ", " + noReferencia.getDireito().getValor() + ")");
					rotacaoDuplaEsquerda(noReferencia);
				}
				
				else if(noReferencia.getBalanceamento() > 0 && noReferencia.getEsquerdo().getBalanceamento() < 0){
					// P -> Balanceamento: positivo // U -> Balanceamento: negativo
					
					System.out.println("Rotação dupla para direita (" + noReferencia.getValor() + ", " + noReferencia.getEsquerdo().getValor() + ")");
					rotacaoDuplaDireita(noReferencia);
				}
			}
			// averiguar balanceamento da arvore;
			
			this.calcularBalanceamento(raiz);
			verificaBalanceamento(noReferencia.getPai());
						
		}
	}
	
	private void rotacaoSimplesEsquerda(No noReferencia) {
		No p = noReferencia;
		No u = p.getDireito();
		No paiP = p.getPai();
		
		No t2 = u.getEsquerdo();
		
		p.setDireito(t2);
		if (t2 != null) {
			t2.setPai(p);
		}
		
		u.setPai(paiP);
		
		if (paiP == null) {
			this.raiz = u;
		}
		
		else {
			if (p == paiP.getEsquerdo()) {
				paiP.setEsquerdo(u);
			}
			else {
				paiP.setDireito(u);
			}
		}
		
		u.setEsquerdo(p);
		p.setPai(u);
	}
	
	private void rotacaoSimplesDireita(No noReferencia) {
		No p = noReferencia;
		No u = p.getEsquerdo();
		No paiP = p.getPai();
		
		No t2 = u.getDireito();
		
		p.setEsquerdo(t2);
		if (t2 != null) {
			t2.setPai(p);
		}
		
		u.setPai(paiP);
		
		if (paiP == null) {
			this.raiz = u;
		}
		
		else {
			if (p == paiP.getEsquerdo()) {
				paiP.setEsquerdo(u);
			}
			else {
				paiP.setDireito(u);
			}
			
			
		}
		
		u.setDireito(p);
		p.setPai(u);
		
	}
	
	private void rotacaoDuplaEsquerda(No noReferencia) {
		No p = noReferencia;
		No u = p.getDireito();
		No v = u.getEsquerdo();
		No paiP = p.getPai();
		
		No t2 = v.getEsquerdo();
		No t3 = v.getDireito();
		
		p.setDireito(t2);
		if(t2 != null) {
			t2.setPai(p);
		}
		
		u.setEsquerdo(t3);
		if(t3 != null) {
			t3.setPai(u);
		}
		
		v.setPai(paiP);
		
		if (paiP == null) {
			this.raiz = v;
		} else {
			if (p == paiP.getEsquerdo()) {
				paiP.setEsquerdo(v);
			}
			else {
				paiP.setDireito(v);
			}
		}
		
		v.setEsquerdo(p);
		p.setPai(v);
		
		v.setDireito(u);
		u.setPai(v);
		 
	}
	
	private void rotacaoDuplaDireita(No noReferencia) {
		No p = noReferencia;
		No u = p.getEsquerdo();
		No v = u.getDireito();
		No paiP = p.getPai();
		
		No t2 = v.getEsquerdo();
		No t3 = v.getDireito();
		
		p.setEsquerdo(t3);
		if(t3 != null) {
			t3.setPai(p);
		}
		
		u.setDireito(t2);
		if(t2 != null) {
			t2.setPai(u);
		}
		
		v.setPai(paiP);
		
		if (paiP == null) {
			this.raiz = v;
		} else {
			if (p == paiP.getEsquerdo()) {
				paiP.setEsquerdo(v);
			}
			else {
				paiP.setDireito(v);
			}
		}
		
		v.setEsquerdo(u);
		u.setPai(v);
		
		v.setDireito(p);
		p.setPai(v);
		
	}
	
	public void imprimirArvore() {
	    if (this.raiz == null) {
	        throw new IllegalArgumentException(OPERACAO_INVALIDA_ARVORE_VAZIA);
	    }
	    
	    imprimirArvoreRecursivamente(this.raiz, "", "");
	}

	private void imprimirArvoreRecursivamente(No noReferencia, String espacos, String direcao) {
	    if (noReferencia != null) {
	        String linha = espacos + "+-" + direcao + ": " + noReferencia.getValor() + " BAL:(" + noReferencia.getBalanceamento() + ")";
	        System.out.println(linha);

	        if (noReferencia.getEsquerdo() != null || noReferencia.getDireito() != null) {
	            String proximosEspacos = espacos + "|  ";
	            imprimirArvoreRecursivamente(noReferencia.getEsquerdo(), proximosEspacos, "ESQ");
	            imprimirArvoreRecursivamente(noReferencia.getDireito(), proximosEspacos, "DIR");
	        }
	    }
	}
	
	public void limparArvore() {
		this.raiz = null;
	}
}
