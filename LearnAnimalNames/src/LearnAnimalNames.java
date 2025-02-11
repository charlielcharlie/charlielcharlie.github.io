import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


public class LearnAnimalNames extends JFrame {

    private JLabel imageLabel;
    private JPanel buttonPanel;
    private JTextField answerField;
    private JButton submitButton;
    private JButton nextButton;
    private JButton prevButton;
    private JButton homeButton;

    private int currentImageIndex = 0;
    private ImageIcon[] imageIcons;
    private String[] names;

    public LearnAnimalNames() {

        Dimension size = new Dimension(140, 70);
        
        answerField = new JTextField();
        answerField.setPreferredSize(size);
        
        homeButton = new JButton("Home");
        homeButton.setPreferredSize(size);

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(size);
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(size);
        
        prevButton = new JButton("Previous");
        prevButton.setPreferredSize(size);
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK);
        
        
        
        // Array of image files to be displayed
        imageIcons = new ImageIcon[] {
        		new ImageIcon("src/cards/Slide1.jpg"),new ImageIcon("src/cards/Slide2.jpg"),
        		new ImageIcon("src/cards/Slide3.jpg"),new ImageIcon("src/cards/Slide4.jpg"),
        		new ImageIcon("src/cards/Slide5.jpg"),new ImageIcon("src/cards/Slide6.jpg"),
        		new ImageIcon("src/cards/Slide7.jpg"),new ImageIcon("src/cards/Slide8.jpg"),new ImageIcon("src/cards/Slide9.jpg"),
        		new ImageIcon("src/cards/Slide10.jpg"),new ImageIcon("src/cards/Slide11.jpg"),
        		new ImageIcon("src/cards/Slide12.jpg"),new ImageIcon("src/cards/Slide13.jpg"),
        		new ImageIcon("src/cards/Slide14.jpg"),new ImageIcon("src/cards/Slide15.jpg"),
        		new ImageIcon("src/cards/Slide16.jpg"),new ImageIcon("src/cards/Slide17.jpg"),
        		new ImageIcon("src/cards/Slide18.jpg"),new ImageIcon("src/cards/Slide19.jpg"),
        		new ImageIcon("src/cards/Slide20.jpg"),new ImageIcon("src/cards/Slide21.jpg"),
        		new ImageIcon("src/cards/Slide22.jpg"),new ImageIcon("src/cards/Slide23.jpg"),
        		new ImageIcon("src/cards/Slide24.jpg"),new ImageIcon("src/cards/Slide25.jpg"),
        		new ImageIcon("src/cards/Slide26.jpg"),new ImageIcon("src/cards/Slide27.jpg"),
        		new ImageIcon("src/cards/Slide28.jpg"),new ImageIcon("src/cards/Slide29.jpg"),
        		new ImageIcon("src/cards/Slide30.jpg")
        		
        };
        
        
     
        
        // Array of animal names to validate spelling
        names = new String[] {
        		"cat","cat","dog","dog","fox","fox","owl","owl","bat","bat","bear","bear","lion","lion","wolf","wolf","goat","goat",
        		"deer","deer","fish","fish","horse","horse","tiger","tiger","sloth","sloth","ottor","ottor"
        		
        	
        		
        		
        		
        };
        
        //Set first image to be displayed
        imageLabel = new JLabel(imageIcons[currentImageIndex]);

        // Set up the JFrame
        setTitle("Learn Animal Names");
		setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
		setLayout(new BorderLayout());

		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		buttonPanel.add(homeButton);
		buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(answerField);
        buttonPanel.add(submitButton);

        // Load the first image and question
        imageLabel = new JLabel(imageIcons[currentImageIndex]);

        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        pack();



        // Add action listeners for the buttons
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextCard();
            }
        });
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevCard();
            }
        });
        
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeCard();
            }
        });

       
    }


    //Function to check answer if answer is correct
    private void checkAnswer() {
        String userAnswer = answerField.getText();
        if (userAnswer.equalsIgnoreCase(names[currentImageIndex])) {
            JOptionPane.showMessageDialog(this, "Correct!");
            answerField.setText("");
            currentImageIndex = (currentImageIndex + 1) % imageIcons.length;
        	imageLabel.setIcon(imageIcons[currentImageIndex]);
            
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect.");
            answerField.setText("");

        }
    }

    // Button functionality
    private void nextCard() {
    	currentImageIndex = (currentImageIndex + 1) % imageIcons.length;
    	imageLabel.setIcon(imageIcons[currentImageIndex]);
        
    }

    private void prevCard() {
    	if (currentImageIndex <= 0) {
    		currentImageIndex = 30;
    		currentImageIndex = (currentImageIndex - 1) % imageIcons.length;
    	}
    	else {
    		currentImageIndex = (currentImageIndex - 1) % imageIcons.length;
    	}
    	imageLabel.setIcon(imageIcons[currentImageIndex]);


    }
    
    private void homeCard() {
    	currentImageIndex = 0 % imageIcons.length;
    	imageLabel.setIcon(imageIcons[currentImageIndex]);


    }
        
    //Run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LearnAnimalNames());
    }
}
