public class Rotor{
    public static void main(String[] args){

    }

    public static char[] rotator(int pos){
        char[] rotor = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','v','z'};
        for (int x = 0; x < pos; x++) {
			char temp2 = rotor[rotor.length-1];
			int y;
			for (y = rotor.length - 1; y > 0; y--){
				rotor[y] = rotor[y - 1];
            }
			rotor[y] = temp2;
		}
        return rotor;
    }

}