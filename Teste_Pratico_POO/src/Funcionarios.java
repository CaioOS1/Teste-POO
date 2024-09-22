import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Arrays;

public class Funcionarios {

    private String nomeFuncionario;
    private CargosEnum cargo;
    private LocalDate periodoContratacao;  
    LocalDate hoje = LocalDate.now();  

    public Funcionarios() {
    }

    public Funcionarios(String nomeFuncionario, LocalDate periodoContratacao, float salarioBruto, CargosEnum cargo) {
        super();
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.periodoContratacao = periodoContratacao;
    }

    Double[] vendasV1 = {5200.0, 4000.0, 4200.0, 5850.0, 7000.0};
    Double[] vendasV2 = {3400.0, 7700.0, 5000.0, 5900.0, 6500.0};

    private double valorVendidoVendedor1() {
        return Arrays.stream(vendasV1).mapToDouble(Double::doubleValue).sum();
    }

    private double valorVendidoVendedor2() {
        return Arrays.stream(vendasV2).mapToDouble(Double::doubleValue).sum();
    }

    public Duration tempoTrabalho() {
        return Duration.between(periodoContratacao.atStartOfDay(), hoje.atStartOfDay());
    }

    public void calcularSalario() {
        double salarioBase = 0;
        double bonusPorAno = 0;
        double porcentagemBonus = 0;

        int anosDeTrabalho = getAnosDeTrabalho();

        switch (this.cargo) {
            case GERENTE:
                salarioBase = 20000;
                bonusPorAno = 3000;
                break;
            case SECRETARIO:
                salarioBase = 7000;
                bonusPorAno = 1000;
                porcentagemBonus = 0.20;
                break;
            case VENDEDOR:
                salarioBase = 12000;
                bonusPorAno = 300;
                porcentagemBonus = 0.30;
                break;
        }

        double salarioFinal = salarioBase + (anosDeTrabalho * bonusPorAno);
        if (porcentagemBonus > 0) {
            salarioFinal += salarioBase * porcentagemBonus;
        }

        System.out.println("Salário final: " + salarioFinal);
    }

    private int getAnosDeTrabalho() {
        return (int) ChronoUnit.YEARS.between(periodoContratacao, hoje);
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public LocalDate getPeriodoContratacao() {
        return periodoContratacao;
    }

    public void setPeriodoContratacao(LocalDate periodoContratacao) {
        this.periodoContratacao = periodoContratacao;
    }

    public CargosEnum getCargo() {
        return cargo;
    }

    public void setCargo(CargosEnum cargo) {
        this.cargo = cargo;
    }

}
