import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Eseg {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 100);
        frame.setTitle("Composizione del tuo brano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Scrivi una frase per creare la tua composizione");
        JTextField textField = new JTextField();
        JTextArea resultTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        // aggiungo i componenti al frame
        frame.add(label, BorderLayout.NORTH);
        frame.add(textField, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // aggiungo un ActionListener al JTextField
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String inputString = textField.getText();
            	Convertitore notina = new Convertitore(inputString);
            	String vocali = new String(notina.converti());
            	String testo = notina.creaTesto(vocali);
            	System.out.println(testo);
            	resultTextArea.setText(testo);
            	frame.dispose();
            }
        });

        frame.setVisible(true);
    }
    
}
