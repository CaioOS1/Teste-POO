public enum CargosEnum {
	SECRETARIO("Secretário", 1),
	VENDEDOR ("Vendedor", 2),
	GERENTE ("Gerente", 3);
	
	private String nome;
	private int codigo;
	
	CargosEnum(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}
}
