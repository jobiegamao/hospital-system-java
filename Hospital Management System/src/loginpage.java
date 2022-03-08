import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField Username_Field;
	private JPasswordField Password_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName()  );//put in try and catch for gui components to work in apple
					loginpage frame = new loginpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginpage() {
		
		
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/may/eclipse-workspace/Hospital Management System/HMS ICON/login Background final.PNG"));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setBounds(0, 0, 780, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		setUndecorated(true);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(429, 110, 145, 28);
		contentPane.add(lblNewLabel_1);
	
		
		JLabel lblNewLabel = new JLabel("Login to your account");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 36));
		lblNewLabel.setBounds(388, 21, 386, 42);
		getContentPane().add(lblNewLabel);
		
		Username_Field = new JTextField();
		Username_Field.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Username_Field.setBounds(429, 140, 319, 36);
		getContentPane().add(Username_Field);
		Username_Field.setColumns(10);
		
		Password_Field = new JPasswordField();
		Password_Field.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Password_Field.setBounds(429, 225, 319, 36);
		getContentPane().add(Password_Field);
		
		JButton LoginBtn = new JButton("Login");
		
		
		
		LoginBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(Username_Field.getText().equals("admin") && Password_Field.getText().equals("admin")) {
					setVisible(false);
					new homepage().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect username or password");
				}
				
			}
		});
		LoginBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		LoginBtn.setBounds(477, 315, 218, 42);
		LoginBtn.setBackground(Color.blue);
		contentPane.add(LoginBtn);
		
		
		JButton CloseBtn = new JButton("Close");
		CloseBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
	
		CloseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you want to close the application?","Select", JOptionPane.YES_NO_OPTION);
				
				if(a==0) {
					System.exit(0);
				}
			}
		});
		CloseBtn.setBounds(477, 383, 218, 42);
		getContentPane().add(CloseBtn);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Password");
		lblNewLabel_1_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(429, 196, 145, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel bcg = new JLabel("");
		bcg.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/src/HMS ICON/login bcg (1).png"));
		bcg.setBounds(0, -13, 798, 523);
		getContentPane().add(bcg);
		
		
	}
}
