package ChessBoardPackage;

import com.github.bhlangonijr.chesslib.move.MoveList;

public class MoveListMethod {

    public static void main(String[] args) {
        String san = "e4 Nc6 d4 Nf6 d5 Ne5 Nf3 d6 Nxe5 dxe5 Bb5+ Bd7 Bxd7+ Qxd7 Nc3 e6 O-O exd5 ";
        MoveList list = new MoveList();
        list.loadFromSan(san);

        System.out.println("FEN of final position: " + list.getFen());
    }
}
