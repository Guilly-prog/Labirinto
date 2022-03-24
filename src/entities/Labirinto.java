package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {

	public static char[][] labirinto;

	public static char[][] carregaLabirinto(String fileName) {    	
		String filename = "./src/resources/" + fileName;

		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			int count = 0;
			int i = Integer.parseInt(line.trim());
			line = bufferedReader.readLine();
			int j = Integer.parseInt(line.trim());

			labirinto = new char[i][j];

			while (line != null) {
				if (count >= 2) {
					labirinto[count-2] = line.toCharArray();
				}
				line = bufferedReader.readLine();
				count++;
			}
//			for (int x = 0; x<i; x++) {
//				for (int y = 0; y<j; y++) {
//					System.out.print(labirinto[x][y]);
//				}
//				System.out.println("");
//			}

			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + filename + "\" nao existe. ");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + filename + ". ");
		}
		return labirinto;		
	}

}
