package xadrez.model;

import java.util.ArrayList;
import java.util.HashMap;
import xadrez.util.Cores;

public class Tabuleiro {

	protected static HashMap<String, String> tabuleiro = new HashMap<>();
    private ArrayList<String> sortedKeys;
    private final int BOARD_SIZE = 8;
    
    public void recomecar() {
        for (char c = 'a'; c <= 'h'; c++) {
            for (int f = 1; f <= BOARD_SIZE; f++) {
                String chave = String.valueOf(c) + f;
                Tabuleiro.tabuleiro.put(chave, " ");
            }
        }

        sortedKeys = new ArrayList<>(Tabuleiro.tabuleiro.keySet());
        
        for (String key : sortedKeys) {
            char column = key.charAt(0);
            char row = key.charAt(1);

            if (row == '2') {
            	Tabuleiro.tabuleiro.replace(key, "P");
            } else if (row == '1') {
                if (column == 'a' || column == 'h') {
                	Tabuleiro.tabuleiro.replace(key, "R");
                } else if (column == 'b' || column == 'g') {
                	Tabuleiro.tabuleiro.replace(key, "N");
                } else if (column == 'c' || column == 'f') {
                	Tabuleiro.tabuleiro.replace(key, "B");
                } else if (column == 'd') {
                    tabuleiro.replace(key, "K");
                } else if (column == 'e') {
                	Tabuleiro.tabuleiro.replace(key, "Q");
                }
            }
        }
    }
    
    public void renderizarTabuleiro() {
        for (int linha = BOARD_SIZE; linha >= 1; linha--) {
            for (char coluna = 'a'; coluna <= 'h'; coluna++) {
                String key = String.valueOf(coluna) + linha;
                String peca = Tabuleiro.tabuleiro.get(key);
                
                if ((linha + coluna) % 2 == 0) {
                    System.out.print(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE_BOLD);
                } else {
                    System.out.print(Cores.ANSI_WHITE_BACKGROUND + Cores.TEXT_BLACK_BOLD);
                }
                System.out.print(" " + peca + " ");
            }
            System.out.println();
        }
    }
}
