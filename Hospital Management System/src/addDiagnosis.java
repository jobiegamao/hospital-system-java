
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import javax.swing.JScrollPane;

public class addDiagnosis extends JFrame {
	
	
	public int flag = 0;
	private JPanel contentPane;
	private JLabel lblPatientId;
	private JTextField textField;
	private JTable table;
	private JButton btnSearch;
	private JLabel lblPatientIdnotfound;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblSymptoms;
	private JLabel lblDiagnosis;
	private JLabel lblMedicines;
	private JLabel lblTypeOfRoom;
	private JLabel lblRoomRequired;
	private JCheckBox chckbxYes;
	private JComboBox comboBox;
	private JButton btnClose;
	private JButton btnSave;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
					addDiagnosis frame = new addDiagnosis();
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
	public addDiagnosis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//setAlwaysOnTop(true);
		
		
		lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(27, 29, 295, 43);
		lblPatientId.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		contentPane.add(lblPatientId);
		
		textField = new JTextField();
		textField.setBounds(27, 77, 318, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idString = textField.getText();
				
				String sql= "SELECT * FROM Patient WHERE ID='" + idString + "';";
				Connection conn =null;
				Statement st = null;
				ResultSet rs = null;
				try{
					 conn = Main.ConnectDb();
					  st  = conn.createStatement();  
		              rs  = st.executeQuery(sql); 
		              	 
		              
		              if(!rs.isBeforeFirst()) { //if query result is empty
			        	 lblPatientIdnotfound.setVisible(true);
			        	 
			         }else { //if it has a first element which is the id
			        	lblPatientIdnotfound.setVisible(false);
						textField.setEditable(false);
						flag = 1;
						
			         }
		            table.setModel(DbUtils.resultSetToTableModel(rs)); //displays auto the result of query
			        
		           
					
				} catch (Exception z) {
					JOptionPane.showMessageDialog(null, z);
				}
			}
		});
		btnSearch.setBounds(372, 77, 134, 43);
		btnSearch.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/src/HMS ICON/search.png"));
		btnSearch.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		contentPane.add(btnSearch);
		
		lblPatientIdnotfound = new JLabel("* Patient ID not found");
		lblPatientIdnotfound.setBounds(27, 125, 145, 16);
		lblPatientIdnotfound.setForeground(Color.RED);
		lblPatientIdnotfound.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblPatientIdnotfound);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		scrollPane.setBounds(27, 146, 801, 97);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblSymptoms = new JLabel("Symptoms");
		lblSymptoms.setBounds(27, 301, 145, 700);
		lblSymptoms.setFont(new Font("Helvetica Neue", Font.BOLD, 17));
		contentPane.add(lblSymptoms);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 296, 274, 32);
		textField_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblRoomRequired = new JLabel("Room Required?");
		lblRoomRequired.setBounds(495, 300, 155, 22);
		lblRoomRequired.setFont(new Font("Helvetica Neue", Font.BOLD, 17));
		contentPane.add(lblRoomRequired);
		
		chckbxYes = new JCheckBox("Yes");
		chckbxYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxYes.isSelected()) {
					comboBox.setVisible(true);
					lblTypeOfRoom.setVisible(true);
				} else {
					comboBox.setVisible(false);
					lblTypeOfRoom.setVisible(false);
				}
			}
		});
		chckbxYes.setBounds(690, 300, 115, 23);
		chckbxYes.setFont(new Font("Helvetica", Font.PLAIN, 17));
		contentPane.add(chckbxYes);
		
		lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setBounds(27, 386, 145, 22);
		lblDiagnosis.setFont(new Font("Helvetica Neue", Font.BOLD, 17));
		contentPane.add(lblDiagnosis);
		
		textField_2 = new JTextField();
		textField_2.setBounds(176, 381, 274, 32);
		textField_2.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		lblTypeOfRoom = new JLabel("Type of Room");
		lblTypeOfRoom.setBounds(495, 385, 155, 22);
		lblTypeOfRoom.setFont(new Font("Helvetica Neue", Font.BOLD, 17));
		contentPane.add(lblTypeOfRoom);
		
		comboBox = new JComboBox();
		comboBox.setBounds(690, 383, 138, 27);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double", "General"}));
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		contentPane.add(comboBox);
		
		lblMedicines = new JLabel("Medicines");
		lblMedicines.setBounds(27, 471, 145, 22);
		lblMedicines.setFont(new Font("Helvetica Neue", Font.BOLD, 17));
		contentPane.add(lblMedicines);
		
		textField_3 = new JTextField();
		textField_3.setBounds(176, 466, 274, 32);
		textField_3.setFont(new Font("Helvetica Neue", Font.PLAIN, 17));
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(flag);
				if(flag == 1) {
					String id = textField.getText();
					String symptom = textField_1.getText();
					String diagnosis = textField_2.getText();
					String med = textField_3.getText();
					String roomReq, typeRoom;
					if (chckbxYes.isSelected()) {
						roomReq = "YES";
						typeRoom = (String)comboBox.getSelectedItem();
					}else {
						roomReq = "NO";
						typeRoom = " ";
					}
					
					try {
						Connection conn = Main.ConnectDb();
						Statement st = conn.createStatement();
						st.executeUpdate("insert into PatientReport values('" +id+"','"+symptom+"','"+diagnosis+"','"+med+"','"+roomReq+"','"+typeRoom+"');");
						JOptionPane.showMessageDialog(null,"Successfully Updated");
						setVisible(false);
						new addDiagnosis().setVisible(true);
						
					} catch (Exception e2) {
					
						JOptionPane.showMessageDialog(null,e2);
					}
						
				}else {
					JOptionPane.showMessageDialog(null,"Patient ID is empty");
				}
			}
		});
		btnSave.setBounds(285, 550, 387, 34);
		contentPane.add(btnSave);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(695, 631, 130, 29);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnClose);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/src/HMS ICON/bcg update.png"));
		lblNewLabel.setBounds(0, 0, 860, 700);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//setBounds((int)screenSize.getWidth()-1000,(int)screenSize.getHeight()-720, 860, 700);
		setBounds(800,250,860,700);
		
		
		
		
		comboBox.setVisible(false);
		lblPatientIdnotfound.setVisible(false);
		lblTypeOfRoom.setVisible(false);
		
		
		
	}
}
