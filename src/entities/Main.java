package entities;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Qual o nome do arquvo?");
			String filename = scan.nextLine();
			Labirinto labirinto = new Labirinto();
			//			labirinto.carregaLabirinto(filename); LabyrinthFile.txt


			labirinto.labirinto = new char[8][20];
			System.out.println("só lengh"+labirinto.labirinto.length);
			System.out.println("só []lengh"+labirinto.labirinto[0].length);
			System.out.println("só [][]"+labirinto.labirinto[0][0]);
			
//			System.out.println();
//			for (int x = 0; x<8; x++) {
//				for (int y = 0; y<20; y++) {
//					System.out.print(labirinto.carregaLabirinto(filename)[x][y]);
//				}
//				System.out.println("");
//			}


		}
	}
}
