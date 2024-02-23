package JChess;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ChessBoard extends JFrame implements MouseListener {

    JLabel label;
    Image offScreenImage;
    Graphics offScreenGraphics;

    public static boolean isHighlighted = false;
    public static int highlightedRow = -1;
    public static int highlightedCol = -1;

    public static final Color DarkWood = new Color(133,94,66);
    public static final Color Tan = new Color(210, 180, 140);
    public static final Color Highlight = new Color(248,222,127);

    ChessBoard() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        label = new JLabel ();
        label.setBounds(0, 0, 800, 800);
        label.addMouseListener(this);

        add(label);
    }


    public void drawPieces (Graphics g, String FEN) {
        Graphics2D g2D = (Graphics2D) g;
        int rankCount = 0;
        int row = 0;
        for (int i = 0; i < FEN.length(); i++) {
            char currChar = FEN.charAt(i);
            if (currChar == '/') {
                rankCount += 1;
                row = 0;
            }
            else if (Character.isDigit(currChar)) {
                row += Character.getNumericValue(currChar);
            }
            else {
                switch (currChar) {
                    case 'r':
                        g2D.drawImage(Piece.BR, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    case 'n':
                        g2D.drawImage(Piece.BKN, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    case 'b':
                        g2D.drawImage(Piece.BB, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    case 'q':
                        g2D.drawImage(Piece.BQ, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    case 'k':
                        g2D.drawImage(Piece.BKI, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    case 'p':
                        g2D.drawImage(Piece.BP, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    case 'R':
                        g2D.drawImage(Piece.WR, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    case 'N':
                        g2D.drawImage(Piece.WKN, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    case 'B':
                        g2D.drawImage(Piece.WB, row*100, rankCount*100, 
                                        100, 100, null);
                        break; 
                    case 'Q':
                        g2D.drawImage(Piece.WQ, row*100, rankCount*100,
                                        100, 100, null);
                        break;
                    case 'K':
                        g2D.drawImage(Piece.WKI, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    case 'P':
                        g2D.drawImage(Piece.WP, row*100, rankCount*100, 
                                        100, 100, null);
                        break;
                    default:
                        System.out.println("FEN String Error");
                        break;
                }
                row += 1;
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (offScreenImage == null) {
            offScreenImage = createImage(getWidth(), getHeight());
            offScreenGraphics = offScreenImage.getGraphics();
        }

        offScreenGraphics.setColor(getBackground());
        offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                boolean isLightSquare = (rank + file) % 2 != 0;

                if (file == highlightedRow && rank == highlightedCol) {
                    offScreenGraphics.setColor(Highlight);
                    offScreenGraphics.fillRect(rank * 100, file * 100, 100, 100);
                } else if (isLightSquare) {
                    offScreenGraphics.setColor(DarkWood);
                    offScreenGraphics.fillRect(rank * 100, file * 100, 100, 100);
                } else {
                    offScreenGraphics.setColor(Tan);
                    offScreenGraphics.fillRect(rank * 100, file * 100, 100, 100);
                }
            }
        }

        drawPieces(offScreenGraphics, BoardUtil.currFEN);

        // Draw the off-screen image to the screen
        g.drawImage(offScreenImage, 0, 0, this);
    }

    int i = 0;
    public void mouseClicked (MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        isHighlighted = true;
        highlightedRow = mouseY / 100;
        highlightedCol = mouseX / 100;
        repaint();
    }

    public void mousePressed (MouseEvent e) {

    }

    public void mouseReleased (MouseEvent e) {

    }

    public void mouseEntered (MouseEvent e) {

    }

    public void mouseExited (MouseEvent e) {

    }

}



