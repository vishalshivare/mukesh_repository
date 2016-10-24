package org.gh;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.List;
import java.awt.Choice;
import javax.swing.JList;
import java.awt.TextArea;
import javax.swing.JTree;
import javax.swing.JTextPane;
import java.awt.TextField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Window2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 window = new Window2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(UIManager.getColor("Button.foreground"));
		frame.setBounds(100, 100,600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Group Health");
		ImageIcon img = new ImageIcon("C:\\Users\\mukeshm\\Desktop\\SmarTek\\builtbylcon.png");
		
		frame.setIconImage(img.getImage());
		
		
		JLabel lblRoot = new JLabel("Root Directory");
		lblRoot.setForeground(UIManager.getColor("Label.disabledForeground"));
		lblRoot.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRoot.setBounds(14, 75, 139, 28);
		frame.getContentPane().add(lblRoot);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		textField.setBounds(176, 78, 250, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchContain = new JLabel("Find Content");
		lblSearchContain.setForeground(UIManager.getColor("Label.disabledForeground"));
		lblSearchContain.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSearchContain.setBounds(14, 130, 119, 28);
		frame.getContentPane().add(lblSearchContain);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(176, 130, 250, 28);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 187, 250, 28);
		frame.getContentPane().add(textField_2);
		
		JLabel lblReplace = new JLabel("Replace Content");
		lblReplace.setForeground(UIManager.getColor("Label.disabledForeground"));
		lblReplace.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblReplace.setBounds(14, 184, 156, 29);
		frame.getContentPane().add(lblReplace);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBackground(SystemColor.activeCaption);
		btnFind.setForeground(UIManager.getColor("Button.foreground"));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Search Content:"+textField_1.getText());
				
				String str=(String)textField.getText();
				File dir=new File(str);
				if(dir.exists())
				{
					JOptionPane.showMessageDialog(null,  "Valid Directory");
					try
					{
						File[] files = dir.listFiles();
						for(File file:files)
						{
							if(!file.isDirectory())
							{
								String result=displayDirectoryContents(file,textField_1.getText());
								textField_3.setText(textField_3.getText()+"\n"+result);
							}
							
						}
						
					}
					catch(Exception err)
					{
						textField_3.setText(err.toString());
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Directory");
				}
				
			}
		});
		btnFind.setBounds(176, 323, 89, 28);
		frame.getContentPane().add(btnFind);
		
		JButton btnReplace = new JButton("Replace");
		btnReplace.setBackground(SystemColor.activeCaption);
		btnReplace.setForeground(UIManager.getColor("Button.foreground"));
		btnReplace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnReplace.setBounds(337, 323, 89, 28);
		frame.getContentPane().add(btnReplace);
		
		textField_3 = new JTextField();
		textField_3.setForeground(UIManager.getColor("Button.foreground"));
		textField_3.setColumns(10);
		textField_3.setBounds(176, 362, 367, 188);
		frame.getContentPane().add(textField_3);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBackground(SystemColor.activeCaption);
		btnBrowse.setForeground(UIManager.getColor("Button.foreground"));
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser f = new JFileChooser();
		        f.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
		        f.showOpenDialog(null);
		        File f1=f.getSelectedFile();
                textField.setText(f1.toString());
		       
			}
		});
		btnBrowse.setBounds(454, 78, 89, 28);
		frame.getContentPane().add(btnBrowse);
		
		JLabel lblNewLabel = new JLabel("GROUP HEALTH FIND AND REPLACE TOOL");
		lblNewLabel.setFont(new Font("Californian FB", Font.BOLD, 25));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(36, 12, 507, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {".txt", ".doc", ".java", ".class", ".xml"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(176, 249, 250, 32);
		frame.getContentPane().add(comboBox);
		
		JLabel lblReplacePattern = new JLabel("Replace Pattern");
		lblReplacePattern.setForeground(UIManager.getColor("Label.disabledForeground"));
		lblReplacePattern.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblReplacePattern.setBounds(14, 248, 156, 29);
		frame.getContentPane().add(lblReplacePattern);
	}
	//LIST ALL THE FILE AND DIRECTORY
	public static String displayDirectoryContents(File dir, String find) throws Exception
	{
		String msg=dir.getName()+": ";
		int lineno=0;
		String line;
		FileReader fr=new FileReader(dir);
		BufferedReader br=new BufferedReader(fr);
		while((line=br.readLine()) != null)
				{
			    lineno++;
			   
			    if(line.indexOf(find,0)>=0)
			    {
			    	msg=msg+lineno+", ";
			    }
			    
			      
				}
		
		  return (String)msg;
			
		
	}
}
