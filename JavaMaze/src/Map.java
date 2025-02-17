import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Map {

    char[][] map;

    private int[] mapSize;

    private final int[] startLocation;

    private int xFinalLocation;
    private int yFinalLocation;

    public Map() {
        map = new char[0][0];
        startLocation = new int[0];
        xFinalLocation = 0;
        yFinalLocation = 0;
    }

    public Map(char[][] maze) {
        map = maze;
        startLocation = new int[0];
        xFinalLocation = 0;
        yFinalLocation = 0;
    }

    public Map(String mapName) {
        map = mapImport(mapName);
        startLocation = new int[2];

    }

//    public Map(char[][] newMap) {
//        map = newMap;
//        startLocation = new int[2];
//
//    }

    public void setStartLocation(int xStartLocation, int yStartLocation) {
        this.startLocation[0] = xStartLocation;
        this.startLocation[1] = yStartLocation;
    }

    public int[] getStartLocation() {
        return startLocation;
    }

    public void setXFinalLocation(int xFinalLocation) {
        this.xFinalLocation = xFinalLocation;
    }

    public int getXFinalLocation() {
        return xFinalLocation;
    }

    public void setYFinalLocation(int yFinalLocation) {
        this.yFinalLocation = yFinalLocation;
    }

    public int getYFinalLocation() {
        return yFinalLocation;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public char[][] getMap() {
        return map;
    }

    public void mapChange(int x, int y, char symbol){
        this.map[y][x] = symbol;

    }



    public static void mapGenDrawing(Map map) {
        for (int i = 0; i < map.getMap().length; i++) {
            for (int u = 0; u < map.getMap().length; u++) {
                System.out.print(map.getMap()[u][i] + " ");
            }
            System.out.println();
        }
    }

    public static void mapDrawing(Map map) {
        for (int i = 0; i < map.getMap().length; i++) {
            System.out.println(map.getMap()[i]);
        }
    }

//    public int[] mapSizing(String inputMapName) {
//        String line;
//        int lineCount = 0;
//        int lineLength = 0;
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputMapName))) {
//            line = reader.readLine();
//            while (line != null) {
//                lineCount += 1;
//                lineLength = line.length();
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new int[] {lineLength, lineCount};
//    }

    public static char[][] mapImport(String inputMapName) {
//        String inputFileName = "map#d.txt";
//        int [] mapSize = mapSizing(inputMapName);
        char[][] map = new char[4][5];

        String line;
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputMapName))) {
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length();i++) {
                    char element = line.charAt(i);
                    map[lineCount][i] = element;
                }
                lineCount += 1;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void mapInfo(Map map) {

        for (int y = 0; y < map.getMap().length; y++) {
            for (int x = 0; x < map.getMap()[0].length; x++) {
                if (map.getMap()[y][x] == 'F') {
                    map.setXFinalLocation(x);
                    map.setYFinalLocation(y);
                }
                if (map.getMap()[y][x] == 'P') {
                    map.setStartLocation(x, y);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Map{" +
                "map=" + Arrays.toString(map) +
                ", xFinalLocation=" + xFinalLocation +
                ", yFinalLocation=" + yFinalLocation +
                '}';
    }
}
