class Deque {

    class Node{
        int val;
        Node prev, next;

        Node(int val){
            this.val = val;
        }
    }

    private Node head, tail;
    private int size;

    public Deque() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
       Node node = new Node(value);
       Node last = tail.prev;

       last.next = node;
       node.prev = last;
       node.next = tail;
       tail.prev = node;
       size++;
    }

    public void appendleft(int value) {
        Node node = new Node(value);
        Node first = head.next;

        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
        size++;
    }

    public int pop() {
        if(isEmpty()) return -1;

        Node last = tail.prev;
        int val = last.val;
        Node nextLast = last.prev;
        nextLast.next = tail;
        tail.prev = nextLast;
        size--;

        return val;
    }

    public int popleft() {
        if(isEmpty()) return -1;

        Node first = head.next;
        int val = first.val;
        Node nextFirst = first.next;
        head.next = nextFirst;
        nextFirst.prev = head;
        size--;

        return val;
    }
}