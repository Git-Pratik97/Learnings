package designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

class PiecePrototype {
    private String name;
    private String position;

    public PiecePrototype(String name, String position){
        this.name = name;                   //Can have expensive validations
        this.position = position;           //Can have expensive validations
    }

    public PiecePrototype(PiecePrototype piecePrototype){       //Lightweight Constructor used for cloning
                                                                //Without any validation or checks
        this.name = piecePrototype.getName();
        this.position = piecePrototype.getPosition();
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "PiecePrototype{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public PiecePrototype clone() throws CloneNotSupportedException {   //Creating a deep copy of a
                                                                        // piece using lightweight constructor
        return new PiecePrototype(this);
    }
}

class ChessBoardPrototype{
    private List<PiecePrototype> piecePrototypeList = new ArrayList<>();

    public void addPiece(PiecePrototype piecePrototype){
        piecePrototypeList.add(piecePrototype);
    }

    public List<PiecePrototype> getPiecePrototypeList(){
        return piecePrototypeList;
    }

    public void showBoardState() {
        for(PiecePrototype piecePrototype : piecePrototypeList){
            System.out.println(piecePrototype);
        }
    }

    public ChessBoardPrototype clone() throws CloneNotSupportedException {
        ChessBoardPrototype clonedBoard = new ChessBoardPrototype();
        for(PiecePrototype piecePrototype : piecePrototypeList){
            clonedBoard.addPiece(piecePrototype.clone());
        }
        return clonedBoard;
    }
}

public class ChessGameWITHPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        ChessBoardPrototype chessBoardPrototype = new ChessBoardPrototype();
        chessBoardPrototype.addPiece(new PiecePrototype("Rook", "a3"));
        chessBoardPrototype.addPiece(new PiecePrototype("Bishop", "c5"));
        chessBoardPrototype.showBoardState();

        //Saving the state
        ChessBoardPrototype copiedBoard = chessBoardPrototype.clone();

        System.out.println("Copied Board");
        copiedBoard.showBoardState();
    }
}
