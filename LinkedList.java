public class LinkedList implements List{

	private Node head;
	private Node tail;
	private int size;

	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	public int size(){
		return size;
	}


	public class Node {

		private Object data;
		private Node next;

		public Node(Object data, Node nextObj) {
			this.data = data;
			this.next = nextObj;
		}
		public Node(Object data){
			this.data = data;
			this.next = null;
		}

		public Node(){
			this.next = null;
			this.data = 0;
		}
		
		public Node getNext(Node next){
			return this.next;
		}
		public void setNext(Node next){
			this.next = next;
		}
		public void data(Object data){
			this.data = data;
		}


	}

	public void add(Object data) {

		if(head == null){
			head = tail = new Node(data);
		}
		else{
			tail.next = new Node(data);
			tail = tail.next;
		}
		size++;


	}

	public void add(int pos, Object data) throws Exception{
		if(pos < 0 || pos >=size)
			throw new  ArrayIndexOutOfBoundsException(pos);
		Node current = head;
		if(head == null){
			head = tail = new Node(data);
		}
		if(pos == 0){
            head = new Node(data, head);
            tail = head;
            size++;
            return;
        }
		for(int i = 0; i < pos && current.next !=null; i++){
			current = current.next;
		}
		current.next = new Node(data, current.next);
		size++;
	}

	public Object remove(int pos) throws Exception{
		if(pos < 0 || pos >=size){
			throw new  ArrayIndexOutOfBoundsException(pos);
		}
		if(size==0){
			return null;
		}
		 if(pos == 0){
            Node node = head;
            head = head.next;
            size--;
            return node.data;
        }

		Node tmp = head;
		for(int i = 0; i < pos-1; i++){
			tmp = tmp.next;
			
		}
		Node rem = tmp.next;
		tmp.next = tmp.next.next;
		size--;
		return rem.data;
	}

	public Object get(int pos) throws Exception{
		if(pos < 0 || pos >= size) {
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		Node current = head;
		for(int i = 0; i < pos ; i++) {
			current = current.next;
		}
		return current.data;


	}

}