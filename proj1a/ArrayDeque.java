

public class ArrayDeque<T> {
	private int size;
	private int nextFirst;
	private int nextLast;
	private T[] array;

	public ArrayDeque() {
		size = 0;
		array = (T[]) new Object[8];
		nextFirst = 3;
		nextLast = 4;
	}

	public void addFirst(T item) {
		if (size == array.length) {
			resizeArray();
		}
		size += 1;
		array[nextFirst] = item;
		nextFirst = minusOne(nextFirst);
	}
	
	private void resizeArray() {
		T[] array1 = (T[]) new Object[(int) (size * 1.5)];
		nextFirst = addOne(nextFirst);
		for(int i = 0; i < size; i ++) {
			array1[i] = array[nextFirst];
			nextFirst = addOne(nextFirst);
		}
		array = array1;
		nextFirst = array.length -1;
		nextLast = size;
	}

	private int minusOne(int index) {
		if (index == 0) {
			return index = array.length - 1;
		} else {
			return index -= 1;
		}
	}

	private int addOne(int index) {
		if (index == array.length - 1) {
			return index = 0;
		} else {
			return index += 1;
		}
	}

	public void addLast(T item) {
		if (size == array.length) {
			resizeArray();
		}
		size += 1;
		array[nextLast] = item;
		nextLast = addOne(nextLast);
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		for (int i = 0; i < size; i++) {
			System.out.println(this.get(i));
		}
	}

	public T removeFirst() {
		if (size == 0) {
			return null;
		}
		size -= 1;
		nextFirst = addOne(nextFirst);
		T first = array[nextFirst];
		array[nextFirst] = null;
		if (size <= (int)array.length/4) {
			desizeArray();
		}
		return first;
	}

	public T removeLast() {
		if (size == 0) {
			return null;
		}
		size -= 1;
		nextLast = minusOne(nextLast);
		T last = array[nextLast];
		array[nextLast] = null;
		if (size <= (int)array.length / 4) {
			desizeArray();
		}
		return last;
	}
	
	private void desizeArray() {
		T[] array1 = (T[]) new Object[(int) (array.length/ 2)];
		nextFirst = addOne(nextFirst);
		for(int i = 0; i < size; i ++) {
			array1[i] = array[nextFirst];
			nextFirst = addOne(nextFirst);
		}
		array = array1;
		nextFirst = array.length -1;
		nextLast = size;
	}

	public T get(int index) {
		if (this.size() == 0) {
			return null;
		}
		int i = nextFirst;
		for(int k = 0; k <= index; k++) {
			i = addOne(i);
		}
		return array[i];
	}

}
