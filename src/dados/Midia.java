package dados;

public abstract class Midia {

	private int codigo;

	private String titulo;

	private int ano;

	public Midia(int codigo, String titulo, int ano) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.ano = ano;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAno() {
		return ano;
	}

	public abstract double calculaLocacao();

}
