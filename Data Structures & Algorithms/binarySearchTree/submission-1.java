class TreeMap {

    private class Node {
        int key, val;
        Node left, right;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        root = insert(root, key, val);
    }

    private Node insert(Node node, int key, int val) {
        if (node == null) {
            return new Node(key, val);
        }
        if (key < node.key) {
            node.left = insert(node.left, key, val);
        } else if (key > node.key) {
            node.right = insert(node.right, key, val);
        } else {
            node.val = val;
        }
        return node;
    }

    public int get(int key) {
        Node node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node.val;
            }
        }
        return -1;
    }

    public int getMin() {
        if (root == null) return -1;
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public int getMax() {
        if (root == null) return -1;
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    private Node remove(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            node.key = successor.key;
            node.val = successor.val;
            node.right = remove(node.right, successor.key);
        }
        return node;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(Node node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.key);
        inorder(node.right, result);
    }
}