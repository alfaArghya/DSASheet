import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
/*-------- calling functions --------*/
    Node root;
    public BinaryTree(int[] data) {
        root = buildTree(data);
    }
    public void preOrderTraversal() {
        System.out.print("Pre-Order Traversal >> ");
        preOrderTraversal(root);
        System.out.println();
    }
    public void inOrderTraversal() {
        System.out.print("In-Order Traversal >> ");
        inOrderTraversal(root);
        System.out.println();
    }
    public void postOrderTraversal() {
        System.out.print("Post-Order Traversal >> ");
        postOrderTraversal(root);
        System.out.println();
    }
    public void levelOrderTraversal() {
        System.out.println("Level-Order Traversal >> ");
        levelOrderTraversal(root);
        System.out.println();
    }
    public void heightOfTree() {
        System.out.println("Height of the tree >> "+height(root));
    }
    public void countNodes() {
        System.out.println("Number of Nodes in the tree >> "+countNodes(root));
    }
    public void diameterOfTree() {
        System.out.println("Diameter of the tree >> "+diameter(root).diameter);
    }
        /*-------- --------*/

/*------------ Working Functions ------------*/
        /*---- Build Binary Tree ----*/
    static int idx = -1;
    private Node buildTree(int[] data) {    //TC -> O(n)
        idx++;

            //base case --> no node avaible for left or right side
        if(data[idx] == -1) {
            return null;
        }

            //root of current tree
        Node root = new Node(data[idx]);
            //connecting nodes
        root.left = buildTree(data);//store new node in left side until null comes
        root.right = buildTree(data);//store new node in right side until null comes

        return root;    //return root node
    }
                /*---- ----*/
        /*---- Pre-order Traversal ----*/
    private void preOrderTraversal(Node root) {  //TC -> O(n)
            //base case --> root node reaches leaf node
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);    //left side of current root
        preOrderTraversal(root.right);   //right side of current root
    }
                /*---- ----*/
        /*---- In-order Traversal ----*/
    private void inOrderTraversal(Node root) {   //TC -> O(n)
            //base case -> root node reaches leaf node
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left); //left side of current root node
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);    //right side of current root node
    }
                /*---- ----*/
        /*---- Post-order Traversal ----*/
    private void  postOrderTraversal(Node root) {    //TC ->O(n)
            //base case -> root node reaches leaf node
        if(root == null) {
            return;
        }

        postOrderTraversal(root.left);   //left side of current root node
        postOrderTraversal(root.right);  //right side of current root node
        System.out.print(root.data+" ");
    }
                /*---- ----*/
        /*---- Level-Order Traversal ----*/
    private void levelOrderTraversal(Node root) {
            //binary tree is empty
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);//root node
        q.add(null); //here null refers to next line

        while(!q.isEmpty()) {
            Node currentNode = q.remove();

            if(currentNode == null) {   //new level
                System.out.println(); //adding a level
                if(q.isEmpty()) {   //when queue is empty stop the loop
                    break;
                } else {
                    q.add(null);
                }
            } else {    //print value
                System.out.print(currentNode.data+" ");

                if(currentNode.left != null) {//if node's left side is not empty add left side value to queue
                    q.add(currentNode.left);
                }
                if(currentNode.right != null) {//if node's right side is not empty add right side value to queue
                    q.add(currentNode.right);
                }
            }
        }

    }
                /*---- ----*/
        /*---- height of tree ----*/
    private int height(Node root) {
            //base case --> current root node is null
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left); //left sub-tree height
        int rightHeight = height(root.right);   //right sub-tree height

        return Math.max(leftHeight,rightHeight)+1;

    }
                /*---- ----*/
        /*---- count nodes in tree ----*/
    private int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSide = countNodes(root.left);   //left-subtree node count
        int rightSide = countNodes(root.right); //right-subtree node count

        return leftSide+rightSide+1;    //left-Side-Nodes + right-Side-Nodes + current-root-node
    }
                /*---- ----*/
        /*---- Diameter of Binary tree ----*/
    private static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    private Info diameter(Node root) {
            //base case
        if(root == null) {
            return new Info(0,0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(leftInfo.height + rightInfo.height + 1, Math.max(leftInfo.diameter,rightInfo.diameter));
        int ht = Math.max(leftInfo.height, rightInfo.height)+1;

        return new Info(diam, ht);
    }
                /*---- ----*/
        /*----------- -----------*/
}

public class Implement_BinaryTrees {
    public static void main(String[] args) {
        int[] data = {1,2,4,7,-1,-1,-1,5,-1,8,11,-1,-1,-1,3,-1,6,9,-1,12,-1,-1,10,-1,-1};
/*
             1
           /   \
          2     3
         / \     \
        4   5     6
       /     \   / \ 
      7       8 9   10
             /   \
            11    12
 */

        BinaryTree bt = new BinaryTree(data);
        System.out.println("root ---> "+bt.root.data);
        bt.preOrderTraversal();
        bt.inOrderTraversal();
        bt.postOrderTraversal();
        bt.levelOrderTraversal();
        bt.heightOfTree();
        bt.countNodes();
        bt.diameterOfTree();
    }
}
