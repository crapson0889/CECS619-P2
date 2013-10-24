/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author p0ros_000
 */
public class binaryTree {
    
    public Node root;
    public int count;
    
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
    
    public void binaryTree()
    {
        root = null;
    }
    
    public void insert( int data )
    {
        root = insert(root, data);
    }
    
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
    
    public boolean lookup(int data)
    {
        return(lookup(root, data));
    }
    
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
            return(lookup(node.leftChild, data));
        }
        else
        {
            return(lookup(node.rightChild, data));
        }
    }
    
    public void printTree()
    {
        printTree(root);
        System.out.println();
    }
    
    private void printTree(Node node)
    {
        if (node == null)
            return;
        
        printTree(node.leftChild);
        System.out.print(node.value + "  ");
        printTree(node.rightChild);
    }
}
