
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import java.sql.*;

public class addPatientRec extends JFrame {

	
	
			
	private JPanel contentPane;
	private JTextField txtID;
	private JLabel lblAge;
	private JLabel lblBloodGroup;
	private JLabel lblAddress;
	private JTextField txt_address;
	private JTextField txt_age;
	private JLabel lblNewLabel_1;
	private JLabel lblSurname_1;
	private JTextField txt_contPersNo;
	private JTextField txt_contPerson;
	private JLabel lbllongtext;
	private JTextField txt_Surname;
	private JTextField txt_Fname;
	private JTextField txt_Mname;
	private JTextField txt_Bloodtype;
	private JTextField txt_contactNo;
	private JLabel lblNewLabel_1_3;
	private JLabel lblGender_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
					addPatientRec frame = new addPatientRec();
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
	public addPatientRec() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setUndecorated(true);
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		setBounds((int)screenSize.getWidth()-1000,(int)screenSize.getHeight()-720, 860, 700);
//		setAlwaysOnTop(true);
		setBounds(800,250,860,700);
		
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(205, 158, 90, 19);
		lblSurname.setForeground(Color.BLACK);
		lblSurname.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblSurname);
		
		txt_Surname = new JTextField();
		txt_Surname.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_Surname.setBounds(205, 183, 185, 26);
		txt_Surname.setColumns(10);
		contentPane.add(txt_Surname);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(205, 221, 63, 19);
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblAge);
		
		txt_age = new JTextField();
		txt_age.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_age.setBounds(205, 246, 78, 26);
		txt_age.setColumns(10);
		contentPane.add(txt_age);
		
		lblNewLabel_1 = new JLabel("Contact No.");
		lblNewLabel_1.setBounds(205, 279, 82, 19);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		
		txt_contactNo = new JTextField();
		txt_contactNo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_contactNo.setBounds(205, 304, 185, 26);
		txt_contactNo.setColumns(10);
		contentPane.add(txt_contactNo);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(557, 381, 5, 19);
		lblGender.setForeground(Color.GRAY);
		lblGender.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblGender);
		
		lblBloodGroup = new JLabel("Blood Type");
		lblBloodGroup.setBounds(304, 358, 86, 19);
		lblBloodGroup.setForeground(Color.BLACK);
		lblBloodGroup.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblBloodGroup);
		
		txt_Fname = new JTextField();
		txt_Fname.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_Fname.setBounds(395, 183, 185, 26);
		txt_Fname.setColumns(10);
		contentPane.add(txt_Fname);
		
		JLabel lblNewLabel_1_1 = new JLabel("Firstname");
		lblNewLabel_1_1.setBounds(395, 158, 67, 19);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox comboBox_gender = new JComboBox();
		comboBox_gender.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		comboBox_gender.setBounds(283, 244, 107, 30);
		comboBox_gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		comboBox_gender.setMaximumRowCount(2);
		contentPane.add(comboBox_gender);
		
		lblGender_1 = new JLabel("Gender");
		lblGender_1.setForeground(Color.BLACK);
		lblGender_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		lblGender_1.setBounds(289, 221, 94, 19);
		contentPane.add(lblGender_1);
		
		txt_contPerson = new JTextField();
		txt_contPerson.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_contPerson.setBounds(395, 304, 185, 26);
		txt_contPerson.setColumns(10);
		contentPane.add(txt_contPerson);
		
		lblSurname_1 = new JLabel("Contact Person");
		lblSurname_1.setBounds(395, 279, 106, 19);
		lblSurname_1.setForeground(Color.BLACK);
		lblSurname_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblSurname_1);
		
		lbllongtext = new JLabel("Any Allergies/Diseases Sufferred Prior");
		lbllongtext.setBounds(300, 411, 274, 76);
		lbllongtext.setHorizontalAlignment(SwingConstants.CENTER);
		lbllongtext.setVerticalAlignment(SwingConstants.TOP);
		lbllongtext.setForeground(Color.BLACK);
		lbllongtext.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lbllongtext);
		
		JTextArea txt_diseases = new JTextArea();
		txt_diseases.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_diseases.setBounds(306, 436, 464, 184);
		contentPane.add(txt_diseases);
		
		txt_Bloodtype = new JTextField();
		txt_Bloodtype.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_Bloodtype.setBounds(402, 356, 185, 24);
		txt_Bloodtype.setColumns(10);
		contentPane.add(txt_Bloodtype);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setBounds(205, 95, 66, 19);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtID.setBounds(205, 120, 185, 30);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txt_Mname = new JTextField();
		txt_Mname.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_Mname.setBounds(585, 183, 185, 26);
		txt_Mname.setColumns(10);
		contentPane.add(txt_Mname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Middlename");
		lblNewLabel_1_1_1.setBounds(585, 158, 82, 19);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_1_1);
		
		txt_address = new JTextField();
		txt_address.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_address.setBounds(395, 244, 375, 30);
		txt_address.setColumns(10);
		contentPane.add(txt_address);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(395, 221, 90, 19);
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblAddress);
		
		lblNewLabel_1_3 = new JLabel("Contact Person No.");
		lblNewLabel_1_3.setBounds(585, 279, 185, 19);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		btnSubmit.setBounds(304, 640, 278, 42);
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showMessageDialog(null,"Submitted");
				
				String sql = "INSERT INTO Patient(ID, Surname, Firstname, Middlename,Age,Gender,Address,ContactNo,ContactPerson,ContactPersonNo,Bloodtype,DiseasesBefore)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)"; 
				try (
						Connection conn = Main.ConnectDb();
						PreparedStatement pst =conn.prepareStatement(sql);
					){
					
					
						pst.setString(1,txtID.getText());
						pst.setString(2,txt_Surname.getText());
						pst.setString(3,txt_Fname.getText());
						pst.setString(4,txt_Mname.getText());
						pst.setString(5,txt_age.getText());
						pst.setString(6,(String)comboBox_gender.getSelectedItem());
						pst.setString(7,txt_address.getText());
						pst.setString(8,txt_contactNo.getText());
						pst.setString(9,txt_contPerson.getText());
						pst.setString(10,txt_contPersNo.getText());
						pst.setString(11,txt_Bloodtype.getText());
						pst.setString(12,txt_diseases.getText());
						
						pst.execute();
						//rs.close();
						pst.close();
						conn.close();
						//java.sql.Statement st = con.createStatement();
						//st.executeUpdate("INSERT INTO Patient values('"+a+"', '"+b+"','"+c+"' , '"+d+"','"+m+"','"+f+"' , '"+g+"' , '"+h+"', '"+i+",''"+j+"','"+k+"','"+l+"') ");
						
						JOptionPane.showMessageDialog(null,"Patient Added in Database");
						setVisible(false);
						new addPatientRec().setVisible(true);
					
			
					
					
				} catch (Exception ev) {
					//JOptionPane.showMessageDialog(null, "Please Enter Data Correctly");
				}
				
				
			}
		});
		contentPane.add(btnSubmit);
		
		txt_contPersNo = new JTextField();
		txt_contPersNo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txt_contPersNo.setBounds(585, 303, 185, 26);
		txt_contPersNo.setColumns(10);
		contentPane.add(txt_contPersNo);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnNewButton.setBounds(616, 642, 152, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel bcg = new JLabel("");
		
		bcg.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/src/HMS ICON/bcg new patient.png"));
		bcg.setBounds(0, -12, 953, 729);
		contentPane.add(bcg);
		
	}
}
