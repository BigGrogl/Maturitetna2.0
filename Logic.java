public class Logic{
    public static int lower = 32;
    public static int upper = 126;
    public static char[] cipherTable = cipherAlpha();

    public static void main(String[] args){
        
    }

    public static char[] cipherAlpha(){
        char[] alpha = new char[(upper-lower)+1];
        for (int i = lower; i <= upper; i++) {
            alpha[i - lower] = (char) i;
        }
        return alpha;
    }

    public static String encode(String input, String key){
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

    public static String decode(String cipher, String key) {
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