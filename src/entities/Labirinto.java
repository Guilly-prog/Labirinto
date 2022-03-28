package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Labirinto {

	private static final char LIVRE = ' ';
	private static final char PAREDE = 'X';
	private static final char TESTADO = '-';
	private static int numeroLinha, numeroColuna;
	private static char[][] labirinto;

	public static void posicaoTestada(int linha, int coluna) {
		labirinto[linha][coluna] = TESTADO;
	}

	/**
	 * Metodo que valida se uma posição esta dentro do labirinto, e se a posicao esta livre
	 * @param linha
	 * @param coluna
	 * @return
	 */
	public boolean posicaoValida(int linha, int coluna) {		
		if(linha>=0 && linha<labirinto.length && 
				coluna>=0 && coluna<labirinto[linha].length) {
			if(labirinto[linha][coluna] == LIVRE) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo recursivo verifica se o nome do arquivo é nulo ou vazio, e se o objeto criado
	 * com ele é nulo
	 * @param fileName
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean labirinto(String fileName) throws IllegalArgumentException{
		if(Objects.isNull(fileName) || fileName.isEmpty()) throw new IllegalArgumentException();
		
		labirinto = carregaLabirinto(fileName);
		if(Objects.nonNull(labirinto)) {
			return labirintoR(labirinto, 0, 0);			
		}
		return false;
	}

	/**
	 * Metodo recursivo que diz se ha alguma solucao para o labirinto ou nao
	 * @param fileCharMatrix
	 * @return
	 */
	private boolean labirintoR(char[][] fileCharMatrix, int linha, int coluna){		
		boolean done = false;
		if(posicaoValida(linha,coluna)) {
			posicaoTestada(linha,coluna);
			
			if (labirinto[linha][coluna] == 'D') {
				done = true;
			} else {
				if(!done) {
					done = labirintoR(fileCharMatrix, linha-1, coluna);//casa de cima
				}
				if(!done) {
					done = labirintoR(fileCharMatrix, linha, coluna-1);//casa da esquerda
				}
				if(!done) {
					done = labirintoR(fileCharMatrix, linha+1, coluna);//casa de baixo
				}
				if(!done) {
					done = labirintoR(fileCharMatrix, linha, coluna+1);//casa da direita
				}
			}
		
		}
		return done;
	}

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
				if (count >= 1) {
					labirinto[count-1] = line.toCharArray();
				}
				line = bufferedReader.readLine();
				count++;
			}

			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + filename + "\" nao existe. ");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + filename + ". ");
		}
		return labirinto;		
	}

	public static int getNumeroLinha() {
		return numeroLinha;
	}
	public static void setNumeroLinha(int numeroLinha) {
		Labirinto.numeroLinha = numeroLinha;
	}

	public static int getNumeroColuna() {
		return numeroColuna;
	}
	public static void setNumeroColuna(int numeroColuna) {
		Labirinto.numeroColuna = numeroColuna;
	}

	public static char[][] getLabirinto() {
		return labirinto;
	}
	public static void setLabirinto(char[][] labirinto) {
		Labirinto.labirinto = labirinto;
	}

	public static char getLivre() {
		return LIVRE;
	}
	public static char getParede() {
		return PAREDE;
	}
	public static char getTestado() {
		return TESTADO;
	}
	
	

	@Override
	public String toString() {
		String resultado = "\n";
		for (int x = 0; x<labirinto.length; x++) {
			for (int y = 0; y<labirinto[x].length; y++) {
				resultado += labirinto[x][y] + "";
			}
			resultado += "\n";
		}
		return resultado;
	}

	


}
