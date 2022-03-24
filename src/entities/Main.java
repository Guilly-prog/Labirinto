package entities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    	try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Qual o nome do arquvo?");
			String filename = scan.nextLine();
			Labirinto labirinto = new Labirinto();
//			labirinto.carregaLabirinto(filename); LabyrinthFile.txt
			
			
			System.out.println();
			for (int x = 0; x<8; x++) {
			for (int y = 0; y<20; y++) {
				System.out.print(labirinto.carregaLabirinto(filename)[x][y]);
			}
			System.out.println("");
		}
			

		}
    }
}
