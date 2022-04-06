import java.io.*;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args){

    }
    public static void Write(String code, String Path){
        try {
          File myObj = new File(Path);
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        try {
          FileWriter myWriter = new FileWriter(Path);
          myWriter.write(code);
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }
  
      public static String Read(String Path){
        String data=" ";  
          try {
            File myObj = new File(Path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              data = myReader.nextLine();
              System.out.println();
              System.out.println("Prebral sem: "+data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          return data;
      }
  
}
