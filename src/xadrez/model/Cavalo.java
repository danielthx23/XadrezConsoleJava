package xadrez.model;

public final class Cavalo extends Peca {

	public void moverCavalo(char coluna, int linha, String vez) {
		int[] linhaCavaloPosicoes = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int[] colunaCavaloPosicoes = { 1, 2, 2, 1, -1, -2, -2, -1 };

		for (int i = 0; i < 8; i++) {
			linhaPeca = linha + linhaCavaloPosicoes[i];
			colunaPeca = (char) (coluna + colunaCavaloPosicoes[i]);

			System.out.println("" + colunaPeca + linhaPeca);

			if (linhaPeca >= 1 && linhaPeca <= 8 && colunaPeca >= 'a' && colunaPeca <= 'h') {
				String cavaloPossiveisPosicoes = "" + colunaPeca + linhaPeca;
				String elementoPossivelPosicao = Tabuleiro.tabuleiro.get(cavaloPossiveisPosicoes);

				if (elementoPossivelPosicao.equals(vez + "N")) {
					System.out.println("Achei o cavalo na posição: " + cavaloPossiveisPosicoes
							+ " com o elemento: " + elementoPossivelPosicao + " e troquei para posição: "
							+ "" + coluna + linha);
					Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "N");
					Tabuleiro.tabuleiro.replace("" + cavaloPossiveisPosicoes, "  ");
					LivroDeRegras.contaJogadas++;
					break;
				}
			} else {
				System.out.println("Não achei o cavalo");
			}
		}
	}
}
