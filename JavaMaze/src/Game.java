import java.util.Scanner;
public class Game {
    private static Scanner sc = new Scanner(System.in);

    public static void gameRun(String mapName) {

        Player gamePlayer = new Player();

        if (mapName == "gen") {
            GenerateMap genMap = new GenerateMap(14);
            char[][] genMapc = genMap.getMaze();
            Map gameMap = new Map(genMapc);
            Map.mapGenDrawing(gameMap);
        } else {
            Map gameMap = new Map(mapName);
            Map.mapInfo(gameMap);
            Map.mapDrawing(gameMap);
            gamePlayer.setPlayerLocation(gameMap.getStartLocation());
            while (!win(gameMap,gamePlayer)) {
                String userInput = sc.nextLine();
                if (freePath(userInput, gameMap, gamePlayer)) {
                    Player.playerMove(userInput, gameMap,gamePlayer);
                    Console.consoleClearing();
                    Map.mapDrawing(gameMap);
                }
            }
        }
    }

    private static boolean win(Map gameMap, Player gamePlayer) {
        return gameMap.getXFinalLocation() == gamePlayer.getPlayerLocation()[0] &&
               gameMap.getYFinalLocation() == gamePlayer.getPlayerLocation()[1];
    }

    private static boolean freePath(String userInput, Map mapInput, Player player) {
        char [][] map = mapInput.getMap();
        int [] playerLocation = player.getPlayerLocation();
        int xChange = 0;
        int yChange = 0;

        switch (userInput) {
            case ("w"):
                yChange =-1;
                break;
            case ("a"):
                xChange = -1;
                break;
            case ("s"):
                yChange = 1;
                break;
            case ("d"):
                xChange = 1;
                break;
        }
        return (map[playerLocation[1]+ yChange][playerLocation[0]+ xChange] != '*');
    }

//    public static void label() {
//        System.out.println("\nE - выйти \n\nW - вверх, A - влево, S - вниз, D - вправо ");
//    }
}
