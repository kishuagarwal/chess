package main.java;

import main.java.ChessPiece.ChessPieceColor;
import main.java.ChessPiece.ChessPieceType;

public class ChessPieceFactory {

	public static ChessPiece getChessPiece(ChessPieceType pieceType, ChessPieceColor color, int pos, ChessBoard board) {
		if (pieceType.type == ChessPieceType.QUEEN.type) {
			System.out.println("Creating queen");
			return new QueenChessPiece(pos, color, board);
		} else if (pieceType.type == ChessPieceType.HORSE.type) {
			return new HorseChessPiece(pos, color, board);
		} else if (pieceType.type == ChessPieceType.PAWN.type) {
			return new PawnChessPiece(pos, color, board);
		}
		else {
			System.out.println("Invalid Chess piece type");
			return null;
		}	
	}
}
