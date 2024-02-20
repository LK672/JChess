package JChess;
import java.awt.*;

import javax.swing.ImageIcon;

public final class Piece {

    public static int None = 0;
    public static int King = 1;
    public static int Pawn = 2;
    public static int Knight = 3;
    public static int Bishop = 4;
    public static int Rook = 5;
    public static int Queen = 6;

    public static int White = 8;
    public static int Black = 16;

    public static Image BB = new ImageIcon("JChess/BlackBishop.png").getImage();
    public static Image BKI = new ImageIcon("JChess/BlackKing.png").getImage();
    public static Image BKN = new ImageIcon("JChess/BlackKnight.png").getImage();
    public static Image BP = new ImageIcon("JChess/BlackPawn.png").getImage();
    public static Image BQ = new ImageIcon("JChess/BlackQueen.png").getImage();
    public static Image BR = new ImageIcon("JChess/BlackRook.png").getImage();

    public static Image WB = new ImageIcon("JChess/WhiteBishop.png").getImage();
    public static Image WKI = new ImageIcon("JChess/WhiteKing.png").getImage();
    public static Image WKN = new ImageIcon("JChess/WhiteKnight.png").getImage();
    public static Image WP = new ImageIcon("JChess/WhitePawn.png").getImage();
    public static Image WQ = new ImageIcon("JChess/WhiteQueen.png").getImage();
    public static Image WR = new ImageIcon("JChess/WhiteRook.png").getImage();
    
}
