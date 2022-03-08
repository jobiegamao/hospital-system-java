import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import net.proteanit.sql.DbUtils;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;

public class fullHistoryofPatient extends JFrame {

	private JPanel contentPane;
	private JButton btnClose;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fullHistoryofPatient frame = new fullHistoryofPatient();
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
	public fullHistoryofPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//setBounds((int)screenSize.getWidth()-1000,(int)screenSize.getHeight()-720, 860, 700);
		setBounds(800,250,860,700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 10, 5, 5));
		setContentPane(contentPane);
		//setAlwaysOnTop(true);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 127, 825, 468);
		scrollPane.setViewportBorder(UIManager.getBorder("ProgressBar.border"));
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(UIManager.getColor("TextComponent.selectionBackgroundInactive"));
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(565, 630, 260, 45);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		btnClose.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		contentPane.add(btnClose);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 860, 700);
		lblNewLabel.setIcon(new ImageIcon("/Users/may/eclipse-workspace/Hospital Management System/src/HMS ICON/bcg list.png"));
		contentPane.add(lblNewLabel);
		
		//table loads details
		try (Connection conn = Main.ConnectDb();){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from Patient INNER JOIN PatientReport USING(id)");
			table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,e2);	
		}
		
	}
}
