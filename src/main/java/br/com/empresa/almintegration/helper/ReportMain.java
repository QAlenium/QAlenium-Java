package br.com.empresa.almintegration.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.empresa.almintegration.execution.PlayTestCases;
import br.com.empresa.almintegration.mainframe.net.sf.f3270.IntegrationTestBase;

/**
 * Fabrica<BR>
 *
 * AUT-126 - Relatorio de execucao em Excel<BR>
 *
 * @since 7 de jul de 2016 15:19:20
 * @author Gabriel Aguido Fraga<BR>
 *         Fabrica<BR>
 * 
 *         automation
 */
public class ReportMain extends IntegrationTestBase {

	private static Logger LOGGER = LoggerFactory.getLogger(ReportMain.class.getSimpleName());
	
	private static XSSFWorkbook workbook;
	
	public ReportMain() {
		
	}
	
	/**
	 * Fabrica<BR>
	 *
	 * AUT-126 - Relatorio de execucao em Excel<BR>
	 *
	 * @since 7 de jul de 2016 11:25:26
	 * @author Gabriel Aguido Fraga<BR>
	 */
	public static String gerarRelatorioXls(String nome) throws Exception {
		
		LOGGER.info("["+new Date()+"] Entrou no metodo gerarRelatorioXls");
		
		Thread.sleep(2000);
		
		workbook = new XSSFWorkbook(new FileInputStream(PlayTestCases.settings.getConfig().getPaths().getAux() + "Relatorio Execucao.xltx"));
		
		String reportName = "Relatorio Execucao" + "-" + nome + "-" + DateHelper.getDataAtualFormatada("yyyyMMdd-HHmmss") + ".xltx";

		String pathName = PlayTestCases.settings.getConfig().getPaths().getOutputDirBaseEvidences();
		
		if (!new File(pathName).exists()) {

			new File(pathName).mkdirs();
		}
		
		FileOutputStream out = null;
		
		try {
			
			// == Relatorios ===================================================
			
			Map<Integer, Object[]> mapReportExecucao = geraMapRelatorioExecucao(nome);
			Map<Integer, Object[]> mapReportCTs = geraMapRelatorioCTs();
			Map<Integer, Object[]> mapReportErros = geraMapRelatorioErros();
			
			// == Abas =========================================================
			
			createSheet("Execucao", mapReportExecucao, false);
			createSheet("CTs", mapReportCTs, true);
			createSheet("Erros", mapReportErros, true);
			
			// == Geracao do arquivo ===========================================
			out = new FileOutputStream(new File(pathName + reportName));
		    
		    LOGGER.info("["+new Date()+"] Relatorio " + pathName + reportName + " gerado com sucesso");	
		} 
		catch (Exception e) {
			
			throw e;
		}
		finally {
			
			Thread.sleep(1000);
		    workbook.write(out);
		    
			Thread.sleep(1000);
		    out.close();
		}
		
		return pathName + reportName;
	}
	
	// = Metodos de apoio ===========================================================
	
	/**
	 * Fabrica<BR>
	 *
	 * AUT-126 - Relatorio de execucao em Excel<BR>
	 *
	 * @since 7 de jul de 2016 13:31:51
	 * @author Gabriel Aguido Fraga<BR>
	 */
	private static Map<Integer, Object[]> geraMapRelatorioExecucao(String nome) throws Exception {
		
    	LOGGER.debug("Entrou no metodo geraMapRelatorioExecucao");
    	
		// Gera map report					
		Map<Integer, Object[]> mapReport = new TreeMap<Integer, Object[]>();
		
		int cont = 1;
		
		int runCount = 0;
		int failureCount = 0;
		int okCount = 0;
		int ignoreCount = 0;
		
		long runTime = 0;
		
		mapReport.put(cont++, new Object[] {
				"Testes da classe",
				"Testes executados",
				"Tempo geral da execucao",
				"Testes falhados",
				"Testes passados",
				"Testes ignorados",
				"Versao",
				"Todos os testes passaram?"
				});
		
		if (PlayTestCases.result != null && !PlayTestCases.result.isEmpty()) {
		
			//for (Result result : results) {
			
			Set<String> keyset = PlayTestCases.result.keySet();
			
			for (String keyReport : keyset) {
			
				Result result = PlayTestCases.result.get(keyReport);
				
				String version = "ND";
				
				runCount += result.getRunCount();
				runTime += result.getRunTime();
				failureCount += result.getFailureCount();
				okCount += (result.getRunCount() - result.getFailureCount());
				ignoreCount += result.getIgnoreCount();
				
				mapReport.put(cont++, new Object[] {
						keyReport,
						result.getRunCount(),
						new Utils().transformMillisToTime(result.getRunTime()),
						result.getFailureCount(),
						result.getRunCount()-result.getFailureCount(),
						result.getIgnoreCount(),
						version, 
						(result.wasSuccessful() && result.getRunCount() > 0)
					}
				);
			}
			
			// Rodape
			mapReport.put(cont++, new Object[] {
					"TOTAL:",
					runCount,
					new Utils().transformMillisToTime(runTime),
					Utils.calculaPercentual(failureCount, runCount) + " %",
					Utils.calculaPercentual(okCount, runCount) + " %",
					Utils.calculaPercentual(ignoreCount, runCount) + " %",
					"", 
					""
				}
			);			
		}
		
		return mapReport;
	}
	
	/**
	 * Fabrica<BR>
	 *
	 * AUT-126 - Relatorio de execucao em Excel<BR>
	 *
	 * @since 8 de jul de 2016 10:35:57
	 * @author Gabriel Aguido Fraga<BR>
	 */
	private static Map<Integer, Object[]> geraMapRelatorioCTs() throws Exception {
		
    	LOGGER.debug("Entrou no metodo geraMapRelatorioExecucao");
    	
		// Gera map report					
		Map<Integer, Object[]> mapReport = new TreeMap<Integer, Object[]>();
		
		int cont = 1;

		// Extrai as falhas
		
		Map<String, Failure> mapFailure = new TreeMap<String, Failure>();
		
		if (PlayTestCases.result != null && !PlayTestCases.result.isEmpty()) {
		
			//for (Result result : results) {
			
			Set<String> keyset = PlayTestCases.result.keySet();
			
			for (String keyReport : keyset) {
			
				Result result = PlayTestCases.result.get(keyReport);
				
				if (result.getFailures() != null && !result.getFailures().isEmpty()) {
					
					for (Failure failure : result.getFailures()) {
					
						mapFailure.put(failure.getTestHeader().substring(failure.getTestHeader().lastIndexOf('.') + 1).replaceAll("[^a-zA-Z0-9_]",""), failure);
						//mapFailure.put(failure.getTestHeader().substring(failure.getTestHeader().lastIndexOf('.') + 1), failure);
					}
				}
			}
		}
				
		mapReport.put(cont++, new Object[] {
				"#",
				"Classe",
				"Modulo",
				"CT",
				"Status",
				"Observacao"
				});
		
		int id = 1;
		
		if (PlayTestCases.ctsSuite != null && !PlayTestCases.ctsSuite.isEmpty()) {
		
			for (String keyReport : PlayTestCases.ctsSuite.keySet()) {
				
				CT ct = PlayTestCases.ctsSuite.get(keyReport);
				
				boolean failure = mapFailure.containsKey(ct.getClasse());
				
				mapReport.put(cont++, new Object[] {
						id++,
						ct.getClasse(),
						ct.getModulo(),
						ct.getCt(),
						(failure ? "FALHA" : "OK"),
						Utils.removeQuebraLinha((failure ? "Verifique os detalhes na planilha de Erros" : ""))
						}
				);
			}
		}
		
		return mapReport;
	}

	/**
	 * Fabrica<BR>
	 *
	 * AUT-126 - Relatorio de execucao em Excel<BR>
	 *
	 * @since 7 de jul de 2016 14:39:46
	 * @author Gabriel Aguido Fraga<BR>
	 */
	private static Map<Integer, Object[]> geraMapRelatorioErros() throws Exception {
		
    	LOGGER.debug("Entrou no metodo geraMapRelatorioErros");
    	
		// Gera map report					
		Map<Integer, Object[]> mapReport = new TreeMap<Integer, Object[]>();
		
		int cont = 1;
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		mapReport.put(cont++, new Object[] {
				"Classe",
				"Mensagem",
				"Trace",
				"Descricao",
				"Excecao"
				});
		
		if (PlayTestCases.result != null && !PlayTestCases.result.isEmpty()) {
		
			//for (Result result : results) {
				
			Set<String> keyset = PlayTestCases.result.keySet();
				
			for (String keyReport : keyset) {
				
				Result result = PlayTestCases.result.get(keyReport);
				
				if (result.getFailures() != null && !result.getFailures().isEmpty()) {
					
					for (Failure failure : result.getFailures()) {
					
						String trace = failure.getTrace();
							
						mapReport.put(cont++, new Object[] {
								failure.getTestHeader().substring(failure.getTestHeader().lastIndexOf('.') + 1).replaceAll("[^a-zA-Z0-9_]+",""),
								//failure.getTestHeader().substring(failure.getTestHeader().lastIndexOf('.') + 1),
								Utils.removeQuebraLinha(failure.getMessage()),
								Utils.removeQuebraLinha(trace),
								Utils.removeQuebraLinha(failure.getDescription().toString()),
								Utils.removeQuebraLinha(failure.getException().toString())
							}
						);
					}
				}
			}
		}
		
		return mapReport;
	}
	
	/**
	 * Fabrica<BR>
	 *
	 * AUT-126 - Relatorio de execucao em Excel<BR>
	 *
	 * @since 7 de jul de 2016 11:29:43
	 * @author Gabriel Aguido Fraga<BR>
	 */
	private static void createSheet(String sheetName, Map<Integer, Object[]> data, boolean autoFilter)
			throws FileNotFoundException, IOException {
		
    	LOGGER.debug("Entrou no metodo createSheet");
		
		XSSFFont fontTitle = workbook.createFont();
		XSSFFont fontTable = workbook.createFont();
		
		configureFontTitle(fontTitle);
		configureFontTable(fontTable);		
		
		XSSFCellStyle styleTitle = workbook.createCellStyle();
		XSSFCellStyle styleTable = workbook.createCellStyle();
		
		configureStyleTitle(styleTitle, fontTitle);
		configureStyleTable(styleTable, fontTable);
		
		//HSSFSheet sheet = this.workbook.createSheet(sheetName);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//sheet.setDefaultColumnWidth(16);
		sheet.createFreezePane(0, 1); 
		
		Set<Integer> keyset = data.keySet();
		
		int rownum = 0;
		
		CellAddress cellAddress = null;
		
		for (Integer keyReport : keyset) {
		
			Row row = sheet.createRow(rownum++);
		    
			Object[] objArr = data.get(keyReport);
		    
			int cellnum = 0;
		    
			for (Object obj : objArr) {
		    
				Cell cell = row.createCell(cellnum++);
				
				sheet.autoSizeColumn(cellnum);
				
				cell.setCellStyle(rownum == 1 ? styleTitle : styleTable);
				
				if(obj instanceof Date) {
		            
					cell.setCellValue((Date)obj);
				}
		        else if(obj instanceof Boolean) {
		            
		        	cell.setCellValue((Boolean)obj);
		        }
		        else if(obj instanceof String) {
		            
		        	cell.setCellValue((String)obj);
		        }
		        else if(obj instanceof Double) {
		            
		        	cell.setCellValue((Double)obj);
		        }
		        else if(obj instanceof Integer) {
		            
		        	cell.setCellValue((Integer)obj);
		        }
				
				cellAddress = cell.getAddress();
		    }
		}
		
		if (autoFilter) {
			
			sheet.setAutoFilter(CellRangeAddress.valueOf("A1:" + cellAddress.toString()));
		}
	}
	
	/**
	 * Fabrica<BR>
	 *
	 * @since 23 de mar de 2016 13:38:08
	 * @author Gabriel Aguido Fraga<BR>
	 */
	private static void configureStyleTitle(XSSFCellStyle style, XSSFFont font) {
		
    	LOGGER.debug("Entrou no metodo configureStyleTitle");
		
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFont(font);
		style.setWrapText(true);	
		
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(HSSFColor.BLACK.index);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(HSSFColor.BLACK.index);
		
		style.setFillBackgroundColor(HSSFColor.GREY_80_PERCENT.index);
		style.setFillForegroundColor(HSSFColor.GREY_80_PERCENT.index);
		
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	}
	
	/**
	 * Fabrica<BR>
	 *
	 * @since 23 de mar de 2016 13:38:08
	 * @author Gabriel Aguido Fraga<BR>
	 */
	private static void configureStyleTable(XSSFCellStyle style, XSSFFont font) {
		
    	LOGGER.debug("Entrou no metodo configureStyleTable");
		
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFont(font);
		style.setWrapText(true);	
		
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setRightBorderColor(HSSFColor.BLACK.index);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setTopBorderColor(HSSFColor.BLACK.index);
		
		style.setFillBackgroundColor(HSSFColor.WHITE.index);
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	}

	/**
	 * Fabrica<BR>
	 *
	 * @since 23 de mar de 2016 13:37:22
	 * @author Gabriel Aguido Fraga<BR>
	 */
	private static void configureFontTitle(XSSFFont font) {
		
    	LOGGER.debug("Entrou no metodo configureFontTitle");
		
		font.setFontName("Calibri");
		font.setFontHeight((short)(11*20));
		font.setColor((short)HSSFColor.WHITE.index);
		font.setBold(true);
	}
	
	/**
	 * Fabrica<BR>
	 *
	 * @since 23 de mar de 2016 13:37:22
	 * @author Gabriel Aguido Fraga<BR>
	 */
	private static void configureFontTable(XSSFFont font) {
		
    	LOGGER.debug("Entrou no metodo configureFontTable");
		
		font.setFontName("Calibri");
		font.setFontHeight((short)(11*20));
		font.setColor((short)HSSFColor.BLACK.index);
		font.setBold(false);
	}

	@Override
	protected Mode getMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getHostname() {
		// TODO Auto-generated method stub
		return null;
	}
}
