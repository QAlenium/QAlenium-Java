package br.com.empresa.almintegration.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * @author Gabriel Fraga
 * 
 * Classe tem a finalidade de realizar a leitura e selecao  
 *
 */
public class LerArquivo {

	private int randomNumber;
	private String partnerCode;
	private int numberOfLines;

	public static BufferedReader getReader(String fileName) throws IOException, URISyntaxException {

		try{
			File file = new File(fileName);
			file.createNewFile();
		} catch (Exception e){
			System.out.println(e.fillInStackTrace()+ "\n" +e.getStackTrace()[0]);
		}

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		return new BufferedReader(isr);

	}

	public StringBuilder lerArquivo(String filePath) throws IOException, URISyntaxException{
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = getReader(filePath);
		
		String linha = "";
		
		while((linha = br.readLine()) != null){
			sb.append(linha);
		}
		
		return sb;
	}

	public String getRandomCep() throws IOException, URISyntaxException{
		return selecionarLinha(
				Utils.carregarLinks().getProperty(
				br.com.empresa.almintegration.constants.ViewConstants.Properties.AUX_PATH) + 
				"cep_sp.txt").split(";")[3];
	}
	
	public String selecionarLinha(String fileName) throws IOException, URISyntaxException{

		numberOfLines = getNumberOfLines(getReader(fileName));
		return getRandomLine(getReader(fileName));
	}
	
	private String getRandomLine(BufferedReader br) throws IOException{

		String linha = "";
		randomNumber = getRandomNumber(numberOfLines)+1;
		int cont2 = 0;

		while ((linha = br.readLine()) != null) {
			cont2++;
			if(cont2 == randomNumber){
				return linha;
			}
		}
		return null;
	}
	
	private int getNumberOfLines(BufferedReader br) throws IOException{

		@SuppressWarnings("unused")
		String linha = "";
		int cont = 0;

		while ((linha = br.readLine()) != null){
			cont++;
		}
		return cont;
	}
	
	private int getRandomNumber(int numberOfLines){
		return new Random().nextInt(numberOfLines);
	}
	
	public int getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public int getNumberOfLines() {
		return numberOfLines;
	}

	public void setNumberOfLines(int numberOfLines) {
		this.numberOfLines = numberOfLines;
	}

	public static void adicionarLinhaNoArquivo(String value, String fileName) throws IOException, URISyntaxException {

		boolean contains = false;

		BufferedReader br = getReader(fileName);

		String linha = "";
		StringBuilder sb = new StringBuilder();

		while ((linha = br.readLine()) != null) {

			if (linha.contains(value)) {
				contains = true;
			}

			sb.append(linha);
			sb.append("\n");
		}

		if (!contains) {
			sb.append(value);
			br.close();
		}

		BufferedWriter bw = getWriter(fileName);

		bw.append(sb);
		bw.flush();
		bw.close();
	}
	
	private static BufferedWriter getWriter(String fileName) throws IOException, URISyntaxException{

		File file = new File(fileName);
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		return new BufferedWriter(osw);

	}
	 
	 
}
