package xadrez.model;

import java.util.ArrayList;
import java.util.HashMap;
import xadrez.util.Cores;

public class Tabuleiro {

	protected static HashMap<String, String> tabuleiro = new HashMap<>();
	private static ArrayList<String> sortedKeys;
	private static final int BOARD_SIZE = 8;

	public static void recomecar() {
		for (char c = 'a'; c <= 'h'; c++) {
			for (int f = 1; f <= BOARD_SIZE; f++) {
				String chave = String.valueOf(c) + f;
				tabuleiro.put(chave, "  ");
			}
		}

		sortedKeys = new ArrayList<>(tabuleiro.keySet());

		for (String key : sortedKeys) {
			char column = key.charAt(0);
			char row = key.charAt(1);

			if (row == '2') {
				tabuleiro.replace(key, "WP");
			} else if (row == '1') {
				if (column == 'a' || column == 'h') {
					tabuleiro.replace(key, "WR");
				} else if (column == 'b' || column == 'g') {
					tabuleiro.replace(key,  "WN");
				} else if (column == 'c' || column == 'f') {
					tabuleiro.replace(key, "WB");
				} else if (column == 'd') {
					tabuleiro.replace(key, "WK");
				} else if (column == 'e') {
					tabuleiro.replace(key, "WQ");
				}
			}
			
			if (row == '7') {
				tabuleiro.replace(key, "BP");
			} else if (row == '8') {
				if (column == 'a' || column == 'h') {
					tabuleiro.replace(key, "BR");
				} else if (column == 'b' || column == 'g') {
					tabuleiro.replace(key,  "BN");
				} else if (column == 'c' || column == 'f') {
					tabuleiro.replace(key, "BB");
				} else if (column == 'd') {
					tabuleiro.replace(key, "BK");
				} else if (column == 'e') {
					tabuleiro.replace(key, "BQ");
				}
			}
		}
	}

	public void renderizarTabuleiro() {
		for (int linha = BOARD_SIZE; linha >= 1; linha--) {
			for (char coluna = 'a'; coluna <= 'h'; coluna++) {
				String key = String.valueOf(coluna) + linha;
				String peca = tabuleiro.get(key);

				if ((linha + coluna) % 2 == 0) {
					System.out.print(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_BLACK_BOLD);
				} else {
					System.out.print(Cores.ANSI_YELLOW_BACKGROUND + Cores.TEXT_BLACK_BOLD);
				}
				System.out.print(" " + peca + " ");
			}
			System.out.println();
		}
	}
}
