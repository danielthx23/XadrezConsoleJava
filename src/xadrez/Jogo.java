package xadrez;

import java.util.Scanner;
import xadrez.model.*;
import xadrez.util.Cores;

public class Jogo {
 
    public static void main(String[] args) {
    	Scanner leia = new Scanner(System.in);
    	Tabuleiro tabuleiro1 = new Tabuleiro();
    	LivroDeRegras regras1 = new LivroDeRegras();
    	String jogada;
    	
    	tabuleiro1.recomecar();
    	
    	do {
    		tabuleiro1.renderizarTabuleiro();
    		
    		System.out.println(Cores.TEXT_RESET + "Número de jogadas: " + regras1.getContaJogadas());
    		System.out.println("Vez do " + regras1.getJogador());
    		System.out.print("\nInsira sua jogada em notação algebrica: \n\n");
    		
    		jogada = leia.next();
    		
    		if(jogada.equalsIgnoreCase("restart")) {
    			
    			tabuleiro1.recomecar();
    			
    		} else {
    		regras1.verificarJogada(jogada);
    		}
    		
    	} while(!jogada.equalsIgnoreCase("(=)"));
    	
    	
    	leia.close();
    	
    }
    
}