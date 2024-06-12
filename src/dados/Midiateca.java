package dados;

import java.util.Collection;
import java.util.ArrayList;

public class Midiateca implements Iterador {

	private int contador = 0;

	private ArrayList<Midia> midia;

	public Midiateca() {

	}

	public boolean cadastraMidia(Midia jogo) {
		return false;
	}

	public Midia consultaPorCodigo(int codigo) {
		return null;
	}

	public ArrayList<Midia> consultaPorCategoria(Categoria categoria) {
		return null;
	}

	public boolean removeMidia(int codigo) {
		return false;
	}


	/**
	 * @see dados.Iterador#reset()
	 */
	public void reset() {
		contador = 0;
	}


	/**
	 * @see dados.Iterador#hasNext()
	 */
	public boolean hasNext() {
		if(contador < midia.size()){
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * @see dados.Iterador#next()
	 */
	public Object next() {
		Midia p = midia.get(contador);
		contador++;
		return p;
	}

}
