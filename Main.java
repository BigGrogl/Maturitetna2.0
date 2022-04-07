import java.util.*;

public class Main {
    public static String PathCripted = "D:\\GIT\\Maturitetna2.0\\Cripted.txt";
    public static String PathPlain = "D:\\GIT\\Maturitetna2.0\\Plain.txt";
    public static String PathDecripted = "D:\\GIT\\Maturitetna2.0\\Decripted.txt";
    public static Scanner bralnik = new Scanner(System.in);
    public static String Key = "";
    public static void main(String[] args){
        System.out.printf("%nVnesi kljucno besedo: ");
        Key = bralnik.nextLine();
        System.out.printf("Izberite funkcijo (Encript/Decript)! ");
        String funkcija = bralnik.next();
        if(funkcija.equals("Encript")){
        Reader.Write(Logic.encode(Reader.Read(PathPlain), Key), PathCripted);
        }else if(funkcija.equals("Decript")){
        Reader.Write(Logic.decode(Reader.Read(PathCripted), Key), PathDecripted);
            if(Reader.Read(PathPlain).equals(Reader.Read(PathDecripted))){
                System.out.println("DELA!");
            }else{
                System.out.println("RETARD SI!");
            }
        }
        

        
    }
}
