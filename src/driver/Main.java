package driver;

import lists.SinglyLinkedListInt;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedListInt list = new SinglyLinkedListInt();
		list.addLast(1);
		list.addLast(4);
		list.addLast(5);
		list.addLast(3);
		list.addLast(2);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		
		list.travarse();
		list.insertionSort();
		list.travarse();
	}

}
