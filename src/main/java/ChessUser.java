package main.java;

import java.util.Scanner;

import main.java.ChessPiece.ChessPieceColor;
import main.java.ChessPiece.ChessPieceType;

public class ChessUser {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		// Read the board
		int boardSize = 8;
		
		ChessBoard board = new ChessBoard(boardSize);

		// Skip first line
		// in.nextLine();
		
		for (int i = 0; i < boardSize; i += 1) {
			for (int j = 0; j < boardSize; j += 1) {
				String encodedPiece = in.next();
				if (encodedPiece.equals("--")) {
					continue;
				}
				String color = String.valueOf(encodedPiece.charAt(0));
				String type = String.valueOf(encodedPiece.charAt(1));
				int pos = i * boardSize + j;
				
				/*System.out.println("Color: " + color);
				System.out.println("Type: " + type);
				System.out.println("Pos: " + pos);*/
				
				ChessPiece piece = ChessPieceFactory.getChessPiece(ChessPieceType.fromString(type),
						ChessPieceColor.fromString(color), pos, board);
				board.addPiece(piece);
			}
		}
		
		System.out.println("Read board state");
		
		board.printBoardState();
		// in.nextLine();
		
		while (true) {
			try {
				String pieceType = in.next();
				String fromEncoded = in.next();
				String toEncoded = in.next();
				
				int from = Integer.parseInt(fromEncoded.charAt(0) + "") * boardSize + Integer.parseInt(fromEncoded.charAt(1) + "");
				int to = Integer.parseInt(toEncoded.charAt(0) + "") * boardSize + Integer.parseInt(toEncoded.charAt(1) + "");

				System.out.println("Moving piece " + pieceType + " from " + from + " to " + to);
				ChessPiece piece = board.getPieceAt(from);
				board.move(piece, from, to);
				board.printBoardState();
				
			} catch (OutOfBoundsException e) {
				System.out.println("Out of chess board move");
			} catch (InvalidMoveException e) {
				System.out.println("Invalid move");
			}
			
		}
	}
}
