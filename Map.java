import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {
    private int[][] table;
    private int mapLength;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public Map(int mapLength) {
        this.mapLength = mapLength;
        table = new int[mapLength][mapLength];

        for(int i = 0; i < mapLength; i++) {
            for(int j = 0; j < mapLength; j++) {
                table[i][j] = 0;
            }
        }
    }

    public Map(String fileName, int mapLength) {
        this.mapLength = mapLength;
        table = new int[mapLength][mapLength];

        String line;
        int lineCounter = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while((line = reader.readLine()) != null) {
                char[] lineAsCharArray = line.toCharArray();

                for(int i = 0; i < mapLength; i++) {
                    int number = Character.getNumericValue(lineAsCharArray[i]);
                    table[lineCounter][i] = number;
                }

                lineCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void print() {
        for(int i = 0; i < mapLength; i++) {
            for(int j = 0; j < mapLength; j++) {
                if(table[i][j] == 1)
                    System.out.print(" " + ANSI_RED + table[i][j] + ANSI_RED + " ");
                else if(table[i][j] == 2)
                    System.out.print(" " + ANSI_BLUE + table[i][j] + ANSI_BLUE + " ");
                else
                    System.out.print(" " + ANSI_WHITE + table[i][j] + ANSI_WHITE + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setValue(int x, int y, int value) {
        table[y][x] = value;
     }

    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }

    public int getMapLength() {
        return mapLength;
    }

    public void setMapLength(int mapLength) {
        this.mapLength = mapLength;
    }
}
