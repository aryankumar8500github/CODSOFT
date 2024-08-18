import java.util.*;
public class numberGame {

   
    public int generate (){
        int output = 0;
        int i ;
        int userInput =0;
        Random rand = new Random();
        int randomNumber =   rand.nextInt(100);
        
        for ( i=0;i<3;i++){

            Scanner input = new Scanner (System.in);
            System.out.println("Enter the Number:");
             userInput = input.nextInt();
            
            if(randomNumber>userInput){
                output =1;
                System.out.println("go High!");
               
                
            }
            
            else if(randomNumber<userInput){
                output =2;
                System.out.println("go Low!");
               
                
            }
            else {
                System.out.println("Bingo!");
            
                break;
            }
            
        }
        if(i==3 & randomNumber != userInput){
            System.out.println("You have exhausted all your trials! Your Number was "+ randomNumber);
        }
        return output;
    }
    public static void main(String[] args) {
       numberGame ob = new numberGame();
        ob.generate();
        
    }
}