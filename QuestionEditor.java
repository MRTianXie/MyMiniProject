package miniProject;

import java.awt.Color;
import java.io.*;
import javax.swing.*;

public class QuestionEditor extends JFrame{
	
	public QuestionEditor() throws Exception {
		super("Question Editor");
		JTabbedPane tabPan = new JTabbedPane();
		tabPan.setTabPlacement(JTabbedPane.LEFT);
		tabPan.setBackground(Color.WHITE);
		tabPan.setForeground(Color.BLUE);
		
		PreviewPanel previewPan = new PreviewPanel();
		tabPan.add("Preview", previewPan);
		
		TrueFalsePanel trueFalsePan = new TrueFalsePanel();
		tabPan.add("True-False", trueFalsePan);
		
		MultipleChoicePanel multiChoicePan = new MultipleChoicePanel();
		tabPan.add("Multiple Choice", multiChoicePan);
		
		MatchingPanel matchingPan = new MatchingPanel();
		tabPan.add("Matching", matchingPan);
		
		NumericalPanel numericalPan = new NumericalPanel();
		tabPan.add("Numerical", numericalPan);
		
		ShortAnswerPanel shortAnswerPan = new ShortAnswerPanel();
		tabPan.add("Short Answer", shortAnswerPan);
		
		MissingWordPanel missingWordPan = new MissingWordPanel();
		tabPan.add("Missing Word", missingWordPan);
		
		File myText = new File("test.txt");
		if(!myText.exists()) {
			try {
				myText.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		setContentPane(tabPan);
		setSize(800, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}