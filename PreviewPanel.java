package miniProject;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class PreviewPanel extends JPanel {
	public PreviewPanel() {
		super(new MigLayout("filly","[grow]"));
		
		JButton btnView = new JButton("View/Refresh");
		add(btnView, "wrap");
		
		add(new JLabel("Questions View"), "wrap");
		final JTextArea txtQuestions = new JTextArea(14, 8);
		JScrollPane scroll = new JScrollPane(txtQuestions);
		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll, "growx, wrap");
		
		JButton btnSave = new JButton("Save to test file");
		add(btnSave);
	}
}
