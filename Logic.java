public class Logic {
    public static String alpha ="abcdefghijklmnopqrstuvwxyz ";
    public static void main(String[] args){

    }

    public static String Encode(String input, int Key){
        input = input.toLowerCase();
        String encripted = "";
        for(int i = 0; i < input.length(); i++){
            int pos = alpha.indexOf(input.charAt(i));
            int key = (Key+pos)%26;
            char replace = alpha.charAt(key);
            encripted += replace;
        }
        return encripted;
    }

    public static String Decode(String input, int Key){
        input = input.toLowerCase();
        String decripted = "";
        for(int i = 0; i < input.length(); i++){
            int pos = alpha.indexOf(input.charAt(i));
            int key = (pos-Key)%26;
            if(key < 0){
                key=alpha.length()+key;
            }
            char replace = alpha.charAt(key);
            decripted += replace;
        }
        return decripted;
    }

}
