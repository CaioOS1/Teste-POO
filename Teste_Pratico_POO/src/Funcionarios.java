import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Arrays;

public class Funcionarios {
	
	public String nomeFuncionario;
    public String cargo;
    public double salarioBase;
    public double bonusAnual;
    public double beneficio;    
    public String dataDeContrato; 
    public double valorVendas;
    LocalDate hoje = LocalDate.now();

    

    public Funcionarios(String nomeFuncionario, String cargo, double salarioBase, double bonusAnual, double beneficio,
			String dataDeContrato, double valorVendas) {
		super();
		this.nomeFuncionario = nomeFuncionario;
		this.cargo = cargo;
		this.salarioBase = salarioBase;
		this.bonusAnual = bonusAnual;
		this.beneficio = beneficio;
		this.dataDeContrato = dataDeContrato;
		this.valorVendas = valorVendas;
	}
    
    public static long calcularDiasEntre(String dataRecebida) {
        LocalDate dataDeContrato = LocalDate.parse(dataRecebida);
        LocalDate hoje = LocalDate.now();

        return ChronoUnit.DAYS.between(dataDeContrato, hoje);
    }
   

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getBonusAnual() {
		return bonusAnual;
	}

	public void setBonusAnual(double bonusAnual) {
		this.bonusAnual = bonusAnual;
	}

	public double getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(double beneficio) {
		this.beneficio = beneficio;
	}

	public String getDataDeContrato() {
		return dataDeContrato;
	}

	public void setDataDeContrato(String dataDeContrato) {
		this.dataDeContrato = dataDeContrato;
	}

	public double getValorVendas() {
		return valorVendas;
	}

	public void setValorVendas(double valorVendas) {
		this.valorVendas = valorVendas;
	}
}
	
	
    
    
    
