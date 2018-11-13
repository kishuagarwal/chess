package main.java;

public class HorseChessPiece extends ChessPiece {

	public HorseChessPiece(int pos, ChessPieceColor color, ChessBoard board) {
		super(pos, color, board);
		this.setChessPieceType(ChessPieceType.HORSE);
	}

	@Override
	public boolean isValidMove(int nextPos) throws OutOfBoundsException {
		super.isValidMove(nextPos);
		
		PositionDiff diff = this.getBoard().getPositionDiff(this.getPosition(), nextPos);
		
		// Horizontal 2, vertical 1
		if (diff.getHorizontalDiff() == 2 && diff.getVerticalDiff() == 1) {
			return true;
		}
		
		// Horizontal 1, vertical 2
		if (diff.getHorizontalDiff() == 1 && diff.getVerticalDiff() == 2) {
			return true;
		}

		return false;
	}

}
