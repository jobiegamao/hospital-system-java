
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class homepage extends JFrame {
	public int i = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		JButton btn1 = new JButton("");
		JButton btn2_AddNewPatient = new JButton("Add New Patient Record");
		JButton btn3_AddDiagnosis = new JButton("Add Diagnosis Information");
		JButton btn4_FullHistory = new JButton("Full History of Patient");
		JButton btn5_UpdateRec = new JButton("Update Patient Record");
		JButton btn6_HospInfo = new JButton("Hospital Information");
		JButton btn7_Logout = new JButton("Logout");
		private final JButton button = new JButton("Close");
		private final JLabel lblNewLabel = new JLabel("");
		private about aboutPanel;
			
		

		
		
	/**
	 * Create the frame.
	 */
		
	public homepage() {
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //center 
		contentPane = new JPanel();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
		//pack();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true); //no x min max button
		toBack();
		
		
		btn1.setBounds(58, 36, 66, 62);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //move buttons 
				if(i == 0) {
					btn2_AddNewPatient.setLocation(150, 30);
					btn3_AddDiagnosis.setLocation(450, 30);
					btn4_FullHistory.setLocation(150, 100);
					btn5_UpdateRec.setLocation(450, 100);
					btn6_HospInfo.setLocation(750, 30);
					btn7_Logout.setLocation(750, 100);
					i=1;
				}
				else {
					btn2_AddNewPatient.setBounds(58, 134, 259, 62);
					btn3_AddDiagnosis.setBounds(58, 232, 259, 62);
					btn4_FullHistory.setBounds(58, 330, 259, 62);
					btn5_UpdateRec.setBounds(58, 428, 259, 62);
					btn6_HospInfo.setBounds(58, 526, 259, 62);
					btn7_Logout.setBounds(58, 624, 259, 62);
					i=0;
				}
			}
		});
		contentPane.setLayout(null);
		
		
		
		
		
		btn1.setForeground(Color.DARK_GRAY);
		btn1.setBackground(Color.GRAY);
		btn1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btn1.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/bin/HMS ICON/two arrow.png"));
		contentPane.add(btn1);
		btn2_AddNewPatient.setBounds(58, 134, 259, 62);
		btn2_AddNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addPatientRec().setVisible(true);
	
			}
		});
		
		
		btn2_AddNewPatient.setForeground(Color.DARK_GRAY);
		btn2_AddNewPatient.setBackground(Color.GRAY);
		btn2_AddNewPatient.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/bin/HMS ICON/add new patient.png"));
		btn2_AddNewPatient.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(btn2_AddNewPatient);
		btn3_AddDiagnosis.setBounds(58, 232, 259, 62);
		btn3_AddDiagnosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addDiagnosis().setVisible(true);
				
			}
		});
		
		
		btn3_AddDiagnosis.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/bin/HMS ICON/add diag.png"));
		btn3_AddDiagnosis.setForeground(Color.DARK_GRAY);
		btn3_AddDiagnosis.setBackground(Color.GRAY);
		btn3_AddDiagnosis.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(btn3_AddDiagnosis);
		btn4_FullHistory.setBounds(58, 330, 259, 62);
		btn4_FullHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new fullHistoryofPatient().setVisible(true);
			}
		});
		
		
		btn4_FullHistory.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/bin/HMS ICON/rsz_history1.png"));
		btn4_FullHistory.setForeground(Color.DARK_GRAY);
		btn4_FullHistory.setBackground(Color.GRAY);
		btn4_FullHistory.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(btn4_FullHistory);
		btn5_UpdateRec.setBounds(58, 428, 259, 62);
		btn5_UpdateRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdatePatientRec().setVisible(true);
			}
		});
		
		
		btn5_UpdateRec.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/bin/HMS ICON/rsz_update_details.png"));
		btn5_UpdateRec.setForeground(Color.DARK_GRAY);
		btn5_UpdateRec.setBackground(Color.GRAY);
		btn5_UpdateRec.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(btn5_UpdateRec);
		btn6_HospInfo.setBounds(58, 526, 259, 62);
		
		btn6_HospInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new about().setVisible(true);
				
			}
		});
		
		
		btn6_HospInfo.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/bin/HMS ICON/rsz_hospital_information.png"));
		btn6_HospInfo.setForeground(Color.DARK_GRAY);
		btn6_HospInfo.setBackground(Color.GRAY);
		btn6_HospInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(btn6_HospInfo);
		btn7_Logout.setBounds(58, 624, 259, 62);
		
		
		btn7_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you want to Logout?","Select", JOptionPane.YES_NO_OPTION);
				
				if(a==0) {
					setVisible(false);
					//new loginpage().setVisible(true);
					loginpage.main(null); // call main method from another class
					
				}
			}
		});
		btn7_Logout.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/bin/HMS ICON/exit.png"));
		btn7_Logout.setForeground(Color.DARK_GRAY);
		btn7_Logout.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btn7_Logout.setBackground(Color.GRAY);
		contentPane.add(btn7_Logout);
		button.setBounds(75, 813, 218, 42);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Do you want to close the application?","Select", JOptionPane.YES_NO_OPTION);
				
				if(a==0) {
					System.exit(0);
				}
			}
		});
		button.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		
		contentPane.add(button);
		
		lblNewLabel.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/src/HMS ICON/bcg home.png"));
		lblNewLabel.setBounds(0, 0, (int)screenSize.getWidth(),(int)screenSize.getHeight());
		contentPane.add(lblNewLabel);
		
		
	}

}
