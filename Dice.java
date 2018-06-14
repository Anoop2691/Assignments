
package dice;
import java.util.Random;
import java.util.Scanner;
public class Dice {

    int diceSize;
    int number=0;
    String[] selection={"one","two","three","four","five","six"};
    public Dice(int diceSize){
        this.diceSize=diceSize;
    }
    public String rollDice(){
        return selection[new Random().nextInt(diceSize)];      
    }
    public static void main(String[] args) {
        System.out.print("Enter Size of Dice (2,4,6) :");
        Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        System.out.println();
        if(size==2 || size==4 || size==6 ){
            Dice d=new Dice(size);
            System.out.println(d.rollDice());
        }
        else{
            System.out.println("Invalid Input"); 
        }  
    } 
}
