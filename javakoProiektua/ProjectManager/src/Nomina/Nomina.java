package Nomina;

import javax.swing.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class Nomina extends JFrame {
    private JTextField nameField;
    private JTextField periodField;
    private JTextField amountField;
    private JButton createPdfButton;

    public Nomina() {
        super("Nomina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        nameField = new JTextField();
        periodField = new JTextField();
        amountField = new JTextField();

        createPdfButton = new JButton("Create PDF");
        createPdfButton.addActionListener(e -> createPdf());

        add(new JLabel("Employee Name:"));
        add(nameField);
        add(new JLabel("Pay Period:"));
        add(periodField);
        add(new JLabel("Total Amount:"));
        add(amountField);
        add(createPdfButton);

        setVisible(true);
    }

    private void createPdf() {
        String name = nameField.getText();
        String period = periodField.getText();
        String amount = amountField.getText();

        try {
            String path = "payroll.pdf";
            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Payroll Document"));
            document.add(new Paragraph("Employee Name: " + name));
            document.add(new Paragraph("Pay Period: " + period));
            document.add(new Paragraph("Total Amount: $" + amount));

            document.close();
            JOptionPane.showMessageDialog(this, "PDF created successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error creating PDF.");
        }
    }

    public static void main(String[] args) {
        new PayrollPdfCreator();
    }
}

