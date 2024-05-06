package xadrez.controller;

import xadrez.repository.XadrezRepository;
import xadrez.model.Cavalo;
import xadrez.model.Peao;
import xadrez.model.Rainha;
import xadrez.model.Rei;

public class XadrezController implements XadrezRepository {

	Peao peao = new Peao();
	Cavalo cavalo = new Cavalo();
	Rainha rainha = new Rainha();
	Rei rei = new Rei();

	@Override
	public void moverPeao(char coluna, int linha, String vez) {
		peao.moverPeao(coluna, linha, vez);
	}
	
	@Override
	public void capturaPeao(char coluna, int linha, String vez) {
		peao.capturaPeao(coluna, linha, vez);
	}

	@Override
	public void moverTorre(char coluna, int linha, String vez) {
		rainha.moverTorre(coluna, linha, vez, "R");
	}

	@Override
	public void moverCavalo(char coluna, int linha, String vez) {
		cavalo.moverCavalo(coluna, linha, vez);
	}

	@Override
	public void moverBispo(char coluna, int linha, String vez) {
		rainha.moverBispo(coluna, linha, vez, "B");
	}

	@Override
	public void moverRei(char coluna, int linha, String vez) {
		rei.moverRei(coluna, linha, vez);
	}

	@Override
	public void moverRainha(char coluna, int linha, String vez) {
		rainha.moverTorre(coluna, linha, vez, "Q");
		rainha.moverBispo(coluna, linha, vez, "Q");
	}

}
