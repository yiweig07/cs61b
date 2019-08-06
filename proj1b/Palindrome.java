

public class Palindrome {
	
	public Deque<Character> wordToDeque(String word){
		Deque<Character> d = new LinkedListDeque<>();
		for (int i = 0; i< word.length(); i++) {
			d.addLast(word.charAt(i));
		}
		return d;
	}
	
	public boolean isPalindrome(String word) {
		if (word.length() == 0 || word.length() == 1) {
			return true;
		}
		Palindrome palindrome = new Palindrome();
		Deque<Character> d = palindrome.wordToDeque(word);
		return isPalindromeHelper(d);
	}
	
	private boolean isPalindromeHelper(Deque<Character> deque) {
		if(deque.size() == 0 || deque.size() == 1) {
			return true;
		}
		if (deque.removeFirst().equals(deque.removeLast())){
			return isPalindromeHelper(deque);
		}
		return false;
	}
	public boolean isPalindrome(String word, CharacterComparator cc) {
		if (word.length() == 0 || word.length() == 1) {
			return true;
		}
		Palindrome palindrome = new Palindrome();
		Deque<Character> d = palindrome.wordToDeque(word);
	return isPalindromeHelper(d, cc);
	}
	
	private boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
		if(deque.size() == 0 || deque.size() == 1) {
			return true;
		}
		if (cc.equalChars(deque.removeFirst(), deque.removeLast())){
			return isPalindromeHelper(deque, cc);
		}
		return false;
	}

	



}
