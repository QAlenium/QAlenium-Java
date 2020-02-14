package br.com.empresa.almintegration.evidences;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

//import org.odftoolkit.odfdom.converter.pdf.PdfConverter; --DESCOMENTAR A LINHA PARA CONVERTER PARA PDF
//import org.odftoolkit.odfdom.converter.pdf.PdfOptions; --DESCOMENTAR A LINHA PARA CONVERTER PARA PDF
import org.odftoolkit.odfdom.doc.OdfDocument;

public class Teste {

	public Teste() {
		EvidencesWriter e = EvidencesWriter.getInstance();
		 ////e.createEvidencesDocument();
		//e.newTestStepTableElement(null, null);
		//TestStepTable newTestStepTableElement = e.newTestStepTableElement(null, null);
		//newTestStepTableElement.addImage(Utils);
		// newTestStepTableElement.setStepStatus(Step_Statuses.PASSED);
		// newTestStepTableElement = e.newTestStepTableElement(null, null);
		// newTestStepTableElement.setStepStatus(Step_Statuses.FAILED);
		try {
			e.getTextDocument().save("teste.odt");
			e.getTextDocument().close();
			File outFile=new File("target/ODTStructures.pdf");
		    outFile.getParentFile().mkdirs();
		    OutputStream out=new FileOutputStream(outFile);
		    //PdfOptions options = PdfOptions.create(); --DESCOMENTAR A LINHA PARA CONVERTER PARA PDF
		    OdfDocument odfDocument = OdfDocument.loadDocument("teste.odt");
		    //PdfConverter.getInstance().convert(odfDocument,out,options); --DESCOMENTAR A LINHA PARA CONVERTER PARA PDF
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		new Teste();
	}
}
