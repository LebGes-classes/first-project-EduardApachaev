import java.util.Random;
import java.util.Stack;

public class MazeGenerator {
    private int width;
    private int height;
    private int[][] maze;
    private Random random = new Random();

//    public MazeGenerator(int i, int i1) {
//    }

    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        this.maze = new int[height][width];
    }

    public void generateMaze() {
        // Заполняем лабиринт стенами (1)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                maze[y][x] = 1;
            }
        }

        // Начальная точка (2, 2)
        int startX = 1;
        int startY = 1;
        maze[startY][startX] = 0; // 0 — это проход

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});

        while (!stack.isEmpty()) {
            int[] current = stack.peek();
            int x = current[0];
            int y = current[1];

            // Получаем возможные направления
            int[][] directions = getPossibleDirections(x, y);

            if (directions.length > 0) {
                // Выбираем случайное направление
                int[] direction = directions[random.nextInt(directions.length)];
                int nx = x + direction[0] * 2; // Шагаем через стену
                int ny = y + direction[1] * 2;

                // Если клетка в пределах лабиринта и это стена
                if (nx >= 0 && nx < width && ny >= 0 && ny < height && maze[ny][nx] == 1) {
                    maze[ny][nx] = 0; // Делаем проход
                    maze[y + direction[1]][x + direction[0]] = 0; // Убираем стену между клетками
                    stack.push(new int[]{nx, ny}); // Переходим в новую клетку
                }
            } else {
                // Если нет возможных направлений, возвращаемся назад
                stack.pop();
            }
        }
    }

    // Возвращает возможные направления для движения
    private int[][] getPossibleDirections(int x, int y) {
        int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // Вверх, вправо, вниз, влево
        int[][] possibleDirections = new int[4][];
        int count = 0;

        for (int[] dir : directions) {
            int nx = x + dir[0] * 2;
            int ny = y + dir[1] * 2;

            // Проверяем, что клетка в пределах лабиринта и это стена
            if (nx >= 0 && nx < width && ny >= 0 && ny < height && maze[ny][nx] == 1) {
                possibleDirections[count++] = dir;
            }
        }

        // Возвращаем только актуальные направления
        int[][] result = new int[count][];
        System.arraycopy(possibleDirections, 0, result, 0, count);
        return result;
    }

    // Выводим лабиринт в консоль
    public void printMaze() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(maze[y][x] == 0 ? " " : "#"); // " " — проход, "#" — стена
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator(21, 21); // Лабиринт 21x21
        mazeGenerator.generateMaze();
        mazeGenerator.printMaze();
    }
}