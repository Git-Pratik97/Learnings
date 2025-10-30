package designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

class Piece{
     private String name;
     private String position;

     public Piece(String name, String position){
         this.name = name;
         this.position = position;
     }

     public String getName() {
         return name;
     }

     public String getPosition(){
         return position;
     }

     @Override
     public String toString() {
         return "Piece{" +
                 "name='" + name + '\'' +
                 ", position='" + position + '\'' +
                 '}';
     }
 }

 class Chessboard{
     private List<Piece> pieces = new ArrayList<>();

     public void addPiece(Piece piece){
         pieces.add(piece);
     }

     public List<Piece> getPieces(){
         return pieces;
     }

     public void showBoardState() {
         for(Piece piece : pieces){
             System.out.println(piece);
         }
     }
 }

public class ChessGameWITHOUTPrototype {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        chessboard.addPiece(new Piece("Rook", "a3"));
        chessboard.addPiece(new Piece("Bishop","c5"));
        chessboard.showBoardState();

        Chessboard copiedBoard = new Chessboard();
        for(Piece piece : chessboard.getPieces()) {
            copiedBoard.addPiece(new Piece(piece.getName(), piece.getPosition()));
        }

        System.out.println("Copied Board");
        copiedBoard.showBoardState();
    }
}
