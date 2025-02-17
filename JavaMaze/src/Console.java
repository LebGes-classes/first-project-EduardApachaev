public class Console {
    public static void consoleClearing() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
        System.out.println();
    }
}
