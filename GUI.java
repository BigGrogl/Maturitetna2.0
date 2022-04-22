import javax.swing.*;

import javafx.event.ActionEvent;

import java.io.*;
import java.nio.*;

public class GUI {
    public static File selectedFile;
    private final static String newline = "\n";
    public static void main(String[] args){
        JFrame frame = new JFrame("TEST GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        JButton buttonEncode = new JButton("Encode");
        JButton buttonDecode = new JButton("Decode");
        JTextField input = new JTextField(15);

        frame.getContentPane().add(buttonEncode);
        frame.getContentPane().add(buttonDecode);
        frame.getContentPane().add(input);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.add(buttonEncode);
        panel.add(buttonDecode);
        panel.add(input);

        JPanel panelDown = new JPanel();

        
        
        

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(panel);
        if(result == JFileChooser.APPROVE_OPTION){
            selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
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
    
}
