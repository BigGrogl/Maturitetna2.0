import java.util.*;

public class Main {
    public static String pathCripted = "";
    public static String pathPlain = "";
    public static String pathDecripted = "";
    public static String filePath = "";
    public static String path = "";
    public static Scanner bralnik = new Scanner(System.in);
    public static String key = "";

    public static void main(String[] args){
        GUI.main(args);
        filePath = GUI.filePath();
        path = GUI.genericPath();
        pathCripted = path.concat("\\Cripted.txt");
        pathDecripted = path.concat("\\Decripted.txt");
        pathPlain = filePath;

        /*System.out.println();
        System.out.println(path);
        System.out.println(pathCripted);
        System.out.println(pathPlain);
        System.out.println(pathDecripted);
        System.out.println(filePath);*/
        
        System.out.printf("%nVnesi kljucno besedo: ");
        key = bralnik.nextLine();
        System.out.printf("Izberite funkcijo (Encript/Decript)! ");
        String funkcija = bralnik.next();
        if(funkcija.equals("Encript")){
        Reader.Write(Logic.encodeLoop(Reader.Read(pathPlain), key), pathCripted);
        }else if(funkcija.equals("Decript")){
        Reader.Write(Logic.decodeLoop(Reader.Read(pathCripted), key), pathDecripted);
            if(Reader.Read(pathPlain).equals(Reader.Read(pathDecripted))){
                System.out.println("DELA!");
            }else{
                System.out.println("NE DELA!");
            }
        }
    }
}
