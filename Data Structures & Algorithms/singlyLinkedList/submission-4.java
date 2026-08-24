class LinkedList {

    class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        Node curr = head;

        for(int i = 0; i < index; i++){
            if(curr == null) return -1;
            curr = curr.next;
        }
        return curr == null ? -1 : curr.val;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean remove(int index) {
        if(head == null) return false;

        if(index == 0){
            head = head.next;

            if(head == null) tail = null;
            return true;
        }

        Node curr = head;

        for(int i = 0; i < index - 1; i++){
            if(curr.next == null) return false;
            curr = curr.next;
        }

        if(curr.next == null) return false;
        if(curr.next == tail) tail = curr;

        curr.next = curr.next.next;
        
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();

        Node curr = head;

        while(curr != null){
            values.add(curr.val);
            curr = curr.next;
        }
        return values;
    }
}