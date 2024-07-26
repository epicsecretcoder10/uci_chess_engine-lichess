package ChessBoardPackage;

import java.util.Stack;

public class ChessBoardWithUndo {

    // Class to represent a move
    static class Move {
        int fromRow, fromCol;
        int toRow, toCol;
        String capturedPiece;

        Move(int fromRow, int fromCol, int toRow, int toCol, String capturedPiece) {
            this.fromRow = fromRow;
            this.fromCol = fromCol;
            this.toRow = toRow;
            this.toCol = toCol;
            this.capturedPiece = capturedPiece;
        }
    }

    public static void main(String[] args) {
        // Initialize the chess board
        String[][] board = new String[8][8];

        // Set up the black pieces
        board[0] = new String[]{"r", "n", "b", "q", "k", "b", "n", "r"};
        board[1] = new String[]{"p", "p", "p", "p", "p", "p", "p", "p"};

        // Set up the white pieces
        board[7] = new String[]{"R", "N", "B", "Q", "K", "B", "N", "R"};
        board[6] = new String[]{"P", "P", "P", "P", "P", "P", "P", "P"};

        // Set up the empty squares
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = " ";
            }
        }

        // Print the initial board
        System.out.println("Initial Board:");
        printBoard(board);

        // Stack to store moves for undo functionality
        Stack<Move> moveHistory = new Stack<>();

        // Move a piece (example: move white pawn from e2 to e4)
        System.out.println("\nAfter moving a piece:");
        movePiece(board, moveHistory, 6, 4, 4, 4);  // Move piece from (6, 4) to (4, 4)
        printBoard(board);

        // Undo the move
        System.out.println("\nAfter undoing the move:");
        undoMove(board, moveHistory);
        printBoard(board);
    }

    public static void movePiece(String[][] board, Stack<Move> moveHistory, int fromRow, int fromCol, int toRow, int toCol) {
        // Check if the move is within board limits
        if (isWithinBoardLimits(fromRow, fromCol) && isWithinBoardLimits(toRow, toCol)) {
            // Capture the piece at the destination, if any
            String capturedPiece = board[toRow][toCol];

            // Record the move in the move history stack
            moveHistory.push(new Move(fromRow, fromCol, toRow, toCol, capturedPiece));

            // Move the piece
            board[toRow][toCol] = board[fromRow][fromCol];
            board[fromRow][fromCol] = " ";  // Empty the original square
        } else {
            System.out.println("Move out of board limits!");
        }
    }

    public static void undoMove(String[][] board, Stack<Move> moveHistory) {
        // Check if there is a move to undo
        if (!moveHistory.isEmpty()) {
            // Pop the last move from the stack
            Move lastMove = moveHistory.pop();

            // Restore the piece to its original position
            board[lastMove.fromRow][lastMove.fromCol] = board[lastMove.toRow][lastMove.toCol];

            // Restore the captured piece, if any
            board[lastMove.toRow][lastMove.toCol] = lastMove.capturedPiece;
        } else {
            System.out.println("No move to undo!");
        }
    }

    public static boolean isWithinBoardLimits(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public static void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

