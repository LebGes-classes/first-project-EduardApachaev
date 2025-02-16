import java.util.Scanner;
public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("1. Начать игру \n2. Выйти");

        int userInput = sc.nextInt();
        while (userInput != 1 && userInput != 2) {
            userInput = sc.nextInt();
        }
        mainMenu(userInput);
    }

    public static void mainMenu(int userInput) {
        switch (userInput) {
            case (1):
                mapTypeSelectionMenu();
                break;
            case (2):
                System.out.println("Выйти");
                break;
        }
    }

    public static void mapTypeSelectionMenu() {
        Console.consoleClearing();
        System.out.println("1. Прохождение уровней \n2. Автогенерация \n3. Назад в меню");

        int userInput = sc.nextInt();
        while (userInput != 1 && userInput != 2) {
            userInput = sc.nextInt();
        }
        mapTypeSelectionMenu(userInput);
    }
    
    public static void mapTypeSelectionMenu(int userInput) {
        switch (userInput) {
            case (1):
                mapCompanyMenu();
                break;
            case (2):
                Game.gameRun("gen");
                break;
            case (3):
                System.out.println("Выйти");
                break;
        }
    }

    public static void mapCompanyMenu(){
        Console.consoleClearing();
        System.out.println("1. Тестовый уровень");
        int userInput = sc.nextInt();
        while (userInput != 1 && userInput != 2) {
            userInput = sc.nextInt();
        }
        mapCompanyMenu(userInput);
    }

    public static void mapCompanyMenu(int userInput){
        switch (userInput) {
            case (1):
                Console.consoleClearing();
                Game.gameRun("map#d.txt");
                break;
            case (2):
                break;
            case (3):
                break;
        }
    }

}
