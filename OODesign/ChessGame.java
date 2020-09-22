package OODesign;

import java.lang.invoke.SwitchPoint;
import java.util.Collections;
import java.util.List;

enum GameStatus {
    ACTIVE, WHITE_WIN, BLACK_WIN, STALEMATE, RESIGNATION
}

class Spot {
    private Piece piece;
    private int x;
    private int y;

    public Spot(int x, int y, Piece piece) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

abstract class Piece {
    private boolean white = false;
    private boolean killed = false;

    public boolean isWhite() {
        return this.white == true;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isKilled() {
        return this.killed == true;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public Piece(boolean white) {
        this.setWhite(white);

    }

    public abstract boolean canMove(Board board, Spot start, Spot end);
}

class King extends Piece {
    private boolean castlingDone = false;

    public boolean isCastlingDone() {
        return this.castlingDone == true;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1) {
            // check if this move will not result in the king
            // being attacked if so return true
            return true;

        }


        return this.isValidCastling(board, start, end);
    }

    private boolean isValidCastling(Board board, Spot start, Spot end) {
        if (this.isCastlingDone())
            return false;

//        Logic for return true or false;
        return false;
    }

    public boolean isCastlingMove(Spot start, Spot end) {
        // check if the starting and
        // ending position are correct
        return false;
    }
}

class Knight extends Piece {
    public Knight(boolean white) {
        super(white);

    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x * y == 2;
    }
}

class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);

    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}

class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);

    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}

class Rook extends Piece {
    public Rook(boolean white) {
        super(white);

    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }
}

class Board {
    Spot[][] boxes;

    public Spot[][] getBoxes() {
        return boxes;
    }

    public void setBoxes(Spot[][] boxes) {
        this.boxes = boxes;
    }

    public Board() {
        this.resetBoard();
    }
    public Spot getBox(int x,int y) throws Exception {
        if(x<0||y<0||x>7||y>7){
            throw new Exception("Index out of bounds Exception");
        }
        return boxes[x][y];
    }

    public void resetBoard() {
//    initialise white pieces
        boxes[0][4] = new Spot(0, 4, new King(true));
        boxes[0][1] = new Spot(0, 1, new Knight(true));
        boxes[0][2] = new Spot(0, 2, new Bishop(true));
        //...
        boxes[1][0] = new Spot(1, 0, new Pawn(true));
        boxes[1][1] = new Spot(1, 1, new Pawn(true));
        //...

        // initialize black pieces
        boxes[7][0] = new Spot(7, 0, new Rook(false));
        boxes[7][1] = new Spot(7, 1, new Knight(false));
        boxes[7][2] = new Spot(7, 2, new Bishop(false));
        //...
        boxes[6][0] = new Spot(6, 0, new Pawn(false));
        boxes[6][1] = new Spot(6, 1, new Pawn(false));

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }
    }

}

abstract class Player {
    public boolean whiteSide;
    public boolean humanPlayer;

    public boolean isWhiteSide() {
        return this.whiteSide == true;
    }

    public void setWhiteSide(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }

    public boolean isHumanPlayer() {
        return this.humanPlayer == true;
    }

    public void setHumanPlayer(boolean humanPlayer) {
        this.humanPlayer = humanPlayer;
    }
}

class HumanPlayer extends Player {
    public HumanPlayer(boolean whiteside) {
        this.whiteSide = whiteside;
        this.humanPlayer = true;

    }
}
class ComputerPlayer extends Player {
    public ComputerPlayer(boolean whiteside) {
        this.whiteSide = whiteside;
        this.humanPlayer = false;

    }
}

class Move {
    private Player player;
    private Spot start;
    private Spot end;
    private Piece pieceMoved;
    private Piece killed;
    private boolean castlingMove = false;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Spot getStart() {
        return start;
    }

    public void setStart(Spot start) {
        this.start = start;
    }

    public Spot getEnd() {
        return end;
    }

    public void setEnd(Spot end) {
        this.end = end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getKilled() {
        return killed;
    }

    public void setKilled(Piece killed) {
        this.killed = killed;
    }

    public Move(Player player, Spot start, Spot end){
        this.player = player;
        this.start = start;
        this.end = end;
    }

    public boolean isCastlingMove() {
        return this.castlingMove==true;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }
}

public class ChessGame {
    private Player[] players;
    private Board board;
    private Player currplayerTurn;
    private GameStatus gameStatus;
    private List<Move> movesPlayed;

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrplayerTurn() {
        return currplayerTurn;
    }

    public void setCurrplayerTurn(Player currplayerTurn) {
        this.currplayerTurn = currplayerTurn;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMovesPlayed() {
        return movesPlayed;
    }

    public void setMovesPlayed(List<Move> movesPlayed) {
        this.movesPlayed = movesPlayed;
    }
    public boolean isEnd(){
        return this.gameStatus != GameStatus.ACTIVE;
    }
    public void initialise(Board board, Player p1, Player p2){
        players[0]=p1;
        players[1]=p2;
        board.resetBoard();
        if(p1.isWhiteSide()){
            this.currplayerTurn = p1;
        }else {
            this.currplayerTurn = p2;
        }
        movesPlayed.clear();
    }
    public boolean playerMove(Player player,int startX,int startY,int endX,int endY) throws Exception {
        Spot startBox = board.getBox(startX,startY);
        Spot endBox = board.getBox(endX,endY);
        Move move = new Move(player,startBox,endBox);
        return this.makeMove(move,player);
    }
    public boolean makeMove(Move move,Player player){
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) {
            return false;
        }

        // valid player
        if (player != currplayerTurn) {
            return false;
        }

        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            return false;
        }

        // valid move?
        if (!sourcePiece.canMove(board, move.getStart(),
                move.getEnd())) {
            return false;
        }

        // kill?
        Piece destPiece = move.getStart().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setKilled(destPiece);
        }

        // castling?
        if (sourcePiece != null && sourcePiece instanceof King
                && ((King) sourcePiece).isCastlingDone()) {
            move.setCastlingMove(true);
        }

        // store the move
        movesPlayed.add(move);

        // move piece from the stat box to end box
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (destPiece != null && destPiece instanceof King) {
            if (player.isWhiteSide()) {
                this.setGameStatus(GameStatus.WHITE_WIN);
            }
            else {
                this.setGameStatus(GameStatus.BLACK_WIN);
            }
        }

        // set the current turn to the other player
        if (this.currplayerTurn == players[0]) {
            this.currplayerTurn = players[1];
        }
        else {
            this.currplayerTurn = players[0];
        }

        return true;

    }
}
