import java.util.*;
public class Main {
    public static String PathCripted = "D:\\GIT\\Maturitetna2.0\\Cripted.txt";
    public static String PathPlain = "D:\\GIT\\Maturitetna2.0\\Plain.txt";
    public static String PathDecripted = "D:\\GIT\\Maturitetna2.0\\Decripted.txt";
    public static Scanner bralnik = new Scanner(System.in);
    public static void main(String[] args){
        System.out.printf("Izberite funkcijo (Encript/Decript)! ");
        String funkcija = bralnik.next();
        if(funkcija.equals("Encript")){
        Reader.Write(Logic.Encode(Reader.Read(PathPlain), 5), PathCripted);
        }else if(funkcija.equals("Decript")){
        Reader.Write(Logic.Decode(Reader.Read(PathCripted), 5), PathDecripted);
        }
    }
}
