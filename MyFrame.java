import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;
import java.io.File;
import java.awt.*;

public class MyFrame extends JFrame implements ActionListener{
    JButton encode = new JButton("Encode");
    JButton decode = new JButton("Decode");
    JButton izberi = new JButton("Izberi datoteko");
    static JLabel label = new JLabel();
    static String izbranFile = " ";
    static JPanel panel = new JPanel();
    JTextField input = new JTextField();
    String method = "";
    String keyword = "";
    static String filePath = "";
    static String pathPlain = "";
    static JFileChooser fileChooser = new JFileChooser();
    static int result;
    public static File selectedFile;
    MyFrame(){
        
        chooser();
        
        encode.setBounds(150,100,100,50);
        decode.setBounds(250,100,100,50);
        izberi.setBounds(250,100,100,50);
        encode.setFocusable(false);
        decode.setFocusable(false);
        izberi.setFocusable(false);
        input.setPreferredSize(new Dimension(250,25));
        input.setText("Klucna beseda");

        encode.addActionListener(this);
        decode.addActionListener(this);
        izberi.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(encode);
        this.add(decode);
        this.add(input);
        this.add(izberi);
        this.pack();
        this.setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==encode){
            method="encode";
            keyword = input.getText();
            Reader.Write(Logic.encode(Reader.Read(filePath),keyword), pathPlain.concat("\\Cripted.txt"));
        }
        else if(e.getSource()==decode){
            method="decode";
            keyword = input.getText();
            Reader.Write(Logic.decode(Reader.Read(filePath),keyword), pathPlain.concat("\\Decripted.txt"));
        }
        else if(e.getSource()==izberi){
            chooser();
        }
        
    }
    public static void chooser(){
        if(result == JFileChooser.APPROVE_OPTION){
            fileChooser.setCurrentDirectory(new File("."));
            result = fileChooser.showOpenDialog(panel);
            selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            pathPlain = filePath.substring(0, filePath.lastIndexOf("\\"));
            filePath = selectedFile.getAbsolutePath();
        }
    }
}
