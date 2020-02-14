package br.com.empresa.almintegration.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.hssf.record.cf.BorderFormatting;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.empresa.almintegration.constants.Constants;
import br.com.empresa.almintegration.constants.ViewConstants;

public class Evidencias {

	private XSSFWorkbook workbook;
	private XSSFSheet evidenceSheet;
	private XSSFRow row;

	private CellStyle titleStyle;
	private CellStyle descriptionStyle;

	private File outputDir;
	private File outputDirTemp;

	public String sheetName;

	public TreeMap<Integer, String> listaScreenshots = null;

	public static Integer evidenceRowCounter = 0;
	public Integer stepCounter = 1;

	/**
	 * @author Gabriel Fraga
	 * 
	 * metodo reponsavel por gravar e gerar o arquivo de evidencias
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public String gravarEvidencia() throws IOException, InterruptedException {

		Thread.sleep(3000);

		FileOutputStream fos;
		formatAutoSizeColumns(workbook, 0, 1);
		listaScreenshots = new TreeMap<Integer, String>();

		//-------------------------------------------------------------------------------------------------------------------

		try {

			putPicture(workbook, new FileInputStream(
					new File(Utils.carregarLinks().getProperty(ViewConstants.Properties.CLIENTE_LOGO))), sheetName, 0, 0);

			File diretorioTemporario = new File(outputDir+ ViewConstants.XpathProperties.UNDERLINE+Constants.temp);
			if(diretorioTemporario.isDirectory()){

				File[] files = diretorioTemporario.listFiles();

				for (int i = 0; i < files.length; i++) {

					File arq = files[i];
					String name = arq.getName();
					String[] nameSplt = name.split("_");

					listaScreenshots.put(Integer.parseInt(nameSplt[2]), arq.getAbsolutePath().toString());

				}
			}

			for (Entry<Integer, String> imagem : listaScreenshots.entrySet()) {

				putPicture(workbook, new FileInputStream(new File(imagem.getValue())), sheetName, 0, imagem.getKey());
			}

			String fileName = getEvidenceFileName(outputDir.getAbsolutePath(), sheetName + "_" + Utils.getDataHora(ViewConstants.XpathProperties.DATA_HORA));
			
			fos = new FileOutputStream(fileName);

			workbook.write(fos);
			fos.close();

			removerImagens(diretorioTemporario);

			System.err.println("\n\n\t TESTE "+getEvidenceFileName(outputDir.getAbsolutePath(), sheetName)+" OK\n\n");

			return fileName;
			
		} catch (Exception e) {
			evidenceRowCounter = 0;
			System.err.println(e.fillInStackTrace()+ "\n" +e.getStackTrace()[0]);
			System.err.println("Erro ao gerar e evidência");
		}
		
		return null;

	}

	/**
	 * @author Gabriel Fraga
	 * 
	 * Esse metodo eh responsavel por carregar todos os dados e objetos necessarios
	 * para gravar as evidencias 
	 * 
	 * @param testCaseName String - Utilizar no maximo 35 caracteres
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void startEvidence(String testCaseName) throws FileNotFoundException, IOException, URISyntaxException {

		workbook = new XSSFWorkbook();

		titleStyle = getBorderBoldSet(workbook);

		descriptionStyle = getBorderSet(workbook); 

		sheetName = testCaseName;

		outputDir = new File(getOutputDir());

		outputDirTemp = new File(outputDir +
				br.com.empresa.almintegration.constants.ViewConstants.XpathProperties.UNDERLINE + 
				Constants.temp);

		if (!outputDir.exists()) {
			outputDir.mkdirs();
		}

		if(!outputDirTemp.exists()){
			outputDirTemp.mkdir();

		}

		evidenceSheet = workbook.createSheet(WorkbookUtil.createSafeSheetName(sheetName));
		
	}


	/**
	 * @author Gabriel Fraga
	 * 
	 * metodo responsavel por criar o cabecalho do arquivo de evidência
	 * 
	 * @param cenario
	 */
	public void construirCapa(String cenario) {

		evidenceSheet.autoSizeColumn(1, false);
		CellStyle styleCabecalho = getStyleCapa(workbook);

		for (int i = 0; i < 41; i++) {
			row = evidenceSheet.createRow(i);

			for (int j = 0; j < 40; j++) {
				row.createCell(j).setCellStyle(styleCabecalho);
			}
		}
		
		evidenceSheet.setColumnWidth(1, 93);
		
		evidenceSheet.getRow(12).getCell(1).setCellStyle(getVerdana26(workbook));
		evidenceSheet.getRow(12).getCell(1).setCellValue(ViewConstants.XpathProperties.ROTULO_EVIDENCIA_TESTE);
		evidenceSheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
		evidenceSheet.addMergedRegion(new CellRangeAddress(0, 2, 1, 1));
		
		evidenceSheet.getRow(19).getCell(1).setCellStyle(getVerdana16(workbook));
		evidenceSheet.getRow(19).getCell(1).setCellValue(cenario);
		
		definirParametrosDeProjeto("PJ07329 - Credenciamento", "1.0", "FTB - TB06 - Funcional", ViewConstants.XpathProperties.ROTULO_FABRICA, "Automao");
		
//		putLine(ViewConstants.XpathProperties.ROTULO_FABRICA, ViewConstants.XpathProperties.ROTULO_YAMAN);
//		evidenceRowCounter++;
//
//		putLine(ViewConstants.XpathProperties.ROTULO_DATA, getToday());
//		evidenceRowCounter++;
//
//		putLine(ViewConstants.XpathProperties.ROTULO_CENARIO, cenario);
//		evidenceRowCounter +=2;

	}


	private void definirParametrosDeProjeto(String projName, String vDoc, String ciclo, String fabrica, String executor) {

		
		
	}

	/**
	 * 
	 * @author Gabriel Fraga
	 * 
	 * metodo que cria o step de cada passo no teste
	 *
	 * @param acao Descricao da acao a ser executada, 
	 * @param resultadoEsperado Descricao do resultado esperado
	 * @param resultado Se possui resultado
	 */
	public void putStep(String acao, String resultadoEsperado, boolean resultado) {

		putLine(ViewConstants.XpathProperties.ROTULO_STEP, stepCounter.toString());
		evidenceRowCounter++;

		putLine(ViewConstants.XpathProperties.ROTULO_ACAO, acao);
		evidenceRowCounter++;

		putLine(ViewConstants.XpathProperties.ROTULO_RESULTADO_ESPERADO, resultadoEsperado);

		if (resultado) {
			evidenceRowCounter++;
		} else {
			evidenceRowCounter += 2;
			stepCounter++;
		}
	}

	/**
	 * Gabriel Aguido Fraga<BR>
	 *
	 * Mtodo responsvel por gerar uma evidencia em String.
	 *
	 * @since 18 de ago de 2016 09:30:51
	 */
	public void putResult(String resultado) {

		putLine(ViewConstants.XpathProperties.ROTULO_RESULTADO, resultado);
		evidenceRowCounter += 2;

		stepCounter++;
	}

	public static CellStyle getBorderBoldSet(XSSFWorkbook wb) {
		XSSFFont font = wb.createFont();
		font.setBold(true);

		CellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setBorderTop(BorderFormatting.BORDER_THIN);
		style.setBorderLeft(BorderFormatting.BORDER_THIN);
		style.setBorderRight(BorderFormatting.BORDER_THIN);
		style.setBorderBottom(BorderFormatting.BORDER_THIN);
		return style;
	}

	public static CellStyle getBorderSet(XSSFWorkbook wb) {
		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_LEFT);
		style.setBorderTop(BorderFormatting.BORDER_THIN);
		style.setBorderLeft(BorderFormatting.BORDER_THIN);
		style.setBorderRight(BorderFormatting.BORDER_THIN);
		style.setBorderBottom(BorderFormatting.BORDER_THIN);
		return style;
	}

	/**
	 * para todos os sheets dentro do workbook, autosize nas colunas
	 * passadas por parametro.
	 * 
	 * @param wb workbook onde sera formatado.
	 * @param colunas colunas que vao receber autosize.
	 */
	public static void formatAutoSizeColumns(XSSFWorkbook wb, int... colunas) {
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			Sheet sheet = wb.getSheetAt(i);
			for (int j : colunas) {
				sheet.autoSizeColumn(j);
			}
		}
	}

	public static String getOutputDir() throws FileNotFoundException, IOException, URISyntaxException {
		StringBuilder directory = new StringBuilder();
		directory.append(Utils.carregarLinks().getProperty(
				br.com.empresa.almintegration.constants.ViewConstants.Properties.OUTPUT_DIR_BASE_EVIDENCES));
		directory.append(getTimestamp());
		return directory.toString();
	}

	public static String getTimestamp() {
		SimpleDateFormat formatter = new SimpleDateFormat(
				br.com.empresa.almintegration.constants.ViewConstants.XpathProperties.TIMESTAMP);
		return formatter.format(GregorianCalendar.getInstance().getTime());
	}

	/**
	 * Retorna um estilo alinhado no centro e com negrito.
	 * 
	 * @param wb workbook onde o estilo sera criado.
	 * @return estilo.
	 */
	public static CellStyle getStyleCapa(XSSFWorkbook wb) {
		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
		XSSFFont font = wb.createFont();
		font.setBold(true);
		font.setFontHeight(14);
		style.setFont(font);
		//style.setBorderTop(BorderFormatting.BORDER_THIN);
		//style.setBorderLeft(BorderFormatting.BORDER_THIN);
		//style.setBorderRight(BorderFormatting.BORDER_THIN);
		//style.setBorderBottom(BorderFormatting.BORDER_THIN);
		return style;
	}
	
	public static CellStyle getVerdana26 (XSSFWorkbook wb) {
		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
		XSSFFont font = wb.createFont();
		font.setBold(true);
		font.setFontHeight(26);
		font.setFontName("Verdana");
		style.setFont(font);
		//style.setBorderTop(BorderFormatting.BORDER_THIN);
		//style.setBorderLeft(BorderFormatting.BORDER_THIN);
		//style.setBorderRight(BorderFormatting.BORDER_THIN);
		//style.setBorderBottom(BorderFormatting.BORDER_THIN);
		return style;
	}
	
	public CellStyle getVerdana16 (XSSFWorkbook wb) {
		
		CellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
		style.setWrapText(true);
		XSSFFont font = wb.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		font.setFontName("Verdana");
		style.setFont(font);
		//style.setBorderTop(BorderFormatting.BORDER_THIN);
		//style.setBorderLeft(BorderFormatting.BORDER_THIN);
		//style.setBorderRight(BorderFormatting.BORDER_THIN);
		//style.setBorderBottom(BorderFormatting.BORDER_THIN);
		return style;
	}

	/**
	 * Inserir evidencias em planilha excel
	 * 
	 * @param wb Workbook aonde sera inserido a planilha
	 * @param image Picture que sera importada para a planilha
	 * @param evidenceSheet Seta a planilha que sera criada
	 * @param col Primeira coluna da planilha a ser utilizada
	 * @param row Linha a ser inserida a Imagem
	 * @throws IOException
	 */
	public static void putPicture(XSSFWorkbook wb, InputStream image, String sheetName, int col, int row) throws IOException {

		if(image != null){

			Sheet sheet = getSheet(wb, sheetName);

			byte[] bytes = IOUtils.toByteArray(image);
			int picture = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);

			CreationHelper helper = wb.getCreationHelper();

			Drawing drawing = (Drawing) sheet.createDrawingPatriarch();

			ClientAnchor anchor = helper.createClientAnchor();

			anchor.setCol1(col);
			anchor.setRow1(row);

			Picture pict = ((Drawing) drawing).createPicture(anchor, picture);

			pict.resize();
		}
	}

	/**
	 *  Cria a sheet caso ela nao exista
	 *   
	 * @param wb Workbook ativo
	 * @param sheetName Id da sheet definido em cada classe
	 * @return Devolve a sheet criada
	 */
	public static Sheet getSheet(XSSFWorkbook wb, String sheetName) {

		XSSFSheet sheet = wb.getSheet(WorkbookUtil.createSafeSheetName(sheetName));

		if (sheet == null) {

			try {				

				sheet = wb.createSheet(WorkbookUtil.createSafeSheetName(sheetName));
			} 
			catch (Exception e) {

				sheet = wb.createSheet();
			}
		}

		return sheet;
	}

	public static String getToday() {
		SimpleDateFormat formatter = new SimpleDateFormat(ViewConstants.XpathProperties.DATA_BARRA);
		return formatter.format(GregorianCalendar.getInstance().getTime());
	}

	public static String getEvidenceFileName(String path, String testCaseName) {
		StringBuilder directory = new StringBuilder();
		directory.append(path);
		directory.append(ViewConstants.XpathProperties.BARRA);
		directory.append(testCaseName);
		directory.append(ViewConstants.XpathProperties.EXCEL_EXTENSION);
		return directory.toString();
	}

	/**
	 * 
	 * @author Gabriel Fraga
	 * 
	 * metodo responsavel por deletar as imagens da pasta temporaria
	 * 
	 * @param f
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void removerImagens(File f) throws IOException, InterruptedException{

		Thread.sleep(3000);
		File[] files = f.listFiles();
		for(File file : files){
			System.gc();
			file.delete();
		}
		f.delete();
		evidenceRowCounter = 0;
	}

	public void putLine(String title, String description) {

		row = evidenceSheet.createRow(evidenceRowCounter);

		// Linha titulo
		row.createCell(0).setCellValue(title);
		titleStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_LEFT);
		row.getCell(0).setCellStyle(titleStyle);

		// Linha descricao
		row.createCell(1).setCellValue(description);
		descriptionStyle.setWrapText(true);
		descriptionStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_LEFT);
		row.getCell(1).setCellStyle(descriptionStyle);
	}
	
	public String textDataEntrance(String endpoint, String data){
		
		return new StringBuilder()
				.append("Endpoint:")
				.append("\n")
				.append(endpoint)
				.append("\n\nRequest:\n")
				.append(data)
				.append("\n")
				.toString();
	}
	
	public boolean validaSaida(int statusCodeExpected, int statusCode){
		
		if(statusCode == statusCodeExpected){
			return true;
		}
		return false;
	}
	
}
