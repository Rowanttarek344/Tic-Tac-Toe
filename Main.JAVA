package gamee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Tic Tac Toe game!");
        
        TicTacToe board =new TicTacToe();
        board.initializeBoard();
        board.printBoard();
        board.checkForWin();
        board.play();

	}

}
