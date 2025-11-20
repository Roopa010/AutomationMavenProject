package framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtil {

	public static String getText(String fileName, int startPage, int endPage) {
		String text = "";
		
		try {
			//Read the PDF file in Java.
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Files\\"+fileName);
			
			//Load PDF file into PDDocument class to analyze the PDF file.
			PDDocument document = PDDocument.load(fis);
			
			//Extract the text from PDF file by using PDFTextStripper class.
			PDFTextStripper pdf = new PDFTextStripper();
			
			//Set the start and end page.
			pdf.setStartPage(startPage);
			pdf.setEndPage(endPage);
			
			//Get the text from PDF.
			text = pdf.getText(document);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return text;
	}
	public static void main(String[] args) {
		
		String text = getText("TWO_WHEELER_Phonepe_Insurance_PDF_250109_185520.pdf",9,9);
		System.out.println(text);
		System.out.println(text.contains("SHILPA"));
		
	}

}
