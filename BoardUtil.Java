package JChess;

public static class BoardUtil {

    public static int[] Square;
    Square = new int[64];

    public static int GetIndex (row, col) {

        return 8*row + col;

    }
    public static int GetRow (index) {

        return index / 8;

    }
    public static int GetCol (index) {

        return index % 8;
    }
    
}

