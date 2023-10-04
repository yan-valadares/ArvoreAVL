package arvoreAVL;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArvoreAVL arvore = new ArvoreAVL();
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		int auxiliar = 0;
		
		do {
			
			System.out.println("\n\t\t Arvore AVL");
			System.out.println("\tDigite a opção desejada: \n");
			
			System.out.println("1. Inserir na árvore");
			System.out.println("2. Remover da árvore");
			System.out.println("3. Imprimir árvore");
			System.out.println("4. Verificar se o valor existe");
			System.out.println("5. Verificar altura da árvore");
			System.out.println("6. Verificar quantidade de nós");
			System.out.println("7. Limpar árvore");
			System.out.println("0. Sair");
			
			opcao = scanner.nextInt();
			
			switch(opcao) {
				case 1:
					System.out.println("Valor a ser inserido: ");
					auxiliar = scanner.nextInt();
					arvore.adicionaNo(auxiliar);
					break;
					
				case 2:
					System.out.println("Valor a ser removido: ");
					auxiliar = scanner.nextInt();
					if (arvore.contem(auxiliar)) {
						arvore.removerNoPorValor(auxiliar);
						System.out.println("Valor removido!");
					}
					else {
						System.out.println("Valor não presente na árvore");
					}
					break;
					
				case 3:
					try {
						arvore.imprimirArvore();
					} catch (Exception e) {
						System.out.println("Árvore vazia");
					}

					break;
					
				case 4:
					System.out.println("Valor a ser buscado: ");
					auxiliar = scanner.nextInt();
					if (arvore.contem(auxiliar)) {
						System.out.println("Valor existente na árvore!");
					}
					else {
						System.out.println("Valor não presente na árvore");
					}
					break;
					
				case 5:
					auxiliar = arvore.pegaAlturaDaArvore();
					System.out.println("Altura da árvore: " + auxiliar);
					break;
					
				case 6:
					auxiliar = arvore.pegaQuantidadeNos();
					System.out.println("Quantidade de nós: " + auxiliar);
					break;
					
				case 7:
					arvore.limparArvore();
					System.out.println("Árvore limpa!");
					break;
					
				case 0:
					System.out.println("Saindo...");
					break;
					
				default:
					System.out.println("Opção inválida.");
			}
			
		} while (opcao != 0);
		
	}

}
