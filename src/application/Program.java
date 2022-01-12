package application;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMath;
import chess.ChessPiece;
import chess.ChessPosition;


public class Program {

	public static void main(String[] args) {
		ChessMath chessMath = new ChessMath();
		List<ChessPiece>captured = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				UI.clearScreen();
				
				UI.printMatch(chessMath,captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMath.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMath.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMath.performChessMove(source, target);
				if(captured != null) {
					captured.add(capturedPiece);
				}
			
			
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();				
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
	}
		

	

}
