package br.com.empresa.almintegration.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.runner.Result;

import br.com.empresa.almintegration.execution.PlayTestCases;

public class SendEmail extends PlayTestCases {
	
//	public static void main(String[] args) throws AddressException, MessagingException, FileNotFoundException, IOException, URISyntaxException{
//		SendEmail s = new SendEmail();
//		s.generateAndSendEmail(null, null);
//	}
	
	private static String HOST;
	private static String PORT;
	private static String FROM;
	private static String TO;
	private static String PASS;
	
	public SendEmail() throws FileNotFoundException, IOException, URISyntaxException {
		this.FROM = settings.getConfig().getEmail().getFrom();
		this.TO = settings.getConfig().getEmail().getTo();
		this.HOST = settings.getConfig().getEmail().getHost();
		this.PASS = settings.getConfig().getEmail().getPass();
		this.PORT = settings.getConfig().getEmail().getPort();
	}
	

	public void generateAndSendEmail(File f, HashMap<String, Result> result) throws AddressException, MessagingException {

		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", HOST);
			props.put("mail.smtp.user", FROM);
			props.put("mail.smtp.password", PASS);
			props.put("mail.smtp.port", PORT);
			props.put("mail.smtp.auth", "true");
			props.put("mail.debug", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(FROM, PASS);
				}
			});

			MimeMessage message = new MimeMessage(session);
			Address fromAddress = new InternetAddress(FROM);
			Address toAddress = new InternetAddress(TO);

			message.setFrom(fromAddress);
			message.setRecipient(Message.RecipientType.TO, toAddress);

			ArrayList<String> TBNames = new PlayTestCases().getTBNames(result);
			StringBuilder sb = new StringBuilder();
			
			for (String TBName : TBNames) {
				sb.append(TBName).append(", ");
			}
			sb.append(".");
			
			String bodyText = sb.toString().replaceAll(", \\.", "\\.");
			
			message.setSubject("[Fábrica CUSTOMER_NAME] Status Report de Automação");
			message.setText("Este é o relatório da execução dos testes automatizados referente a:\n"
					+ bodyText + "\n"
					+ "Em anexo está a planilha de relatórios com o descritivo de cada teste.\n"
					+ "\n"
					+ "\nEste é um email automático que é gerado após cada execução.");

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();

			DataSource source = new FileDataSource(f);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(f.getName());
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			Transport transport = session.getTransport("smtp");
			transport.connect(HOST, FROM, PASS);
			message.saveChanges();
			Transport.send(message);
			transport.close();

		}catch(Exception ex){
			System.err.println("Erro ao enviar e-mail: " + ex.getMessage());
		}
	}

}
