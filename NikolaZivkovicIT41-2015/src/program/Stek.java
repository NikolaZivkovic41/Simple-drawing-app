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

public class Stek extends JFrame {

	private JPanel contentPane,panel;
	private Stack<Kvadrat> stek;
	private JLabel label;
	private JButton btnDodaj,btnIzbrisi;
	private JButton unutrasnjaBoja,spoljasnjaBoja;
	private Color unuBoja,spoljBoja,unuBoja1,spoljBoja1;
	private JPanel panel2,panelBoja,panel3,panelBoja1,bojaUnu,bojaSpolja;
	private JTextField text;
	private int xKvadrata,yKvadrata,duzinaStranice;
	private String xKoord,yKoord,duzinaStr;
	private JTextField xField,yField,strField,xField1,yField1,strField1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stek frame = new Stek();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Stek() {
		JTextField boja=new JTextField("Boje:");
		boja.setPreferredSize(new Dimension(200,20));
		boja.setBackground(null);
		boja.setBorder(new LineBorder(Color.BLACK,0));
		boja.setFont(new Font("Arial",Font.BOLD,12));
		JTextField spoljasnjaBB=new JTextField("Spoljasnja");
		spoljasnjaBB.setBackground(null);
		spoljasnjaBB.setBorder(new LineBorder(Color.BLACK,0));
		spoljasnjaBB.setForeground(Color.BLACK);
		JTextField unutrasnjaBB=new JTextField("Unutrasnja");
		unutrasnjaBB.setBackground(null);
		unutrasnjaBB.setBorder(new LineBorder(Color.BLACK,0));
		unutrasnjaBB.setForeground(Color.BLACK);
		text=new JTextField("Izaberite opciju:");
		text.setFont(new Font("Sans-Serif",Font.PLAIN,30));
		text.setEditable(false);
		text.setBorder(new EmptyBorder(0,0,0, 0));
		stek=new Stack<Kvadrat>();
		
		xField=new JTextField(5);
		yField=new JTextField(5);
		strField=new JTextField(5);
		unutrasnjaBoja=new JButton("Unutrasnja");
		unutrasnjaBoja.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				unuBoja=JColorChooser.showDialog(contentPane,"Izaberite unutrasnju boju", Color.white);
				unutrasnjaBoja.setBackground(unuBoja);
			}
		});
		spoljasnjaBoja=new JButton("Spoljasnja");
		spoljasnjaBoja.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				spoljBoja=JColorChooser.showDialog(contentPane,"Izaberite spoljasnju boju", Color.white);
				spoljasnjaBoja.setBackground(spoljBoja);
			}
		});
		panelBoja=new JPanel(new FlowLayout(0,5,0));
		panelBoja.add(unutrasnjaBoja); panelBoja.add(spoljasnjaBoja);
		panel2=new JPanel(new FlowLayout(0,5,5));
		panel2.setPreferredSize(new Dimension(220,140));
		panel2.add(new JLabel("Unesite x koordinatu:")); panel2.add(xField);
		panel2.add(new JLabel("Unesite y koordinatu:")); panel2.add(yField);
		panel2.add(new JLabel("Unesite duzinu stranice:")); panel2.add(strField);
		panel2.add(new JLabel("Izaberite boje:"));
		panel2.add(panelBoja);	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Zivkovic Nikola IT41-2015");
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
		
		label = new JLabel("Izaberite opciju:");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(label);
		
		btnDodaj = new JButton("Dodaj kvadrat na stek");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rezultat = JOptionPane.showConfirmDialog(contentPane, panel2,"Dodavanje elementa na stek", JOptionPane.OK_CANCEL_OPTION);
				if(rezultat==JOptionPane.OK_OPTION){
					xKoord=xField.getText();
					yKoord=yField.getText();
					duzinaStr=strField.getText();
					xKvadrata=Integer.parseInt(xKoord);
					yKvadrata=Integer.parseInt(yKoord);
					duzinaStranice=Integer.parseInt(duzinaStr);
					
					stek.push(new Kvadrat(new Tacka(xKvadrata,yKvadrata),duzinaStranice,unuBoja,spoljBoja));
					
				}
				xField.setText("");
				yField.setText("");
				strField.setText("");
				xKoord=null;
				yKoord=null;
				duzinaStr=null;
				unuBoja=null;
				spoljBoja=null;
				unutrasnjaBoja.setBackground(null);
				spoljasnjaBoja.setBackground(null);
			}
		});
		btnDodaj.setBackground(new Color(0, 102, 255));
		btnDodaj.setForeground(new Color(255, 255, 255));
		btnDodaj.setFont(new Font("Arial", Font.BOLD, 16));
		btnDodaj.setPreferredSize(new Dimension(240, 50));
		panel.add(btnDodaj);
		
		btnIzbrisi = new JButton("Izbrisi kvadrat sa steka");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(stek.isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "Stek je prazan.\nPrvo dodajte kvadrat na stek." , "Greska", JOptionPane.INFORMATION_MESSAGE);
				}else{
					xKoord=Integer.toString(stek.peek().getGoreLevo().getX());
					xField1=new JTextField(xKoord);
					yKoord=Integer.toString(stek.peek().getGoreLevo().getY());
					yField1=new JTextField(yKoord);
					duzinaStr=Integer.toString(stek.peek().getDuzinaStranice());
					strField1=new JTextField(duzinaStr);
					unuBoja1=stek.peek().getUnuBoja();
					spoljBoja1=stek.peek().getSpoljBoja();
					bojaUnu=new JPanel();
					bojaUnu.setPreferredSize(unutrasnjaBoja.getPreferredSize());
					bojaUnu.setBackground(unuBoja1); bojaUnu.add(unutrasnjaBB);
					bojaSpolja=new JPanel();
					bojaSpolja.setPreferredSize(spoljasnjaBoja.getPreferredSize());
					bojaSpolja.setBackground(spoljBoja1); bojaSpolja.add(spoljasnjaBB);
					panelBoja1=new JPanel(new FlowLayout(0,5,0));
					panelBoja1.add(bojaUnu); panelBoja1.add(bojaSpolja);
					panel3=new JPanel(new FlowLayout(0,5,5));
					panel3.setPreferredSize(new Dimension(220,140));
					panel3.add(new JLabel("X koordinata:")); panel3.add(xField1);
					panel3.add(new JLabel("Y koordinata:")); panel3.add(yField1);
					panel3.add(new JLabel("Duzina stranice:")); panel3.add(strField1);
					panel3.add(boja);
					panel3.add(panelBoja1);	
					int rezultat = JOptionPane.showConfirmDialog(contentPane, panel3,"Brisanje elementa sa steka", JOptionPane.OK_CANCEL_OPTION);
					if(rezultat==JOptionPane.OK_OPTION){
						stek.pop();
					}
				}
			}
		});
		btnIzbrisi.setFont(new Font("Arial", Font.BOLD, 16));
		btnIzbrisi.setForeground(new Color(255, 255, 255));
		btnIzbrisi.setBackground(new Color(0, 102, 255));
		btnIzbrisi.setPreferredSize(new Dimension(240, 50));
		panel.add(btnIzbrisi);
	}
}
