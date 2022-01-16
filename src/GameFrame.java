import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class GameFrame extends BackFrame implements ActionListener {
	
	GameFrame() {
		
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
		
		//Set up TitlePanel, RestartPanel, and GameStatusPanel
		title.setText("Tic Tac Toe");
		title.setForeground(Color.black);
		title.setBackground(Color.white);
		title.setFont(new Font("MV Boli", Font.BOLD, 85));
		title.setOpaque(true);
		
		titlePanel.setBounds(0, 0, 560, 500);
		titlePanel.setBackground(Color.white);
		
		gameStatus.setBounds(300, 80, 220, 80);
		gameStatus.setFont(new Font("MV Boli", Font.PLAIN, 60));
		gameStatus.setForeground(Color.black);
		gameStatus.setBackground(Color.white);
		gameStatus.setOpaque(true);
		
		//Random PlayerTurn Generator
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
		
		restartButton.setBounds(20, 80, 240, 80);
		restartButton.setText("Restart");
		restartButton.setFont(new Font("MV Boli", Font.PLAIN, 35));
		restartButton.setFocusable(false);
		restartButton.addActionListener(this);
		
		restartPanel.setBounds(0, 500, 560, 184);
		restartPanel.setBackground(Color.white);
		restartPanel.setLayout(null);
		
		//Set up LeftSide
		leftSide.setLayout(null);
		leftSide.setBounds(0, 0, 560, 684);
		
		for(JButton i : boxes) {
			i.setFont(new Font("MV Boli", Font.PLAIN, 200));
			i.setFocusable(false);
			i.addActionListener(this);
		}
		
		//Set up RightSide
		rightSide.setLayout(new GridLayout(3, 3));
		rightSide.setBounds(560, 0, 707, 684);
		
		//Set Up Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tic Tac Toe");
		frame.setLayout(null);
		frame.setSize(1280, 720);
		frame.setResizable(false);
		
		//Add Labels and Buttons to LeftSide Panels
		titlePanel.add(title);
		restartPanel.add(gameStatus);
		restartPanel.add(restartButton);
		
		//Add Panels to LeftSide
		leftSide.add(titlePanel);
		leftSide.add(restartPanel);
		
		//Add Game Buttons to RightSide
		for(JButton i : boxes) {
			rightSide.add(i);
		}
		
		//Add the LeftSide and RightSide Panels to Frame
		frame.add(leftSide);
		frame.add(rightSide);
		
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
			frame.dispose();
			new GameFrame();
		}
	}
}
