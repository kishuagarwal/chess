package main.java;
abstract class ChessPiece {
	public static enum ChessPieceType {
		PAWN("P"),
		ROOK("R"),
		HORSE("H"),
		QUEEN("Q"),
		KING("K"),
		BISHOP("B");
		
		String type;
		
		ChessPieceType(String type) {
			this.type = type;
		}
		
		public static ChessPieceType fromString(String type) {
		    for (ChessPieceType t : ChessPieceType.values()) {
		      if (t.type.equalsIgnoreCase(type)) {
		        return t;
		      }
		    }
		    throw new IllegalArgumentException();
		 }
	}
	
	public static enum ChessPieceColor {
		WHITE("W"),
		BLACK("B");
		
		String color;
		
		ChessPieceColor(String color) {
			this.color = color;
		}
		
		public static ChessPieceColor fromString(String color) {
		    for (ChessPieceColor c : ChessPieceColor.values()) {
		      if (c.color.equalsIgnoreCase(color)) {
		        return c;
		      }
		    }
		    throw new IllegalArgumentException();
		  }
	}
	
	private int position;
	private ChessPieceColor color;
	private ChessPieceType type;
	private ChessBoard board;
	
	public ChessPiece(int position, ChessPieceColor color, ChessBoard board) {
		this.position = position;
		this.color = color;
		this.board = board;
	}

	
	public int getPosition() {
		return position;
	}



	public void setPosition(int position) {
		this.position = position;
	}



	public ChessPieceColor getColor() {
		return color;
	}



	public void setColor(ChessPieceColor color) {
		this.color = color;
	}

	public ChessBoard getBoard() {
		return board;
	}

	public void setBoard(ChessBoard board) {
		this.board = board;
	}

	protected void setChessPieceType(ChessPieceType type) {
		this.type = type;
	}
	
	public boolean isValidMove(int nextPos) throws OutOfBoundsException {
		ChessPiece nextPiece = this.board.getPieceAt(nextPos);
		if (nextPiece != null) {
			if (this.color.color.equals(nextPiece.color.color)) {
				return false;
			}
		}
		
		return true;
	}
	
	public void moveTo(int nextPos) {
		this.position = nextPos;
	}
	
	public String toString() {
		return this.color.color + this.type.type;
	}
}
