import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Olá, informe o seu nome");
        String name = scn.nextLine();

        System.out.println("Informe sua idade");
        int idade = scn.nextInt();

        System.out.printf("Olá %s sua idade é %d \n", name, idade);

        scn.close();
    }
}