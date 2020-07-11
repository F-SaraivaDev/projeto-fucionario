package aplicacao;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidade.Funcionario;
import entidade.Terceirizado;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		List<Funcionario> funcionario = new ArrayList<>();
		
		System.out.print("Digite o número de funcionários: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++){
			System.out.print("Dados do funcionário nº" + (i + 1) + ": ");
			System.out.print("\nTerceirizado (s / n)? ");
			char resp = sc.next().charAt(0);
			 
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Horas: ");
			int horas = sc.nextInt();
			
			System.out.print("Valor por horas: R$ ");
			double valorHora = sc.nextDouble();
			
			if(resp == 's' || resp == 'S'){
				System.out.print("Cobrança adicional: R$ ");
				double cobranca = sc.nextDouble();
		    
				funcionario.add(new Terceirizado(nome, horas, valorHora,cobranca));
				
			}else{
				funcionario.add(new Funcionario(nome, horas, valorHora));		
			}	
		}
		
		System.out.println("\nPAGAMENTO:");
		for (Funcionario func : funcionario) {
			System.out.println(func.getNome() + String.format(" - R$ %.2f", func.pagamento()));
		}
			
		sc.close();

	}

}
