package entities;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Qual o nome do arquvo?");
			String filename = scan.nextLine();
			Labirinto labirinto = new Labirinto();
			//			labirinto.carregaLabirinto(filename); LabyrinthFile.txt

			labirinto.labirinto(filename);
			System.out.println(labirinto.toString());
			


		}
	}
}
