import java.util.Scanner;

public class Dice 
{
    int sides,outcome=0;
    
    public static int randomNumber(int min, int max)
    {
        int result=(int)((Math.random()*max)+1);
        return result;
    }
    
    public Dice(int sides)
    {
        this.sides=sides;
    } 
    
    public void rollTheDice()
    {     
           
       outcome=randomNumber(1,sides);
           if(sides==2)
           {
             if(outcome==1)
             { System.out.println("Heads");
             } 
             else
             { System.out.println("Tails");}
           }
           else if((sides%2)!=0)
           { System.out.println("wrong input");   
           }
           else {
               System.out.println(outcome);
       }
    }
    
    public static void main(String[] args)
    {
        System.out.println("Enter no. of sides for Dice");
       Scanner sc = new Scanner(System.in);
       int sides=sc. nextInt();
      Dice dice=new Dice(sides);
      dice.rollTheDice();
    }
    
    
}
