package JChess;

public final class BoardUtil {

    public static Piece.Pieces[] Square; {
        Square = new Piece.Pieces[64];
    }

    public static String currFEN; {
    //TODO: add difference for starting as white or black
    currFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
    }

    public static int GetIndex (int row, int col) {

        return 8*row + col;

    }
    public static int GetRow (int index) {

        return index / 8;

    }
    public static int GetCol (int index) {

        return index % 8;
    }
    public static void ArrToFEN (int[] arr) {

        int drow = 0;
        String res = "";
        for (int i  = 0; i < 64; i++) {
            if (i % 8 == 0 && i != 0) {
                res += "/";
                drow = 0;
            }
            if (Square[i] == Piece.Pieces.NONE) {
                drow += 1;
            }
            else {
                String shift = "";
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
                switch (Square[i]) {
                    case BKING:
                        res += shift;
                        res += 'k';
                        break;
                    case Piece.Pieces.BPAWN:
                        res += shift;
                        res += 'p';
                        break;
                    case Piece.Pieces.BKNIGHT:
                        res += shift;
                        res += 'n';
                        break;
                    case Piece.Pieces.BBISHOP:
                        res += shift;
                        res += 'b';
                        break;
                    case Piece.Pieces.BROOK:
                        res += shift;
                        res += 'r';
                        break;
                    case Piece.Pieces.BQUEEN:
                        res += shift;
                        res += 'q';
                        break;

                    case Piece.Pieces.WKING:
                        res += shift;
                        res += 'K';
                        break;
                    case Piece.Pieces.WPAWN:
                        res += shift;
                        res += 'P';
                        break;
                    case Piece.Pieces.WKNIGHT:
                        res += shift;
                        res += 'N';
                        break;
                    case Piece.Pieces.WBISHOP:
                        res += shift;
                        res += 'B';
                        break;
                    case Piece.Pieces.WROOK:
                        res += shift;
                        res += 'R';
                        break;
                    case Piece.Pieces.WQUEEN:
                        res += shift;
                        res += 'Q';
                        break;
                    default:
                        res += "";
                        break;

                }
            }
        }
        currFEN = res;
    }
    public static void FENToARR (String FEN) {
        Piece.Pieces[] resArr = new Piece.Pieces[64];
        int i = 0;
        while (i < FEN.length()) {
            char currChar = FEN.charAt(i);
            if (Character.isDigit(currChar)) {
                i += Character.getNumericValue(currChar);
                continue;
            }
            else if (Character.isAlphabetic(currChar)) {
                switch (currChar) {
                    case 'k':
                        resArr[i] = Piece.Pieces.BKING;
                        break;
                    case 'p':
                        resArr[i] = Piece.Pieces.BPAWN;
                        break;
                    case 'n':
                        resArr[i] = Piece.Pieces.BKNIGHT;
                        break;
                    case 'b':
                        resArr[i] = Piece.Pieces.BBISHOP;
                        break;
                    case 'r':
                        resArr[i] = Piece.Pieces.BROOK;
                        break;
                    case 'q':
                        resArr[i] = Piece.Pieces.BQUEEN;
                        break;
                    
                    case 'K':
                        resArr[i] = Piece.Pieces.WKING;
                        break;
                    case 'P':
                        resArr[i] = Piece.Pieces.WPAWN;
                        break;
                    case 'N':
                        resArr[i] = Piece.Pieces.WKNIGHT;
                        break;
                    case 'B':
                        resArr[i] = Piece.Pieces.WBISHOP;
                        break;
                    case 'R':
                        resArr[i] = Piece.Pieces.WROOK;
                        break;
                    case 'Q':
                        resArr[i] = Piece.Pieces.WQUEEN;
                        break;
                    default:
                        break;
                }
            }
            i += 1;
        }
        for (int j = 0; j < 64; j++) {
            System.out.println(resArr[j]);
            BoardUtil.Square[i] = resArr[j]; 
        }
    }
}

