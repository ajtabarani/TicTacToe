import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameHub implements ActionListener {
	private JFrame frame = new JFrame();
	private JPanel leftSide = new JPanel();
	private JPanel rightSide = new JPanel();
	private JPanel rlBorder = new JPanel();
	
	private JPanel titlePanel = new JPanel();
	private JLabel title = new JLabel();
	
	private JPanel gameStatusPanel = new JPanel();
	private JLabel nameCredits = new JLabel();
	
	private JPanel rTop = new JPanel();
	private JLabel chooseGameHeader = new JLabel();

	private JPanel rBottom = new JPanel();
	private JButton ticTacToeButton = new JButton();
	private JButton snakeButton = new JButton();
	
	private JButton[] gameListButtons = new JButton[2];
	
	GameHub() {
		gameListButtons[0] = ticTacToeButton;
		gameListButtons[1] = snakeButton;
		
		//Set up TitlePanel and GameStatusPanel
		title.setText("Game Hub");
		title.setForeground(Color.black);
		title.setBackground(Color.white);
		title.setFont(new Font("MV Boli", Font.BOLD, 80));
		
		titlePanel.setBounds(0, 0, 550, 200);
		titlePanel.setBackground(Color.white);
		
		nameCredits.setBounds(50, 380, 450, 80);
		nameCredits.setText("By AJ Tabarani");
		nameCredits.setFont(new Font("MV Boli", Font.PLAIN, 60));
		nameCredits.setForeground(Color.black);
		nameCredits.setBackground(Color.white);
		
		gameStatusPanel.setLayout(null);
		gameStatusPanel.setBounds(0, 200, 550, 484);
		gameStatusPanel.setBackground(Color.white);
		
		//Set up LeftSide
		leftSide.setLayout(null);
		leftSide.setBounds(0, 0, 550, 684);
		
		//Set up RightSide Panels
		chooseGameHeader.setBounds(0, 0, 720, 200);
		chooseGameHeader.setText("Choose Game");
		chooseGameHeader.setFont(new Font("MV Boli", Font.PLAIN, 60));
		chooseGameHeader.setHorizontalAlignment(JLabel.CENTER);
		chooseGameHeader.setVerticalAlignment(JLabel.BOTTOM);
		chooseGameHeader.setForeground(Color.black);
		chooseGameHeader.setBackground(Color.white);
		
		rTop.setBounds(0, 0, 720, 200);
		rTop.setBackground(Color.white);
		rTop.setLayout(null);
		
		for(JButton i : gameListButtons) {
			i.setPreferredSize(new Dimension(240, 80));
			i.setFont(new Font("MV Boli", Font.PLAIN, 35));
			i.setFocusable(false);
			i.addActionListener(this);
		}
		
		ticTacToeButton.setText("Tic Tac Toe");
		snakeButton.setText("Snake");
		
		rBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		rBottom.setBounds(200, 200, 320, 484);
		rBottom.setBackground(Color.white);
		
		//Set up RightSide
		rightSide.setLayout(null);
		rightSide.setBounds(560, 0, 707, 684);
		rightSide.setBackground(Color.white);
		
		//Set up Center Border
		rlBorder.setBounds(550, 0, 10, 684);
		rlBorder.setBackground(Color.black);
		
		//Set Up Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Game Hub");
		frame.setLayout(null);
		frame.setSize(1280, 720);
		frame.setResizable(false);
		
		//Add Labels and Buttons to LeftSide Panels
		titlePanel.add(title);
		gameStatusPanel.add(nameCredits);
		
		//Add Panels to LeftSide
		leftSide.add(titlePanel);
		leftSide.add(gameStatusPanel);
		
		//Add Game Buttons to rightSide Center and Top Panels
		rTop.add(chooseGameHeader);
		rBottom.add(ticTacToeButton);
		rBottom.add(snakeButton);
		
		//Add Game Buttons to RightSide
		rightSide.add(rTop);
		rightSide.add(rBottom);
		
		//Add the LeftSide, RightSide, and Center Panels to Frame
		frame.add(leftSide);
		frame.add(rightSide);
		frame.add(rlBorder);
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ticTacToeButton) {
			frame.dispose();
			new TicTacToe();
		}
	}
}
