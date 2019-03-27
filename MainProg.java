public class MainProg {
    public static void main(String[] args) throws InterruptedException {
        Map map = new Map("map01", 20);
        FloodFill floodFill = new FloodFill(map, 5, 5);
        floodFill.run();
    }
}
