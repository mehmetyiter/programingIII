import java.util.Random;
import java.util.Scanner;

public class numbers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("how many random number do you want to generate?");
        int number =scanner.nextInt(); // do exception here!
        if (number<0){
            System.out.print("number is negative");
            return;
        }
        System.out.println("what is your name?");
        String name = scanner.next();
        if (name.isEmpty()){
            System.out.println("name can't empty");
            return;
        }

        System.out.println("what is minimum number?");
        int min = scanner.nextInt();
        if (min<0){
            System.out.println("number is negative");
        }
        System.out.println("what is maximum number?");
        int max = scanner.nextInt();
        if (max<min){
            System.out.println("number can't less than minimum");
        }

        Random rand = new Random();
        System.out.print("Result: ");
        for (int i = 0; i < number; i++) {
            int randomNum = rand.nextInt((max - min) + 1) + min;
            System.out.print(randomNum);
            if(i<number-1){
                System.out.print(", ");
            }
        }

    }
}
