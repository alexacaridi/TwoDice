/*Java Final Project
Filename: TwoDiceGUI.java
Alexa Caridi 3/4/2020*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener
{
    //instance objects/variables & constants for this class
    JLabel title = new JLabel("Two Dice");
    JLabel firstRoll = new JLabel("First Die Roll is:         ");
    JLabel secondRoll = new JLabel("Second Die Roll is:    ");
    JLabel firstResult = new JLabel("");
    JLabel secondResult = new JLabel("");
    JLabel summary = new JLabel("");
    //create the panels to store first roll and result together, and second roll and result together
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    //create the button object
    JButton button = new JButton("Click to Play!");
    //create a font object
    Font bigFont = new Font("Times New Roman", Font.BOLD, 55);
    Font smallFont = new Font("Century", Font.BOLD, 16);
    Font buttonFont = new Font("Century", Font.BOLD, 12);
    //create color objects
    Color navyC = new Color(13, 31, 99);
    Color lightBlueC = new Color(194, 233, 234);
    Color blueC = new Color(166, 194, 234);
    Color lightGrayC = new Color(244, 244, 244);

    //constructor for the TwoDiceGUI class
    public TwoDiceGUI()
    {
        //use JFrame constructor to construct THIS object
        super("Two Dice");
        setBounds(550, 250, 280, 225); //set to center my screen and fits game to window with no extra space
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //layout manager for the GUI
        setLayout(new FlowLayout());

        //set fonts
        title.setFont(bigFont);
        firstRoll.setFont(smallFont);
        firstResult.setFont(smallFont);
        secondRoll.setFont(smallFont);
        secondResult.setFont(smallFont);
        summary.setFont(smallFont);
        button.setFont(buttonFont);

        //set colors
        getContentPane().setBackground(navyC);
        title.setForeground(lightBlueC);
        firstRoll.setForeground(blueC);
        secondRoll.setForeground(blueC);
        firstResult.setForeground(Color.WHITE);
        secondResult.setForeground(Color.WHITE);
        button.setForeground(navyC);
        button.setBackground(lightGrayC);
        summary.setForeground(lightBlueC);

        //set dimensions for the JLabel results to assure an equal distance
        firstResult.setPreferredSize(new Dimension(90,15));
        secondResult.setPreferredSize(new Dimension(91,15));

        //add instance objects to the frame
        add(title);
        add(firstRoll);
        add(firstResult);
        add(secondRoll);
        add(secondResult);
        add(button);
        add(summary);

        //add the listener method to the button
        button.addActionListener(this);
    }

    //actionPerformed method details what should happen when the ActionListener button is clicked on
    @Override
    public void actionPerformed(ActionEvent e)
    {
        playGame(); //run a method that will generate the results of the game
    }

    //method that handles the actual game TwoDiceGUI
    public void playGame()
    {
        // objects 
		Die firstDie = new Die();
		Die secondDie = new Die();
		
		// variables and constants
		int value1 = firstDie.getValue();
		int value2 = secondDie.getValue();
		String msg;
		
		// calculation phase
		if(value1 == value2)
		{
			msg = "The dice are a match!";
		}
		else
		{
			if(value1 > value2)
			{
				msg = "First die roll is greater.";
			}
			else
			{
				msg = "Second die roll is greater.";
			}
		}
		
        // output phase
        firstResult.setText(Integer.toString(value1));
        secondResult.setText(Integer.toString(value2));
		summary.setText(msg);
    }

    //main method to start the application which in turn creates an object from the TwoDiceGUI class
    public static void main(String[] args)
    {
        TwoDiceGUI game = new TwoDiceGUI();
        game.setVisible(true);
    }
}