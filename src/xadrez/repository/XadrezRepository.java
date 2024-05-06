package xadrez.repository;

public interface XadrezRepository {

	//Movimentação das peças
	public void moverPeao(char coluna, int linha, String vez);
	public void capturaPeao(char coluna, int linha, String vez);
	public void moverTorre(char coluna, int linha, String vez);
	public void moverCavalo(char coluna, int linha, String vez);
	public void moverBispo(char coluna, int linha, String vez);
	public void moverRei(char coluna, int linha, String vez);
	public void moverRainha(char coluna, int linha, String vez);
}
