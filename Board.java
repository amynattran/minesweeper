import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    int numBombs;
    int[][] board;
    int height;
    int width;

    Board(int height, int width, int numBombs) {
        this.numBombs = numBombs;
        this.height = height;
        this.width = width;
        assert numBombs < (height * width) * 0.75: "There are too many bombs!!!";
        this.board = createBoard(height, width, numBombs);
    }

    private static int[][] createBoard(int height, int width, int numBombs) {
        int[][] ret = new int[height][width];
        List<Integer> allLocs = IntStream.range(1, height * width).boxed().collect(Collectors.toList());;
        Collections.shuffle(allLocs);
        for(int i = 0; i < numBombs; i++) {
            Integer bomb = allLocs.get(i);
            int x = Math.floorDiv(bomb, width);
            int y = bomb % width;
            ret[x][y] = -1;
            if (canAdd(ret, x+1, y)) { ret[x+1][y] ++; }
            if (canAdd(ret, x+1, y+1)) { ret[x+1][y+1] ++; }
            if (canAdd(ret, x+1, y-1)) { ret[x+1][y-1] ++; }
            if (canAdd(ret, x-1, y)) { ret[x-1][y] ++; }
            if (canAdd(ret, x-1, y+1)) { ret[x-1][y+1] ++; }
            if (canAdd(ret, x-1, y-1)) { ret[x-1][y-1] ++; }
            if (canAdd(ret, x, y+1)) { ret[x][y+1] ++; }
            if (canAdd(ret, x, y-1)) { ret[x][y-1] ++; }

        }
        return ret;
    }
    private static boolean canAdd(int[][] board, int x, int y){
        int boardLen = board.length;
        int otherLen = board[0].length;
        if (x >= 0) {
            if (y >= 0) {
                if (boardLen > x) {
                    if (otherLen > y) {
                        if (board[x][y] != -1){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void printBoard(){
        for (int i = 0; i < this.board.length; i ++) {
            for (int j = 0; j < this.board[i].length; j ++) {
                System.out.print(this.board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}