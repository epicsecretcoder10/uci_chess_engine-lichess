import java.util.List;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Side;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.Piece;

public class ChessEngine {

    public static void main(String[] args) {
        Board board = new Board();
        int x = evaluate(board);
        System.out.println(x);
    }

    public static int evaluate(Board board) {
        return getMaterial(board);
    }

    public static int getMaterial(Board board) {
        Square[] allSquares = Square.values();
        for (Square square : allSquares) {
            int totalValue = 0;
            if (square != Square.NONE) {
                Piece occupiedPiece = board.getPiece(square);
                if (occupiedPiece.getPieceType() != null) {
                    totalValue += getPieceValue(occupiedPiece);
                }
            }
        }
        return totalValue;
    }
    public static int getPieceValue(Piece piece) {
        int value = 0;
        switch (piece.getPieceType()) {
            case "PAWN":
                value = 100;
                break;
            case "KNIGHT":
                value = 300;
                break;
            case "BISHOP":
                value = 300;
                break;
            case "ROOK":
                value = 500;
                break;
            case "QUEEN":
                value = 900;
                break;
        }
    
        if (piece.getPieceSide() == "WHITE") {
            return value;
        } else if (piece.getPieceSide() == "BLACK") {
            return -value;
        } else {
            // handle the case where piece.getPieceSide() is null (e.g., for Piece.NONE)
            throw new IllegalArgumentException("Invalid piece side");
        }
    }
}