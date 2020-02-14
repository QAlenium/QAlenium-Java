package br.com.empresa.almintegration.helper;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Random;

public class RG_CPF_CNPJ_Helper {


	public static void main(String[] args) throws IOException{

		HashMap <String, Integer> cpfs = new HashMap <String, Integer>();

		while(cpfs.size() != 30000){
			StringBuilder sb = new StringBuilder();

			for(int i=0; i<11; i++){
				sb.append(getRandomNumber());
			}

			if(isCPF(sb.toString())){
				cpfs.put(sb.toString(), 1);
			}
		}

		for (Entry<String, Integer> cpf : cpfs.entrySet()) {
			System.out.println(cpf.getKey()/*+" - "+ new NamesGenerator().gerarNome()*/); //printa os CPFs
		}

		//		int i = 0;
		//		while(i < 5){
		//			logger.info(generateCPF());
		//		}

	}

	public String generateCPF(){

		int i = 0;
		while(i != 30000){
			StringBuilder sb = new StringBuilder();

			for(int j=0; j<11; j++){
				sb.append(getRandomNumber());
			}

			if(isCPF(sb.toString())){
				return sb.toString();
			}
		}
		return null;
	}

	public String generateRG(){

		StringBuilder sb = new StringBuilder();
		for(int j=0; j<9; j++){
			sb.append(getRandomNumber());
		}
		return sb.toString();
	}


	public static int getRandomNumber(){
		return new Random().nextInt(9);
	}

	public static boolean isCPF(String CPF) {

		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999") ||
				(CPF.length() != 11)){
			return(false);
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {              
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0         
				// (48 eh a posicao de '0' na tabela ASCII)         
				num = (int)(CPF.charAt(i) - 48); 
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else dig11 = (char)(r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return(true);
			else return(false);
		} catch (InputMismatchException erro) {
			return(false);
		}
	}

	public String pontuarCPF(String CPF) {
		return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
				CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	}

	public String cpfSemSpecialChars(String cpf){
		String replaceAll = cpf.replaceAll("\\.", "");
		String cpfSemCharsSpecial = replaceAll.replaceAll("-", "");
		return cpfSemCharsSpecial;
	}

	public String cnpjSemSpecialChars(String cnpj){
		
		String replaceAll = cnpj.replaceAll("\\.", "");
		String replaceAll2 = replaceAll.replaceAll("-", "");
		String cnpjSemSpecialChars = replaceAll2.replaceAll("/", "");
		return cnpjSemSpecialChars;
	}
	
	public String imprimeRG(String RG) {
		return(RG.substring(0, 2) + "." + RG.substring(2, 5) + "." +
				RG.substring(5, 8) + "-" + RG.substring(8, 9));
	}

	public String generateCNPJ(){

		int digito1 = 0, digito2 = 0, resto = 0;
		String  nDigResult;
		String numerosContatenados;
		String numeroGerado;
		Random numeroAleatorio = new Random();
		
		//numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);
		int n10 = numeroAleatorio.nextInt(10); 
		int n11 = numeroAleatorio.nextInt(10); 
		int n12 = numeroAleatorio.nextInt(10); 
		
		int soma = n12*2 + n11*3 + n10*4 + n9*5 + n8*6 + n7*7 + n6*8 + n5*9 + n4*2 + n3*3 + n2*4 + n1*5;
		int valor = (soma / 11)*11;
		digito1 = soma-valor;
		
		//Primeiro resto da diviso por 11.
		resto = (digito1 % 11);
		if(digito1 < 2){
			digito1 = 0;
		} else {
			digito1 = 11-resto;
		}
		
		int soma2 =  digito1*2 + n12*3 + n11*4 + n10*5 + n9*6 + n8*7 + n7*8 + n6*9 + n5*2 + n4*3 + n3*4 + n2*5 + n1*6 ;
		int valor2 = (soma2 / 11)*11;
		digito2 = soma2-valor2;
		
		//Primeiro resto da diviso por 11.
		resto = (digito2 % 11);
		if(digito2 < 2){
			digito2 = 0;
		} else {
			digito2 = 11-resto;
		}
		
		//Conctenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) +"."+ String.valueOf(n3) + String.valueOf(n4) +
				String.valueOf(n5) +"."+ String.valueOf(n6) + String.valueOf(n7) +String.valueOf(n8)+"/"+
				String.valueOf(n9) + String.valueOf(n10) + String.valueOf(n11) +
				String.valueOf(n12)+"-";
		//Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
		numeroGerado = numerosContatenados+nDigResult;
		
		return numeroGerado;

	}
}
