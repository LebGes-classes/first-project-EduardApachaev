public class GenerateMap {
    char[][] maze;
    private int sizeMap;

    public GenerateMap(int sizeMap) {
        generateMap(sizeMap);
    }

    public char[][] getMaze() {
        return maze;
    }

    public char[][] generateMap(int size) {
        this.sizeMap = (size % 2 == 0) ? size + 1 : size;

        maze = new char[this.sizeMap][this.sizeMap];

        for (int y = 0; y < this.sizeMap; y++) {
            for (int x = 0; x < this.sizeMap; x++) {
                maze[y][x] = '#';
            }
        }

        carve(1, 1);
        return maze;
    }

    private void carve(int x, int y) {
        int[][] dirs = {{0, -2}, {0, 2}, {-2, 0}, {2, 0}};

        // Перемешиваем направления
        for (int i = 0; i < 4; i++) {
            int j = randomModule.nextInt(0, 4);
            int[] tmp = dirs[i];
            dirs[i] = dirs[j];
            dirs[j] = tmp;
        }

        // Прокладываем путь в случайном порядке
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];

            // Проверяем, что координаты не выходят за пределы карты
            if (nx > 0 && ny > 0 && nx < sizeMap - 1 && ny < sizeMap - 1 && maze[ny][nx] == '#') {
                maze[ny][nx] = ' ';
                maze[ny - d[1] / 2][nx - d[0] / 2] = ' ';
                carve(nx, ny);

                maze[1][1] = 'P';
            }
        }
    }
}