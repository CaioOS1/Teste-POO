import java.time.LocalDate;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Scanner dado = new Scanner(System.in);
        
        System.out.println("Informe a quantidade de meses e logo após os valores");
        int x = dado.nextInt();  
        int[] vendas = new int[x];  

        for (int i = 0; i < x; i++) {
            System.out.println("Informe o valor da venda no mês " + (i + 1) + ":");
            vendas[i] = dado.nextInt();
        }

        double somaDasVendas = 0.0;
        for (int i = 0; i < x; i++) {
            somaDasVendas += vendas[i]; 
        }

        System.out.println("A soma total das vendas é: R$ " + somaDasVendas);

        System.out.println("Informe o número de funcionários: ");
        int n = dado.nextInt();
        
        dado.nextLine(); 

        Funcionarios[] vect = new Funcionarios[n];
        
        
        for (int i = 0; i < n; i++) {
            System.out.println("Informe o nome do funcionário: ");
            String nomeFuncionario = dado.nextLine();
            System.out.println("Cargo: ");
            String cargo = dado.nextLine();
            System.out.println("Salario Base: ");
            double salarioBase = dado.nextDouble();
            System.out.println("Valor do bonus anual: ");
            double bonusAnual = dado.nextDouble();
            System.out.println("Porcentagem de beneficio: EX: #.##");
            double beneficio = dado.nextDouble();
            dado.nextLine(); 
            System.out.println("Data de Contrato (yyyy-MM-dd): ");
            String dataDeContrato = dado.nextLine();
            System.out.println("Se for vendedor, informe o valor total das vendas (ou 0 se não for vendedor): obs: Informe o valor recebido na média");
            double valorVendas = dado.nextDouble();
            dado.nextLine(); 

            vect[i] = new Funcionarios(nomeFuncionario, cargo, salarioBase, bonusAnual, beneficio, dataDeContrato, valorVendas);
        }

        // Exibir opções de consulta
        System.out.println("Digite a informação desejada:\n"
                + "1 - Lista de Salário\n"
                + "2 - Salário Base\n"
                + "3 - Funcionários que recebem benefícios\n"
                + "4 - Salário mais alto entre os funcionários\n"
                + "5 - Valor total dos benefícios\n"
                + "6 - Vendedor que mais vendeu");

        int opcaoDesejada = dado.nextInt();

        // Processar a opção escolhida
        switch (opcaoDesejada) {
            case 1:
                listarSalarios(vect, n);
                break;
            case 2:
                listarSalarioBase(vect, n);
                break;
            case 3:
                calcularBeneficios(vect, n);
                break;
            case 4:
                calcularMaiorSalario(vect, n);
                break;
            case 5:
                calcularValorTotalBeneficios(vect, n);
                break;
            case 6:
                calcularMaiorVenda(vect, n);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        dado.close();
    }

    // Método para listar salários
    public static void listarSalarios(Funcionarios[] vect, int n) {
        for (int i = 0; i < n; i++) {
            double valorAnual = vect[i].bonusAnual * Funcionarios.calcularDiasEntre(vect[i].dataDeContrato);
            double salarioTotal = vect[i].salarioBase + valorAnual + (vect[i].salarioBase * vect[i].beneficio);
            System.out.println("Funcionário: " + vect[i].nomeFuncionario + " - Salário Total: R$ " + salarioTotal);
        }
    }

    // Método para listar salários base
    public static void listarSalarioBase(Funcionarios[] vect, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Funcionário: " + vect[i].nomeFuncionario + " - Salário Base: R$ " + vect[i].salarioBase);
        }
    }

    // Método para calcular benefícios
    public static void calcularBeneficios(Funcionarios[] vect, int n) {
        for (int i = 0; i < n; i++) {
            double valorBeneficios = vect[i].beneficio * vect[i].salarioBase;
            System.out.println("Funcionário: " + vect[i].nomeFuncionario + " - Benefícios: R$ " + valorBeneficios);
        }
    }

    // Método para calcular o maior salário
    public static void calcularMaiorSalario(Funcionarios[] vect, int n) {
        double maiorSalario = 0.0;
        String nomeMaiorSalario = "";
        for (int i = 0; i < n; i++) {
            double salarioTotal = vect[i].salarioBase + vect[i].bonusAnual;
            if (salarioTotal > maiorSalario) {
                maiorSalario = salarioTotal;
                nomeMaiorSalario = vect[i].nomeFuncionario;
            }
        }
        System.out.println("O funcionário com o maior salário é " + nomeMaiorSalario + " com R$ " + maiorSalario);
    }

    // Método para calcular o valor total dos benefícios
    public static void calcularValorTotalBeneficios(Funcionarios[] vect, int n) {
        double valorTotalBeneficios = 0.0;
        for (int i = 0; i < n; i++) {
            valorTotalBeneficios += vect[i].beneficio * vect[i].salarioBase;
        }
        System.out.println("O valor total de benefícios é R$ " + valorTotalBeneficios);
    }

    // Método para calcular o maior vendedor
    public static void calcularMaiorVenda(Funcionarios[] vect, int n) {
        double maiorVenda = 0.0;
        String nomeMaiorVendedor = "";
        for (int i = 0; i < n; i++) {
            if (vect[i].valorVendas > maiorVenda) {
                maiorVenda = vect[i].valorVendas;
                nomeMaiorVendedor = vect[i].nomeFuncionario;
            }
        }
        if (!nomeMaiorVendedor.isEmpty()) {
            System.out.println("O vendedor que mais vendeu foi " + nomeMaiorVendedor + " com R$ " + maiorVenda);
        } else {
            System.out.println("Nenhum vendedor registrado.");
        }
    }
}
