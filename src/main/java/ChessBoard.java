package main.java;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
	private int boardSize;
	private Map<Integer, ChessPiece> boardState; 
	
	public ChessBoard(int boardSize) {
		this.boardSize= boardSize;
		this.boardState = new HashMap<Integer, ChessPiece>();
	}
	
	public void addPiece(ChessPiece piece) {
		this.boardState.put(piece.getPosition(), piece);
	}
	
	private void checkBounds(int pos) throws OutOfBoundsException {
		// Check whether pos lying within the bounds of the board
		if (pos < 0 || pos >= boardSize * boardSize) {
			throw new OutOfBoundsException();
		}
	}
	
	public ChessPiece getPieceAt(int pos) throws OutOfBoundsException {
		checkBounds(pos);
		return boardState.get(pos);
	}
	
	public PositionDiff getPositionDiff(int from, int to) {
		int fromRow = from / this.boardSize;
		int fromCol = from % this.boardSize;
		
		int toRow = to / this.boardSize;
		int toCol = to % this.boardSize;
		
		int horizontalDiff = Math.abs(toCol - fromCol);
		int verticalDiff = Math.abs(toRow - fromRow);
		
		return new PositionDiff(horizontalDiff, verticalDiff);
	}	
		
	public void move(ChessPiece piece, int from, int to) throws InvalidMoveException, OutOfBoundsException {
		checkBounds(from);
		checkBounds(to);
		
		// If the piece is not at the starting position, then it's a invalid move
		if (piece.getPosition() != from) {
			throw new InvalidMoveException();
		}
		
		if (piece.isValidMove(to)) {
			piece.moveTo(to);
			this.boardState.remove(from);
			
			// Also captures the target piece;
			this.boardState.put(to, piece);
		} else {
			throw new InvalidMoveException();
		}
	}
	
	public int getBoardSize() {
		return this.boardSize;
	}
	
	public void printBoardState() {
		for (int i = 0; i < this.boardSize * this.boardSize; i += 1) {
			if (i % this.boardSize == 0) {
				System.out.println();
			}
			if (this.boardState.get(i) == null) {
				System.out.print("-- "); 
			} else {
				System.out.print(this.boardState.get(i) + " ");
			}
		}
	}
}
