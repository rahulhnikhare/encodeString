package character_swapping;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestEncodeString {

	EncodeString encodeString = new EncodeString();

	@Test
	public void test_positive_offset_for_characters() {
		String stringToEncode = "AaBb";
		String encodedString = encodeString.encode(1, stringToEncode);

		assertTrue((stringToEncode.charAt(0) + 1) == encodedString.charAt(0));
		assertTrue((stringToEncode.charAt(1) + 1) == encodedString.charAt(1));
		assertTrue((stringToEncode.charAt(2) + 1) == encodedString.charAt(2));
		assertTrue((stringToEncode.charAt(3) + 1) == encodedString.charAt(3));

	}

	@Test
	public void test_Negative_Offset_For_Characters() {
		String stringToEncode = "BbCc";
		String encodedString = encodeString.encode(-1, stringToEncode);

		assertTrue((stringToEncode.charAt(0) - 1) == encodedString.charAt(0));
		assertTrue((stringToEncode.charAt(1) - 1) == encodedString.charAt(1));
		assertTrue((stringToEncode.charAt(2) - 1) == encodedString.charAt(2));
		assertTrue((stringToEncode.charAt(3) - 1) == encodedString.charAt(3));
	}

	@Test
	public void test_For_Special_Character_Should_Not_Be_Changed_For_Positive_Offset() {
		String specialCharacteString = "Bb_Cc";
		String encodedString = encodeString.encode(1, specialCharacteString);

		assertTrue((specialCharacteString.charAt(0) + 1) == encodedString.charAt(0));
		assertTrue((specialCharacteString.charAt(1) + 1) == encodedString.charAt(1));
		assertTrue((specialCharacteString.charAt(2)) == encodedString.charAt(2));
		assertFalse((specialCharacteString.charAt(2) + 1) == encodedString.charAt(2));
		assertTrue((specialCharacteString.charAt(3) + 1) == encodedString.charAt(3));
		assertTrue((specialCharacteString.charAt(4) + 1) == encodedString.charAt(4));

	}

	@Test
	public void test_For_Special_Character_Should_Not_Be_Changed_For_Negative_Offset() {
		String specialCharacteString = "Bb_Cc";
		String encodedString = encodeString.encode(-1, specialCharacteString);

		assertTrue((specialCharacteString.charAt(0) - 1) == encodedString.charAt(0));
		assertTrue((specialCharacteString.charAt(1) - 1) == encodedString.charAt(1));
		assertTrue((specialCharacteString.charAt(2)) == encodedString.charAt(2));
		assertTrue((specialCharacteString.charAt(3) - 1) == encodedString.charAt(3));
		assertTrue((specialCharacteString.charAt(4) - 1) == encodedString.charAt(4));
	}

	@Test
	public void test_for_Z_For_Positive_Offset_It_Should_Changed_To_A() {
		String stringContainZ = "zZ";
		String encodedString = encodeString.encode(1, stringContainZ);

		assertTrue((stringContainZ.charAt(0) - 25) == encodedString.charAt(0));
		assertTrue((stringContainZ.charAt(1) - 25) == encodedString.charAt(1));

	}

	@Test
	public void test_for_A_For_Negative_Offset_It_Should_Changed_To_A() {
		String stringContainA = "aA";
		String encodedString = encodeString.encode(-1, stringContainA);

		assertTrue((stringContainA.charAt(0) + 25) == encodedString.charAt(0));
		assertTrue((stringContainA.charAt(1) + 25) == encodedString.charAt(1));
	}

}
