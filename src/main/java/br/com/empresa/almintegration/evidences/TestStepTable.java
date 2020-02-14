package br.com.empresa.almintegration.evidences;

import java.io.File;
import java.net.URI;

import org.odftoolkit.odfdom.dom.element.table.TableTableElement;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.odftoolkit.simple.draw.Textbox;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.Paragraph;

public class TestStepTable extends TableTableElement {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3925659722388156505L;

	enum Step_Statuses {PASSED, FAILED} 

	public TestStepTable(OdfFileDom ownerDoc) {
		super(ownerDoc);		
	}
	
	public void addImagesToEvidences(String path, String runStepId){
		int i = 0;
		for (String filePath : path.split(",")) {
			filePath = filePath.replace("[", "").replace("]", "").replace(" ","");
			File file = new File(filePath);
			addImage(file.getPath());
			i++;
		}
	}
	
	public void addImage(String imagePath){
		imagePath = imagePath.replace('\\', '/');
		Cell evidencesCell = getEvidencesCell();
		Commons.insertImage(imagePath);
		// Paragraph paragraph = evidencesCell.getParagraphByReverseIndex(0, false);
		Paragraph paragraph = evidencesCell.addParagraph("");
		Textbox textBox = paragraph.addTextbox();		
		textBox.setImage(URI.create(imagePath));
	}
	
	public void setStepName(String stepName){
		Cell stepCounterCell = getStepNameCell();
		Paragraph paragraph = stepCounterCell.getParagraphByIndex(0, false);
		paragraph.setTextContent(stepName);
	}
	
	public void setStepAction(String stepAction){
		Cell stepActionCell = getStepActionCell();
		Paragraph paragraph = stepActionCell.getParagraphByIndex(0, false);
		paragraph.setTextContent(stepAction);
	}
	
	public void setStepExpectedResult(String stepExpectedResult){
		Cell stepExpectedResultCell = getStepExpectedResultCell();
		Paragraph paragraph = stepExpectedResultCell.getParagraphByIndex(0, false);
		paragraph.setTextContent(stepExpectedResult);
	}
	
	public void setStepActualResult(String stepActualResult){
		Cell stepActualResultCell = getStepActualResultCell();
		Paragraph paragraph = stepActualResultCell.getParagraphByIndex(0, false);
		paragraph.setTextContent(stepActualResult);
	}
	
	private Cell getStepNameCell() {
		Cell cell = Table.getInstance(this).getCellByPosition("C2");
		return cell;
	}
	
	private Cell getStepActionCell() {
		Cell cell = Table.getInstance(this).getCellByPosition("C3");
		return cell;
	}
	
	private Cell getStepExpectedResultCell(){
		Cell cell = Table.getInstance(this).getCellByPosition("E4");
		return cell;
	}
	
	private Cell getStepActualResultCell(){
		Cell cell = Table.getInstance(this).getCellByPosition("D5");
		return cell;
	}

	public void setStepCounter(String stepCounter){
		Cell stepCounterCell = getStepCounterCell();
		Paragraph paragraph = stepCounterCell.getParagraphByIndex(0, false);
		paragraph.setTextContent(stepCounter);
	}
	
	private Cell getStepCounterCell() {
		Cell cell = Table.getInstance(this).getCellByPosition("B1");
		return cell;
	}

	public void setStepStatus(String status){
		Cell statusCell = getTestStatusCell();
		Paragraph paragraph = statusCell.getParagraphByIndex(0, false);
		paragraph.setTextContent(status);
	}
	
	public void setEndDate(String date){
		Cell dateCell = getDateCell();
		Paragraph paragraph = dateCell.getParagraphByIndex(0, false);
		paragraph.setTextContent(date);
	}
	
	public void setEndTime(String time){
		Cell timeCell = getTimeCell();
		Paragraph paragraph = timeCell.getParagraphByIndex(0, false);
		paragraph.setTextContent(time);
	}
	
	private Cell getTimeCell() {
		Cell cell = Table.getInstance(this).getCellByPosition("K6");
		return cell;
	}

	private Cell getDateCell() {
		Cell cell = Table.getInstance(this).getCellByPosition("H6");
		return cell;
	}

	private Cell getEvidencesCell(){
		Cell cell = Table.getInstance(this).getCellByPosition("A8");
		return cell;
	}

	private Cell getTestStatusCell() {
		Cell cell = Table.getInstance(this).getCellByPosition("C6");
		return cell;
	}

}
