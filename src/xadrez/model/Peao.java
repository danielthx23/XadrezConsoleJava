package xadrez.model;

public final class Peao extends Peca {

	public void moverPeao(char coluna, int linha, String vez) {
		if (vez.equals("W")) {
			if (linha - 1 >= 1 && Tabuleiro.tabuleiro.get("" + coluna + (linha - 1)).equals(vez + "P")) {
				Tabuleiro.tabuleiro.replace("" + coluna + (linha - 1), "  ");
				Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "P");
				LivroDeRegras.contaJogadas++;
			} else if (linha == 4 && Tabuleiro.tabuleiro.get("" + coluna + (linha - 2)).equals(vez + "P")
					&& Tabuleiro.tabuleiro.get("" + coluna + (linha - 1)).equals("  ")) {
				Tabuleiro.tabuleiro.replace("" + coluna + (linha - 2), "  ");
				Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "P");
				LivroDeRegras.contaJogadas++;
			}
		} else {
			if (linha - 1 >= 1 && Tabuleiro.tabuleiro.get("" + coluna + (linha + 1)).equals(vez + "P")) {
				Tabuleiro.tabuleiro.replace("" + coluna + (linha + 1), "  ");
				Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "P");
				LivroDeRegras.contaJogadas++;
			} else if (linha == 5 && Tabuleiro.tabuleiro.get("" + coluna + (linha + 2)).equals(vez + "P")
					&& Tabuleiro.tabuleiro.get("" + coluna + (linha + 1)).equals("  ")) {
				Tabuleiro.tabuleiro.replace("" + coluna + (linha + 2), "  ");
				Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "P");
				LivroDeRegras.contaJogadas++;
			}
		}
	}

	public void capturaPeao(char coluna, int linha, String vez) {
	    if (vez.equals("W")) {
	        if (!Tabuleiro.tabuleiro.get("" + (char)(coluna + 1) + (linha - 1)).equals("  ")) {
	            Tabuleiro.tabuleiro.replace("" + (char)(coluna + 1) + (linha - 1), "  ");
	            Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "P");
	            LivroDeRegras.contaJogadas++;
	        } else if (!Tabuleiro.tabuleiro.get("" + (char)(coluna - 1) + (linha - 1)).equals("  ")) {
	            Tabuleiro.tabuleiro.replace("" + (char)(coluna - 1) + (linha - 1), "  ");
	            Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "P");
	            LivroDeRegras.contaJogadas++;
	        }
	    } 
	    else if (vez.equals("B")) {
	        if (!Tabuleiro.tabuleiro.get("" + (char)(coluna - 1) + (linha + 1)).equals("  ")) {
	            Tabuleiro.tabuleiro.replace("" + (char)(coluna - 1) + (linha + 1), "  ");
	            Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "P");
	            LivroDeRegras.contaJogadas++;
	        } else if (!Tabuleiro.tabuleiro.get("" + (char)(coluna + 1) + (linha + 1)).equals("  ")) {
	            Tabuleiro.tabuleiro.replace("" + (char)(coluna + 1) + (linha + 1), "  ");
	            Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "P");
	            LivroDeRegras.contaJogadas++;
	        }
	    }
	}
}
