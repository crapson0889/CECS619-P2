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
            System.out.println(count + " objects now in trees");
            
        }    
        
        int expCount = 0;
        while(expCount < 5)
        {
            int expNum = 100 + (200 * expCount);
            float[] binResults = BinExperiment(expNum, binTree);
            float[] digResults = DigExperiment(expNum, digTree);
            System.out.println(expNum + " Keys");
            System.out.println("--------");
            System.out.println("Binary Tree Results: ");
            System.out.println("Minimum = " + binResults[0] + " Maximum = " + binResults[1] + " Average = " + binResults[2]);
            System.out.println("Digital Tree Results: ");
            System.out.println("Minimum = " + digResults[0] + " Maximum = " + digResults[1] + " Average = " + digResults[2]);
            System.out.println("");
            expCount++;
        }
        
        
  
                
    }
     
    public static float[] BinExperiment(int numKeys, binaryTree tree)
    {
        List<Integer> counts = new ArrayList<>();
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
                //System.out.println(i);
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
