package MinMax;

import chesslib.*;

public class MinMax {
    // Infinity placeholder to return on checkmate
    public static final int INFINITY = 1000000000;
    public static final int MAX_DEPTH = 1;

    public static void main(String[] args) {
        Board board = new Board("1k6/8/1K6/8/8/6p1/6Q1/8 w - - 0 1");
        MoveValue solution = minmax(1, board, true);
        System.out.println("Best move: " + solution.move.toString());
        System.out.println("Value: " + solution.value);
    }

    public static class MoveValue {
        public Move move;
        public int value;

        public MoveValue(Move move, int value) {
            this.move = move;
            this.value = value;
        }
    }

    public static MoveValue minmax(int depth, Board board, boolean isMaximising) {
        if (depth == 0) {
            return new MoveValue(null, evaluate(board));
        } else {
            Move bestMove = null;
            int bestValue = isMaximising ? -INFINITY : INFINITY;
            for (Move move : board.legalMoves()) {
                board.doMove(move);
                MoveValue result = minmax(depth - 1, board, !isMaximising);
                board.undoMove();
                if (isMaximising) {
                    if (result.value > bestValue) {
                        bestValue = result.value;
                        bestMove = move;
                    }
                } else {
                    if (result.value < bestValue) {
                        bestValue = result.value;
                        bestMove = move;
                    }
                }
            }
            return new MoveValue(bestMove, bestValue);
        }
    }

    public static int evaluate(Board board) {
        if (isCheckmate(board)) {
            if (board.getSideToMove() == Side.WHITE) {
                return -INFINITY;
            } else {
                return INFINITY;
            }
        }
        int materialPoints = 0;
        for (com.github.bhlangonijr.chesslib.Piece piece : board.getPieces()) {
            if (piece.isWhite()) {
                materialPoints += getPieceValue(piece.getType());
            } else {
                materialPoints -= getPieceValue(piece.getType());
            }
        }
        return materialPoints;
    }

    private static int getPieceValue(com.github.bhlangonijr.chesslib.Piece.Type type) {
        switch (type) {
            case PAWN:
                return 1;
            case KNIGHT:
                return 3;
            case BISHOP:
                return 3;
            case ROOK:
                return 5;
            case QUEEN:
                return 9;
            default:
                return 0;
        }
    }

    public static boolean isCheckmate(Board board) {
        if (!board.isKingInCheck()) {
            return false;
        }
        return board.legalMoves().size() == 0;
    }
}