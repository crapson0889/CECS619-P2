
package project2;

/**
 *
 * @author p0rose02
 */
public class digitalTree extends binaryTree{
    
    
    @Override
    public void insert( int data )
    {
        String dataStr = Integer.toBinaryString(data);
        root = insert(root, dataStr, 0);
    }
    
    private Node insert(Node node, String data, int bit)
    {
        
        if(bit == data.length())
        {
            node = new Node(Integer.parseInt(data, 2));
        }
        else 
        {
            if(node == null)
            {
                root = new Node(0);
                node = root;
            }
            
            if(data.charAt(bit) == '0')
            {
                if(node.leftChild == null)
                {
                    node.leftChild = new Node(0);
                }
                
                node.leftChild = insert(node.leftChild, data, bit + 1);
            }
            
            else
            {
                if(node.rightChild == null)
                {
                    node.rightChild = new Node(1);
                }
                
                node.rightChild = insert(node.rightChild, data, bit + 1);
            }
        
        }
        
        return node;
    }
    
    public void digitalTree()
    {
        root = null;
    }
    
    @Override
    public boolean lookup(int data)
    {
        count = 0;
        String dataStr = Integer.toBinaryString(data);
        return(lookup(root, dataStr, 0));
    }
    
    private boolean lookup(Node node, String data, int bit)
    {
        if(node == null)
        {
            return false;
        }
        
        if(Integer.parseInt(data, 2) == node.value)
        {
            return true;
        }
        
        else if(data.charAt(bit) == '0')
        {
            count++;
            return(lookup(node.leftChild, data, bit + 1));
        }
        
        else
        {
            count++;
            return(lookup(node.rightChild, data, bit + 1));
        }
    }
}
