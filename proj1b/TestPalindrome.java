import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
	// You must use this palindrome, and not instantiate
	// new Palindromes, or the autograder might be upset.
	static Palindrome palindrome = new Palindrome();

	@Test
	public void testWordToDeque() {
		Deque d = palindrome.wordToDeque("persiflage");
		String actual = "";
		for (int i = 0; i < "persiflage".length(); i++) {
			actual += d.removeFirst();
		}
		assertEquals("persiflage", actual);
	}

	@Test
	public void testIsPalindrome() {
		assertFalse(palindrome.isPalindrome("aaaba"));
		assertFalse(palindrome.isPalindrome("persiflage"));
		assertFalse(palindrome.isPalindrome("Aa"));
		assertFalse(palindrome.isPalindrome("Abbba"));
		assertTrue(palindrome.isPalindrome("aba"));
		assertTrue(palindrome.isPalindrome("racecar"));
		assertTrue(palindrome.isPalindrome("s"));
		assertTrue(palindrome.isPalindrome("noon"));
		assertTrue(palindrome.isPalindrome(""));
	}

	@Test
	public void testIsPalindromeOffByOne() {
		CharacterComparator cc = new OffByOne();
		assertFalse(palindrome.isPalindrome("abc", cc));
		assertFalse(palindrome.isPalindrome("aa", cc));
		assertFalse(palindrome.isPalindrome("Aa", cc));
		assertFalse(palindrome.isPalindrome("Abbba", cc));
		assertTrue(palindrome.isPalindrome("rq", cc));
		assertTrue(palindrome.isPalindrome("flake", cc));
		assertTrue(palindrome.isPalindrome("s", cc));
		assertTrue(palindrome.isPalindrome("acb", cc));
		assertTrue(palindrome.isPalindrome("", cc));
	}
}
