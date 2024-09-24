import java.time.LocalDate;
import java.util.Scanner;

public class Programa{


	public static void main (String[] args) {
		
		Scanner dado = new Scanner(System.in);

		System.out.println("Informe o número de funcionários: ");
		int n = dado.nextInt();
		
		Funcionarios[] vect = new Funcionarios[n];
		
		for (int i=0; i<n; i++) {
			dado.nextLine();
			System.out.println("Informe o nome do funcionário: ");
			String nomeFuncionario = dado.nextLine();
			System.out.println("Cargo: ");
			String cargo = dado.nextLine();
			System.out.println("Salario Base: ");
			double salarioBase = dado.nextDouble();
			System.out.println("Valor do bonus anual: ");
			double bonusAnual = dado.nextDouble();
			System.out.println("Porcentagem de benefiocio: EX: #.##");
			double beneficio = dado.nextDouble();
			System.out.println("Data de Contrato: ");
			String dataDeContrato = dado.nextLine();
			System.out.println("Se for vendedor informe o valor total das vendas: ");
			double valorVendas = dado.nextDouble();
			vect[i] = new Funcionarios(nomeFuncionario, cargo, salarioBase, bonusAnual, beneficio, dataDeContrato, valorVendas);
			
		};
		int opcaoDesejada = 0;
		
		System.out.println("Digite a informação desejada: /n 1 - Metodo para retornar Lista de Salario "
				+ "/n 2 - Metodo para retornar apenas salario "
				+ "/n 3 - Metodo para retornar funcionários que recebem beneficios"
				+ "/n 4 - Metodo para retornar o salario mais alto entre os funcionários"
				+ "/n 5 - Metodo para retornar funcionarios que recebem benefiocios"
				+ "/n 6 - Metodo para retornar vendedor que mais vendeu");
		
		int oopcaoDesejada = dado.nextInt();
		
		
		//Método para calcular bonus Anual	
		double valorAnual = 0.0;
		for (int i=0; i<n; i++) {
			valorAnual = vect[n].bonusAnual * Funcionarios.calcularDiasEntre(vect[n].dataDeContrato);
		};
		
		if(oopcaoDesejada == 1) {
		//Metodo para retornar Lista de Salario
		
		double salarioTotal = 0.0;
		for (int i=0; i<n; i++) {
			salarioTotal = vect[n].salarioBase + valorAnual + (vect[n].salarioBase * vect[i].beneficio);
		}
		};
		
		if(oopcaoDesejada == 2) {
		//Metodo para retornar apenas salario
		System.out.println(vect[n].salarioBase);
		};
		
		if(oopcaoDesejada == 3) {
		//Metodo para retornar funcionários que recebem beneficios
		double valorTotalBeneficios = 0.0;
		if(vect[n].beneficio != null && vect[n].valorVendas == null) {
			valorTotalBeneficios = vect[n].beneficio * vect[n].salarioBase;
		}
		else if (vect[n].beneficio != null && vect[n].valorVendas != null)			
		 {valorTotalBeneficios = vect[n].beneficio * vect[n].valorVendas;
		}
		};
		
		
		if(oopcaoDesejada == 4) {
		//Metodo para retornar o salario mais alto entre os funcionários
		
		double maiorValorSalario = 0.0;
		for (int i=0; i<n; i++) {
			if (salarioTotal[n] > salarioTotal[maiorValorSalario]) {
		        maiorValorSalario = n;		        
		    }
		}		
		}
		
		
		if(oopcaoDesejada == 5) {
		//Metodo para retornar funcionarios que recebem benefiocios
		
		double valorTotalBeneficios = 0.0;
		if(vect[n].beneficio != null && vect[n].valorVendas == null) {
			valorTotalBeneficios = vect[n].beneficio * vect[n].salarioBase;
		}
		else if (vect[n].beneficio != null && vect[n].valorVendas != null)			
		 {valorTotalBeneficios = vect[n].beneficio * vect[n].valorVendas;
		};	
		}
		
		if(oopcaoDesejada == 6) {
		//Metodo para retornar vendedor que mais vendeu
		
		double maiorVenda = 0.0;
		if(vect[n].valorVendas != null) {
			if(vect[n].valorVendas > vect[maiorVenda])
				maiorVenda = n;
		}return maiorVenda;
		}
		
		
		
		dado.close();
	}
}
