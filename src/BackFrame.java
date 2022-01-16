import javax.swing.*;

public class BackFrame {
	
	String playerTurn;
	
	int[] xBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	int[] oBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	JFrame frame = new JFrame();
	
	JPanel leftSide = new JPanel();
	JPanel rightSide = new JPanel();
	
	JPanel titlePanel = new JPanel();
	JLabel title = new JLabel();
	
	JPanel restartPanel = new JPanel();
	JButton restartButton = new JButton();
	JLabel gameStatus = new JLabel();
	
	JButton box0 = new JButton();
	JButton box1 = new JButton();
	JButton box2 = new JButton();
	JButton box3 = new JButton();
	JButton box4 = new JButton();
	JButton box5 = new JButton();
	JButton box6 = new JButton();
	JButton box7 = new JButton();
	JButton box8 = new JButton();
	
	JButton[] boxes = new JButton[9];
	
	void checkBoard() {
		//Check for X Win
		if (xBoard[0] == 1 && xBoard[1] == 1 && xBoard[2] == 1) {
			XWinner();
		}
		else if (xBoard[3] == 1 && xBoard[4] == 1 && xBoard[5] == 1) {
			XWinner();
		}
		else if (xBoard[6] == 1 && xBoard[7] == 1 && xBoard[8] == 1) {
			XWinner();
		}
		else if (xBoard[0] == 1 && xBoard[3] == 1 && xBoard[6] == 1) {
			XWinner();
		}
		else if (xBoard[1] == 1 && xBoard[4] == 1 && xBoard[7] == 1) {
			XWinner();
		}
		else if (xBoard[2] == 1 && xBoard[5] == 1 && xBoard[8] == 1) {
			XWinner();
		}
		else if (xBoard[0] == 1 && xBoard[4] == 1 && xBoard[8] == 1) {
			XWinner();
		}
		else if (xBoard[2] == 1 && xBoard[4] == 1 && xBoard[6] == 1) {
			XWinner();
		}
		
		//Check for O Win
		else if (oBoard[0] == 1 && oBoard[1] == 1 && oBoard[2] == 1) {
			OWinner();
		}
		else if (oBoard[3] == 1 && oBoard[4] == 1 && oBoard[5] == 1) {
			OWinner();
		}
		else if (oBoard[6] == 1 && oBoard[7] == 1 && oBoard[8] == 1) {
			OWinner();
		}
		else if (oBoard[0] == 1 && oBoard[3] == 1 && oBoard[6] == 1) {
			OWinner();
		}
		else if (oBoard[1] == 1 && oBoard[4] == 1 && oBoard[7] == 1) {
			OWinner();
		}
		else if (oBoard[2] == 1 && oBoard[5] == 1 && oBoard[8] == 1) {
			OWinner();
		}
		else if (oBoard[0] == 1 && oBoard[4] == 1 && oBoard[8] == 1) {
			OWinner();
		}
		else if (oBoard[2] == 1 && oBoard[4] == 1 && oBoard[6] == 1) {
			OWinner();
		}
		
		//Check for draw
		else if (board[0] == 1 && board[1] == 1 && board[2] == 1 && board[3] == 1 && board[4] == 1 && board[5] == 1 && board[6] == 1 && board[7] == 1 && board[8] == 1) {
			Draw();
		}
	}
	
	void XWinner() {
		gameStatus.setText("X Win");
		board = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
	}
	
	void OWinner() {
		gameStatus.setText("O Win");
		board = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
	}
	
	void Draw() {
		gameStatus.setText("Draw");
		board = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
	}
}
