import javax.swing.*;

import java.awt.Component;
import java.awt.event.*;
import java.io.*;
import java.nio.*;
import java.util.EventListener;

public class GUI extends JFrame implements ActionListener{

    public static File selectedFile;
    public static JTextField input = new JTextField(15);
    public static String method = "";
    
    public static void main(String[] args){

        JFrame frame = new JFrame("GROŠELJ ENCODER");
        JPanel panel = new JPanel();
        JPanel position = new JPanel();
        JLabel vnos = new JLabel("Ključ:");

        JButton buttonEncode;
        JButton buttonDecode;

        buttonEncode = new JButton("Encode");
        buttonDecode = new JButton("Decode");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        frame.getContentPane().add(buttonEncode);
        frame.getContentPane().add(buttonDecode);
        frame.getContentPane().add(input);
        
        panel.add(buttonEncode);
        panel.add(buttonDecode);
        panel.add(vnos);
        panel.add(input);
        frame.setSize(400,400);   
        frame.setVisible(true);   

        JFileChooser fileChooser = new JFileChooser("D:\\GIT\\Maturitetna2.0\\");
            
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

    public void actionPerformed(ActionEvent e){
        method = "encode";
    }
    
}
