package Program.III_5;

public class Maze {
    private final int TRIED = 3;
    private final int PATH = 7;
    private int[][] grid = {
            {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public boolean traverse(int row, int column) {
        boolean done = false;
        if (valid(row, column)) {
            grid[row][column] = TRIED;  // cell sudah dicoba
            if (row == grid.length - 1 && column == grid[0].length - 1) done = true;  // maze dipecahkan
            else {
                done = traverse(row + 1, column);     // bawah
                if (!done) done = traverse(row, column + 1);  // kanan
                if (!done) done = traverse(row - 1, column);  // atas
                if (!done) done = traverse(row, column - 1);  // kiri
            }
            if (done)  // lokasi ini bagian dari jalur akhir
                grid[row][column] = PATH;
        }
        return done;
    }

    //tentukan jika lokasi spesifik adalah valid.
    private boolean valid(int row, int column) {
        boolean result = false;
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length)
            if (grid[row][column] == 1) result = true;
        return result;
    }

    //Kembalikan nilai maze sebagai string
    public String toString() {
        String result = "\n";
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }
        return result;
    }
}
