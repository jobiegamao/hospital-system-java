import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


import net.proteanit.sql.DbUtils;

public class UpdatePatientRec extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txt_Surname;
	private JTextField txt_Fname;
	private JTextField txt_Mname;
	private JLabel lblAge;
	private JLabel lblAddress;
	private JTextField txt_age;
	private JTextField txt_address;
	private JLabel lblNewLabel_1;
	private JLabel lblSurname_1;
	private JLabel lblNewLabel_1_3;
	private JTextField txt_contactNo;
	private JTextField txt_contPersNo;
	private JLabel lblBloodGroup;
	private JTextField txt_Bloodtype;
	private JLabel lbllongtext;
	private JLabel lblGender;
	private JButton btnUpdate;
	private JButton button_1;
	private JButton btnSearch;
	private JTextArea txt_diseases;
	private JTextField txt_contPerson;
	private JTextField txt_gender;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePatientRec frame = new UpdatePatientRec();
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
	public UpdatePatientRec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		setAlwaysOnTop(true);
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		setBounds((int)screenSize.getWidth()-1000,(int)screenSize.getHeight()-720, 860, 700);
		setBounds(800,250,860,700);
		
		txt_contPersNo = new JTextField();
		txt_contPersNo.setBounds(432, 291, 181, 26);
		txt_contPersNo.setColumns(10);
		contentPane.add(txt_contPersNo);
		
		lblNewLabel_1_3 = new JLabel("Contact Person No.");
		lblNewLabel_1_3.setBounds(432, 265, 181, 19);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_3);
		
		txt_address = new JTextField();
		txt_address.setBounds(243, 230, 370, 30);
		txt_address.setColumns(10);
		contentPane.add(txt_address);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(243, 208, 59, 19);
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblAddress);
		
		txt_Mname = new JTextField();
		txt_Mname.setBounds(432, 172, 181, 26);
		txt_Mname.setColumns(10);
		contentPane.add(txt_Mname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Middlename");
		lblNewLabel_1_1_1.setBounds(432, 148, 90, 19);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_1_1);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = txtID.getText();
				try (Connection conn = Main.ConnectDb();){
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * from Patient where id='"+ID+"'");
					
					if(rs.next()) {
						txtID.setEditable(false);
						txt_Surname.setText(rs.getString(2));
						txt_Fname.setText(rs.getString(3));
						txt_Mname.setText(rs.getString(4));
						txt_age.setText(rs.getString(5));
						txt_gender.setText(rs.getString(6));
						txt_address.setText(rs.getString(7));
						txt_contactNo.setText(rs.getString(8));
						txt_contPerson.setText(rs.getString(9));
						txt_contPersNo.setText(rs.getString(10));
						txt_Bloodtype.setText(rs.getString(11));
						txt_diseases.setText(rs.getString(12));
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Patient ID does not Exist");	
					}
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2);	
				}
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setBounds(55, 108, 91, 19);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(150, 102, 296, 31);
		contentPane.add(txtID);
		txtID.setColumns(10);
		btnSearch.setBounds(454, 102, 159, 31);
		btnSearch.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		btnSearch.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/src/HMS ICON/search.png"));
		contentPane.add(btnSearch);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(55, 148, 66, 19);
		lblSurname.setForeground(Color.BLACK);
		lblSurname.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblSurname);
		
		JLabel lblNewLabel_1_1 = new JLabel("Firstname");
		lblNewLabel_1_1.setBounds(243, 148, 73, 19);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_1);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(55, 208, 91, 19);
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblAge);
		
		txt_Surname = new JTextField();
		txt_Surname.setBounds(55, 172, 184, 26);
		txt_Surname.setColumns(10);
		contentPane.add(txt_Surname);
		
		txt_Fname = new JTextField();
		txt_Fname.setBounds(243, 172, 185, 26);
		txt_Fname.setColumns(10);
		contentPane.add(txt_Fname);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(141, 208, 98, 19);
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblGender);
		
		txt_age = new JTextField();
		txt_age.setBounds(55, 232, 80, 26);
		txt_age.setColumns(10);
		contentPane.add(txt_age);
		
		txt_gender = new JTextField();
		txt_gender.setColumns(10);
		txt_gender.setBounds(141, 232, 99, 26);
		contentPane.add(txt_gender);
		
		lblNewLabel_1 = new JLabel("Contact No.");
		lblNewLabel_1.setBounds(55, 265, 85, 19);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		lblSurname_1 = new JLabel("Contact Person");
		lblSurname_1.setBounds(243, 265, 112, 19);
		lblSurname_1.setForeground(Color.BLACK);
		lblSurname_1.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblSurname_1);
		
		txt_contactNo = new JTextField();
		txt_contactNo.setBounds(55, 289, 184, 26);
		txt_contactNo.setColumns(10);
		contentPane.add(txt_contactNo);
		
		txt_contPerson = new JTextField();
		txt_contPerson.setBounds(243, 289, 185, 26);
		txt_contPerson.setColumns(10);
		contentPane.add(txt_contPerson);
		
		lblBloodGroup = new JLabel("Blood Type");
		lblBloodGroup.setBounds(55, 347, 90, 19);
		lblBloodGroup.setForeground(Color.BLACK);
		lblBloodGroup.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lblBloodGroup);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(55, 661, 373, 29);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
				
				
				
				try (Connection conn = Main.ConnectDb();){
					Statement st = conn.createStatement();
					String query ="Update patient set surname=" + "'" +txt_Surname.getText() + "',Firstname='"  
					+txt_Fname.getText()+"',Middlename='" + txt_Mname.getText()+"',Age='" + txt_age.getText()+"',Gender='" +
					txt_gender.getText()+"',Address='" + txt_address.getText()+"',ContactNo='" + txt_contactNo.getText()+"',ContactPerson='" +
					txt_contPerson.getText()+"',ContactPersonNo='" + txt_contPersNo.getText()+"',Bloodtype='" + txt_Bloodtype.getText()+"',DiseasesBefore='" +
					txt_diseases.getText() + "' where ID ='" + txtID.getText() + "';"; 
					st.executeUpdate(query);
					setVisible(false);
					JOptionPane.showMessageDialog(null,"Record Updated");	
					new UpdatePatientRec().setVisible(true);
					
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2);	
				}
				
			}
		});
		btnUpdate.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		btnUpdate.setBackground(Color.WHITE);
		contentPane.add(btnUpdate);
		
		txt_diseases = new JTextArea();
		txt_diseases.setBounds(55, 444, 558, 184);
		contentPane.add(txt_diseases);
		
		lbllongtext = new JLabel("Any Allergies/Diseases Sufferred Prior");
		lbllongtext.setBounds(55, 410, 373, 19);
		lbllongtext.setHorizontalAlignment(SwingConstants.LEFT);
		lbllongtext.setVerticalAlignment(SwingConstants.TOP);
		lbllongtext.setForeground(Color.BLACK);
		lbllongtext.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		contentPane.add(lbllongtext);
		
		txt_Bloodtype = new JTextField();
		txt_Bloodtype.setBounds(150, 345, 275, 24);
		txt_Bloodtype.setColumns(10);
		contentPane.add(txt_Bloodtype);
		
		button_1 = new JButton("Close");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1.setBounds(432, 662, 108, 29);
		button_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		contentPane.add(button_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/src/HMS ICON/bcg update.png"));
		lblNewLabel_2.setBounds(0, 0, 860, 700);
		contentPane.add(lblNewLabel_2);
	}
}
