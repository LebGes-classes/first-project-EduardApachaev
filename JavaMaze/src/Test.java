import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Test {
    public static void main(String[] args) {
        char[][] map = new char[][]{
                {'*', '*', '*', '*', '*'},
                {'*', '*', ' ', 'F', '*'},
                {'*', 'P', ' ', '*', '*'},
                {'*', '*', '*', '*', '*'},
        };
        int widthY = map.length;
        int lengthX = map[1].length;

        int[] playerLocation = new int[2];
        int xPlayerLocation = 0;
        int yPlayerLocation = 0;

        for (int i = 0; i < map.length; i++) {
            for (int u = 0; u < map.length; u++) {
                if (map[i][u] == 'P') {
                    xPlayerLocation = u;
                    yPlayerLocation = i;
                    playerLocation[0] = i;
                    playerLocation[1] = u;
                }
            }
        }

        System.out.println(xPlayerLocation);
        System.out.println(yPlayerLocation);

        System.out.println();

        System.out.println(map[0]);
        System.out.println(map[1]);
        System.out.println(map[2]);
        System.out.println(map[3]);

        System.out.println();

        //click D button
        if (map[xPlayerLocation + 1][yPlayerLocation] != '*') {
            map[yPlayerLocation][xPlayerLocation] = ' ';
            xPlayerLocation += 1;
            map[yPlayerLocation][xPlayerLocation] = 'P';

        }

//        //click D button
//        if (map[xPlayerLocation + 1][yPlayerLocation] != '*') {
//            map[yPlayerLocation][xPlayerLocation] = ' ';
//            xPlayerLocation += 1;
//            map[yPlayerLocation][xPlayerLocation] = 'P';
//
//        }

        System.out.println(map[0]);
        System.out.println(map[1]);
        System.out.println(map[2]);
        System.out.println(map[3]);

        String inputFileName = "map#d.txt";

        char[][] mapt = new char[4][5];
        String line;
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length();i++) {
                    char element = line.charAt(i);
                    mapt[lineCount][i] = element;
                }
                lineCount += 1;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println(mapt[0]);
        System.out.println(mapt[1]);
        System.out.println(mapt[2]);
        System.out.println(mapt[3]);

    }
}
