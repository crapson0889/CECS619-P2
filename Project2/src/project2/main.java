package project2;

import java.util.Scanner;

/**
 *
 * @author p0ros_000
 */
public class main {


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
        
        binTree.printTree();
//        digTree.printTree();
        
        
        Scanner searcher = new Scanner(System.in);
        while(1 == 1)
        {
            System.out.println("Enter a number to search for");
            int search = searcher.nextInt();
            boolean truth = binTree.lookup(search);
            boolean digTru = digTree.lookup(search);
            System.out.println("Is is " + truth + " that your value is in the table");
            if(truth)
            {
                System.out.println("It took " + binTree.count + " steps to find it in the binary tree!");
                System.out.println("It took " + digTree.count + " steps to find it in the digital tree!");
                
            }
        }
    }
     
    
}
