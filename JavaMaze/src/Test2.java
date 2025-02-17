import java.util.Scanner;
public class Test2 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String mapName = "map#d.txt";

        Map gameMap = new Map(mapName);
        Map.mapInfo(gameMap);
        Map.mapDrawing(gameMap);

        Player gamePlayer = new Player();

        gamePlayer.setPlayerLocation(gameMap.getStartLocation());

        boolean win = gameMap.getXFinalLocation() == gamePlayer.getPlayerLocation()[0] &&
                      gameMap.getYFinalLocation() == gamePlayer.getPlayerLocation()[1];

        while (!win) {
            String userInput = sc.nextLine();
            if (freePath(userInput, gameMap, gamePlayer)) {
                playerMove(userInput, gameMap,gamePlayer);
                Console.consoleClearing();
                Map.mapDrawing(gameMap);
            }
            win = gameMap.getXFinalLocation() == gamePlayer.getPlayerLocation()[0] &&
                    gameMap.getYFinalLocation() == gamePlayer.getPlayerLocation()[1];
        }
    }

//    public static String correctGameInput() {
//        String userInput = sc.nextLine();
//        while (userInput != "W" && userInput != "A" && userInput != "S" && userInput!= "D" && userInput != "E")
//        {
//            userInput = sc.nextLine();
//        }
//        return userInput;
//    }

    public static boolean freePath(String userInput, Map mapInput, Player player) {
        char [][] map = mapInput.getMap();
        int [] playerLocation = player.getPlayerLocation();
        int xChange = 0;
        int yChange = 0;

        switch (userInput) {
            case ("W"):
                yChange =-1;
                break;
            case ("A"):
                yChange = -1;
                break;
            case ("S"):
                xChange = 1;
                break;
            case ("D"):
                yChange = 1;
                break;
        }
        return (map[playerLocation[1]+ yChange][playerLocation[0]+ xChange] != '*');
    }

//    public static boolean freePath(String userInput, Map mapInput, Player player) {
//        char [][] map = mapInput.getMap();
//        int [] playerLocation = player.getPlayerLocation();
//
//        switch (userInput) {
//            case ("W"):
//                return (map[playerLocation[1]-1][playerLocation[0]] != '*');
//            case ("A"):
//                return (map[playerLocation[1]][playerLocation[0]-1] != '*');
//            case ("S"):
//                return (map[playerLocation[1]+1][playerLocation[0]] != '*');
//            case ("D"):
//                return (map[playerLocation[1]][playerLocation[0]+1] != '*');
//            default:
//                return false;
//        }
//    }

    public static void playerMove(String userInput, Map mapInput, Player player) {
        int [] playerLocation = player.getPlayerLocation();

        switch (userInput) {
            case ("W"):
                mapInput.mapChange(playerLocation[0], playerLocation[1], ' ');
                player.setPlayerLocation(playerLocation[0], playerLocation[1]-1);
                mapInput.mapChange(playerLocation[0], playerLocation[1], 'P');
                break;
            case ("A"):
                mapInput.mapChange(playerLocation[0], playerLocation[1], ' ');
                player.setPlayerLocation(playerLocation[0]-1,playerLocation[1]);
                mapInput.mapChange(playerLocation[0], playerLocation[1], 'P');
                break;
            case ("S"):
                mapInput.mapChange(playerLocation[0], playerLocation[1], ' ');
                player.setPlayerLocation(playerLocation[0],playerLocation[1]+1);
                mapInput.mapChange(playerLocation[0], playerLocation[1], 'P');
                break;
            case ("D"):
                mapInput.mapChange(playerLocation[0], playerLocation[1], ' ');
                player.setPlayerLocation(playerLocation[0]+1,playerLocation[1]);
                mapInput.mapChange(playerLocation[0], playerLocation[1], 'P');
                break;
        }
    }
}
