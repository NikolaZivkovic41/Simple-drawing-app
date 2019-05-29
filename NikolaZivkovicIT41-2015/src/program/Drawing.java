package program;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Drawing extends JFrame{

	private JPanel contentPane;
	private JPanel Options,Modifications,Shapes,Delete,controlPanel;
	private DrawingPanel drawingPanel;
	private JButton btnChoose,btnDelete,btnDeleteAll,btnPoint,btnSquare,btnRectangle,btnLine,btnCircle,btnInf,btnModify;
	
	private String btnClicked=null,lengthString=null,radiusString=null,heightString=null;
	private Color innerColor,outerColor;
	private int x,y,length,lengthRect,height,radius;
	
	private boolean selected0=false;
	private Object linePoint;
	int lineI=0;
	
	private JPanel infPoint,infLine,infSquare,infCircle,infRect;
	private JTextField xStartField1,yStartField1,xEndField1,yEndField1,lengthField1,heightField1,radiusField1;
	private JTextField innerColorField,outerColorField;
	private JPanel modifyPoint,modifyLine,modifySquare,modifyCircle,modifyRect;
	private JTextField xStartField,yStartField,xEndField,yEndField,lengthField,heightField,radiusField;
	private JButton newInnerColor,newOuterColor;
	private Color newOuterC,newInnerC;
	
	private Point tempPoint;
	private Line tempLine;
	private Square tempSquare;
	private Circle tempCircle;
	private Rectangle tempRect;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing frame = new Drawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Drawing() {	
		Components();
		Operations();
	}
	
	public void Components(){		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		setMinimumSize(new Dimension(1024, 576));
		setTitle("Simple drawing app");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		controlPanel = new JPanel();
		controlPanel.setBackground(new Color(255, 255, 204));
		controlPanel.setPreferredSize(new Dimension(1024,100));
		contentPane.add(controlPanel, BorderLayout.NORTH);
		controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Options = new JPanel();
		Options.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Options", TitledBorder.LEADING, TitledBorder.BOTTOM, null, Color.GRAY));
		Options.setBackground(new Color(255, 255, 204));
		Options.setPreferredSize(new Dimension(165, 90));
		controlPanel.add(Options);
		Options.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnChoose = new JButton("Choose");
		btnChoose.setFont(new Font("Arial", Font.BOLD, 16));
		btnChoose.setForeground(new Color(255, 255, 255));
		btnChoose.setBackground(new Color(0, 102, 255));
		btnChoose.setPreferredSize(new Dimension(130, 25));
		Options.add(btnChoose);
		
		Shapes = new JPanel();
		Shapes.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Shapes", TitledBorder.LEADING, TitledBorder.BOTTOM, null, Color.GRAY));
		Shapes.setBackground(new Color(255, 255, 204));
		Shapes.setPreferredSize(new Dimension(480, 90));
		controlPanel.add(Shapes);
		Shapes.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnPoint = new JButton("Point");
		btnPoint.setForeground(new Color(255, 255, 255));
		btnPoint.setFont(new Font("Arial", Font.BOLD, 16));
		btnPoint.setBackground(new Color(0, 102, 255));
		btnPoint.setPreferredSize(new Dimension(135, 25));
		Shapes.add(btnPoint);
		
		btnSquare = new JButton("Square");
		btnSquare.setForeground(new Color(255, 255, 255));
		btnSquare.setFont(new Font("Arial", Font.BOLD, 16));
		btnSquare.setBackground(new Color(0, 102, 255));
		btnSquare.setPreferredSize(new Dimension(135, 25));
		Shapes.add(btnSquare);
		
		btnRectangle = new JButton("Rectangle");
		btnRectangle.setForeground(new Color(255, 255, 255));
		btnRectangle.setFont(new Font("Arial", Font.BOLD, 16));
		btnRectangle.setBackground(new Color(0, 102, 255));
		btnRectangle.setPreferredSize(new Dimension(150, 25));
		Shapes.add(btnRectangle);
		
		btnLine = new JButton("Line");
		btnLine.setFont(new Font("Arial", Font.BOLD, 16));
		btnLine.setForeground(new Color(255, 255, 255));
		btnLine.setBackground(new Color(0, 102, 255));
		btnLine.setPreferredSize(new Dimension(140, 25));
		Shapes.add(btnLine);
		
		btnCircle = new JButton("Circle");
		btnCircle.setFont(new Font("Arial", Font.BOLD, 16));
		btnCircle.setForeground(new Color(255, 255, 255));
		btnCircle.setBackground(new Color(0, 102, 255));
		btnCircle.setPreferredSize(new Dimension(140, 25));
		Shapes.add(btnCircle);
		
		Modifications = new JPanel();
		Modifications.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Modifications", TitledBorder.LEADING, TitledBorder.BOTTOM, null, Color.GRAY));
		Modifications.setBackground(new Color(255, 255, 204));
		Modifications.setPreferredSize(new Dimension(165, 90));
		controlPanel.add(Modifications);
		Modifications.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnInf = new JButton("Info");
		btnInf.setFont(new Font("Arial", Font.BOLD, 16));
		btnInf.setForeground(new Color(255, 255, 255));
		btnInf.setBackground(new Color(0, 102, 255));
		btnInf.setPreferredSize(new Dimension(130, 25));
		Modifications.add(btnInf);
		
		btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Arial", Font.BOLD, 16));
		btnModify.setForeground(new Color(255, 255, 255));
		btnModify.setBackground(new Color(0, 102, 255));
		btnModify.setPreferredSize(new Dimension(130, 25));
		Modifications.add(btnModify);
		
		Delete = new JPanel();
		Delete.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Delete", TitledBorder.LEADING, TitledBorder.BOTTOM, null, Color.GRAY));
		Delete.setBackground(new Color(255, 255, 204));
		Delete.setPreferredSize(new Dimension(165, 90));
		controlPanel.add(Delete);
		Delete.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(0, 102, 255));
		btnDelete.setFont(new Font("Arial", Font.BOLD, 16));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setPreferredSize(new Dimension(130, 25));
		Delete.add(btnDelete);
		
		btnDeleteAll = new JButton("Delete all");
		btnDeleteAll.setBackground(new Color(0, 102, 255));
		btnDeleteAll.setFont(new Font("Arial", Font.BOLD, 16));
		btnDeleteAll.setForeground(new Color(255, 255, 255));
		btnDeleteAll.setPreferredSize(new Dimension(130, 25));
		Delete.add(btnDeleteAll);
		
		newOuterColor=new JButton("Outer"); 
		newInnerColor=new JButton("Inner");
		
		drawingPanel = new DrawingPanel();
		drawingPanel.setPreferredSize(new Dimension(1024,476));
		contentPane.add(drawingPanel, BorderLayout.CENTER);
	}
	
	public void Operations(){
		drawingPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnClicked=="point"){
					x=arg0.getX();
					y=arg0.getY();
					outerColor=JColorChooser.showDialog(contentPane,"Choose outer color", Color.white);
					Point t1=new Point(x,y,outerColor);
					drawingPanel.getShapes().add(t1);
				}else if(btnClicked=="line"){
					if(lineI==0){
						linePoint=new Line(new Point(arg0.getX(),arg0.getY()),new Point(0,0));
						lineI=1;
						return;
					}else{
						Line l1=(Line)linePoint;
						l1.settEnd(new Point(arg0.getX(),arg0.getY()));
						outerColor=JColorChooser.showDialog(contentPane,"Choose outer color", Color.white);
						l1.setOuterColor(outerColor);
						drawingPanel.getShapes().add(l1);
						lineI=0;
					}	
				}else if(btnClicked=="square"){
					x=arg0.getX();
					y=arg0.getY();
					lengthString=JOptionPane.showInputDialog(contentPane, "Length:");
					boolean test = true;
					while(test)
					{
						try{
							 length=Integer.parseInt(lengthString);
							 if(length <= 0)
								 throw new IllegalArgumentException("The value must be greater than zero.");
							 outerColor=JColorChooser.showDialog(contentPane,"Choose outer color", Color.white);	
							 innerColor=JColorChooser.showDialog(contentPane,"Choose inner color", Color.white);
							 Square square = new Square(new Point(x,y), length,innerColor,outerColor);	 
							 drawingPanel.getShapes().add(square);
							 test = false;
						}
						catch(NumberFormatException nfe)
						{
							lengthString=JOptionPane.showInputDialog(contentPane, "Length must be greater than zero:");
						}
						catch(IllegalArgumentException ex)
						{		
							lengthString = JOptionPane.showInputDialog(null, ex.getMessage(), "Repeat input", JOptionPane.QUESTION_MESSAGE );						
						}
					}
				}else if(btnClicked=="circle"){
					x=arg0.getX();
					y=arg0.getY();
					radiusString=JOptionPane.showInputDialog(contentPane, "Radius:");
					boolean test = true;
					while(test)
					{
						try{
							 radius=Integer.parseInt(radiusString);
							 if(radius <= 0)
								 throw new IllegalArgumentException("The value must be greater than zero.");
							 outerColor=JColorChooser.showDialog(contentPane,"Choose outer color", Color.white);	
							 innerColor=JColorChooser.showDialog(contentPane,"Choose inner color", Color.white);
							 Circle circle = new Circle(new Point(x,y),radius, innerColor,outerColor);
							 drawingPanel.getShapes().add(circle);
							 test = false;
						}
						catch(NumberFormatException nfe)
						{
							radiusString=JOptionPane.showInputDialog(contentPane, "Radius must be greater than zero:");
						}
						catch(IllegalArgumentException ex)
						{		
							radiusString = JOptionPane.showInputDialog(null, ex.getMessage(), "Repeat input", JOptionPane.QUESTION_MESSAGE );						
						}
					}
				}else if(btnClicked=="rectangle"){
					x=arg0.getX();
					y=arg0.getY();
					lengthString=JOptionPane.showInputDialog(contentPane, "Length:");
					boolean test = true;
					while(test)
					{
						try{
							 lengthRect=Integer.parseInt(lengthString);
							 if(lengthRect <= 0)
								 throw new IllegalArgumentException("The value must be greater than zero.");
							 test = false;
						}
						catch(NumberFormatException nfe)
						{
							lengthString=JOptionPane.showInputDialog(contentPane, "Length must be greater than zero:");
						}
						catch(IllegalArgumentException ex)
						{		
							lengthString = JOptionPane.showInputDialog(contentPane, ex.getMessage(), "Repeat input", JOptionPane.QUESTION_MESSAGE );						
						}
					}
					heightString=JOptionPane.showInputDialog(contentPane, "Height:");
					test = true;
					while(test)
					{
						try{
							 height=Integer.parseInt(heightString);
							 if(height <= 0)
								 throw new IllegalArgumentException("The value must be greater than zero.");
						 	 outerColor=JColorChooser.showDialog(contentPane,"Choose outer color", Color.white);	
							 innerColor=JColorChooser.showDialog(contentPane,"Choose inner color", Color.white);
							 Rectangle prav = new Rectangle(new Point(x,y),lengthRect,height,innerColor,outerColor);
							 drawingPanel.getShapes().add(prav);
							 test = false;
						}
						catch(NumberFormatException nfe)
						{
							heightString=JOptionPane.showInputDialog(contentPane, "Height must be greater than zero:");
						}
						catch(IllegalArgumentException ex)
						{		
							heightString = JOptionPane.showInputDialog(contentPane, ex.getMessage(), "Repeat input", JOptionPane.QUESTION_MESSAGE );						
						}
					}
				}else if(btnClicked=="choose"){
					if(selected0==false){
						for(int i=drawingPanel.getShapes().size()-1;i>=0;i--){
							if(drawingPanel.getShapes().get(i) instanceof Point){
								tempPoint=(Point)drawingPanel.getShapes().get(i);
								if(tempPoint.contains(arg0.getX(), arg0.getY())){
									tempPoint.setSelected(true);
									tempPoint.selected(drawingPanel.getGraphics());								
									selected0=true;
									return;
								}
							}else if(drawingPanel.getShapes().get(i) instanceof Line){
								tempLine=(Line)drawingPanel.getShapes().get(i);
								if(tempLine.contains(arg0.getX(), arg0.getY())){
									tempLine.setSelected(true);
									tempLine.selected(drawingPanel.getGraphics());								
									selected0=true;
									return;
								}
							}else if(drawingPanel.getShapes().get(i) instanceof Square){
								tempSquare=(Square)drawingPanel.getShapes().get(i);
								if(tempSquare.contains(arg0.getX(), arg0.getY())){
									tempSquare.setSelected(true);
									tempSquare.selected(drawingPanel.getGraphics());								
									selected0=true;
									return;
								}
							}else if(drawingPanel.getShapes().get(i) instanceof Circle){
								tempCircle=(Circle)drawingPanel.getShapes().get(i);
								if(tempCircle.contains(arg0.getX(), arg0.getY())){
									tempCircle.setSelected(true);
									tempCircle.selected(drawingPanel.getGraphics());								
									selected0=true;
									return;
								}
							}else if(drawingPanel.getShapes().get(i) instanceof Rectangle){
								tempRect=(Rectangle)drawingPanel.getShapes().get(i);
								if(tempRect.contains(arg0.getX(), arg0.getY())){
									tempRect.setSelected(true);
									tempRect.selected(drawingPanel.getGraphics());									
									selected0=true;
									return;
								}
							}				
						}
					}		
				}
			}
		});
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="point";
			}
		});
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="line";
			}
		});
		btnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="square";
			}
		});
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="circle";
			}
		});
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="rectangle";
			}
		});
		newOuterColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				newOuterC=JColorChooser.showDialog(contentPane,"Choose new outer color", Color.white);
				newOuterColor.setBackground(newOuterC);
			}
		});
		newInnerColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				newInnerC=JColorChooser.showDialog(contentPane,"Choose new inner color", Color.white);
				newInnerColor.setBackground(newInnerC);
			}
		});
		btnChoose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				btnClicked="choose";
			}
		});
		btnInf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(btnClicked=="choose" && selected0==true){
					for(int i=drawingPanel.getShapes().size()-1;i>=0;i--){
						if(drawingPanel.getShapes().get(i) instanceof Point){
							tempPoint=(Point)drawingPanel.getShapes().get(i);
							if(tempPoint.isSelected()==true){
								infPoint=new JPanel();
								xStartField1=new JTextField(5); xStartField1.setEditable(false);
								yStartField1=new JTextField(5); yStartField1.setEditable(false);
								outerColorField=new JTextField("Outer"); outerColorField.setEditable(false);
								infPoint.add(new JLabel("X coordinate:")); infPoint.add(xStartField1);
								infPoint.add(new JLabel("Y coordinate:")); infPoint.add(yStartField1);
								infPoint.add(new JLabel("Colors:")); infPoint.add(outerColorField);
								xStartField1.setText(Integer.toString(tempPoint.getX()));
								yStartField1.setText(Integer.toString(tempPoint.getY()));
								outerColorField.setBackground(tempPoint.getOuterColor());
								JOptionPane.showConfirmDialog(contentPane, infPoint,"Point info", JOptionPane.OK_CANCEL_OPTION);
								xStartField1.setText("");
								yStartField1.setText("");
								outerColorField.setBackground(null);
								selected0=false;
								tempPoint.setSelected(false);
								tempPoint.selected(drawingPanel.getGraphics());
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Line){
							tempLine=(Line)drawingPanel.getShapes().get(i);
							if(tempLine.isSelected()==true){
								infLine=new JPanel();
								xStartField1=new JTextField(5); xStartField1.setEditable(false);
								yStartField1=new JTextField(5); yStartField1.setEditable(false);
								xEndField1=new JTextField(5); xEndField1.setEditable(false);
								yEndField1=new JTextField(5); yEndField1.setEditable(false);
								outerColorField=new JTextField("Outer"); outerColorField.setEditable(false);
								infLine.add(new JLabel("Start point of X coordinate:")); infLine.add(xStartField1);
								infLine.add(new JLabel("Start point of Y coordinate:")); infLine.add(yStartField1);
								infLine.add(new JLabel("End point of X coordinate:")); infLine.add(xEndField1);
								infLine.add(new JLabel("End point of Y coordinate:")); infLine.add(yEndField1);
								infLine.add(new JLabel("Colors:")); infLine.add(outerColorField);
								xStartField1.setText(Integer.toString(tempLine.gettStart().getX()));
								yStartField1.setText(Integer.toString(tempLine.gettStart().getY()));
								xEndField1.setText(Integer.toString(tempLine.gettEnd().getX()));
								yEndField1.setText(Integer.toString(tempLine.gettEnd().getY()));
								outerColorField.setBackground(tempLine.getOuterColor());
								JOptionPane.showConfirmDialog(contentPane, infLine,"Line info", JOptionPane.OK_CANCEL_OPTION);
								xStartField1.setText("");
								yStartField1.setText("");
								xEndField1.setText("");
								yEndField1.setText("");
								outerColorField.setBackground(null);
								tempLine.setSelected(false);
								tempLine.selected(drawingPanel.getGraphics());
								selected0=false;
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Square){
							tempSquare=(Square)drawingPanel.getShapes().get(i);
							if(tempSquare.isSelected()==true){
								infSquare=new JPanel();
								xStartField1=new JTextField(5); xStartField1.setEditable(false);
								yStartField1=new JTextField(5); yStartField1.setEditable(false);
								lengthField1=new JTextField(5); lengthField1.setEditable(false);
								outerColorField=new JTextField("Outer"); outerColorField.setEditable(false);
								innerColorField=new JTextField("Inner"); innerColorField.setEditable(false);
								infSquare.add(new JLabel("X coordinate of start point:")); infSquare.add(xStartField1);
								infSquare.add(new JLabel("Y coordinate of start point:")); infSquare.add(yStartField1);
								infSquare.add(new JLabel("Length:")); infSquare.add(lengthField1);
								infSquare.add(new JLabel("Colors:")); infSquare.add(outerColorField); infSquare.add(innerColorField);
								xStartField1.setText(Integer.toString(tempSquare.getStart().getX()));
								yStartField1.setText(Integer.toString(tempSquare.getStart().getY()));
								lengthField1.setText(Integer.toString(tempSquare.getLength()));
								outerColorField.setBackground(tempSquare.getOuterColor()); innerColorField.setBackground(tempSquare.getInnerColor());
								JOptionPane.showConfirmDialog(contentPane, infSquare,"Square info", JOptionPane.OK_CANCEL_OPTION);
								tempSquare.setSelected(false);
								tempSquare.selected(drawingPanel.getGraphics());
								selected0=false;
								xStartField1.setText("");
								yStartField1.setText("");
								lengthField1.setText("");
								outerColorField.setBackground(null); innerColorField.setBackground(null);
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Circle){
							tempCircle=(Circle)drawingPanel.getShapes().get(i);
							if(tempCircle.isSelected()==true){
								infCircle=new JPanel();
								xStartField1=new JTextField(5); xStartField1.setEditable(false);
								yStartField1=new JTextField(5); yStartField1.setEditable(false);
								radiusField1=new JTextField(5); radiusField1.setEditable(false);
								outerColorField=new JTextField("Outer"); outerColorField.setEditable(false);
								innerColorField=new JTextField("Inner"); innerColorField.setEditable(false);
								infCircle.add(new JLabel("X coordinate of center:")); infCircle.add(xStartField1);
								infCircle.add(new JLabel("Y coordinate of center:")); infCircle.add(yStartField1);
								infCircle.add(new JLabel("Radius:")); infCircle.add(radiusField1);
								infCircle.add(new JLabel("Colors:")); infCircle.add(outerColorField); infCircle.add(innerColorField);
								xStartField1.setText(Integer.toString(tempCircle.getCenter().getX()));
								yStartField1.setText(Integer.toString(tempCircle.getCenter().getY()));
								radiusField1.setText(Integer.toString(tempCircle.getR()));
								outerColorField.setBackground(tempCircle.getOuterColor()); innerColorField.setBackground(tempCircle.getInnerColor());
								JOptionPane.showConfirmDialog(contentPane, infCircle,"Circle info", JOptionPane.OK_CANCEL_OPTION);
								tempCircle.setSelected(false);
								tempCircle.selected(drawingPanel.getGraphics());
								selected0=false;
								xStartField1.setText("");
								yStartField1.setText("");
								radiusField1.setText("");
								outerColorField.setBackground(null); innerColorField.setBackground(null);
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Rectangle){
							tempRect=(Rectangle)drawingPanel.getShapes().get(i);
							if(tempRect.isSelected()==true){
								infRect=new JPanel();
								xStartField1=new JTextField(5); xStartField1.setEditable(false);
								yStartField1=new JTextField(5); yStartField1.setEditable(false);
								lengthField1=new JTextField(5); lengthField1.setEditable(false);
								heightField1=new JTextField(5); heightField1.setEditable(false);
								outerColorField=new JTextField("Outer"); outerColorField.setEditable(false);
								innerColorField=new JTextField("Inner"); innerColorField.setEditable(false);
								infRect.add(new JLabel("X coordinate of start point:")); infRect.add(xStartField1);
								infRect.add(new JLabel("Y coordinate of start point:")); infRect.add(yStartField1);
								infRect.add(new JLabel("Length:")); infRect.add(lengthField1);
								infRect.add(new JLabel("Height:")); infRect.add(heightField1);
								infRect.add(new JLabel("Colors:")); infRect.add(outerColorField); infRect.add(innerColorField);
								xStartField1.setText(Integer.toString(tempRect.getStart().getX()));
								yStartField1.setText(Integer.toString(tempRect.getStart().getY()));
								lengthField1.setText(Integer.toString(tempRect.getLength()));
								heightField1.setText(Integer.toString(tempRect.getHeight()));
								outerColorField.setBackground(tempRect.getOuterColor()); innerColorField.setBackground(tempRect.getInnerColor());
								JOptionPane.showConfirmDialog(contentPane, infRect,"Rectangle info", JOptionPane.OK_CANCEL_OPTION);
								tempRect.setSelected(false);
								tempRect.selected(drawingPanel.getGraphics());
								selected0=false;
								xStartField1.setText("");
								yStartField1.setText("");
								lengthField1.setText("");
								heightField1.setText("");
								outerColorField.setBackground(null); innerColorField.setBackground(null);
							}	
						}				
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "You didn't choose the shape." , "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnModify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(btnClicked=="choose" && selected0==true){
					for(int i=drawingPanel.getShapes().size()-1;i>=0;i--){
						if(drawingPanel.getShapes().get(i) instanceof Point){
							tempPoint=(Point)drawingPanel.getShapes().get(i);
							if(tempPoint.isSelected()==true){
								modifyPoint=new JPanel();
								modifyPoint.setPreferredSize(new Dimension(250,130));
								newOuterColor.setBackground(tempPoint.getOuterColor());
								xStartField=new JTextField(5); xStartField.setText(Integer.toString(tempPoint.getX()));
								yStartField=new JTextField(5); yStartField.setText(Integer.toString(tempPoint.getY()));
								modifyPoint.add(new JLabel("Change X coordinate:")); modifyPoint.add(xStartField);
								modifyPoint.add(new JLabel("Change Y coordinate:")); modifyPoint.add(yStartField);
								modifyPoint.add(new JLabel("Colors:")); modifyPoint.add(newOuterColor);
								int result=JOptionPane.showConfirmDialog(contentPane, modifyPoint,"Modify point", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									Point temp=new Point(Integer.parseInt(xStartField.getText()),Integer.parseInt(yStartField.getText()),newOuterC);
									selected0=false;
									xStartField.setText("");
									yStartField.setText("");
									newOuterColor.setBackground(null);
									drawingPanel.getShapes().remove(i);
									drawingPanel.getShapes().add(i, temp);
								}	
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Line){
							tempLine=(Line)drawingPanel.getShapes().get(i);
							if(tempLine.isSelected()==true){
								modifyLine=new JPanel();
								modifyLine.setPreferredSize(new Dimension(300,150));
								newOuterColor.setBackground(tempLine.getOuterColor());
								xStartField=new JTextField(5); xStartField.setText(Integer.toString(tempLine.gettStart().getX()));
								yStartField=new JTextField(5); yStartField.setText(Integer.toString(tempLine.gettStart().getY()));
								xEndField=new JTextField(5); xEndField.setText(Integer.toString(tempLine.gettEnd().getX()));
								yEndField=new JTextField(5); yEndField.setText(Integer.toString(tempLine.gettEnd().getY()));
								modifyLine.add(new JLabel("Change X coordinate of start point:")); modifyLine.add(xStartField);
								modifyLine.add(new JLabel("Change Y coordinate of start point:")); modifyLine.add(yStartField);
								modifyLine.add(new JLabel("Change X coordinate of end point:")); modifyLine.add(xEndField);
								modifyLine.add(new JLabel("Change Y coordinate of end point:")); modifyLine.add(yEndField);
								modifyLine.add(new JLabel("Colors:")); modifyLine.add(newOuterColor);
								int result=JOptionPane.showConfirmDialog(contentPane, modifyLine,"Modify line", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									int startX=Integer.parseInt(xStartField.getText()); int startY=Integer.parseInt(yStartField.getText());
									int endX=Integer.parseInt(xEndField.getText()); int endY=Integer.parseInt(yEndField.getText());
									Line temp=new Line(new Point(startX,startY),new Point(endX,endY),newOuterC);
									selected0=false;
									xStartField.setText(""); xEndField.setText("");
									yStartField.setText(""); yEndField.setText("");
									newOuterColor.setBackground(null);
									drawingPanel.getShapes().remove(i);
									drawingPanel.getShapes().add(i, temp);
								}			
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Square){
							tempSquare=(Square)drawingPanel.getShapes().get(i);
							if(tempSquare.isSelected()==true){
								modifySquare=new JPanel();
								modifySquare.setPreferredSize(new Dimension(293,150));
								newOuterColor.setBackground(tempSquare.getOuterColor()); newInnerColor.setBackground(tempSquare.getInnerColor());
								xStartField=new JTextField(5); xStartField.setText(Integer.toString(tempSquare.getStart().getX()));
								yStartField=new JTextField(5); yStartField.setText(Integer.toString(tempSquare.getStart().getY()));
								lengthField=new JTextField(5); lengthField.setText(Integer.toString(tempSquare.getLength()));
								modifySquare.add(new JLabel("Change X coordinate of start point:")); modifySquare.add(xStartField);
								modifySquare.add(new JLabel("Change Y coordinate of start point:")); modifySquare.add(yStartField);
								modifySquare.add(new JLabel("Change length:")); modifySquare.add(lengthField);
								modifySquare.add(new JLabel("Colors:")); modifySquare.add(newOuterColor); modifySquare.add(newInnerColor);
								int result=JOptionPane.showConfirmDialog(contentPane, modifySquare,"Modify square", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									int startX=Integer.parseInt(xStartField.getText()); int startY=Integer.parseInt(yStartField.getText());
									int length=Integer.parseInt(lengthField.getText()); 
									Square temp=new Square(new Point(startX,startY),length,newInnerC,newOuterC);
									selected0=false;
									xStartField.setText(""); lengthField.setText("");
									yStartField.setText(""); 
									newOuterColor.setBackground(null); newInnerColor.setBackground(null);
									drawingPanel.getShapes().remove(i);
									drawingPanel.getShapes().add(i, temp);
								}
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Circle){
							tempCircle=(Circle)drawingPanel.getShapes().get(i);
							if(tempCircle.isSelected()==true){
								modifyCircle=new JPanel();
								modifyCircle.setPreferredSize(new Dimension(240,130));
								xStartField=new JTextField(5); xStartField.setText(Integer.toString(tempCircle.getCenter().getX()));
								yStartField=new JTextField(5); yStartField.setText(Integer.toString(tempCircle.getCenter().getY()));
								radiusField=new JTextField(5); radiusField.setText(Integer.toString(tempCircle.getR()));
								newOuterColor.setBackground(tempCircle.getOuterColor()); newInnerColor.setBackground(tempCircle.getInnerColor());
								modifyCircle.add(new JLabel("Change X coordinate of center:")); modifyCircle.add(xStartField);
								modifyCircle.add(new JLabel("Change Y coordinate of center:")); modifyCircle.add(yStartField);
								modifyCircle.add(new JLabel("Change radius:")); modifyCircle.add(radiusField);
								modifyCircle.add(new JLabel("Colors:")); modifyCircle.add(newOuterColor); modifyCircle.add(newInnerColor);
								int result=JOptionPane.showConfirmDialog(contentPane, modifyCircle,"Modify circle", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									int centerX=Integer.parseInt(xStartField.getText()); int centerY=Integer.parseInt(yStartField.getText());
									int radius=Integer.parseInt(radiusField.getText()); 
									Circle temp=new Circle(new Point(centerX,centerY),radius,newInnerC,newOuterC);
									selected0=false;
									xStartField.setText(""); radiusField.setText("");
									yStartField.setText(""); 
									newOuterColor.setBackground(null); newInnerColor.setBackground(null);
									drawingPanel.getShapes().remove(i);
									drawingPanel.getShapes().add(i, temp);
								}	
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Rectangle){
							tempRect=(Rectangle)drawingPanel.getShapes().get(i);
							if(tempRect.isSelected()==true){
								modifyRect=new JPanel();
								modifyRect.setPreferredSize(new Dimension(300,150));
								newOuterColor.setBackground(tempRect.getOuterColor()); newInnerColor.setBackground(tempRect.getInnerColor());
								xStartField=new JTextField(5); xStartField.setText(Integer.toString(tempRect.getStart().getX()));
								yStartField=new JTextField(5); yStartField.setText(Integer.toString(tempRect.getStart().getY()));							
								heightField=new JTextField(5); heightField.setText(Integer.toString(tempRect.getHeight()));
								lengthField=new JTextField(5); lengthField.setText(Integer.toString(tempRect.getLength()));
								modifyRect.add(new JLabel("Change X coordinate of start point:")); modifyRect.add(xStartField);
								modifyRect.add(new JLabel("Change Y coordinate of start point:")); modifyRect.add(yStartField);
								modifyRect.add(new JLabel("Change height:")); modifyRect.add(heightField);
								modifyRect.add(new JLabel("Change length:")); modifyRect.add(lengthField);
								modifyRect.add(new JLabel("Colors:")); modifyRect.add(newOuterColor); modifyRect.add(newInnerColor);
								int result=JOptionPane.showConfirmDialog(contentPane, modifyRect,"Modify rectangle", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									int startX=Integer.parseInt(xStartField.getText()); int startY=Integer.parseInt(yStartField.getText());
									int length=Integer.parseInt(lengthField.getText()); int height=Integer.parseInt(heightField.getText());
									Rectangle temp=new Rectangle(new Point(startX,startY),length,height,newInnerC,newOuterC);
									selected0=false;
									xStartField.setText(""); lengthField.setText("");
									yStartField.setText(""); heightField.setText("");
									newOuterColor.setBackground(null); newInnerColor.setBackground(null);
									drawingPanel.getShapes().remove(i);
									drawingPanel.getShapes().add(i, temp);
								}
							}	
						}				
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "You didn't choose the shape." , "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drawingPanel.getShapes().isEmpty()==true ){
					JOptionPane.showMessageDialog(contentPane, "There is nothing to delete." , "Error", JOptionPane.INFORMATION_MESSAGE);
				}else{
					int result=JOptionPane.showConfirmDialog(contentPane, "Delete all[OK/CANCEL]:", "Delete all", JOptionPane.OK_CANCEL_OPTION);
					if(result==JOptionPane.OK_OPTION){
						for(int i=drawingPanel.getShapes().size()-1;i>=0;i--){
							drawingPanel.getShapes().remove(i);
						}
					}
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnClicked=="choose" && selected0==true){
					for(int i=drawingPanel.getShapes().size()-1;i>=0;i--){
						if(drawingPanel.getShapes().get(i) instanceof Point){
							tempPoint=(Point)drawingPanel.getShapes().get(i);
							if(tempPoint.isSelected()==true){
								int result=JOptionPane.showConfirmDialog(contentPane, "Delete point[OK/CANCEL]:", "Delete point", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									selected0=false;
									drawingPanel.getShapes().remove(i);
								}
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Line){
							tempLine=(Line)drawingPanel.getShapes().get(i);
							if(tempLine.isSelected()==true){
								int result=JOptionPane.showConfirmDialog(contentPane, "Delete line[OK/CANCEL]:", "Delete line", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									selected0=false;
									drawingPanel.getShapes().remove(i);
								}
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Square){
							tempSquare=(Square)drawingPanel.getShapes().get(i);
							if(tempSquare.isSelected()==true){
								int result=JOptionPane.showConfirmDialog(contentPane, "Delete square[OK/CANCEL]:", "Delete square", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									selected0=false;
									drawingPanel.getShapes().remove(i);
								}
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Circle){
							tempCircle=(Circle)drawingPanel.getShapes().get(i);
							if(tempCircle.isSelected()==true){
								int result=JOptionPane.showConfirmDialog(contentPane, "Delete circle[OK/CANCEL]:", "Delete circle", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									selected0=false;
									drawingPanel.getShapes().remove(i);
								}
							}
						}else if(drawingPanel.getShapes().get(i) instanceof Rectangle){
							tempRect=(Rectangle)drawingPanel.getShapes().get(i);
							if(tempRect.isSelected()==true){
								int result=JOptionPane.showConfirmDialog(contentPane, "Delete rectangle[OK/CANCEL]:", "Delete rectangle", JOptionPane.OK_CANCEL_OPTION);
								if(result==JOptionPane.OK_OPTION){
									selected0=false;
									drawingPanel.getShapes().remove(i);
								}
							}	
						}				
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "You didn't choose the shape." , "Greska", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
}
