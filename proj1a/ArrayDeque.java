

public class ArrayDeque<T> {
	int size;
	int nextFirst;
	int nextLast;
	T[] array;

	public ArrayDeque() {
		size = 0;
		array = (T[]) new Object[8];
		nextFirst = 3;
		nextLast = 4;
	}

	public void addFirst(T item) {
		if (this.size == array.length) {
			resizeArray();
		}
		size += 1;
		array[nextFirst] = item;
		minusOne(nextFirst);
	}
	
	public void resizeArray() {
		T[] array1 = (T[]) new Object[(int) (size * 1.5)];
		addOne(nextFirst);
		for(int i = 0; i < size; i ++) {
			array1[i] = array[nextFirst];
			addOne(nextFirst);
		}
		array = array1;
		nextFirst = array.length -1;
		nextLast = size;
	}

	public int minusOne(int index) {
		if (index == 0) {
			return index = array.length - 1;
		} else {
			return index -= 1;
		}
	}

	public int addOne(int index) {
		if (index == array.length - 1) {
			return index = 0;
		} else {
			return index += 1;
		}
	}

	public void addLast(T item) {
		if (this.size == array.length) {
			resizeArray();
		}
		size += 1;
		array[nextLast] = item;
		addOne(nextLast);
	}

	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i));
		}
	}

	public T removeFirst() {
		if (this.size() == 0) {
			return null;
		}
		size -= 1;
		addOne(nextFirst);
		T first = array[nextFirst];
		array[nextFirst] = null;
		if (size <= (int)array.length/4) {
			desizeArray();
		}
		return first;
	}

	public T removeLast() {
		if (this.size() == 0) {
			return null;
		}
		size -= 1;
		minusOne(nextLast);
		T last = array[nextLast];
		array[nextLast] = null;
		if (size <= (int)array.length / 4) {
			desizeArray();
		}
		return last;
	}
	
	public void desizeArray() {
		T[] array1 = (T[]) new Object[(int) (array.length/ 2)];
		addOne(nextFirst);
		for(int i = 0; i < size; i ++) {
			array1[i] = array[nextFirst];
			addOne(nextFirst);
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
			addOne(i);
		}
		return array[i];
	}

}
