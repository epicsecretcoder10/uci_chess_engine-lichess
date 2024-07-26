package ChessBoardPackage;

public class ChessBoardWithFEN {

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

        // Generate the FEN string
        String fen = generateFEN(board, 'w', true, true, true, true, "-", 0, 1);
        System.out.println("FEN String: " + fen);
    }

    public static String generateFEN(String[][] board, char activeColor, boolean whiteKingSideCastle, boolean whiteQueenSideCastle, boolean blackKingSideCastle, boolean blackQueenSideCastle, String enPassantTarget, int halfmoveClock, int fullmoveNumber) {
        StringBuilder fen = new StringBuilder();

        // Piece placement
        for (int i = 0; i < 8; i++) {
            int emptyCount = 0;
            for (int j = 0; j < 8; j++) {
                String piece = board[i][j];
                if (piece.equals(" ")) {
                    emptyCount++;
                } else {
                    if (emptyCount > 0) {
                        fen.append(emptyCount);
                        emptyCount = 0;
                    }
                    fen.append(piece);
                }
            }
            if (emptyCount > 0) {
                fen.append(emptyCount);
            }
            if (i < 7) {
                fen.append("/");
            }
        }

        // Active color
        fen.append(" ").append(activeColor);

        // Castling availability
        StringBuilder castling = new StringBuilder();
        if (whiteKingSideCastle) castling.append("K");
        if (whiteQueenSideCastle) castling.append("Q");
        if (blackKingSideCastle) castling.append("k");
        if (blackQueenSideCastle) castling.append("q");
        if (castling.length() == 0) castling.append("-");
        fen.append(" ").append(castling);

        // En passant target square
        fen.append(" ").append(enPassantTarget);

        // Halfmove clock
        fen.append(" ").append(halfmoveClock);

        // Fullmove number
        fen.append(" ").append(fullmoveNumber);

        return fen.toString();
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

