package xadrez.model;

import xadrez.controller.XadrezController;

public class LivroDeRegras {

	protected static int contaJogadas = 0;
	protected static String historico = "";
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
					if (Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && !notacao.contains("x")) {
						controlPecas.moverTorre(coluna, linha, vez);
					} else if (!Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && notacao.contains("x")) {
						controlPecas.moverTorre(coluna, linha, vez);
					}

					break;
				}
				case "N": {
					if (Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && !notacao.contains("x")) {
						controlPecas.moverCavalo(coluna, linha, vez);
					} else if (!Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && notacao.contains("x")) {
						controlPecas.moverCavalo(coluna, linha, vez);
					}

					break;
				}
				case "B": {
					if (Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && !notacao.contains("x")) {
						controlPecas.moverBispo(coluna, linha, vez);
					} else if (!Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && notacao.contains("x")) {
						controlPecas.moverBispo(coluna, linha, vez);
					}

					break;
				}

				case "K": {
					if (Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && !notacao.contains("x")) {
						controlPecas.moverRei(coluna, linha, vez);
					} else if (!Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && notacao.contains("x")) {
						controlPecas.moverRei(coluna, linha, vez);
					}

					break;
				}

				case "Q": {
					if (Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && !notacao.contains("x")) {
						controlPecas.moverRainha(coluna, linha, vez);
					} else if (!Tabuleiro.tabuleiro.get("" + coluna + linha).equals("  ") && notacao.contains("x")) {
						controlPecas.moverRainha(coluna, linha, vez);
					}

					break;
				}

				default:
					throw new Exception("Unexpected value: " + peca);
				}
			}
		} catch (Exception e) {
			System.err.println("Notação inválida");
		}

		for (String pecas : Tabuleiro.tabuleiro.keySet()) {
			if (Tabuleiro.tabuleiro.get(pecas).equals("BK")) {
				reiPreto = true;
			} else if (Tabuleiro.tabuleiro.get(pecas).equals("WK")) {
				reiBranco = true;
			}
		}
		
		int placarPreto = 0;
		int placarBranco = 0;

		if (reiBranco == false) {
			contaJogadas = 0;
			System.out.println("Preto ganhou!\n");
			placarPreto++;
			System.out.println(placarPreto + " - " + placarBranco + "\n");
			System.out.println(historico + "\n");
			Tabuleiro.recomecar();
		} else if (reiPreto == false) {
			contaJogadas = 0;
			System.out.println("Branco ganhou!\n");
			placarBranco++;
			System.out.println(placarPreto + " - " + placarBranco + "\n");
			System.out.println(historico + "\n");
			Tabuleiro.recomecar();
		}

	}
}