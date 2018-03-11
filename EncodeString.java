package character_swapping;


public class EncodeString {

	private static char SMALL_Z = 'z';
	private static char CAPITAL_Z = 'Z';
	private static char SMALL_A = 'a';
	private static char CAPITAL_A = 'A';
	private static int ASCII_SMALL_A = 97;
	private static int ASCII_CAPITAL_A = 65;
	private static int ASCII_SMALL_Z = 122;
	private static int ASCII_CAPITAL_Z = 90;
	private static int OFFSET_PLUS_ONE = 1;
	private static int OFFSET_MINUS_ONE = -1;

	public static void main(String[] args) {
		String sampleResult = new EncodeString().encode(-1, "RaHul  Zz Aa!!!");
		System.out.println("Final::" + sampleResult);
	}

	// Method to get Next Character
	private char getNextCharacter(char character) {
		if (character == SMALL_Z || character == CAPITAL_Z) {
			return getCharacterForZ(character);
		}
		return (char) (character + 1);
	}
	
	// Method to get Previous Character
	private char getPreviousCharacter(char character) {
		if (character == SMALL_A || character == CAPITAL_A) {
			return getCharacterForA(character);
		}
		return (char) (character - 1);

	}

	//Method to get Character for z/Z only
	private char getCharacterForZ(char character) {
		return (char) (character - 25);
	}

	//Method to get Character for a/A only
	private char getCharacterForA(char character) {
		return (char) (character + 25);
	}

	public String encode(int offset, String stringToEncode) {
		char[] array = stringToEncode.toCharArray();

		for (int i = 0; i < stringToEncode.length(); i++) {
			if (isCharacter((int) array[i])) {
				if (offset == OFFSET_PLUS_ONE) {
					array[i] = getNextCharacter(array[i]);
				}

				if (offset == OFFSET_MINUS_ONE) {
					array[i] = getPreviousCharacter(array[i]);
				}
			}
		}
		return String.valueOf(array);
	}

	//Method to check characters only
	private boolean isCharacter(int characterASCII) {
		if ((characterASCII >= ASCII_SMALL_A && characterASCII <= ASCII_SMALL_Z)
				|| (characterASCII >= ASCII_CAPITAL_A && characterASCII <= ASCII_CAPITAL_Z)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
