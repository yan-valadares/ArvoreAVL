package ArvoreBB;

import No.No;

public class ArvoreBB {

	protected static final String OPERACAO_INVALIDA_ARVORE_VAZIA = "Operacao Invalida: arvore vazia";
	protected No raiz;
	
	public ArvoreBB() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean ehVazia() {
		return raiz == null;
	}

	public int pegaQuantidadeNos() {
		return pegaQuantidadeNosDoSubNo(raiz);
	}

	public int pegaQuantidadeNosDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaQuantidadeNosDoSubNo(noReferencia.getEsquerdo()) + 1 + pegaQuantidadeNosDoSubNo(noReferencia.getDireito());
		}
	}

	public int pegaAlturaDoNo(No noReferencia) {
		if (ehVazia()) {
			return 0;
		} else {
			return pegaAlturaDoSubNo(noReferencia) - 1;
		}
	}

	private int pegaAlturaDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		}
		int alturaDireita = pegaAlturaDoSubNo(noReferencia.getDireito()); // 2
		int alturaEsquerda = pegaAlturaDoSubNo(noReferencia.getEsquerdo()); // 0

		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}

	public int pegaAlturaDaArvore() {
		return pegaAlturaDoNo(raiz);
	}

	public int pegaProfundidadeDoNo(No noReferencia) {

		if (ehVazia()) {
			return 0;
		} else {
			return pegaProfundidadeDoNoAteRaiz(raiz, noReferencia) - 1;
		}
	}

	private int pegaProfundidadeDoNoAteRaiz(No noReferencia, No noBuscado) {
		if (noReferencia == null) {
			return 0;
		} else {
			if (noBuscado.getValor() == noReferencia.getValor()) {
				return 1;
			}

			if (noBuscado.getValor() < noReferencia.getValor()) {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getEsquerdo(), noBuscado);
			} else {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getDireito(), noBuscado);
			}
		}
	}

	public No pegarNoArvorePorValor(int valorBuscado) {

		return buscaValorNoReferenciaSeusDescendentes(valorBuscado, raiz);
	}

	private No buscaValorNoReferenciaSeusDescendentes(int valorBuscado, No noReferencia) {

		if (noReferencia == null) {
			return null;
		}

		if (valorBuscado == noReferencia.getValor()) {
			return noReferencia;
		}

		if (valorBuscado < noReferencia.getValor()) {
			return buscaValorNoReferenciaSeusDescendentes(valorBuscado, noReferencia.getEsquerdo());
		} else {
			return buscaValorNoReferenciaSeusDescendentes(valorBuscado, noReferencia.getDireito());
		}
	}

	public boolean contem(int valorBuscado) {

		return buscaValorNoReferenciaSeusDescendentes(valorBuscado, raiz) != null;
	}
	
	public void adicionaNo(int valorNoAdicionado) {
		
		if (ehVazia()) {
			this.raiz = new No(valorNoAdicionado, null, null);
		}
		else {
			insereNovoNoArvoreRercursivamente(raiz, valorNoAdicionado);
		}	
	}
	
	protected void insereNovoNoArvoreRercursivamente(No noReferencia, int valorNoAcionado) {
		
		if (noReferencia != null) {
			
			if (valorNoAcionado < noReferencia.getValor()) {
				
				 if (noReferencia.getEsquerdo() == null) {
					 No novoNo = new No(valorNoAcionado, null, null);
					 noReferencia.setEsquerdo(novoNo);
					 
				 }
				 else {
					 insereNovoNoArvoreRercursivamente(noReferencia.getEsquerdo(), valorNoAcionado);
				 }
			}
			else {
				
				 if (noReferencia.getDireito() == null) {
					 No novoNo = new No(valorNoAcionado, null, null);
					 noReferencia.setDireito(novoNo);
				 }
				 else {
					 insereNovoNoArvoreRercursivamente(noReferencia.getDireito(), valorNoAcionado);
				 }
			}
		}
	}
	
	public void removerNoPorValor(int valorRemovido) {
		
		if (ehVazia()) {
			throw new IllegalArgumentException(OPERACAO_INVALIDA_ARVORE_VAZIA);
		}
		else {
			raiz = removerNoArvoreRecursivamente(raiz, valorRemovido);
		}
	}
	
	protected No removerNoArvoreRecursivamente(No noReferencia, int valorRemovido) {
		
			if (noReferencia == null) {
				return null;
			}
			
			if (valorRemovido == noReferencia.getValor()) {
				
				if (noReferencia.ehFolha()) {
					return null;
				}
				
				else if (soFilhoDireito(noReferencia)) {
					 return noReferencia.getDireito();
				}
				else if (soFilhoEsquerdo(noReferencia)) {
					return noReferencia.getEsquerdo();
				}
				else {
					int menorValor = pegaMenorValor (noReferencia.getDireito());
					noReferencia.setValor(menorValor);
					noReferencia.setDireito(removerNoArvoreRecursivamente(noReferencia.getDireito(), menorValor));
					return noReferencia;
				}
			}
			
			if (valorRemovido < noReferencia.getValor()) {
				 noReferencia.setEsquerdo(removerNoArvoreRecursivamente(noReferencia.getEsquerdo(), valorRemovido));	 
			}
			else {
				 noReferencia.setDireito(removerNoArvoreRecursivamente(noReferencia.getDireito(), valorRemovido));
			}
			return noReferencia;
			
	}
	
	protected boolean soFilhoDireito(No noReferencia) {
		return ((noReferencia.getDireito() != null) && (noReferencia.getEsquerdo() == null));
	}
	
	protected boolean soFilhoEsquerdo(No noReferencia) {
		return ((noReferencia.getDireito() == null) && (noReferencia.getEsquerdo() != null));
	}
	
	protected int pegaMenorValor(No noReferencia) {
		if (noReferencia.getEsquerdo() == null) {
			return noReferencia.getValor();
		}
		else {
			return pegaMenorValor(noReferencia.getEsquerdo());
		}
	}
	
	public void imprimirConsolePreOrder() {
		if (this.raiz == null) {
			throw new IllegalArgumentException("Impossivel imprimir: arvore vazia");
		}
		
		imprimirArvorePreOrder(this.raiz);
	}
	
	private void imprimirArvorePreOrder(No noReferencia) {
		if(noReferencia != null) {
			System.out.println(noReferencia.getValor());
			
			imprimirArvorePreOrder(noReferencia.getEsquerdo());
			imprimirArvorePreOrder(noReferencia.getDireito());
		}
	}
	
	public void imprimirConsoleInOrder() {
		if (this.raiz == null) {
			throw new IllegalArgumentException("Impossivel imprimir: arvore vazia");
		}
		
		imprimirArvoreInOrder(this.raiz);
	}
	
	private void imprimirArvoreInOrder(No noReferencia) {
		if(noReferencia != null) {
			
			if(noReferencia.getEsquerdo() != null) {
				imprimirArvoreInOrder(noReferencia.getEsquerdo());
			}
			
			System.out.println(noReferencia.getValor());
			imprimirArvoreInOrder(noReferencia.getDireito());
		}
	}
	
	public void imprimirConsolePosOrder() {
		if (this.raiz == null) {
			throw new IllegalArgumentException("Impossivel imprimir: arvore vazia");
		}
		
		imprimirArvorePosOrder(this.raiz);
	}
	
	private void imprimirArvorePosOrder(No noReferencia) {
		if(noReferencia != null) {
			
			if(noReferencia.getEsquerdo() != null) {
				imprimirArvorePosOrder(noReferencia.getEsquerdo());
			}
			
			if(noReferencia.getDireito() != null) {
				imprimirArvorePosOrder(noReferencia.getDireito());
			}
			
			System.out.println(noReferencia.getValor());
		}
	
	}

}
