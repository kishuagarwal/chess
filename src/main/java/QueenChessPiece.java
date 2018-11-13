package main.java;

public class QueenChessPiece extends ChessPiece {

	public QueenChessPiece(int position, ChessPieceColor color, ChessBoard board) {
		super(position, color, board);
		this.setChessPieceType(ChessPieceType.QUEEN);
	}

	@Override
	public boolean isValidMove(int nextPos) throws OutOfBoundsException {
		if (!super.isValidMove(nextPos)) {
			return false;
		}
		
		PositionDiff diff = this.getBoard().getPositionDiff(this.getPosition(), nextPos);
		int boardSize = this.getBoard().getBoardSize();
		
		// Horizontal or vertical
		if (diff.getHorizontalDiff() == 0 && diff.getVerticalDiff() > 0) {
			for (int i = this.getPosition() + boardSize; i < nextPos; i += boardSize) {
				if (this.getBoard().getPieceAt(i) != null) {
					return false;
				}
			}
		}
		
		if (diff.getVerticalDiff() == 0 && diff.getHorizontalDiff() > 0) {
			for (int i = this.getPosition() + 1; i < nextPos; i += 1) {
				if (this.getBoard().getPieceAt(i) != null) {
					return false;
				}
			}
			return true;
		}
		
		// Diagonal
		if (diff.getHorizontalDiff() == diff.getVerticalDiff()) {
			// TODO
			for (int i = this.getPosition() + boardSize + 1; i < nextPos; i += boardSize + 1) {
				if (this.getBoard().getPieceAt(i) != null) {
					return false;
				}
			}
			return true;
		}
		
		return false;
	}
	
}
