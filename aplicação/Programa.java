package aplicação;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionarios;
import entidades.FuncionariosTerceirizados;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionarios> List = new ArrayList<>();

		System.out.print("Entre com a quantidade de funcionarios: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite os dados do funcionario " + i + ": ");
			System.out.print("Este funcionario é terceirizado(y/n)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas: ");
			int hora = sc.nextInt();
			System.out.print("Valor da hora: ");
			double valorDaHora = sc.nextDouble();
			
			if (ch == 'y') {
				System.out.print("Pagamento adicional: ");
				double pagamentoadd = sc.nextDouble();
				List.add(new FuncionariosTerceirizados(nome, hora, valorDaHora, pagamentoadd)); 
			}
			else {
				List.add(new Funcionarios(nome, hora, valorDaHora));
			}
		}
		
		System.out.println();
		System.out.println("PAGAMENTOS: ");
		for (Funcionarios fun : List) {
			System.out.println(fun.getNome() + "- $" + String.format("%.2f", fun.pagamento()));
		}
		
		sc.close();
	}
}
