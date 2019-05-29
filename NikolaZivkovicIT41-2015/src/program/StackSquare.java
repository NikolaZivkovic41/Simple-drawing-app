package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.FlowLayout;

public class StackSquare extends JFrame {

	private JPanel contentPane,panel;
	private Stack<Square> stack;
	private JLabel label;
	private JButton btnAdd,btnDelete;
	private JButton innerColor,outerColor;
	private Color inner,outer,inner1,outer1;
	private JPanel panel2,colorPanel,panel3,colorPanel1,colorInner,colorOuter;
	private JTextField text;
	private int xSquare,ySquare,length;
	private String xCoord,yCoord,lengthStr;
	private JTextField xField,yField,strField,xField1,yField1,strField1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackSquare frame = new StackSquare();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StackSquare() {
		JTextField color=new JTextField("Colors:");
		color.setPreferredSize(new Dimension(200,20));
		color.setBackground(null);
		color.setBorder(new LineBorder(Color.BLACK,0));
		color.setFont(new Font("Arial",Font.BOLD,12));
		JTextField outerCC=new JTextField("Outer");
		outerCC.setBackground(null);
		outerCC.setBorder(new LineBorder(Color.BLACK,0));
		outerCC.setForeground(Color.BLACK);
		JTextField innerCC=new JTextField("Inner");
		innerCC.setBackground(null);
		innerCC.setBorder(new LineBorder(Color.BLACK,0));
		innerCC.setForeground(Color.BLACK);
		text=new JTextField("Choose an option:");
		text.setFont(new Font("Sans-Serif",Font.PLAIN,30));
		text.setEditable(false);
		text.setBorder(new EmptyBorder(0,0,0, 0));
		stack=new Stack<Square>();
		
		xField=new JTextField(5);
		yField=new JTextField(5);
		strField=new JTextField(5);
		innerColor=new JButton("Inner");
		innerColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				inner=JColorChooser.showDialog(contentPane,"Choose inner color", Color.white);
				innerColor.setBackground(inner);
			}
		});
		outerColor=new JButton("Outer");
		outerColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				outer=JColorChooser.showDialog(contentPane,"Choose outer color", Color.white);
				outerColor.setBackground(outer);
			}
		});
		colorPanel=new JPanel(new FlowLayout(0,5,0));
		colorPanel.add(innerColor); colorPanel.add(outerColor);
		panel2=new JPanel(new FlowLayout(0,5,5));
		panel2.setPreferredSize(new Dimension(220,140));
		panel2.add(new JLabel("X coordinate:")); panel2.add(xField);
		panel2.add(new JLabel("Y coordinate:")); panel2.add(yField);
		panel2.add(new JLabel("Length:")); panel2.add(strField);
		panel2.add(new JLabel("Colors:"));
		panel2.add(colorPanel);	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Simple stack the squares app");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(15);
		panel.setPreferredSize(new Dimension(250, 250));
		panel.setBackground(new Color(255, 255, 204));
		contentPane.add(panel);
		
		label = new JLabel("Choose an option:");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(label);
		
		btnAdd = new JButton("Add square on stack");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(contentPane, panel2,"Adding elements on stack", JOptionPane.OK_CANCEL_OPTION);
				if(result==JOptionPane.OK_OPTION){
					xCoord=xField.getText();
					yCoord=yField.getText();
					lengthStr=strField.getText();
					xSquare=Integer.parseInt(xCoord);
					ySquare=Integer.parseInt(yCoord);
					length=Integer.parseInt(lengthStr);
					
					stack.push(new Square(new Point(xSquare,ySquare),length,inner,outer));
					
				}
				xField.setText("");
				yField.setText("");
				strField.setText("");
				xCoord=null;
				yCoord=null;
				lengthStr=null;
				inner=null;
				outer=null;
				innerColor.setBackground(null);
				outerColor.setBackground(null);
			}
		});
		btnAdd.setBackground(new Color(0, 102, 255));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
		btnAdd.setPreferredSize(new Dimension(240, 50));
		panel.add(btnAdd);
		
		btnDelete = new JButton("Delete square from stack");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(stack.isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "Stack is empty.\nAdd square on stack first." , "Error", JOptionPane.INFORMATION_MESSAGE);
				}else{
					xCoord=Integer.toString(stack.peek().getStart().getX());
					xField1=new JTextField(xCoord);
					yCoord=Integer.toString(stack.peek().getStart().getY());
					yField1=new JTextField(yCoord);
					lengthStr=Integer.toString(stack.peek().getLength());
					strField1=new JTextField(lengthStr);
					inner1=stack.peek().getInnerColor();
					outer1=stack.peek().getOuterColor();
					colorInner=new JPanel();
					colorInner.setPreferredSize(innerColor.getPreferredSize());
					colorInner.setBackground(inner1); colorInner.add(innerCC);
					colorOuter=new JPanel();
					colorOuter.setPreferredSize(outerColor.getPreferredSize());
					colorOuter.setBackground(outer1); colorOuter.add(outerCC);
					colorPanel1=new JPanel(new FlowLayout(0,5,0));
					colorPanel1.add(colorInner); colorPanel1.add(colorOuter);
					panel3=new JPanel(new FlowLayout(0,5,5));
					panel3.setPreferredSize(new Dimension(220,140));
					panel3.add(new JLabel("X coordinate:")); panel3.add(xField1);
					panel3.add(new JLabel("Y coordinate:")); panel3.add(yField1);
					panel3.add(new JLabel("Length:")); panel3.add(strField1);
					panel3.add(color);
					panel3.add(colorPanel1);	
					int result = JOptionPane.showConfirmDialog(contentPane, panel3,"Deleting elements from stack", JOptionPane.OK_CANCEL_OPTION);
					if(result==JOptionPane.OK_OPTION){
						stack.pop();
					}
				}
			}
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 16));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(0, 102, 255));
		btnDelete.setPreferredSize(new Dimension(240, 50));
		panel.add(btnDelete);
	}
}
