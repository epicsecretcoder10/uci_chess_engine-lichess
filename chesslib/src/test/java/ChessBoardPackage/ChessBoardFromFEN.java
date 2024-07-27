package ChessBoardPackage;

public class ChessBoardFromFEN {

    public static void main(String[] args) {
        // Example FEN string
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

        // Initialize the chess board
        String[][] board = new String[8][8];

        // Load the position from FEN
        loadPositionFromFEN(board, fen);

        // Print the loaded board
        System.out.println("Board loaded from FEN:");
        printBoard(board);
    }

    public static void loadPositionFromFEN(String[][] board, String fen) {
        String[] parts = fen.split(" ");
        String piecePlacement = parts[0];
        String[] ranks = piecePlacement.split("/");

        for (int i = 0; i < ranks.length; i++) {
            String rank = ranks[i];
            int fileIndex = 0;

            for (char c : rank.toCharArray()) {
                if (Character.isDigit(c)) {
                    int emptySquares = Character.getNumericValue(c);
                    for (int j = 0; j < emptySquares; j++) {
                        board[i][fileIndex] = " ";
                        fileIndex++;
                    }
                } else {
                    board[i][fileIndex] = String.valueOf(c);
                    fileIndex++;
                }
            }
        }
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


