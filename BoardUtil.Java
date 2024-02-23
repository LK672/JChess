package JChess;

public final class BoardUtil {

    public static String currFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    public static Piece.Pieces[] Square = new Piece.Pieces[64];

    public static int GetIndex (int row, int col) {

        return 8*row + col;

    }
    public static int GetRow (int index) {

        return index / 8;

    }
    public static int GetCol (int index) {

        return index % 8;
    }
    public static void ArrToFEN (Piece.Pieces[] arr) {

        int drow = 0;
        String res = "";
        for (int i  = 0; i < 64; i++) {
            String shift = "";
            if (i % 8 == 0 && i != 0) {
                if (drow > 0) {
                    res += drow;
                }
                res += "/";
                drow = 0;
            }
            switch (drow) {
                case 0:
                    shift = "";
                    break;
                case 8:
                    res += Character.forDigit(drow, 10);
                    break;
                default:
                    String s = String.valueOf(Character.forDigit(drow, 10));
                    shift = s;
                    break;
            }
            if (Square[i] == Piece.Pieces.NOPIECE) {
                drow += 1;
            }
            else {
                switch (Square[i]) {
                    case Piece.Pieces.NOPIECE:
                        drow += 1; 
                    case Piece.Pieces.BKING:
                        res += shift;
                        res += 'k';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.BPAWN:
                        res += shift;
                        res += 'p';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.BKNIGHT:
                        res += shift;
                        res += 'n';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.BBISHOP:
                        res += shift;
                        res += 'b';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.BROOK:
                        res += shift;
                        res += 'r';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.BQUEEN:
                        res += shift;
                        res += 'q';
                        drow = 0;
                        shift = "";
                        break;

                    case Piece.Pieces.WKING:
                        res += shift;
                        res += 'K';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.WPAWN:
                        res += shift;
                        res += 'P';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.WKNIGHT:
                        res += shift;
                        res += 'N';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.WBISHOP:
                        res += shift;
                        res += 'B';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.WROOK:
                        res += shift;
                        res += 'R';
                        drow = 0;
                        shift = "";
                        break;
                    case Piece.Pieces.WQUEEN:
                        res += shift;
                        res += 'Q';
                        drow = 0;
                        shift = "";
                        break;
                    default:
                        res += shift;
                        res += "";
                        drow = 0;
                        shift = "";
                        break;

                }
            }
            if (i == 63 && drow > 0) {
                res += String.valueOf(Character.forDigit(drow, 10));
            }
        }
        currFEN = res;
    }
    public static void FENToArr (String FEN) {
        Piece.Pieces[] resArr = new Piece.Pieces[64];
        int currArrIndex = 0;
        for (int i = 0; i < FEN.length(); i++) {
            char currChar = FEN.charAt(i);
            if (Character.isDigit(currChar)) {
                int num = currArrIndex;
                for (int j = num; j < num+Character.getNumericValue(currChar); j++) {
                    resArr[j] = Piece.Pieces.NOPIECE;
                    currArrIndex++;
                }
                continue;
            }
            else if (Character.isAlphabetic(currChar)) {
                switch (currChar) {
                    case 'k':
                        resArr[currArrIndex] = Piece.Pieces.BKING;
                        break;
                    case 'p':
                        resArr[currArrIndex] = Piece.Pieces.BPAWN;
                        break;
                    case 'n':
                        resArr[currArrIndex] = Piece.Pieces.BKNIGHT;
                        break;
                    case 'b':
                        resArr[currArrIndex] = Piece.Pieces.BBISHOP;
                        break;
                    case 'r':
                        resArr[currArrIndex] = Piece.Pieces.BROOK;
                        break;
                    case 'q':
                        resArr[currArrIndex] = Piece.Pieces.BQUEEN;
                        break;
                    
                    case 'K':
                        resArr[currArrIndex] = Piece.Pieces.WKING;
                        break;
                    case 'P':
                        resArr[currArrIndex] = Piece.Pieces.WPAWN;
                        break;
                    case 'N':
                        resArr[currArrIndex] = Piece.Pieces.WKNIGHT;
                        break;
                    case 'B':
                        resArr[currArrIndex] = Piece.Pieces.WBISHOP;
                        break;
                    case 'R':
                        resArr[currArrIndex] = Piece.Pieces.WROOK;
                        break;
                    case 'Q':
                        resArr[currArrIndex] = Piece.Pieces.WQUEEN;
                        break;
                    default:
                        break;
                }
                currArrIndex++;
            }
        }
        for (int j = 0; j < 64; j++) {
            BoardUtil.Square[j] = resArr[j]; 
        }
    }
}

