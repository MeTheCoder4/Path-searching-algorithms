public class MainProg {
    public static void main(String[] args) throws InterruptedException {
        Map map = new Map(25);
        FloodFill floodFill = new FloodFill(map, 10, 10);
        floodFill.run();
    }
}
