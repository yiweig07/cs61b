public class OffByN implements CharacterComparator {
	private int k;

	public OffByN(int N) {
		k = N;
	}

	@Override
	public boolean equalChars(char x, char y) {
		return equalChars(x, y, k);
	}

	private boolean equalChars(char x, char y, int N) {
		if (Math.abs(x - y) == N) {
			return true;
		}
		return false;
	}

}
