package lists;


public class SinglyLinkedListInt {

	
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	public SinglyLinkedListInt( ) { }
	
	public int size( ) { 
		return size; 
	}
	
	public boolean isEmpty( ) { 
		return size == 0; 
	}
	
	public int first( ) {
		if (isEmpty( )) return 0;
		return head.getElement( );

	}
	
	
	public int last( ) {
		if (isEmpty( )) return 0;
		return tail.getElement( );

	}

	public void addFirst(int e) {
		head = new Node(e, head);
		if (size == 0)
			tail = head;
		size++;
	}
	
	public void addLast(int e) {
		Node newest = new Node(e, null); 
		if (isEmpty( ))
		head = newest;
		else
		tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	public int removeFirst( ) {
		if (isEmpty( )) return 0;
		int answer = head.getElement( );
		head = head.getNext( );
		size--;
		if (size == 0)
			tail = null;
		return answer;
	}
	
	public void sort(){
		int indexOfI = 1;
		//int indexOfJ = 0;
		Node i = head.next;
		Node prevI = head;
		while(i != null){
			Node j = head;
			int indexOfJ = 0;
			Node currentI = i;
			Node nextI = i.next;
			if(j.getElement() > i.getElement()){
				prevI.next = i.next;
				i.next = j;
				head = i;
				currentI = j;
			}
			else{
				Node prevJ = j;
				while(indexOfJ < indexOfI && j.next!=null){
					Node currentJ = j;
					Node nextJ = j.next;
					
					if(j.getElement() > i.getElement()){
						prevI.next = i.next;
						i.next = j;
						prevJ.next = i;
						currentI = j;
						currentJ = i;
						break;
						//travarse();
					}
					prevJ = currentJ;
					j = nextJ;
					indexOfJ++;
				}
			}
			prevI = currentI;
			i = nextI;
			indexOfI++;
		}
	}
	
	
	public void insertBefore(int data, int index){
		
		if(index == 0){
			this.addFirst(data);
		}
		else{
			int count = 0;
			Node nn = new Node(data, null);
			Node temp = this.head;
			while(count != index-1){
				temp = temp.next;
				count++;
			}
			nn.next = temp.next;
			temp.next = nn;
		}
	}

	public void insertBetween(int data, Node prevNode, Node nextNode){
		
	}
	
	public void insertionSort(){
		SinglyLinkedListInt sortedList = new SinglyLinkedListInt();
		sortedList.addLast(this.removeFirst());
		
		while(!this.isEmpty()){
			int flag = 0;
			int index = 0;
			int data = this.removeFirst();
			Node currentNodeFromSortedList = sortedList.head;
			while(currentNodeFromSortedList != null){
				if(data < currentNodeFromSortedList.getElement()){
					sortedList.insertBefore(data,index);
					flag = 1;
					break;
				}
				currentNodeFromSortedList = currentNodeFromSortedList.next;
				index++;
			}
			
			if(flag == 0){
				sortedList.addLast(data);
			}
			
		}
		
		this.head = sortedList.head;
	}
	
	
	public void travarse(){
		Node current = head;
		while(current!=null){
			System.out.print(current.getElement()+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	
	
	private class Node {

		private int element;
		private Node next;

		public Node(int e, Node n) {
			element = e;
			next = n;
		}
		
		public int getElement( ) { return element; }
		public Node getNext( ) { return next; }
		public void setNext(Node n) { next = n; }
	}
}
