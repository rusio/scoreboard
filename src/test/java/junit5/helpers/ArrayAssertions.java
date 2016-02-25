package junit5.helpers;

import org.junit.gen5.api.Assertions;

public class ArrayAssertions {

	public static void assertArrayEquals(int[] expectedArray, int[] actualArray) {
		Assertions.assertEquals(expectedArray.length, actualArray.length, "length");
		for (int i = 0; i < expectedArray.length; i++) {
			Assertions.assertEquals(expectedArray[i], actualArray[i], "element at index " + i);
		}
	}

}
