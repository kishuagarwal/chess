package main.java;

public class PawnChessPiece extends ChessPiece {

	public PawnChessPiece(int position, ChessPieceColor color, ChessBoard board) {
		super(position, color, board);
		this.setChessPieceType(ChessPieceType.PAWN);
	}

	@Override
	public boolean isValidMove(int nextPos) throws OutOfBoundsException {
		super.isValidMove(nextPos);
		
		PositionDiff diff = this.getBoard().getPositionDiff(this.getPosition(), nextPos);
		
		// One move
		if (diff.getHorizontalDiff() == 0 && diff.getVerticalDiff() == 1) {
			return true;
		}
		
		// Capture
		if (diff.getHorizontalDiff() == 1 && diff.getVerticalDiff() == 1) {
			ChessPiece nextPiece = this.getBoard().getPieceAt(nextPos);
			if (nextPiece != null && !this.getColor().color.equals(nextPiece.getColor().color)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

}
