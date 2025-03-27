import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Quanto é 2 + 2 ?");
        int result = scn.nextInt();

        boolean isRight;

        if(isRight = result == 4) {

            String report = "Sim";
            System.out.printf("O resultado é %d \n", result);
            System.out.printf("Você acertou? (%s)", report);
        } else {

            String report = "Não";
            System.out.printf("O resultado é %d \n", 4);
            System.out.printf("Você acertou? (%s)", report);
        }

        scn.close();
    }
}