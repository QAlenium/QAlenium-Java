package br.com.empresa.almintegration.testing.web;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.empresa.almintegration.constants.Constants;
import br.com.empresa.almintegration.constants.ViewConstants;

public class WebTestCase {

	/**
	 * @author Gabriel Fragra 
	 * 
	 * Metodo responsavel por Salvar um screenshot da tela de tamanho 1000 x 500.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveScreenshot(WebDriver driver) throws IOException {
		saveScreenshot(null, Boolean.FALSE, Boolean.FALSE, driver);
	}
	
	/**
	 * @author Gabriel Fraga
	 * 
	 * Salva screenshot com uma pequena area de tela em redor do elemento selecionado
	 *
	 * @param element Elemento selecionado
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveCroppedScreenshot(WebElement element, WebDriver driver) throws IOException {
		try{
			saveScreenshot(element, Boolean.TRUE, Boolean.FALSE, driver);
		} catch (RasterFormatException rfe){
			saveScreenshot(element, Boolean.FALSE, Boolean.FALSE, driver);
		}
	}
	
	/** @author gabriel.fraga
	 * Salva screenshot com uma pequena area de tela em redor do elemento, que fica destacado em vermelho
	 *
	 * @param element Elemento selecionado
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveCroppedHighlightedScreenshot(WebElement element, WebDriver driver) throws IOException {
		try{
			saveScreenshot(element, Boolean.TRUE, Boolean.TRUE, driver);
		} catch (RasterFormatException rfe){
			saveScreenshot(element, Boolean.FALSE, Boolean.FALSE, driver);
		}
	}
	
	/**
	 * @author Gabriel Fraga
	 * 
	 * metodo responsavel por salvar screenshot da tela toda
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void saveScreenshot(WebElement element, Boolean crop, Boolean highlight, WebDriver driver) throws IOException {

		StringBuilder outputfileName = new StringBuilder();
		outputfileName.append(ViewConstants.XpathProperties.UNDERLINE);
		outputfileName.append(ViewConstants.Properties.TEMP);
		outputfileName.append(ViewConstants.XpathProperties.BARRA);
		outputfileName.append(ViewConstants.XpathProperties.UNDERLINE);
		outputfileName.append(ViewConstants.XpathProperties.UNDERLINE);
		outputfileName.append(ViewConstants.XpathProperties.UNDERLINE);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date hora = Calendar.getInstance().getTime(); 
		String dataFormatada = sdf.format(hora);
		dataFormatada = dataFormatada.replaceAll(":", "");
		
		outputfileName.append(dataFormatada);
		outputfileName.append(ViewConstants.XpathProperties.PONTO);
		outputfileName.append(ViewConstants.XpathProperties.PNG);

		File outputfile = new File(outputfileName.toString());
		//logger.info(outputfileName.toString());

		BufferedImage imagem = getScreenshot(driver, element, crop, highlight);

		int alturaImagem = (int) imagem.getHeight();

		ImageIO.write(imagem, ViewConstants.XpathProperties.PNG, outputfile);

		//getListaScreenshots().put(evidenceRowCounter, outputfileName.toString());

	}
	
	public static BufferedImage getScreenshot(WebDriver driver, WebElement element, Boolean crop, Boolean highlight) throws IOException {

		final BufferedImage img;

		int xNovaImagem;
		int yNovaImagem;
		int larguraNovaImagem;
		int alturaNovaImagem;

		if (element != null && highlight) {

			try{
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0,"+(element.getLocation().y-250)+");");
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid #cc008f'", element);
			} catch (RasterFormatException e){
				e.printStackTrace();
				driver.navigate().refresh();
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid #cc008f'", element);
			}
		}

		img = ImageIO.read(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));

		if (element != null && crop) {
			int larguraImagem = img.getWidth();
			int alturaImagem = img.getHeight();
			int x = element.getLocation().getX();
			int y = element.getLocation().getY();
			int larguraElemento = element.getSize().getWidth();
			int alturaElemento = element.getSize().getHeight();

			if (y - 200 < 0) {
				yNovaImagem = 0;
			} else {
				yNovaImagem = y - 200;
			}

			if (x - 200 < 0) {
				xNovaImagem = 0;
			} else {
				xNovaImagem = x - 200;
			}

			if (x + larguraElemento + 200 > larguraImagem) {
				larguraNovaImagem = (x + larguraElemento) + (larguraImagem - (x + larguraElemento)); 
			} else {
				larguraNovaImagem = larguraElemento + 400;
			}

			if (y + alturaElemento + 200 > alturaImagem) {
				alturaNovaImagem = (y + alturaElemento) + (alturaImagem - (y + alturaElemento));
			} else {
				alturaNovaImagem = alturaElemento + 400;
			}

			try{
				return img.getSubimage(xNovaImagem, yNovaImagem, larguraNovaImagem, alturaNovaImagem);
			} catch (RasterFormatException rfe){

			}
		}

		alturaNovaImagem = img.getHeight();
		larguraNovaImagem = img.getWidth();

		if(img.getHeight() > Constants.screen.getHeight()) {
			alturaNovaImagem = (int) Constants.screen.getHeight();
		}

		if (img.getWidth() > Constants.screen.getWidth()) {
			larguraNovaImagem = (int) Constants.screen.getWidth();
		}

		return img.getSubimage(0, 0, larguraNovaImagem, alturaNovaImagem);
	}
	
}
