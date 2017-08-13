/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;
import java.util.*;

/**
 *
 * @author rrr101
 */
public class Perceptron 
{
    
    
    public static boolean compareArrays(int[] array1, int[] array2) 
    {
        boolean b = true;
        if (array1 != null && array2 != null)
        {
          if (array1.length != array2.length)
              b = false;
          else
              for (int i = 0; i < array2.length; i++) 
              {
                  if (array2[i] != array1[i]) 
                  {
                      b = false;    
                  }                 
            }
        }
        else
        {
          b = false;
        }
        return b;
    }
    
    
    public static int actualOutput(int signal1, int signal2, float i1, float i2, float threshold)
    {
        int output=0;
        float calcVal = 0 ;
        
        calcVal = (i1*signal1) + (i2*signal2);
        
       
         if(calcVal>=threshold)
            output=1;
            
                  
        return output;
    }
    
    public static void gate(int gate)
    {
         int[] targetOut = {0,0,0,0};
         
        if(gate == 1)
        {
         targetOut[0] = 0;
         targetOut[1] = 1;
         targetOut[2] = 1;
         targetOut[3] = 1;
        }
        else if(gate ==2)
        {
         targetOut[0] = 0;
         targetOut[1] = 0;
         targetOut[2] = 0;
         targetOut[3] = 1;
        }

        else if(gate==3)
        {
         targetOut[0] = 1;
         targetOut[1] = 0;
         targetOut[2] = 0;
         targetOut[3] = 0;
         }
        
        System.out.println("\n The target output is \t" + Arrays.toString(targetOut));
        Scanner in = new Scanner(System.in);
        float i1=0;
        float i2=0;
        float learningCoefficient = 0;
        float thresholdValue = 0;
        
        System.out.println(" \n \n Enter First weight");
        i1 = in.nextFloat();
        System.out.println("\n \n Enter Second weight");
        i2 = in.nextFloat();
        System.out.println("\n \n Enter the learning coefficient");
        learningCoefficient = in.nextFloat();
        System.out.println("\n \n Enter the threshold value");
        thresholdValue = in.nextInt();
        
        int count = 0;
        int signal1=0; int signal2=0;
        int out=0;
        int check=0;
        while(count<=20 && check!=1)
        {
            
            int[] actual = {0,0,0,0};
            
            for(int i=0; i<4; i++)
            {
                if(i==0)
                {
                    signal1=0;
                    signal2=0;
                    out = actualOutput(signal1,signal2,i1,i2,thresholdValue);
                    actual[i] = out;
                      
                      if(out!= targetOut[i])
                     {
                        
                        i1 = i1+ (learningCoefficient*(targetOut[i]-out))*signal1;
                        i2 = i2+ (learningCoefficient*(targetOut[i]-out))*signal2;
                        
                        System.out.println("\n Weights are \t"+ i1 + "  " + i2);
                     }
                }
                else if(i==1)
                {
                    signal1=0;
                    signal2=1;    
                    out = actualOutput(signal1,signal2,i1,i2,thresholdValue);
                    actual[i] = out;
                      
                      if(out!= targetOut[i])
                     {
                        i1 = i1+ (learningCoefficient*(targetOut[i]-out))*signal1;
                        i2 = i2+ (learningCoefficient*(targetOut[i]-out))*signal2;
                        
                        System.out.println("\n Weights are \t"+ i1 + "  " + i2);
                     }

                }
                else if(i==2)
                {
                    signal1=1;
                    signal2=0;
                    out = actualOutput(signal1,signal2,i1,i2,thresholdValue);
                    actual[i] = out;
                      
                      if(out!= targetOut[i])
                     {
                        i1 = i1+ (learningCoefficient*(targetOut[i]-out))*signal1;
                        i2 = i2+ (learningCoefficient*(targetOut[i]-out))*signal2;
                        
                        System.out.println("\n Weights are \t"+ i1 + "  " + i2);
                     }

                }
                else if(i==3)
                {
                    signal1=1;
                    signal2=1;
                    out = actualOutput(signal1,signal2,i1,i2,thresholdValue);
                    actual[i] = out;
                      
                      if(out!= targetOut[i])
                     {
                        i1 = i1+ (learningCoefficient*(targetOut[i]-out))*signal1;
                        i2 = i2+ (learningCoefficient*(targetOut[i]-out))*signal2;
                        
                        System.out.println("\n Weights are \t"+ i1 + "  " + i2);
                     }

                }
               }
                
                System.out.println("\n Actual Output is \t" + Arrays.toString(actual));
                
              
                
                if(gate!=3)
                {
                  if(compareArrays(targetOut,actual) == true)
                   {
                     System.out.println("\n Outputs are same in this case");
                     check = 1;
                     break;
                   }
                }
                else if (gate==3 && count>4)
                {
                  if(compareArrays(targetOut,actual) == true)
                  {
                   System.out.println("\n Outputs are same in this case\n \n");
                   check =1;
                   break;

                  }
                }
               
                                
                count++;
                System.out.println("After" + count + "epochs Weight i1 "+ i1+ "weight i2 " + i2);
                
                if(compareArrays(targetOut,actual))   
                    break;
                if(count>20)
                    break;
            
        }
            
       
    }
    
       
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int choice = 0 ;
        do
        {
            System.out.println("\n Select Gate \n");
            System.out.println("\n 1. OR Gate");
            System.out.println("\n 2. AND Gate");
            System.out.println("\n 3. NOR Gate");
            System.out.println("\n 4. Exit");
            choice = scan.nextInt();
            
            switch(choice)
            {
                case 1: gate(choice); break;
                case 2: gate(choice); break;
                case 3: gate(choice); break;
                case 4: break;
            }
        }
        while(choice!=4);
    }

    public Perceptron() {
        
    }
    
}
