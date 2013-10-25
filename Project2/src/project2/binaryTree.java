
package project2;

/**
 *
 * @author p0ros_000
 */
public class binaryTree {
    
    public Node root;
    public int count;
    
    //Custom node class to hold a value, as well as the left/right child
    public static class Node 
    {
        Node leftChild;
        Node rightChild;
        int value; 
        
        Node(int newValue)
        {
            leftChild = null;
            rightChild = null;
            value = newValue;
        }
    }
    
    //Initialization of a new tree
    public void binaryTree()
    {
        root = null;
    }
    
    //Public function to begin recursive insertion algorithm
    public void insert( int data )
    {
        root = insert(root, data);
    }
    
    //Private recursive insertion Algorithm
    private Node insert(Node node, int data)
    {
        if(node == null)
        {
            node = new Node(data);
        }
        
        else{
            if (data <= node.value)
            {
                node.leftChild = insert(node.leftChild, data);
            }
            else
            {
                node.rightChild = insert(node.rightChild, data);
            }              
        }       
        return node;
    }
    
    //Public function to begin Recursive Lookup algorithm
    public boolean lookup(int data)
    {
        count = 0;
        return(lookup(root, data));
    }
    
    //Private recursive Lookup Algorithm
    private boolean lookup(Node node, int data)
    {
        if(node == null)
        {
            return false;
        }
        
        if(data == node.value)
        {
            return true;
        }
        
        else if (data < node.value)
        {
            count++;
            return(lookup(node.leftChild, data));
        }
        else
        {
            count++;
            return(lookup(node.rightChild, data));
        }
    }
    
    //Public function to print all values in a tree
    public void printTree()
    {
        printTree(root);
        System.out.println();
    }
    
    //Private recursive function to print all tree values
    private void printTree(Node node)
    {
        if (node == null)
            return;
        
        printTree(node.leftChild);
        System.out.print(node.value + "  ");
        printTree(node.rightChild);
    }
}
