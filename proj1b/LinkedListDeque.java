


public class LinkedListDeque<T> implements Deque<T>{
	private ListNode sentinel;
	private int size;

	private class ListNode {
		public T value;
		public ListNode next;
		public ListNode pre;

		public ListNode(T item, ListNode rest, ListNode prev) {
			this.value = item;
			this.next = rest;
			this.pre = prev;
		}

		public ListNode() {
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
@Override
	public void addFirst(T item) {
		ListNode first = new ListNode(item, sentinel.next, sentinel);
		sentinel.next.pre = first;
		sentinel.next = first;
		size += 1;
	}

@Override
	public void addLast(T item) {
		ListNode last = new ListNode(item, sentinel, sentinel.pre);
		sentinel.pre.next = last;
		sentinel.pre = last;
		size += 1;
	}

@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

@Override
	public int size() {
		return size;
	}

@Override
	public void printDeque() {
		for (int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i));
		}
	}
@Override
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
@Override
	public T removeLast() {
		if (size == 0) {
			return null;
		}
		size -= 1;
		ListNode last = sentinel.pre;
		sentinel.pre = sentinel.pre.pre;
		sentinel.pre.next = sentinel;
		return last.value;
	}
@Override
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
