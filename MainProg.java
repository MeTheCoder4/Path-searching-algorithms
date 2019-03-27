public class MainProg {
    public static void main(String[] args) throws InterruptedException {
//        Map map = new Map("map01", 40);
        Map map = new Map("poop.png");
        FloodFill floodFill = new FloodFill(map, 10, 10);
        floodFill.run();
    }
}
