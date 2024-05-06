package xadrez.model;

public final class Rainha extends Peca {

	public void moverBispo(char coluna, int linha, String vez, String tipoPeca) {
		int[][] bispoDesvios = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

		for (int[] desvio : bispoDesvios) {
			int linhaDesvio = desvio[0];
			int colunaDesvio = desvio[1];

			linhaPeca = linha;
			colunaPeca = coluna;

			while (linhaPeca >= 1 && linhaPeca <= 8 && colunaPeca >= 'a' && colunaPeca <= 'h') {
				linhaPeca += linhaDesvio;
				colunaPeca += colunaDesvio;

				if (linhaPeca >= 1 && linhaPeca <= 8 && colunaPeca >= 'a' && colunaPeca <= 'h') {
					String bispoPossivelPosicao = "" + colunaPeca + linhaPeca;
					String elementoPossivelPosicao = Tabuleiro.tabuleiro.get(bispoPossivelPosicao);

					if (elementoPossivelPosicao != null && elementoPossivelPosicao.equals(vez + tipoPeca)) {
						chaveLinha = linhaPeca;
						chaveColuna = colunaPeca;
						break;
					}
				} else {
					System.out.println("Essa posição é nula " + colunaPeca + linhaPeca);
					break;
				}
			}
		}

		System.out.println("Em que posição está o bispo que eu achei:" + chaveColuna + chaveLinha);
		System.out.println("Em que posição eu quero que o bispo vá:" + coluna + linha);

		for (int[] desvio : bispoDesvios) {
			int linhaDesvio = desvio[0];
			int colunaDesvio = desvio[1];

			linhaPeca = linha;
			colunaPeca = coluna;

			while (linhaPeca >= 1 && linhaPeca <= 8 && colunaPeca >= 'a' && colunaPeca <= 'h') {
				linhaPeca += linhaDesvio;
				colunaPeca += colunaDesvio;

				if (linhaPeca >= 1 && linhaPeca <= 8 && colunaPeca >= 'a' && colunaPeca <= 'h') {
					String bispoPossivelPosicao = "" + colunaPeca + linhaPeca;
					String elementoPossivelPosicao = Tabuleiro.tabuleiro.get(bispoPossivelPosicao);

					if (elementoPossivelPosicao.equals("  ") && !("" + chaveColuna + chaveLinha).equals("a0")) {
						caminhoLimpo = true;
						break;
					}
				} else {
					caminhoLimpo = false;
					System.out.println("tem coisa no caminho " + colunaPeca + linhaPeca);
					break;
				}
			}
		}

		System.out.println(caminhoLimpo);

		if (caminhoLimpo) {
			System.out.println("" + coluna + linha + vez + tipoPeca);
			Tabuleiro.tabuleiro.replace("" + chaveColuna + chaveLinha, "  ");
			Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + tipoPeca);
			LivroDeRegras.contaJogadas++;
		}
	}

	
	// ******************************************* MOVIMENTO DA TORRE ******************************************* //
	
	
	
	public void moverTorre(char coluna, int linha, String vez, String tipoPeca) {
		for (linhaPeca = linha; linhaPeca >= 1 && linhaPeca <= 8; linhaPeca += (linha > 1) ? -1 : 1) {
			if (Tabuleiro.tabuleiro.containsKey("" + coluna + linhaPeca)
					&& Tabuleiro.tabuleiro.get("" + coluna + linhaPeca).equals(vez + tipoPeca)) {
				chaveLinha = linhaPeca;
				chaveColuna = coluna;
				break;
			}
		}

		for (colunaPeca = coluna; colunaPeca >= 'a' && colunaPeca <= 'h'; colunaPeca += (coluna > 'a') ? -1 : 1) {
			if (Tabuleiro.tabuleiro.containsKey("" + colunaPeca + linha)
					&& Tabuleiro.tabuleiro.get("" + colunaPeca + linha).equals(vez + tipoPeca)) {
				chaveColuna = colunaPeca;
				chaveLinha = linha;
				break;
			}
		}

		System.out.println("Em que posição está a torre que eu achei:" + chaveColuna + chaveLinha);
		System.out.println("Em que posição eu quero que a torre vá:" + coluna + linha);

		if (chaveLinha == linha) {
			for (colunaPeca = coluna; colunaPeca != chaveColuna; colunaPeca += (colunaPeca < chaveColuna) ? 1 : -1) {
				if (colunaPeca >= 'a' && colunaPeca <= 'h' && Tabuleiro.tabuleiro.containsKey("" + colunaPeca + linha)
						&& Tabuleiro.tabuleiro.get("" + colunaPeca + linha).equals("  ")) {
					caminhoLimpo = true;
				} else {
					System.out.println("tem coisa no caminho " + colunaPeca + linha);
					caminhoLimpo = false;
					break;
				}
			}

			if (caminhoLimpo) {
				System.out.println("" + coluna + linha + vez + tipoPeca);
				Tabuleiro.tabuleiro.replace("" + chaveColuna + linha, "  ");
				Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + tipoPeca);
				LivroDeRegras.contaJogadas++;
			}
		}

		if (chaveColuna == coluna) {
			for (linhaPeca = linha; linhaPeca != chaveLinha; linhaPeca += (linhaPeca < chaveLinha) ? 1 : -1) {
				if (linhaPeca >= 1 && linhaPeca <= 8 && Tabuleiro.tabuleiro.containsKey("" + coluna + linhaPeca)
						&& Tabuleiro.tabuleiro.get("" + coluna + linhaPeca).equals("  ")) {
					caminhoLimpo = true;
				} else {
					System.out.println("tem coisa no caminho " + coluna + linhaPeca);
					caminhoLimpo = false;
					break;
				}
			}

			if (caminhoLimpo) {
				System.out.println("" + coluna + linha + vez + tipoPeca);
				Tabuleiro.tabuleiro.replace("" + coluna + chaveLinha, "  ");
				Tabuleiro.tabuleiro.replace("" + coluna + linha, vez + tipoPeca);
				LivroDeRegras.contaJogadas++;
			}
		}
	}

}
