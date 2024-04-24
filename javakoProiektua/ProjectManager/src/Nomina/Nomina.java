package Nomina;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



import ControlNomina.ControlNomina;
import Menua.Menua;

public class Nomina extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField izena;
    private JTextField ordainketaPeriodoa;
    private JTextField diruKantitatea;
    private JButton createPdfButton;
    private JButton btnNewButton;

 
    public Nomina(Menua menua) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        izena = new JTextField();
        izena.setBounds(128, 46, 159, 19);
        ordainketaPeriodoa = new JTextField();
        ordainketaPeriodoa.setBounds(128, 98, 159, 19);
        diruKantitatea = new JTextField();
        diruKantitatea.setBounds(128, 150, 159, 19);

        createPdfButton = new JButton("Nomina egin");
        createPdfButton.setBounds(140, 207, 137, 21);
        createPdfButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ControlNomina.nominaEgin(izena.getText(),ordainketaPeriodoa.getText(),diruKantitatea.getText());
            }
        });
        contentPane.setLayout(null);

        JLabel label = new JLabel("Langilearen izena:");
        label.setBounds(142, 23, 121, 13);
        contentPane.add(label);
        contentPane.add(izena);
        izena.setMaximumSize(new Dimension(Integer.MAX_VALUE, izena.getPreferredSize().height));
        
        JLabel label_1 = new JLabel("Ordainketa periodoa:");
        label_1.setBounds(142, 75, 108, 13);
        contentPane.add(label_1);
        contentPane.add(ordainketaPeriodoa);
        ordainketaPeriodoa.setMaximumSize(new Dimension(Integer.MAX_VALUE, ordainketaPeriodoa.getPreferredSize().height));

        JLabel label_2 = new JLabel("Diru totala:");
        label_2.setBounds(142, 127, 108, 13);
        contentPane.add(label_2);
        contentPane.add(diruKantitatea);
        diruKantitatea.setMaximumSize(new Dimension(Integer.MAX_VALUE, diruKantitatea.getPreferredSize().height));
        
        contentPane.add(createPdfButton);
        
        btnNewButton = new JButton("Atzera");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

				menua.setVisible(true);
				Nomina.this.setVisible(false);
        	}
        });
        btnNewButton.setBounds(5, 232, 85, 21);
        contentPane.add(btnNewButton);
    }

}

