class AVLTree {

    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    private Node root;

    // Utility function to get height of the node
    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Utility function to get max of two integers
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Right rotate subtree rooted with y
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get balance factor of node N
    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        // 1. Perform normal BST insertion
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        // 2. Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Get the balance factor to check whether
        // this node became unbalanced
        int balance = getBalance(node);

        // If unbalanced, then 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // A utility function to print preorder traversal of the tree.
    // The function also prints height of every node
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // You can add more functions like search, delete etc. if you want.
    
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder();
    }
}