import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
	
	private JFrame frame = new JFrame();
	
	private JPanel leftSide = new JPanel();
	private JPanel rightSide = new JPanel();
	private JPanel rlBorder = new JPanel();
	
	private JPanel titlePanel = new JPanel();
	private JLabel title = new JLabel();
	
	private JPanel gameStatusPanel = new JPanel();
	private JButton restartButton = new JButton();
	private JButton backButton = new JButton();
	private JLabel gameStatus = new JLabel();
	
	private JButton box0 = new JButton();
	private JButton box1 = new JButton();
	private JButton box2 = new JButton();
	private JButton box3 = new JButton();
	private JButton box4 = new JButton();
	private JButton box5 = new JButton();
	private JButton box6 = new JButton();
	private JButton box7 = new JButton();
	private JButton box8 = new JButton();
	
	private JButton[] boxes = new JButton[9];
	
	private int[] xBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int[] oBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	private String playerTurn;
	private String winner = "";
	
	TicTacToe() {
		//Put all Game Boxes into Array for quick access
		boxes[0] = box0;
		boxes[1] = box1;
		boxes[2] = box2;
		boxes[3] = box3;
		boxes[4] = box4;
		boxes[5] = box5;
		boxes[6] = box6;
		boxes[7] = box7;
		boxes[8] = box8;
		
		//Set up TitlePanel and GameStatusPanel
		title.setText("Tic Tac Toe");
		title.setForeground(Color.black);
		title.setBackground(Color.white);
		title.setFont(new Font("MV Boli", Font.BOLD, 80));
		
		titlePanel.setBounds(0, 0, 550, 200);
		titlePanel.setBackground(Color.white);
		
		gameStatus.setBounds(300, 380, 210, 80);
		gameStatus.setFont(new Font("MV Boli", Font.PLAIN, 60));
		gameStatus.setForeground(Color.black);
		gameStatus.setBackground(Color.white);
		
		randomPlayer();
		
		restartButton.setBounds(20, 280, 240, 80);
		restartButton.setText("Restart");
		restartButton.setFont(new Font("MV Boli", Font.PLAIN, 35));
		restartButton.setFocusable(false);
		restartButton.addActionListener(this);
		
		backButton.setBounds(20, 380, 240, 80);
		backButton.setText("Back to Hub");
		backButton.setFont(new Font("MV Boli", Font.PLAIN, 35));
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		
		gameStatusPanel.setBounds(0, 200, 550, 484);
		gameStatusPanel.setBackground(Color.white);
		gameStatusPanel.setLayout(null);
		
		//Set up LeftSide
		leftSide.setLayout(null);
		leftSide.setBounds(0, 0, 550, 684);
		
		//Setup Game Boxes
		for(JButton i : boxes) {
			i.setFont(new Font("MV Boli", Font.PLAIN, 200));
			i.setFocusable(false);
			i.addActionListener(this);
		}
		
		//Set up RightSide
		rightSide.setLayout(new GridLayout(3, 3));
		rightSide.setBounds(560, 0, 707, 684);
		
		//Set up Center Border
		rlBorder.setBounds(550, 0, 10, 684);
		rlBorder.setBackground(Color.black);
		
		//Set Up Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic Tac Toe");
		frame.setLayout(null);
		frame.setSize(1280, 720);
		frame.setResizable(false);
		
		//Add Labels and Buttons to LeftSide Panels
		titlePanel.add(title);
		gameStatusPanel.add(gameStatus);
		gameStatusPanel.add(restartButton);
		gameStatusPanel.add(backButton);
		
		//Add Panels to LeftSide
		leftSide.add(titlePanel);
		leftSide.add(gameStatusPanel);
		
		//Add Game Buttons to RightSide
		for(JButton i : boxes) {
			rightSide.add(i);
		}
		
		//Add the LeftSide, RightSide, and Center Panels to Frame
		frame.add(leftSide);
		frame.add(rightSide);
		frame.add(rlBorder);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		for(int i = 0; i < 9; i++) {
			if(e.getSource() == this.boxes[i]) {
				if(board[i] == 0 && playerTurn == "X") {
					boxes[i].setText("X");
					xBoard[i] = 1;
					board[i] = 1;
					playerTurn = "O";
					gameStatus.setText("O Turn");
					checkBoard();
				}
				else if(board[i] == 0 && playerTurn == "O") {
					boxes[i].setText("O");
					oBoard[i] = 1;
					board[i] = 1;
					playerTurn = "X";
					gameStatus.setText("X Turn");
					checkBoard();
				}
			}
		}
		
		if(e.getSource() == restartButton) {
			randomPlayer();
			winner = "";
			xBoard = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
			oBoard = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
			board = new int [] {0, 0, 0, 0, 0, 0, 0, 0, 0};
			
			for(JButton i : boxes) {
				i.setText("");
			}
		}
		
		if(e.getSource() == backButton) {
			frame.dispose();
			new GameHub();
		}
		
	}
	
	void randomPlayer() {
		if(winner == "X") {
			playerTurn = "O";
			gameStatus.setText("O Turn");
		}
		
		else if(winner == "O") {
			playerTurn = "X";
			gameStatus.setText("X Turn");
		}
		
		else {
			Random random = new Random();
			double x = random.nextDouble(1);

			if(x < 0.5) {
				playerTurn = "X";
				gameStatus.setText("X Turn");
			}
			
			else {
				playerTurn = "O";
				gameStatus.setText("O Turn");
			}
		}
	}
	
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
		winner = "X";
		board = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
	}
	
	void OWinner() {
		gameStatus.setText("O Win");
		winner = "O";
		board = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
	}
	
	void Draw() {
		gameStatus.setText("Draw");
		board = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
	}
}
