package JChess;
import java.awt.*;
import javax.swing.ImageIcon;

public final class Piece {

    public static enum Pieces {
        
        NONE,
        BKING,
        BPAWN,
        BKNIGHT,
        BBISHOP,
        BROOK,
        BQUEEN,

        WKING,
        WPAWN,
        WKNIGHT,
        WBISHOP,
        WROOK,
        WQUEEN,

    }

    public static Image BB = new ImageIcon("JChess/Images/BlackBishop.png").getImage();
    public static Image BKI = new ImageIcon("JChess/Images/BlackKing.png").getImage();
    public static Image BKN = new ImageIcon("JChess/Images/BlackKnight.png").getImage();
    public static Image BP = new ImageIcon("JChess/Images/BlackPawn.png").getImage();
    public static Image BQ = new ImageIcon("JChess/Images/BlackQueen.png").getImage();
    public static Image BR = new ImageIcon("JChess/Images/BlackRook.png").getImage();

    public static Image WB = new ImageIcon("JChess/Images/WhiteBishop.png").getImage();
    public static Image WKI = new ImageIcon("JChess/Images/WhiteKing.png").getImage();
    public static Image WKN = new ImageIcon("JChess/Images/WhiteKnight.png").getImage();
    public static Image WP = new ImageIcon("JChess/Images/WhitePawn.png").getImage();
    public static Image WQ = new ImageIcon("JChess/Images/WhiteQueen.png").getImage();
    public static Image WR = new ImageIcon("JChess/Images/WhiteRook.png").getImage();
    
}
