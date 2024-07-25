package ChessBoardPackage;

public class ChessBoardBasics {

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

        // Move a piece (example: move white pawn from e2 to e4)
        System.out.println("\nAfter moving a piece:");
        movePiece(board, 6, 4, 4, 4);  // Move piece from (6, 4) to (4, 4)
        printBoard(board);
    }

    public static void movePiece(String[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        // Check if the move is within board limits
        if (isWithinBoardLimits(fromRow, fromCol) && isWithinBoardLimits(toRow, toCol)) {
            // Move the piece
            board[toRow][toCol] = board[fromRow][fromCol];
            board[fromRow][fromCol] = " ";  // Empty the original square
        } else {
            System.out.println("Move out of board limits!");
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





