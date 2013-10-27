package project2;

import java.util.ArrayList;
import java.util.List;
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
        
//        binTree.printTree();
//        digTree.printTree();
        
        
//        Scanner searcher = new Scanner(System.in);
//        while(1 == 1)
//        {
//            System.out.println("Enter a number to search for");
//            int search = searcher.nextInt();
//            boolean truth = binTree.lookup(search);
//            boolean digTru = digTree.lookup(search);
//            System.out.println("Is is " + digTru + " that your value is in the table");
//            if(digTru)
//            {
//                System.out.println("It took " + binTree.count + " steps to find it in the binary tree!");
//                System.out.println("It took " + digTree.count + " steps to find it in the digital tree!");
//                
//            }
//        }
        
//        float[] hundred = BinExperiment(900, binTree);
//        System.out.println("Min is " + hundred[0]);
//        System.out.println("Max is " + hundred[1]);
//        System.out.println("Average is " + hundred [2]);
//        System.out.println(hundred[3] + " numbers successfully found!");
        try
        {
        float[] dighund = DigExperiment(900, digTree);
        
        System.out.println("Min is " + dighund[0]);
        System.out.println("Max is " + dighund[1]);
        System.out.println("Average is " + dighund[2]);
        System.out.println(dighund[3] + " numbers successfully found!");
        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.out.println(e);
            
        }
        
        
    }
     
    public static float[] BinExperiment(int numKeys, binaryTree tree)
    {
        List<Integer> counts = new ArrayList<Integer>();
        float[] result = new float[4];
        int min = 0;
        int max = 0;
        int total = 0;
        
        
        int i = 0;
        while(i < numKeys)
        {
            int random = (int)(Math.random() * 65536 + 1);
            if(tree.lookup(random))
            {
                counts.add(tree.count);
                i++;
            }
        }
        
        for(int j = 0; j < counts.size(); j++)
        {
            if(j == 0)
            {
                min = counts.get(j);
                max = counts.get(j);
            }
            
            if(counts.get(j) < min)
            {
                min = counts.get(j);
            }
            
            if(counts.get(j) > max)
            {
                max = counts.get(j);
            }
            
            total = total + counts.get(j);
        }
        
        result[0] = min;
        result[1] = max;
        result[2] = total/counts.size();
        result[3] = counts.size();
        
        return result;
    }
    
    public static float[] DigExperiment(int numKeys, digitalTree tree) throws StringIndexOutOfBoundsException
    {
        List<Integer> counts = new ArrayList<Integer>();
        float[] result = new float[4];
        int min = 0;
        int max = 0;
        int total = 0;
        
        
        int i = 0;
        while(i < numKeys)
        {
            int random = (int)(Math.random() * 65536 + 1);
            if(tree.lookup(random))
            {
                counts.add(tree.count);
                i++;
                System.out.println(i);
            }
        }
        
        for(int j = 0; j < counts.size(); j++)
        {
            if(j == 0)
            {
                min = counts.get(j);
                max = counts.get(j);
            }
            
            if(counts.get(j) < min)
            {
                min = counts.get(j);
            }
            
            if(counts.get(j) > max)
            {
                max = counts.get(j);
            }
            
            total = total + counts.get(j);
        }
        
        result[0] = min;
        result[1] = max;
        result[2] = total/counts.size();
        result[3] = counts.size();
        
        return result;
    }
}
