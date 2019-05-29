package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class Sorting extends JFrame {
	private JButton btnAddSquare,btnSort;
	private JPanel contentPane,panel;
	private ArrayList<Square> squares=new ArrayList<Square>();
	private JTextField xCoordStr,yCoordStr,lengthStr;
	private JPanel squarePanel;
	private JTextArea sortK;
	private String sqList="";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sorting frame = new Sorting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sorting() {
		Components();
		Operations();
	}
	
	public void Components(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Simple sorting app");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(15);
		panel.setBackground(new Color(255, 255, 204));
		panel.setPreferredSize(new Dimension(250, 250));
		contentPane.add(panel);
		
		JLabel lblChooseOption = new JLabel("Choose an option:");
		lblChooseOption.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblChooseOption);
		
		btnAddSquare = new JButton("Add square to list");
		btnAddSquare.setPreferredSize(new Dimension(240, 50));
		btnAddSquare.setBackground(new Color(0, 102, 255));
		btnAddSquare.setForeground(new Color(255, 255, 255));
		btnAddSquare.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(btnAddSquare);
		
		btnSort = new JButton("Sort list and show");
		btnSort.setForeground(new Color(255, 255, 255));
		btnSort.setPreferredSize(new Dimension(240, 50));
		btnSort.setFont(new Font("Arial", Font.BOLD, 16));
		btnSort.setBackground(new Color(0, 102, 255));
		panel.add(btnSort);
	}
	
	public void Operations(){
		btnAddSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				squarePanel=new JPanel();
				squarePanel.setPreferredSize(new Dimension(200,200));
				xCoordStr=new JTextField(5); yCoordStr=new JTextField(5);
				lengthStr=new JTextField(5);
				squarePanel.add(new JLabel("X coordinate:")); squarePanel.add(xCoordStr);
				squarePanel.add(new JLabel("Y coordinate:")); squarePanel.add(yCoordStr);
				squarePanel.add(new JLabel("Length:")); squarePanel.add(lengthStr);
				int result = JOptionPane.showConfirmDialog(contentPane, squarePanel,"Adding square to list", JOptionPane.OK_CANCEL_OPTION);
				if(result==JOptionPane.OK_OPTION){
					int startX=Integer.parseInt(xCoordStr.getText()); int startY=Integer.parseInt(yCoordStr.getText());
					int length=Integer.parseInt(lengthStr.getText());
					squares.add(new Square(new Point(startX,startY),length));
				}
			}
		});
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(squares.isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "The list is empty.\nAdd square first." , "Error", JOptionPane.INFORMATION_MESSAGE);
				}else{
					Collections.sort(squares, (length1,length2) -> length1.getLength() - length2.getLength());
					sqList = "";
					for(int i=0;i<squares.size();i++){
						sqList+=squares.get(i)+"\n";
					}
					sortK=new JTextArea();
					sortK.setEditable(false);
					sortK.setText(sqList);
					JOptionPane.showMessageDialog(contentPane, sortK , "Sorted square list", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

}
