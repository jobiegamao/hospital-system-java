import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class about extends JPanel {

	private JPanel contentPane;
	private JButton button;


	/**
	 * Create the frame.
	 */
	public about() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		button = new JButton("Close");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		contentPane.add(button, BorderLayout.SOUTH);
		
		add(contentPane);
	}

}
