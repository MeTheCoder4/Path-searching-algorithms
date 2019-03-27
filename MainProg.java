public class MainProg {
    public static void main(String[] args) throws InterruptedException {
        Map map = new Map(25);

        for(int i = 5; i < map.getMapLength(); i++) {
            for(int j = 5; j < map.getMapLength(); j++) {
                if(i == 5) {
                    map.setValue(i, j, 2);
                }
                else if(i == 13)
                    map.setValue(i, j, 2);
            }
        }

        FloodFill floodFill = new FloodFill(map, 10, 10);
        floodFill.run();
    }
}
