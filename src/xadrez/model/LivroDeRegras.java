package xadrez.model;

public class LivroDeRegras {

    private int contaJogada = 1;

    public void verificarJogada(String notacao) {

        if (!notacao.contains("x")) {
            String peca = notacao.substring(0, 1);
            char coluna = notacao.charAt(1);
            int linha = Integer.parseInt(notacao.substring(2, 3));
            int chaveLinha = 0;
            boolean caminhoLimpo = false;
            int linhaTorre = 0;

            if (Tabuleiro.tabuleiro.get("" + coluna + linha).equals(" ")) {
                if (peca.equals("P") && Tabuleiro.tabuleiro.get("" + coluna + (linha - 1)).equals("P")) {
                    Tabuleiro.tabuleiro.replace("" + coluna + (linha - 1), " ");
                    Tabuleiro.tabuleiro.replace("" + coluna + linha, "P");
                    contaJogada++;
                } else if ((peca.equals("P") && linha == 4)
                        && Tabuleiro.tabuleiro.get("" + coluna + (linha - 2)).equals("P")) {
                    Tabuleiro.tabuleiro.replace("" + coluna + (linha - 2), " ");
                    Tabuleiro.tabuleiro.replace("" + coluna + linha, "P");
                    contaJogada++;
                } else if (peca.equals("R")) {
                    // Verificar movimento para cima (linhas superiores)
                    for (linhaTorre = linha; linhaTorre >= 1; linhaTorre--) {
                        if (Tabuleiro.tabuleiro.get("" + coluna + linhaTorre).equals("R")) {
                            chaveLinha = linhaTorre;
                        }
                    }
                    for (linhaTorre = linha; linhaTorre > chaveLinha; linhaTorre--) {
                        if (Tabuleiro.tabuleiro.get("" + coluna + linhaTorre).equals(" ")) {
                            caminhoLimpo = true;
                        } else {
                            caminhoLimpo = false;
                            break; // Se encontrar uma peça no caminho, pare de verificar
                        }
                    }
                    // Verificar movimento para baixo (linhas inferiores)
                    if (caminhoLimpo) {
                        for (linhaTorre = linha; linhaTorre <= 8; linhaTorre++) {
                            if (Tabuleiro.tabuleiro.get("" + coluna + linhaTorre).equals("R")) {
                                chaveLinha = linhaTorre;
                            }
                        }
                        for (linhaTorre = linha; linhaTorre < chaveLinha; linhaTorre++) {
                            if (Tabuleiro.tabuleiro.get("" + coluna + linhaTorre).equals(" ")) {
                                caminhoLimpo = true;
                            } else {
                                caminhoLimpo = false;
                                break; // Se encontrar uma peça no caminho, pare de verificar
                            }
                        }
                    }
                    if (caminhoLimpo) {
                        Tabuleiro.tabuleiro.replace("" + coluna + chaveLinha, " ");
                        Tabuleiro.tabuleiro.replace("" + coluna + linha, "R");
                    }
                } else if (peca.equals("N")) {

                }
            }
        }
    }

    public int getContaJogada() {
        return contaJogada;
    }

    public void setContaJogada(int contaJogada) {
        this.contaJogada = contaJogada;
    }
}