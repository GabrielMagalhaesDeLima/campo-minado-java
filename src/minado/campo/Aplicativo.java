package minado.campo;

import minado.campo.modelo.Tabuleiro;
import minado.campo.visao.TabuleiroConsole;

public class Aplicativo {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro (6, 6, 3);
		new TabuleiroConsole(tabuleiro);
	}
}
