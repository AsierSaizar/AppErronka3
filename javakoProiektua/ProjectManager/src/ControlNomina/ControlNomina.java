package ControlNomina;

import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;



public class ControlNomina {

	public static void nominaEgin(String name, String period, String amount) {
		// TODO Auto-generated method stub
        PDDocument document = new PDDocument();
        try {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Nomina Document");
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Langilearen izena: " + name);
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Ordainketa periodoa: " + period);
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Totalean $" + amount);
            contentStream.endText();

            contentStream.close();

            String path = "Nomina.pdf";
            document.save(path);
            document.close();

            JOptionPane.showMessageDialog(null, "PDF created successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error creating PDF: " + e.getMessage());
        }
    
	}

}
