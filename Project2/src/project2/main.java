/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author p0ros_000
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        binaryTree binTree = new binaryTree();
        digitalTree digTree = new digitalTree();
        int count = 0;
        int random = 0;
        while(count < 10000)
        {
            while(random == 0 || binTree.lookup(random))
            {
                random = (int)(Math.random() * 65536 + 1);
            }
            
            binTree.insert(random);
            digTree.insert(random);
            count++;
            System.out.println(count + " objects now in tree");
            
        }
                
        //binTree.printTree();
        digTree.printTree();
    }
     
    
}
