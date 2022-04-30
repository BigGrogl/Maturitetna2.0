import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.*;
import java.io.File;
import java.awt.*;

public class MyFrame extends JFrame implements ActionListener{
    JButton encode = new JButton("Encode");
    JButton decode = new JButton("Decode");
    JTextField input = new JTextField();
    String method = "";
    String keyword = "";
    String filePath = "";
    String pathPlain = "";
    public static File selectedFile;
    MyFrame(){
        JFileChooser fileChooser = new JFileChooser("D:\\GIT\\Maturitetna2.0\\");
        int result = fileChooser.showOpenDialog(this);
            if(result == JFileChooser.APPROVE_OPTION){
                selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                filePath = selectedFile.getAbsolutePath();
            }
        
        pathPlain = filePath.substring(0, filePath.lastIndexOf("\\"));
        
        encode.setBounds(150,100,100,50);
        decode.setBounds(250,100,100,50);
        encode.setFocusable(false);
        decode.setFocusable(false);
        input.setPreferredSize(new Dimension(250,25));
        input.setText("Klucna beseda");

        encode.addActionListener(this);
        decode.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(encode);
        this.add(decode);
        this.add(input);
        this.pack();
        this.setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==encode){
            method="encode";
            keyword = input.getText();
            Reader.Write(Logic.encodeLoop(Reader.Read(filePath),keyword), pathPlain.concat("\\Cripted.txt"));
        }
        else if(e.getSource()==decode){
            method="decode";
            keyword = input.getText();
            Reader.Write(Logic.decodeLoop(Reader.Read(filePath),keyword), pathPlain.concat("\\Decripted.txt"));
        }
        
    }
}
