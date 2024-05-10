package xadrez.model;

public final class Rei extends Peca {

	public void moverRei(char coluna, int linha, String vez) {
		int[][] reiPossiveisPosicoes = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 },
				{ 1, -1 } };

		for (int[] reiPosicoes : reiPossiveisPosicoes) {
			linhaPeca = linha + reiPosicoes[0];
			colunaPeca = (char) (coluna + reiPosicoes[1]);

			System.out.println("" + colunaPeca + linhaPeca);

			if (linhaPeca >= 1 && linhaPeca <= 8 && colunaPeca >= 'a' && colunaPeca <= 'h') {
				String reiPossivelPosicao = "" + colunaPeca + linhaPeca;
				String elementoPossivelPosicao = Tabuleiro.tabuleiro.get(reiPossivelPosicao);

				if (elementoPossivelPosicao.equals(vez + "K")) {
					System.out.println("Achei o rei na posição: " + reiPossivelPosicao + " com o elemento: "
							+ elementoPossivelPosicao + " e troquei para posição: " + "" + coluna + linha);
					Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + "K");
					Tabuleiro.tabuleiro.replace("" + reiPossivelPosicao, "  ");
					LivroDeRegras.contaJogadas++;
					LivroDeRegras.historico += vez + coluna + linha + "K" + " ";
					break;
				}
			} else {
				System.out.println("Não achei o rei");
			}
		}
	}
}
