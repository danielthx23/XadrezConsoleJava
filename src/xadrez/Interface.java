package xadrez;

import java.util.Scanner;
import xadrez.model.*;
import xadrez.util.Cores;

public class Interface {
 
    public static void main(String[] args) {
    	Scanner leia = new Scanner(System.in);
    	Tabuleiro tabuleiro1 = new Tabuleiro();
    	LivroDeRegras regras1 = new LivroDeRegras();
    	String jogada;
    	
    	tabuleiro1.recomecar();
    	
    	do {
    		tabuleiro1.renderizarTabuleiro();
    		System.out.print(Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND_BRIGHT + "\nInsira sua jogada em notação algebrica: \n\n");
    		jogada = leia.next();
    		regras1.verificarJogada(jogada);
    	} while(!jogada.equalsIgnoreCase("(=)"));
    }
}