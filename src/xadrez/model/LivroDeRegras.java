package xadrez.model;

import xadrez.controller.XadrezController;

public class LivroDeRegras {

	protected static int contaJogadas = 0;
	private String jogador = "";

	public int getContaJogadas() {
		return contaJogadas;
	}

	public String getJogador() {
		if (contaJogadas % 2 == 0) {
			jogador = "Branco";
		} else {
			jogador = "Preto";
		}
		return jogador;
	}

	public void verificarJogada(String notacao) {

		XadrezController controlPecas = new XadrezController();
		String peca = "", vez = "";
		char coluna = ' ';
		int linha = 0;
		boolean reiBranco = false, reiPreto = false;

		if (!notacao.contains("x")) {
			peca = notacao.substring(0, 1);
			coluna = notacao.charAt(1);
			linha = Integer.parseInt(notacao.substring(2, 3));
		} else if (notacao.contains("x")) {
			peca = notacao.substring(0, 1);
			coluna = notacao.charAt(2);
			linha = Integer.parseInt(notacao.substring(3, 4));
		}

		if (contaJogadas % 2 == 0) {
			vez = "W";
		} else {
			vez = "B";
		}

		try {

			if (!Tabuleiro.tabuleiro.get("" + coluna + linha).contains(vez)) {

				switch (peca) {
				case "P": {
					if (Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && !notacao.contains("x")) {
						controlPecas.moverPeao(coluna, linha, vez);
					} else if (!Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && notacao.contains("x")) {
						controlPecas.capturaPeao(coluna, linha, vez);
					}
					break;
				}
				case "R": {
					controlPecas.moverTorre(coluna, linha, vez);

					break;
				}
				case "N": {
					controlPecas.moverCavalo(coluna, linha, vez);

					break;
				}
				case "B": {
					controlPecas.moverBispo(coluna, linha, vez);

					break;
				}

				case "K": {
					controlPecas.moverRei(coluna, linha, vez);

					break;
				}

				case "Q": {
					controlPecas.moverRainha(coluna, linha, vez);

					break;
				}

				default:
					throw new Exception("Unexpected value: " + peca);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for (String pecas : Tabuleiro.tabuleiro.keySet()) {
			if (Tabuleiro.tabuleiro.get(pecas).equals("BK")) {
				reiPreto = true;
			} else if (Tabuleiro.tabuleiro.get(pecas).equals("WK")) {
				reiBranco = true;
			}
		}

		if (reiBranco == false) {
			System.out.println("Preto ganhou!");
			Tabuleiro.recomecar();
		} else if (reiPreto == false) {
			System.out.println("Branco ganhou!");
			Tabuleiro.recomecar();
		}

	}
}