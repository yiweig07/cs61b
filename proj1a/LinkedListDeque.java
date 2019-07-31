
public class LinkedListDeque<T> {
	private ListNode sentinel;
	private int size;

	private class ListNode {
		public T value;
		public ListNode next;
		public ListNode pre;

		public ListNode(T item, ListNode rest, ListNode prev) {
			value = item;
			next = rest;
			pre = prev;
		}

		public ListNode() {
			next = this;
			pre = this;
		}
	}

	/**
	 * public LinkedListDeque(T value) { sentinel = new ListNode(); sentinel.next =
	 * new ListNode(value, sentinel, sentinel); sentinel.pre = sentinel.next; size =
	 * 1; }
	 */

	public LinkedListDeque() {
		sentinel = new ListNode();
		sentinel.next = sentinel;
		sentinel.pre = sentinel;
		size = 0;
	}

	public void addFirst(T item) {
		sentinel.next = new ListNode(item, sentinel.next, sentinel.next.pre);
		size += 1;
	}

	public void addLast(T item) {
		sentinel.pre = new ListNode(item, sentinel, sentinel.pre);
		size += 1;
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
		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i));
		}
	}

	public T removeFirst() {
		if (size == 0) {
			return null;
		}
		size -= 1;
		T first = sentinel.next.value;
		sentinel.next = sentinel.next.next;
		sentinel.next.pre = sentinel;
		return first;
	}

	public T removeLast() {
		if (size == 0) {
			return null;
		}
		size -= 1;
		T last = sentinel.pre.value;
		sentinel.pre = sentinel.pre.pre;
		sentinel.pre.next = sentinel;
		return last;
	}

	public T get(int index) {
		if (size == 0) {
			return null;
		}
		ListNode p = sentinel;
		for (int i = 0; i <= index; i++) {
			p = p.next;
		}
		return p.value;
	}

	public T getRecursive(int index) {
		if (size == 0) {
			return null;
		}
		T t = getnode(index).value;
		return t;
	}

	private ListNode getnode(int index) {
		if (index == 0) {
			return sentinel.next;
		}
		return getnode(index - 1).next;
	}

}
