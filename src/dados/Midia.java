package dados;

public abstract class Midia {

	private int codigo;

	private Categoria categoria;

	private String titulo;

	private int ano;

	public Midia(int codigo, String titulo, int ano, Categoria categoria) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.ano = ano;
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public int getAno() {
		return ano;
	}

	public abstract double calculaLocacao();

}
