import java.util.*;
class Ghost {
    int row, col;        // ghost ki position
    String prevCell;     // jo cell neeche thi usse yaad rakho
    Random rand = new Random();

    Ghost(int startRow, int startCol, String[][] arr) {
        this.row = startRow;
        this.col = startCol;
        this.prevCell = arr[startRow][startCol]; // us cell ko save karo
    }

    void move(String[][] arr) {
        int[] dRow = {-1, 1, 0, 0};   // upar, neeche
        int[] dCol = {0, 0, -1, 1};   // left, right

        arr[row][col] = prevCell;      // purani jagah wapas kar do

        List<Integer> dirs = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Collections.shuffle(dirs, rand); // random direction

        for (int d : dirs) {
            int newRow = row + dRow[d];
            int newCol = col + dCol[d];

            // wall se nahi takraaye
            if (!arr[newRow][newCol].contains("█") &&
                    !arr[newRow][newCol].contains("▓")) {
                prevCell = arr[newRow][newCol]; // nai cell save karo
                row = newRow;
                col = newCol;
                break;
            }
        }
        arr[row][col] = "\u001B[35m👻\u001B[0m"; // ghost draw karo
    }
    boolean catchesPacman(int pRow, int pCol) {
        return row == pRow && col == pCol;
    }
}
