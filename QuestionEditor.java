package miniProject;

import java.awt.Color;
import javax.swing.*;

public class QuestionEditor extends JFrame{
	
	public QuestionEditor() {
		super("Question Editor");
		JTabbedPane tabPan = new JTabbedPane();
		tabPan.setTabPlacement(JTabbedPane.LEFT);
		tabPan.setBackground(Color.WHITE);
		tabPan.setForeground(Color.BLUE);
		
		TrueFalsePanel trueFalsePan = new TrueFalsePanel();
		tabPan.add("True-False", trueFalsePan);
		
		MultipleChoicePanel multiChoicePan = new MultipleChoicePanel();
		tabPan.add("Multiple Choice", multiChoicePan);
		
		MatchingPanel matchingPan = new MatchingPanel();
		tabPan.add("Matching", matchingPan);
		
		setContentPane(tabPan);
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}