import java.util.Random;

class BinarySearchTree
{
    class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    Node root;

    // konstruktor
    BinarySearchTree()
    {
        root = null;
    }

    int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    int getLevelUtil(Node node, int data, int level)
    {
        if (node == null)
            return 0;

        if (node.key == data)
            return level;

        int downlevel = getLevelUtil(node.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getLevelUtil(node.right, data, level + 1);
        return downlevel;
    }

    int getLevel(Node node, int data)
    {
        return getLevelUtil(node, data, 1);
    }

    void deleteKey(int key)
    {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key)
    {
        if (root == null)  return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
                root.right = deleteRec(root.right, key);
            else
            {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
            }

        return root;
    }

    void insert(int key)
    {
        root = insertRec(root, key);
        int level = 0;
    }

    Node insertRec(Node root, int key)
    {

        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder()
    {
        inorderRec(root);
    }

    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public static void main(String[] args)
    {
        int high = 0;
        BinarySearchTree tree = new BinarySearchTree(); 
  

        Random generator = new Random();

        int x=10000;
       for(int j=0; j<100; j++) {
            for (int i = 0; i < x; i++) {
                tree.insert(generator.nextInt());
            }
            System.out.println("Liczba elementow: "+x);
            System.out.println("Wysokosc: " +
                    tree.maxDepth(tree.root));
            System.out.println(" ");


            x=10000+x;
        }



        /*
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(55);
        tree.insert(80);
        */

     //   System.out.println("Inorder ");
     //   tree.inorder();

     //   System.out.println("Wysokosc : " +
      //          tree.maxDepth(tree.root));


        /*
        System.out.println("\nDelete 55");
        tree.deleteKey(50);
        System.out.println("Inorder po usunieciu 55");
        tree.inorder();
        */

        /*
        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder po usunieciu 20");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder po usunieciu 30");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder po usunieciu 50");
        tree.inorder();
        */
    }
} 