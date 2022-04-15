public class Logic{
    public static int lower = 32;
    public static int upper = 126;
    public static char[] cipherTable = cipherAlpha();

    public static void main(String[] args){
        
    }

    public static String encodeLoop(String plain, String key){
        int keyInt = key.length();
        String cripted = plain;

            cripted = encodeVige(cripted, key);
            cripted = encodeCaesar(cripted, keyInt);     
        return cripted;
    }

    public static String decodeLoop(String cripted, String key){
        int keyInt = key.length();
        String plain = cripted;

        plain = decodeCaesar(cripted, keyInt);
        plain = decodeVige(cripted, key);
        
        return plain;
    }

    public static char[] cipherAlpha(){
        char[] alpha = new char[(upper-lower)+1];
        for (int i = lower; i <= upper; i++) {
            alpha[i - lower] = (char) i;
        }
        return alpha;
    }

    public static String encodeVige(String input, String key){
        StringBuilder builder = new StringBuilder(input.length());
            int keyIndex = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                int pos = (int) c;
                if (pos < lower || pos > upper) {
                    builder.append(c);
                } else {
                    char k = key.charAt(keyIndex);
                    pos = getCharacterPosition(c);
                    int pos2 = getCharacterPosition(k);
                    int sum = (pos + pos2) % cipherTable.length;
                    builder.append(getCharacter(sum));
                    keyIndex = ++keyIndex % key.length();
                }
            }
            return builder.toString();
    }

    public static String decodeVige(String cipher, String key) {
        StringBuilder builder = new StringBuilder(cipher.length());
        int keyIndex = 0;
        for (int i = 0; i < cipher.length(); i++) {
            char c = cipher.charAt(i);
            int pos = (int) c;
            if (pos < lower || pos > upper) {
                builder.append(c);
            } else {
                char k = key.charAt(keyIndex);
                pos = getCharacterPosition(c);
                int pos2 = getCharacterPosition(k);
                int sum = pos - pos2;
                while (sum < 0) {
                    sum += cipherTable.length;
                }
                sum = sum % cipherTable.length;
                builder.append(getCharacter(sum));
                keyIndex = ++keyIndex % key.length();
            }
        }
        return builder.toString();
    }

    public static String encodeCaesar(String s, int Key) {
        char[] roll = s.toCharArray();
        for (int x = 0; x < Key; x++) {
			char temp = roll[roll.length - 1];
			int y;
			for (y = roll.length - 1; y > 0; y--){
				roll[y] = roll[y - 1];
            }
			roll[y] = temp;
		}
        return String.valueOf(roll);
    }
    public static String decodeCaesar(String s, int Key) {
        char[] roll = s.toCharArray();
        for(int i = 0; i < Key; i++){
            char temp1 = roll[0];
            int j;
            for(j = 0; j < roll.length-1; j++){
                roll[j]=roll[j+1];
            }
                roll[j]=temp1;
        }
        return String.valueOf(roll);
    }

    public static int getCharacterPosition(char c) {
        for (int i = 0; i < cipherTable.length; i++) {
            if (c == cipherTable[i]) {
                return i;
            }
        }

        return -1;
    }

    public static char getCharacter(int index) {
        if (index >= 0 && index < cipherTable.length) {
            return cipherTable[index];
        } else {
            return '?';
        }
    }
}