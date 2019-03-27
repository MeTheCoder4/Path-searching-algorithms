import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FloodFill {
    private boolean[][] visited;
    private Queue<Pair<Integer, Integer>> open;
    private Map map;

    public FloodFill(Map map, int initialX, int initialY) {
        visited = new boolean[map.getMapLength()][map.getMapLength()];
        open = new LinkedList<>();
        map.setValue(initialX, initialY, 1);
        open.add(new Pair<>(initialY, initialX));
        visited[initialY][initialX] = true;
        this.map = map;

        for(int i = 0; i < map.getMapLength(); i++) {
            for(int j = 0; j < map.getMapLength(); j++) {
                if(map.getTable()[i][j] == 2)
                    visited[i][j] = true;
            }
        }
    }
    // Runs main algorithm loop, modifying map cells and displaying each modification
    public void run() throws InterruptedException {
        while(!open.isEmpty()) {
            Pair<Integer, Integer> current = open.poll();
            List<Pair<Integer, Integer>> neighbors = getNeighbors(current);

            for(Pair<Integer, Integer> neighbor : neighbors) {
                if(!doesVisitedContain(neighbor.getKey(), neighbor.getValue())) {
                    open.add(neighbor);
                    visited[neighbor.getKey()][neighbor.getValue()] = true;
                    map.setValue(neighbor.getValue(), neighbor.getKey(), 1);
                    map.print();
                    Thread.sleep(70);
                }
            }
        }
    }
    // Checks which neighbors are available and returns their positions
    private List<Pair<Integer, Integer>> getNeighbors(Pair<Integer, Integer> current) {
        List<Pair<Integer, Integer>> neighbors = new LinkedList<>();

        if(current.getKey() != 0) {
            neighbors.add(new Pair<>(current.getKey() - 1, current.getValue()));
        }
        if(current.getValue() != 0) {
            neighbors.add(new Pair<>(current.getKey(), current.getValue() - 1));
        }
        if(current.getKey() != map.getMapLength() - 1) {
            neighbors.add(new Pair<>(current.getKey() + 1, current.getValue()));
        }
        if(current.getValue() != map.getMapLength() - 1) {
            neighbors.add(new Pair<>(current.getKey(), current.getValue() + 1));
        }

        return neighbors;
    }

    private boolean doesVisitedContain(int y, int x) {
        return visited[y][x];
    }
}
