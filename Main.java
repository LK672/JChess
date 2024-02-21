package JChess;

public class Main{
    public static void main(String args[]) {
        ChessBoard board = new ChessBoard();
        BoardUtil.FENToARR (BoardUtil.currFEN);
    }
}
