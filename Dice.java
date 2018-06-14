
package dice;
import java.util.Random;
import java.util.Scanner;
public class Dice {

    int diceSize;
    int number=0;
    public Dice(int diceSize){
        this.diceSize=diceSize;
    }
    public int rollDice(){
        Random rand=new Random();
        number=rand.nextInt(diceSize)+1;
        return number;       
    }
    String intToString(Dice d){
        int ch=d.rollDice();
        switch(ch){
            case 1:return "one";
            case 2:return "two";
            case 3:return "three";
            case 4:return "four";
            case 5:return "five";
            case 6:return "six";
            default: return null;
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter Size of Dice (2,4,6) :");
        Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        System.out.println();
        if(size==2 || size==4 || size==6 ){
            Dice d=new Dice(size);
            System.out.println(d.intToString(d)+" "+d.number);
        }
        else{
            System.out.println("Invalid Input"); 
        }  
    } 
}
