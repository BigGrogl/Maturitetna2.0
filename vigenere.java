public class vigenere{
    public static String alpha ="abcdefghijklmnopqrstuvwxyz 1234567890?.;,:-_";
    public static char[][] cipher = new char[alpha.length()][alpha.length()];

    public static void main(String[] args){
        char[] input = alpha.toCharArray();
        for(int i = 0; i < cipher.length; i++){
            cipher[i] = cipher(input,i);
        }
    }

    public static char[] cipher(char[] input, int n){
        for (int x = 0; x < input.length; x++) {
			char temp2 = input[input.length - 1];
			int y;
			for (y = input.length - 1; y > 0; y--){
				input[y] = input[y - 1];
            }
			input[y] = temp2;
		}
        return input;
    }
}