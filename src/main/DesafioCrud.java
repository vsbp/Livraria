package main;

import java.util.Scanner;

import Model.Genero;

public class DesafioCrud {

	public static void main(String[] args) throws Exception {

		Scanner teclado = new Scanner(System.in);

		int opcao = 0;
		Genero genero;

		int codigo = 0;
		String descricao = null;

		do {
			switch (opcao) {
			case 1:
				genero = new Genero();
				break;
			case 2:
				genero = new Genero();
				break;
			case 3:
				System.out.println("Digite o id que deseja alterar: ");
				codigo = teclado.nextInt();
				System.out.println("Digite uma descricao que deseja alterar: ");
				descricao = teclado.next();
				genero = new Genero(codigo, descricao);
				break;
			case 4:
				System.out.println("Digite o codigo que deseja excluir: ");
				codigo = teclado.nextInt();
				genero = new Genero(codigo);
				break;
			case 5:
				
				break;
			default:
				break;
			}
		} while (opcao != 5);

		// Cadastrar
//		Genero genero = new Genero(1, "teste");
//		
		// Excluir
//		Genero genero = new Genero(4);

//		Genero genero = new Genero();

		// Alterar
	}
}