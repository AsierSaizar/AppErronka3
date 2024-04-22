package Nomina;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import ControlNomina.ControlNomina;
import Menua.Menua;

public class Nomina extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField izena;
    private JTextField ordainketaPeriodoa;
    private JTextField diruKantitatea;
    private JButton createPdfButton;

 
    public Nomina(Menua menua) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        izena = new JTextField();
        izena.setBounds(5, 18, 426, 19);
        ordainketaPeriodoa = new JTextField();
        ordainketaPeriodoa.setBounds(5, 50, 426, 19);
        diruKantitatea = new JTextField();
        diruKantitatea.setBounds(5, 82, 426, 19);

        createPdfButton = new JButton("Nomina egin");
        createPdfButton.setBounds(19, 101, 83, 21);
        createPdfButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControlNomina.nominaEgin(izena.getText(),ordainketaPeriodoa.getText(),diruKantitatea.getText());
            }
        });
        contentPane.setLayout(null);

        JLabel label = new JLabel("Langilearen izena:");
        label.setBounds(19, 5, 78, 13);
        contentPane.add(label);
        contentPane.add(izena);
        izena.setMaximumSize(new Dimension(Integer.MAX_VALUE, izena.getPreferredSize().height));
        
        JLabel label_1 = new JLabel("Ordainketa periodoa:");
        label_1.setBounds(19, 37, 52, 13);
        contentPane.add(label_1);
        contentPane.add(ordainketaPeriodoa);
        ordainketaPeriodoa.setMaximumSize(new Dimension(Integer.MAX_VALUE, ordainketaPeriodoa.getPreferredSize().height));

        JLabel label_2 = new JLabel("Diru totala:");
        label_2.setBounds(19, 69, 66, 13);
        contentPane.add(label_2);
        contentPane.add(diruKantitatea);
        diruKantitatea.setMaximumSize(new Dimension(Integer.MAX_VALUE, diruKantitatea.getPreferredSize().height));
        
        contentPane.add(createPdfButton);
    }

}

