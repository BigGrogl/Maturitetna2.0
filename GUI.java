import javax.swing.*;

import javafx.event.ActionEvent;

import java.io.*;
import java.nio.*;
import java.util.EventListener;

public class GUI extends JFrame implements ActionListener {
    public static File selectedFile;
    private final static String newline = "\n";
    public JButton buttonEncode = new JButton("Encode");
    public static JButton buttonDecode = new JButton("Decode");
    public static JTextField input = new JTextField(15);
    public static void main(String[] args){
        JFrame frame = new JFrame("GROŠELJ ENCODER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        

        frame.getContentPane().add(buttonEncode);
        frame.getContentPane().add(buttonDecode);
        frame.getContentPane().add(input);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        JButton izbirnik= new JButton("Izberi datoteko");
        panel.add(buttonEncode);
        panel.add(buttonDecode);
        panel.add(izbirnik);
        JLabel vnos = new JLabel("Ključ:");
        panel.add(vnos);
        panel.add(input);

        buttonEncode.addActionListener(this);  
        frame.add(buttonEncode);frame.add(input);  
        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true);   

        JFileChooser fileChooser = new JFileChooser("C:\\Grošelj\\Maturitetna2.0\\");
            if(izbirnik.getModel().isPressed()){
            int result = fileChooser.showOpenDialog(panel);
            if(result == JFileChooser.APPROVE_OPTION){
                selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            }
        }

        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }
    public static String filePath(){
        return selectedFile.getAbsolutePath();
    }
    public static String genericPath(){
        String path = selectedFile.getAbsolutePath();
        String genericPath = path.substring(0, path.lastIndexOf("\\"));
        return genericPath;
    }
    public static String method(){
        String metoda = "";
        if(buttonDecode.getModel().isPressed()){
            metoda = "Decript";
        }else if(buttonEncode.getModel().isPressed()){
            metoda = "Encript";
        }
        return metoda;
    }
    
}
