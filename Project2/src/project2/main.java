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
        digitalTree modTree = new digitalTree();
        int count = 0;
        int random = 0;
        
        while(count < 10000)
        {
            while(random == 0 || binTree.lookup(random))
            {
                random = (int)(Math.random() * 65536 + 1);
            }
            String temp = Integer.toBinaryString(random);
            temp = temp.substring(1, temp.length());
            
            binTree.insert(random);
            digTree.insert(random);
            modTree.insert(Integer.parseInt(temp, 2));
            count++;
            //System.out.println(count + " objects now in trees");
            
        }    
        
        int expCount = 0;
        while(expCount < 5)
        {
            int expNum = 100 + (200 * expCount);
//            float[] binResults = BinExperiment(expNum, binTree);
//            float[] digResults = DigExperiment(expNum, digTree);
            
            float[] results = experiment(expNum, binTree, digTree, modTree);
            
            System.out.println(expNum + " Keys");
            System.out.println("--------");
            System.out.println("Binary Tree Results: ");
            System.out.println("Minimum = " + results[0] + " Maximum = " + results[1] + " Average = " + results[2]);
            System.out.println("Digital Tree Results: ");
            System.out.println("Minimum = " + results[3] + " Maximum = " + results[4] + " Average = " + results[5]);
            System.out.println("Modified Digital Tree Results: ");
            System.out.println("Minimum = " + results[6] + " Maximum = " + results[7] + " Average = " + results[8]);

//            System.out.println(expNum + " Keys");
//            System.out.println("--------");
//            System.out.println("Binary Tree Results: ");
//            System.out.println("Minimum = " + binResults[0] + " Maximum = " + binResults[1] + " Average = " + binResults[2]);
//            System.out.println("Digital Tree Results: ");
//            System.out.println("Minimum = " + digResults[0] + " Maximum = " + digResults[1] + " Average = " + digResults[2]);

            System.out.println("");
            expCount++;
        }
        
        
  
                
    }
    public static float[] experiment(int numKeys, binaryTree binTree, digitalTree digTree, digitalTree modTree)
    {
        float[] results = new float[9];
        List<Integer> binCounts = new ArrayList<>();
        List<Integer> digCounts = new ArrayList<>();
        List<Integer> modCounts = new ArrayList<>();
        int[] min = new int[3];
        int[] max = new int[3];
        int[] total = new int[3];
        
        for(int c = 0; c < 3; c++)
        {
            min[c] = 0;
            max[c] = 0;
            total[c] = 0;
        }
        int i = 0;
        while(i < numKeys)
        {
            int random = (int)(Math.random() * 65536 + 1);
            if(binTree.lookup(random))
            {
                binTree.lookup(random);
                binCounts.add(binTree.count);
                
                digTree.lookup(random);
                digCounts.add(digTree.count);
                
                modTree.lookup(random);              
                modCounts.add(modTree.count);
                i++;
            }
        }
            
            for(int j = 0; j < numKeys; j++)
            {
                if(j == 0)
                {
                    min[0] = binCounts.get(j); // 0 = binary
                    min[1] = digCounts.get(j); // 1 = digital
                    min[2] = modCounts.get(j); // 2 = modified
                    
                    max[0] = binCounts.get(j);
                    max[1] = digCounts.get(j);
                    max[2] = modCounts.get(j);
                }

                if(binCounts.get(j) < min[0])
                {
                    min[0] = binCounts.get(j);
                }
                
                if(digCounts.get(j) < min[1])
                {
                    min[1] = digCounts.get(j);
                }
                
                if(modCounts.get(j) < min[2])
                {
                    min[2] = modCounts.get(j);
                }
                
                if(binCounts.get(j) > max[0])
                {
                    max[0] = binCounts.get(j);
                }
                
                if(digCounts.get(j) > max[1])
                {
                    max[1] = digCounts.get(j);
                }
                
                if(modCounts.get(j) > max[2])
                {
                    max[2] = modCounts.get(j);
                }
         
                total[0] = total[0] + binCounts.get(j);
                total[1] = total[1] + digCounts.get(j);
                total[2] = total[2] + modCounts.get(j);
                
            }
  
        
        //Results Array: 
        //0-2 = bin min, max, avg
        results[0] = min[0];
        results[1] = max[0];
        results[2] = total[0]/numKeys;
        //3-5 = dig min, max, avg
        results[3] = min[1];
        results[4] = max[1];
        results[5] = total[1]/numKeys;
        //6-8 = mod min, max, avg
        results[6] = min[2];
        results[7] = max[2];
        results[8] = total[2]/numKeys;
        return results;
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
    
 
    public static float[] modExperiment(int numKeys, digitalTree tree) throws StringIndexOutOfBoundsException
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
