public class Map {
    private int[][] table;
    private int mapLength;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLUE = "\u001B[34m";

    Map(int mapLength) {
        this.mapLength = mapLength;
        table = new int[mapLength][mapLength];

        for(int i = 0; i < mapLength; i++) {
            for(int j = 0; j < mapLength; j++) {
                table[i][j] = 0;
            }
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
