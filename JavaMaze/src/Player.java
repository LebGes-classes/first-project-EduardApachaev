public class Player {
    private int [] playerLoc;

    public void setPlayerLocation(int x, int y) {
        this.playerLoc[0] = x;
        this.playerLoc[1] = y;
    }

    public void setPlayerLocation(int [] playerLoc) {
        this.playerLoc = playerLoc;
    }

    public int [] getPlayerLocation() {
        return playerLoc;
    }

    static void playerMove(String userInput, Map mapInput, Player player) {
        int [] playerLocation = player.getPlayerLocation();
        mapInput.mapChange(playerLocation[0], playerLocation[1], ' ');

        switch (userInput) {
            case ("w"):
                player.setPlayerLocation(playerLocation[0], playerLocation[1]-1);
                break;
            case ("a"):
                player.setPlayerLocation(playerLocation[0]-1,playerLocation[1]);;
                break;
            case ("s"):
                player.setPlayerLocation(playerLocation[0],playerLocation[1]+1);
                break;
            case ("d"):
                player.setPlayerLocation(playerLocation[0]+1,playerLocation[1]);
                break;
        }
        mapInput.mapChange(playerLocation[0], playerLocation[1], 'P');
    }

//    public static void playerMovement(String userInput, Player player, Map map) {
//
////        click D button
////        if (map[xPlayerLocation + 1][yPlayerLocation] != '*') {
////            map[yPlayerLocation][xPlayerLocation] = ' ';
////            xPlayerLocation += 1;
////            map[yPlayerLocation][xPlayerLocation] = 'P';
////        }
//
//        switch (userInput) {
//            case ("W"):
//            case ("A"):
//            case ("S"):
//            case ("D"):
//                break;
//        }
//    }
}
