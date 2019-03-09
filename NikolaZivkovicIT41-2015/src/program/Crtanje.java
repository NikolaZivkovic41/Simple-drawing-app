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

public class Crtanje extends JFrame{

	private JPanel contentPane;
	private JPanel Opcije,Izmene,Oblici,Brisanje,gore;
	private PanelCrtanja dole;
	private JButton btnIzaberi,btnIzbrisi,btnIzbrisiSve,btnTacka,btnKvadrat,btnPravougaonik,btnLinija,btnKrug,btnInf,btnPromeni;
	
	private String btnClicked=null,duzinaStraniceString=null,poluprecnikString=null,visinaString=null;
	private Color unuBoja,spoljBoja;
	private int x,y,duzinaStranice,duzinaStrPrav,visina,poluprecnik;
	
	private boolean selektovanO=false;
	private Object tackaLinije;
	int linijaI=0;
	
	private JPanel infTacka,infLinija,infKvadrat,infKrug,infPrav;
	private JTextField xPocetnaField1,yPocetnaField1,xKrajnjaField1,yKrajnjaField1,duzinaStrField1,visinaField1,poluprecnikField1;
	private JTextField unuBojaField,spoljBojaField;
	private JPanel promeniTacka,promeniLinija,promeniKvadrat,promeniKrug,promeniPrav;
	private JTextField xPocetnaField,yPocetnaField,xKrajnjaField,yKrajnjaField,duzinaStrField,visinaField,poluprecnikField;
	private JButton novaUnuBoja,novaSpoljBoja;
	private Color novaSpolj,novaUnu;
	
	private Tacka pomocnaTacka;
	private Linija pomocnaLinija;
	private Kvadrat pomocniKvadrat;
	private Krug pomocniKrug;
	private Pravougaonik pomocniPrav;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crtanje frame = new Crtanje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Crtanje() {	
		Komponente();
		Operacije();
	}
	
	public void Komponente(){		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		setMinimumSize(new Dimension(1024, 576));
		setTitle("Zivkovic Nikola IT41-2015");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		gore = new JPanel();
		gore.setBackground(new Color(255, 255, 204));
		gore.setPreferredSize(new Dimension(1024,100));
		contentPane.add(gore, BorderLayout.NORTH);
		gore.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Opcije = new JPanel();
		Opcije.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Opcije", TitledBorder.LEADING, TitledBorder.BOTTOM, null, Color.GRAY));
		Opcije.setBackground(new Color(255, 255, 204));
		Opcije.setPreferredSize(new Dimension(165, 90));
		gore.add(Opcije);
		Opcije.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnIzaberi = new JButton("Izaberi");
		btnIzaberi.setFont(new Font("Arial", Font.BOLD, 16));
		btnIzaberi.setForeground(new Color(255, 255, 255));
		btnIzaberi.setBackground(new Color(0, 102, 255));
		btnIzaberi.setPreferredSize(new Dimension(130, 25));
		Opcije.add(btnIzaberi);
		
		Oblici = new JPanel();
		Oblici.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Oblici", TitledBorder.LEADING, TitledBorder.BOTTOM, null, Color.GRAY));
		Oblici.setBackground(new Color(255, 255, 204));
		Oblici.setPreferredSize(new Dimension(480, 90));
		gore.add(Oblici);
		Oblici.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnTacka = new JButton("Tacka");
		btnTacka.setForeground(new Color(255, 255, 255));
		btnTacka.setFont(new Font("Arial", Font.BOLD, 16));
		btnTacka.setBackground(new Color(0, 102, 255));
		btnTacka.setPreferredSize(new Dimension(135, 25));
		Oblici.add(btnTacka);
		
		btnKvadrat = new JButton("Kvadrat");
		btnKvadrat.setForeground(new Color(255, 255, 255));
		btnKvadrat.setFont(new Font("Arial", Font.BOLD, 16));
		btnKvadrat.setBackground(new Color(0, 102, 255));
		btnKvadrat.setPreferredSize(new Dimension(135, 25));
		Oblici.add(btnKvadrat);
		
		btnPravougaonik = new JButton("Pravougaonik");
		btnPravougaonik.setForeground(new Color(255, 255, 255));
		btnPravougaonik.setFont(new Font("Arial", Font.BOLD, 16));
		btnPravougaonik.setBackground(new Color(0, 102, 255));
		btnPravougaonik.setPreferredSize(new Dimension(150, 25));
		Oblici.add(btnPravougaonik);
		
		btnLinija = new JButton("Linija");
		btnLinija.setFont(new Font("Arial", Font.BOLD, 16));
		btnLinija.setForeground(new Color(255, 255, 255));
		btnLinija.setBackground(new Color(0, 102, 255));
		btnLinija.setPreferredSize(new Dimension(140, 25));
		Oblici.add(btnLinija);
		
		btnKrug = new JButton("Krug");
		btnKrug.setFont(new Font("Arial", Font.BOLD, 16));
		btnKrug.setForeground(new Color(255, 255, 255));
		btnKrug.setBackground(new Color(0, 102, 255));
		btnKrug.setPreferredSize(new Dimension(140, 25));
		Oblici.add(btnKrug);
		
		Izmene = new JPanel();
		Izmene.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Izmene", TitledBorder.LEADING, TitledBorder.BOTTOM, null, Color.GRAY));
		Izmene.setBackground(new Color(255, 255, 204));
		Izmene.setPreferredSize(new Dimension(165, 90));
		gore.add(Izmene);
		Izmene.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnInf = new JButton("Informacije");
		btnInf.setFont(new Font("Arial", Font.BOLD, 16));
		btnInf.setForeground(new Color(255, 255, 255));
		btnInf.setBackground(new Color(0, 102, 255));
		btnInf.setPreferredSize(new Dimension(130, 25));
		Izmene.add(btnInf);
		
		btnPromeni = new JButton("Promeni");
		btnPromeni.setFont(new Font("Arial", Font.BOLD, 16));
		btnPromeni.setForeground(new Color(255, 255, 255));
		btnPromeni.setBackground(new Color(0, 102, 255));
		btnPromeni.setPreferredSize(new Dimension(130, 25));
		Izmene.add(btnPromeni);
		
		Brisanje = new JPanel();
		Brisanje.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Brisanje", TitledBorder.LEADING, TitledBorder.BOTTOM, null, Color.GRAY));
		Brisanje.setBackground(new Color(255, 255, 204));
		Brisanje.setPreferredSize(new Dimension(165, 90));
		gore.add(Brisanje);
		Brisanje.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.setBackground(new Color(0, 102, 255));
		btnIzbrisi.setFont(new Font("Arial", Font.BOLD, 16));
		btnIzbrisi.setForeground(new Color(255, 255, 255));
		btnIzbrisi.setPreferredSize(new Dimension(130, 25));
		Brisanje.add(btnIzbrisi);
		
		btnIzbrisiSve = new JButton("Izbrisi Sve");
		btnIzbrisiSve.setBackground(new Color(0, 102, 255));
		btnIzbrisiSve.setFont(new Font("Arial", Font.BOLD, 16));
		btnIzbrisiSve.setForeground(new Color(255, 255, 255));
		btnIzbrisiSve.setPreferredSize(new Dimension(130, 25));
		Brisanje.add(btnIzbrisiSve);
		
		novaSpoljBoja=new JButton("Spoljasnja"); 
		novaUnuBoja=new JButton("Unutrasnja");
		
		dole = new PanelCrtanja();
		dole.setPreferredSize(new Dimension(1024,476));
		contentPane.add(dole, BorderLayout.CENTER);
	}
	
	public void Operacije(){
		dole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnClicked=="tacka"){
					x=arg0.getX();
					y=arg0.getY();
					spoljBoja=JColorChooser.showDialog(contentPane,"Izaberite spoljasnju boju", Color.white);
					Tacka t1=new Tacka(x,y,spoljBoja);
					dole.getOblici().add(t1);
				}else if(btnClicked=="linija"){
					if(linijaI==0){
						tackaLinije=new Linija(new Tacka(arg0.getX(),arg0.getY()),new Tacka(0,0));
						linijaI=1;
						return;
					}else{
						Linija l1=(Linija)tackaLinije;
						l1.settKrajnja(new Tacka(arg0.getX(),arg0.getY()));
						spoljBoja=JColorChooser.showDialog(contentPane,"Izaberite spoljasnju boju", Color.white);
						l1.setSpoljBoja(spoljBoja);
						dole.getOblici().add(l1);
						linijaI=0;
					}	
				}else if(btnClicked=="kvadrat"){
					x=arg0.getX();
					y=arg0.getY();
					duzinaStraniceString=JOptionPane.showInputDialog(contentPane, "Unesite duzinu stranice kvadrata:");
					boolean probaj = true;
					while(probaj)
					{
						try{
							 duzinaStranice=Integer.parseInt(duzinaStraniceString);
							 if(duzinaStranice <= 0)
								 throw new IllegalArgumentException("Vrednost mora biti veca od nule.");
							 spoljBoja=JColorChooser.showDialog(contentPane,"Izaberite spoljasnju boju", Color.white);	
							 unuBoja=JColorChooser.showDialog(contentPane,"Izaberite unutrasnju boju", Color.white);
							 Kvadrat kvadrat = new Kvadrat(new Tacka(x,y), duzinaStranice,unuBoja,spoljBoja);	 
							 dole.getOblici().add(kvadrat);
							 probaj = false;
						}
						catch(NumberFormatException nfe)
						{
							duzinaStraniceString=JOptionPane.showInputDialog(contentPane, "Unesite pozitivnu duzinu stranice kvadrata:");
						}
						catch(IllegalArgumentException ex)
						{		
							duzinaStraniceString = JOptionPane.showInputDialog(null, ex.getMessage(), "Ponovite unos", JOptionPane.QUESTION_MESSAGE );						
						}
					}
				}else if(btnClicked=="krug"){
					x=arg0.getX();
					y=arg0.getY();
					poluprecnikString=JOptionPane.showInputDialog(contentPane, "Unesite poluprecnik kruga:");
					boolean probaj = true;
					while(probaj)
					{
						try{
							 poluprecnik=Integer.parseInt(poluprecnikString);
							 if(poluprecnik <= 0)
								 throw new IllegalArgumentException("Vrednost mora biti veca od nule.");
							 spoljBoja=JColorChooser.showDialog(contentPane,"Izaberite spoljasnju boju", Color.white);	
							 unuBoja=JColorChooser.showDialog(contentPane,"Izaberite unutrasnju boju", Color.white);
							 Krug krug = new Krug(new Tacka(x,y),poluprecnik, unuBoja,spoljBoja);
							 dole.getOblici().add(krug);
							 probaj = false;
						}
						catch(NumberFormatException nfe)
						{
							poluprecnikString=JOptionPane.showInputDialog(contentPane, "Unesite pozitivnu vrednost poluprecnika kruga::");
						}
						catch(IllegalArgumentException ex)
						{		
							poluprecnikString = JOptionPane.showInputDialog(null, ex.getMessage(), "Ponovite unos", JOptionPane.QUESTION_MESSAGE );						
						}
					}
				}else if(btnClicked=="pravougaonik"){
					x=arg0.getX();
					y=arg0.getY();
					duzinaStraniceString=JOptionPane.showInputDialog(contentPane, "Unesite duzinu stranice pravougaonika:");
					boolean probaj = true;
					while(probaj)
					{
						try{
							 duzinaStrPrav=Integer.parseInt(duzinaStraniceString);
							 if(duzinaStrPrav <= 0)
								 throw new IllegalArgumentException("Vrednost mora biti veca od nule.");
							 probaj = false;
						}
						catch(NumberFormatException nfe)
						{
							duzinaStraniceString=JOptionPane.showInputDialog(contentPane, "Unesite pozitivnu duzinu stranice pravougaonika:");
						}
						catch(IllegalArgumentException ex)
						{		
							duzinaStraniceString = JOptionPane.showInputDialog(contentPane, ex.getMessage(), "Ponovite unos", JOptionPane.QUESTION_MESSAGE );						
						}
					}
					visinaString=JOptionPane.showInputDialog(contentPane, "Unesite visinu pravougaonika:");
					probaj = true;
					while(probaj)
					{
						try{
							 visina=Integer.parseInt(visinaString);
							 if(visina <= 0)
								 throw new IllegalArgumentException("Vrednost mora biti veca od nule.");
							 spoljBoja=JColorChooser.showDialog(contentPane,"Izaberite spoljasnju boju", Color.white);	
							 unuBoja=JColorChooser.showDialog(contentPane,"Izaberite unutrasnju boju", Color.white);
							 Pravougaonik prav = new Pravougaonik(new Tacka(x,y),duzinaStrPrav,visina,unuBoja,spoljBoja);
							 dole.getOblici().add(prav);
							 probaj = false;
						}
						catch(NumberFormatException nfe)
						{
							visinaString=JOptionPane.showInputDialog(contentPane, "Unesite pozitivnu vrednost visine pravougaonika:");
						}
						catch(IllegalArgumentException ex)
						{		
							visinaString = JOptionPane.showInputDialog(contentPane, ex.getMessage(), "Ponovite unos", JOptionPane.QUESTION_MESSAGE );						
						}
					}
				}else if(btnClicked=="izaberi"){
					if(selektovanO==false){
						for(int i=dole.getOblici().size()-1;i>=0;i--){
							if(dole.getOblici().get(i) instanceof Tacka){
								pomocnaTacka=(Tacka)dole.getOblici().get(i);
								if(pomocnaTacka.sadrzi(arg0.getX(), arg0.getY())){
									pomocnaTacka.setSelektovan(true);
									pomocnaTacka.selektovan(dole.getGraphics());								
									selektovanO=true;
									return;
								}
							}else if(dole.getOblici().get(i) instanceof Linija){
								pomocnaLinija=(Linija)dole.getOblici().get(i);
								if(pomocnaLinija.sadrzi(arg0.getX(), arg0.getY())){
									pomocnaLinija.setSelektovan(true);
									pomocnaLinija.selektovan(dole.getGraphics());								
									selektovanO=true;
									return;
								}
							}else if(dole.getOblici().get(i) instanceof Kvadrat){
								pomocniKvadrat=(Kvadrat)dole.getOblici().get(i);
								if(pomocniKvadrat.sadrzi(arg0.getX(), arg0.getY())){
									pomocniKvadrat.setSelektovan(true);
									pomocniKvadrat.selektovan(dole.getGraphics());								
									selektovanO=true;
									return;
								}
							}else if(dole.getOblici().get(i) instanceof Krug){
								pomocniKrug=(Krug)dole.getOblici().get(i);
								if(pomocniKrug.sadrzi(arg0.getX(), arg0.getY())){
									pomocniKrug.setSelektovan(true);
									pomocniKrug.selektovan(dole.getGraphics());								
									selektovanO=true;
									return;
								}
							}else if(dole.getOblici().get(i) instanceof Pravougaonik){
								pomocniPrav=(Pravougaonik)dole.getOblici().get(i);
								if(pomocniPrav.sadrzi(arg0.getX(), arg0.getY())){
									pomocniPrav.setSelektovan(true);
									pomocniPrav.selektovan(dole.getGraphics());									
									selektovanO=true;
									return;
								}
							}				
						}
					}		
				}
			}
		});
		btnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="tacka";
			}
		});
		btnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="linija";
			}
		});
		btnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="kvadrat";
			}
		});
		btnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="krug";
			}
		});
		btnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicked="pravougaonik";
			}
		});
		novaSpoljBoja.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				novaSpolj=JColorChooser.showDialog(contentPane,"Izaberite novu spoljasnju boju", Color.white);
				novaSpoljBoja.setBackground(novaSpolj);
			}
		});
		novaUnuBoja.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				novaUnu=JColorChooser.showDialog(contentPane,"Izaberite novu unutrasnju boju", Color.white);
				novaUnuBoja.setBackground(novaUnu);
			}
		});
		btnIzaberi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				btnClicked="izaberi";
			}
		});
		btnInf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(btnClicked=="izaberi" && selektovanO==true){
					for(int i=dole.getOblici().size()-1;i>=0;i--){
						if(dole.getOblici().get(i) instanceof Tacka){
							pomocnaTacka=(Tacka)dole.getOblici().get(i);
							if(pomocnaTacka.isSelektovan()==true){
								infTacka=new JPanel();
								xPocetnaField1=new JTextField(5); xPocetnaField1.setEditable(false);
								yPocetnaField1=new JTextField(5); yPocetnaField1.setEditable(false);
								spoljBojaField=new JTextField("Spoljasnja"); spoljBojaField.setEditable(false);
								infTacka.add(new JLabel("X koordinata tacke:")); infTacka.add(xPocetnaField1);
								infTacka.add(new JLabel("Y koordinata tacke:")); infTacka.add(yPocetnaField1);
								infTacka.add(new JLabel("Boje:")); infTacka.add(spoljBojaField);
								xPocetnaField1.setText(Integer.toString(pomocnaTacka.getX()));
								yPocetnaField1.setText(Integer.toString(pomocnaTacka.getY()));
								spoljBojaField.setBackground(pomocnaTacka.getSpoljBoja());
								JOptionPane.showConfirmDialog(contentPane, infTacka,"Informacije o tacki", JOptionPane.OK_CANCEL_OPTION);
								xPocetnaField1.setText("");
								yPocetnaField1.setText("");
								spoljBojaField.setBackground(null);
								selektovanO=false;
								pomocnaTacka.setSelektovan(false);
								pomocnaTacka.selektovan(dole.getGraphics());
							}
						}else if(dole.getOblici().get(i) instanceof Linija){
							pomocnaLinija=(Linija)dole.getOblici().get(i);
							if(pomocnaLinija.isSelektovan()==true){
								infLinija=new JPanel();
								xPocetnaField1=new JTextField(5); xPocetnaField1.setEditable(false);
								yPocetnaField1=new JTextField(5); yPocetnaField1.setEditable(false);
								xKrajnjaField1=new JTextField(5); xKrajnjaField1.setEditable(false);
								yKrajnjaField1=new JTextField(5); yKrajnjaField1.setEditable(false);
								spoljBojaField=new JTextField("Spoljasnja"); spoljBojaField.setEditable(false);
								infLinija.add(new JLabel("X koordinata pocetne tacke:")); infLinija.add(xPocetnaField1);
								infLinija.add(new JLabel("Y koordinata pocetne tacke:")); infLinija.add(yPocetnaField1);
								infLinija.add(new JLabel("X koordinata krajnje tacke:")); infLinija.add(xKrajnjaField1);
								infLinija.add(new JLabel("Y koordinata krajnje tacke:")); infLinija.add(yKrajnjaField1);
								infLinija.add(new JLabel("Boje:")); infLinija.add(spoljBojaField);
								xPocetnaField1.setText(Integer.toString(pomocnaLinija.gettPocetna().getX()));
								yPocetnaField1.setText(Integer.toString(pomocnaLinija.gettPocetna().getY()));
								xKrajnjaField1.setText(Integer.toString(pomocnaLinija.gettKrajnja().getX()));
								yKrajnjaField1.setText(Integer.toString(pomocnaLinija.gettKrajnja().getY()));
								spoljBojaField.setBackground(pomocnaLinija.getSpoljBoja());
								JOptionPane.showConfirmDialog(contentPane, infLinija,"Informacije o liniji", JOptionPane.OK_CANCEL_OPTION);
								xPocetnaField1.setText("");
								yPocetnaField1.setText("");
								xKrajnjaField1.setText("");
								yKrajnjaField1.setText("");
								spoljBojaField.setBackground(null);
								pomocnaLinija.setSelektovan(false);
								pomocnaLinija.selektovan(dole.getGraphics());
								selektovanO=false;
							}
						}else if(dole.getOblici().get(i) instanceof Kvadrat){
							pomocniKvadrat=(Kvadrat)dole.getOblici().get(i);
							if(pomocniKvadrat.isSelektovan()==true){
								infKvadrat=new JPanel();
								xPocetnaField1=new JTextField(5); xPocetnaField1.setEditable(false);
								yPocetnaField1=new JTextField(5); yPocetnaField1.setEditable(false);
								duzinaStrField1=new JTextField(5); duzinaStrField1.setEditable(false);
								spoljBojaField=new JTextField("Spoljasnja"); spoljBojaField.setEditable(false);
								unuBojaField=new JTextField("Unutrasnja"); unuBojaField.setEditable(false);
								infKvadrat.add(new JLabel("X koordinata tacke gore levo:")); infKvadrat.add(xPocetnaField1);
								infKvadrat.add(new JLabel("Y koordinata tacke gore levo:")); infKvadrat.add(yPocetnaField1);
								infKvadrat.add(new JLabel("Duzina stranice kvadrata:")); infKvadrat.add(duzinaStrField1);
								infKvadrat.add(new JLabel("Boje:")); infKvadrat.add(spoljBojaField); infKvadrat.add(unuBojaField);
								xPocetnaField1.setText(Integer.toString(pomocniKvadrat.getGoreLevo().getX()));
								yPocetnaField1.setText(Integer.toString(pomocniKvadrat.getGoreLevo().getY()));
								duzinaStrField1.setText(Integer.toString(pomocniKvadrat.getDuzinaStranice()));
								spoljBojaField.setBackground(pomocniKvadrat.getSpoljBoja()); unuBojaField.setBackground(pomocniKvadrat.getUnuBoja());
								JOptionPane.showConfirmDialog(contentPane, infKvadrat,"Informacije o kvadratu", JOptionPane.OK_CANCEL_OPTION);
								pomocniKvadrat.setSelektovan(false);
								pomocniKvadrat.selektovan(dole.getGraphics());
								selektovanO=false;
								xPocetnaField1.setText("");
								yPocetnaField1.setText("");
								duzinaStrField1.setText("");
								spoljBojaField.setBackground(null); unuBojaField.setBackground(null);
							}
						}else if(dole.getOblici().get(i) instanceof Krug){
							pomocniKrug=(Krug)dole.getOblici().get(i);
							if(pomocniKrug.isSelektovan()==true){
								infKrug=new JPanel();
								xPocetnaField1=new JTextField(5); xPocetnaField1.setEditable(false);
								yPocetnaField1=new JTextField(5); yPocetnaField1.setEditable(false);
								poluprecnikField1=new JTextField(5); poluprecnikField1.setEditable(false);
								spoljBojaField=new JTextField("Spoljasnja"); spoljBojaField.setEditable(false);
								unuBojaField=new JTextField("Unutrasnja"); unuBojaField.setEditable(false);
								infKrug.add(new JLabel("X koordinata centra:")); infKrug.add(xPocetnaField1);
								infKrug.add(new JLabel("Y koordinata centra:")); infKrug.add(yPocetnaField1);
								infKrug.add(new JLabel("Poluprecnik kruga:")); infKrug.add(poluprecnikField1);
								infKrug.add(new JLabel("Boje:")); infKrug.add(spoljBojaField); infKrug.add(unuBojaField);
								xPocetnaField1.setText(Integer.toString(pomocniKrug.getCentar().getX()));
								yPocetnaField1.setText(Integer.toString(pomocniKrug.getCentar().getY()));
								poluprecnikField1.setText(Integer.toString(pomocniKrug.getR()));
								spoljBojaField.setBackground(pomocniKrug.getSpoljBoja()); unuBojaField.setBackground(pomocniKrug.getUnuBoja());
								JOptionPane.showConfirmDialog(contentPane, infKrug,"Informacije o krugu", JOptionPane.OK_CANCEL_OPTION);
								pomocniKrug.setSelektovan(false);
								pomocniKrug.selektovan(dole.getGraphics());
								selektovanO=false;
								xPocetnaField1.setText("");
								yPocetnaField1.setText("");
								poluprecnikField1.setText("");
								spoljBojaField.setBackground(null); unuBojaField.setBackground(null);
							}
						}else if(dole.getOblici().get(i) instanceof Pravougaonik){
							pomocniPrav=(Pravougaonik)dole.getOblici().get(i);
							if(pomocniPrav.isSelektovan()==true){
								infPrav=new JPanel();
								xPocetnaField1=new JTextField(5); xPocetnaField1.setEditable(false);
								yPocetnaField1=new JTextField(5); yPocetnaField1.setEditable(false);
								duzinaStrField1=new JTextField(5); duzinaStrField1.setEditable(false);
								visinaField1=new JTextField(5); visinaField1.setEditable(false);
								spoljBojaField=new JTextField("Spoljasnja"); spoljBojaField.setEditable(false);
								unuBojaField=new JTextField("Unutrasnja"); unuBojaField.setEditable(false);
								infPrav.add(new JLabel("X koordinata tacke gore levo:")); infPrav.add(xPocetnaField1);
								infPrav.add(new JLabel("Y koordinata tacke gore levo:")); infPrav.add(yPocetnaField1);
								infPrav.add(new JLabel("Duzina stranice pravougaonika:")); infPrav.add(duzinaStrField1);
								infPrav.add(new JLabel("Visina pravougaonika:")); infPrav.add(visinaField1);
								infPrav.add(new JLabel("Boje:")); infPrav.add(spoljBojaField); infPrav.add(unuBojaField);
								xPocetnaField1.setText(Integer.toString(pomocniPrav.getGoreLevo().getX()));
								yPocetnaField1.setText(Integer.toString(pomocniPrav.getGoreLevo().getY()));
								duzinaStrField1.setText(Integer.toString(pomocniPrav.getDuzinaStranice()));
								visinaField1.setText(Integer.toString(pomocniPrav.getVisina()));
								spoljBojaField.setBackground(pomocniPrav.getSpoljBoja()); unuBojaField.setBackground(pomocniPrav.getUnuBoja());
								JOptionPane.showConfirmDialog(contentPane, infPrav,"Informacije o pravougaoniku", JOptionPane.OK_CANCEL_OPTION);
								pomocniPrav.setSelektovan(false);
								pomocniPrav.selektovan(dole.getGraphics());
								selektovanO=false;
								xPocetnaField1.setText("");
								yPocetnaField1.setText("");
								duzinaStrField1.setText("");
								visinaField1.setText("");
								spoljBojaField.setBackground(null); unuBojaField.setBackground(null);
							}	
						}				
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Niste izabrali oblik." , "Greska", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnPromeni.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(btnClicked=="izaberi" && selektovanO==true){
					for(int i=dole.getOblici().size()-1;i>=0;i--){
						if(dole.getOblici().get(i) instanceof Tacka){
							pomocnaTacka=(Tacka)dole.getOblici().get(i);
							if(pomocnaTacka.isSelektovan()==true){
								promeniTacka=new JPanel();
								promeniTacka.setPreferredSize(new Dimension(250,130));
								novaSpoljBoja.setBackground(pomocnaTacka.getSpoljBoja());
								xPocetnaField=new JTextField(5); xPocetnaField.setText(Integer.toString(pomocnaTacka.getX()));
								yPocetnaField=new JTextField(5); yPocetnaField.setText(Integer.toString(pomocnaTacka.getY()));
								promeniTacka.add(new JLabel("Promeni X koordinatu tacke:")); promeniTacka.add(xPocetnaField);
								promeniTacka.add(new JLabel("Promeni Y koordinatu tacke:")); promeniTacka.add(yPocetnaField);
								promeniTacka.add(new JLabel("Boje:")); promeniTacka.add(novaSpoljBoja);
								int rezultat=JOptionPane.showConfirmDialog(contentPane, promeniTacka,"Promeni tacku", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									Tacka nova=new Tacka(Integer.parseInt(xPocetnaField.getText()),Integer.parseInt(yPocetnaField.getText()),novaSpolj);
									selektovanO=false;
									xPocetnaField.setText("");
									yPocetnaField.setText("");
									novaSpoljBoja.setBackground(null);
									dole.getOblici().remove(i);
									dole.getOblici().add(i, nova);
								}	
							}
						}else if(dole.getOblici().get(i) instanceof Linija){
							pomocnaLinija=(Linija)dole.getOblici().get(i);
							if(pomocnaLinija.isSelektovan()==true){
								promeniLinija=new JPanel();
								promeniLinija.setPreferredSize(new Dimension(300,150));
								novaSpoljBoja.setBackground(pomocnaLinija.getSpoljBoja());
								xPocetnaField=new JTextField(5); xPocetnaField.setText(Integer.toString(pomocnaLinija.gettPocetna().getX()));
								yPocetnaField=new JTextField(5); yPocetnaField.setText(Integer.toString(pomocnaLinija.gettPocetna().getY()));
								xKrajnjaField=new JTextField(5); xKrajnjaField.setText(Integer.toString(pomocnaLinija.gettKrajnja().getX()));
								yKrajnjaField=new JTextField(5); yKrajnjaField.setText(Integer.toString(pomocnaLinija.gettKrajnja().getY()));
								promeniLinija.add(new JLabel("Promeni X koordinatu pocetne tacke:")); promeniLinija.add(xPocetnaField);
								promeniLinija.add(new JLabel("Promeni Y koordinatu pocetne tacke:")); promeniLinija.add(yPocetnaField);
								promeniLinija.add(new JLabel("Promeni X koordinatu krajnje tacke:")); promeniLinija.add(xKrajnjaField);
								promeniLinija.add(new JLabel("Promeni Y koordinatu krajnje tacke:")); promeniLinija.add(yKrajnjaField);
								promeniLinija.add(new JLabel("Boje:")); promeniLinija.add(novaSpoljBoja);
								int rezultat=JOptionPane.showConfirmDialog(contentPane, promeniLinija,"Promeni liniju", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									int pocetnaX=Integer.parseInt(xPocetnaField.getText()); int pocetnaY=Integer.parseInt(yPocetnaField.getText());
									int krajnjaX=Integer.parseInt(xKrajnjaField.getText()); int krajnjaY=Integer.parseInt(yKrajnjaField.getText());
									Linija nova=new Linija(new Tacka(pocetnaX,pocetnaY),new Tacka(krajnjaX,krajnjaY),novaSpolj);
									selektovanO=false;
									xPocetnaField.setText(""); xKrajnjaField.setText("");
									yPocetnaField.setText(""); yKrajnjaField.setText("");
									novaSpoljBoja.setBackground(null);
									dole.getOblici().remove(i);
									dole.getOblici().add(i, nova);
								}			
							}
						}else if(dole.getOblici().get(i) instanceof Kvadrat){
							pomocniKvadrat=(Kvadrat)dole.getOblici().get(i);
							if(pomocniKvadrat.isSelektovan()==true){
								promeniKvadrat=new JPanel();
								promeniKvadrat.setPreferredSize(new Dimension(293,150));
								novaSpoljBoja.setBackground(pomocniKvadrat.getSpoljBoja()); novaUnuBoja.setBackground(pomocniKvadrat.getUnuBoja());
								xPocetnaField=new JTextField(5); xPocetnaField.setText(Integer.toString(pomocniKvadrat.getGoreLevo().getX()));
								yPocetnaField=new JTextField(5); yPocetnaField.setText(Integer.toString(pomocniKvadrat.getGoreLevo().getY()));
								duzinaStrField=new JTextField(5); duzinaStrField.setText(Integer.toString(pomocniKvadrat.getDuzinaStranice()));
								promeniKvadrat.add(new JLabel("Promeni X koordinatu tacke gore levo:")); promeniKvadrat.add(xPocetnaField);
								promeniKvadrat.add(new JLabel("Promeni Y koordinatu tacke gore levo:")); promeniKvadrat.add(yPocetnaField);
								promeniKvadrat.add(new JLabel("Promeni duzinu stranice kvadrata:")); promeniKvadrat.add(duzinaStrField);
								promeniKvadrat.add(new JLabel("Boje:")); promeniKvadrat.add(novaSpoljBoja); promeniKvadrat.add(novaUnuBoja);
								int rezultat=JOptionPane.showConfirmDialog(contentPane, promeniKvadrat,"Promeni kvadrat", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									int goreLevoX=Integer.parseInt(xPocetnaField.getText()); int goreLevoY=Integer.parseInt(yPocetnaField.getText());
									int duzinaStr=Integer.parseInt(duzinaStrField.getText()); 
									Kvadrat novi=new Kvadrat(new Tacka(goreLevoX,goreLevoY),duzinaStr,novaUnu,novaSpolj);
									selektovanO=false;
									xPocetnaField.setText(""); duzinaStrField.setText("");
									yPocetnaField.setText(""); 
									novaSpoljBoja.setBackground(null); novaUnuBoja.setBackground(null);
									dole.getOblici().remove(i);
									dole.getOblici().add(i, novi);
								}
							}
						}else if(dole.getOblici().get(i) instanceof Krug){
							pomocniKrug=(Krug)dole.getOblici().get(i);
							if(pomocniKrug.isSelektovan()==true){
								promeniKrug=new JPanel();
								promeniKrug.setPreferredSize(new Dimension(240,130));
								xPocetnaField=new JTextField(5); xPocetnaField.setText(Integer.toString(pomocniKrug.getCentar().getX()));
								yPocetnaField=new JTextField(5); yPocetnaField.setText(Integer.toString(pomocniKrug.getCentar().getY()));
								poluprecnikField=new JTextField(5); poluprecnikField.setText(Integer.toString(pomocniKrug.getR()));
								novaSpoljBoja.setBackground(pomocniKrug.getSpoljBoja()); novaUnuBoja.setBackground(pomocniKrug.getUnuBoja());
								promeniKrug.add(new JLabel("Promeni X koordinatu centra:")); promeniKrug.add(xPocetnaField);
								promeniKrug.add(new JLabel("Promeni Y koordinatu centra:")); promeniKrug.add(yPocetnaField);
								promeniKrug.add(new JLabel("Promeni poluprecnik kruga:")); promeniKrug.add(poluprecnikField);
								promeniKrug.add(new JLabel("Boje:")); promeniKrug.add(novaSpoljBoja); promeniKrug.add(novaUnuBoja);
								int rezultat=JOptionPane.showConfirmDialog(contentPane, promeniKrug,"Promeni krug", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									int centarX=Integer.parseInt(xPocetnaField.getText()); int centarY=Integer.parseInt(yPocetnaField.getText());
									int poluprecnik=Integer.parseInt(poluprecnikField.getText()); 
									Krug novi=new Krug(new Tacka(centarX,centarY),poluprecnik,novaUnu,novaSpolj);
									selektovanO=false;
									xPocetnaField.setText(""); poluprecnikField.setText("");
									yPocetnaField.setText(""); 
									novaSpoljBoja.setBackground(null); novaUnuBoja.setBackground(null);
									dole.getOblici().remove(i);
									dole.getOblici().add(i, novi);
								}	
							}
						}else if(dole.getOblici().get(i) instanceof Pravougaonik){
							pomocniPrav=(Pravougaonik)dole.getOblici().get(i);
							if(pomocniPrav.isSelektovan()==true){
								promeniPrav=new JPanel();
								promeniPrav.setPreferredSize(new Dimension(300,150));
								novaSpoljBoja.setBackground(pomocniPrav.getSpoljBoja()); novaUnuBoja.setBackground(pomocniPrav.getUnuBoja());
								xPocetnaField=new JTextField(5); xPocetnaField.setText(Integer.toString(pomocniPrav.getGoreLevo().getX()));
								yPocetnaField=new JTextField(5); yPocetnaField.setText(Integer.toString(pomocniPrav.getGoreLevo().getY()));							
								visinaField=new JTextField(5); visinaField.setText(Integer.toString(pomocniPrav.getVisina()));
								duzinaStrField=new JTextField(5); duzinaStrField.setText(Integer.toString(pomocniPrav.getDuzinaStranice()));
								promeniPrav.add(new JLabel("Promeni X koordinatu tacke gore levo:")); promeniPrav.add(xPocetnaField);
								promeniPrav.add(new JLabel("Promeni Y koordinatu tacke gore levo:")); promeniPrav.add(yPocetnaField);
								promeniPrav.add(new JLabel("Promeni visinu pravougaonika:")); promeniPrav.add(visinaField);
								promeniPrav.add(new JLabel("Promeni duzinu stranice pravougaonika:")); promeniPrav.add(duzinaStrField);
								promeniPrav.add(new JLabel("Boje:")); promeniPrav.add(novaSpoljBoja); promeniPrav.add(novaUnuBoja);
								int rezultat=JOptionPane.showConfirmDialog(contentPane, promeniPrav,"Promeni pravougaonik", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									int goreLevoX=Integer.parseInt(xPocetnaField.getText()); int goreLevoY=Integer.parseInt(yPocetnaField.getText());
									int duzinaStr=Integer.parseInt(duzinaStrField.getText()); int visina=Integer.parseInt(visinaField.getText());
									Pravougaonik novi=new Pravougaonik(new Tacka(goreLevoX,goreLevoY),duzinaStr,visina,novaUnu,novaSpolj);
									selektovanO=false;
									xPocetnaField.setText(""); duzinaStrField.setText("");
									yPocetnaField.setText(""); visinaField.setText("");
									novaSpoljBoja.setBackground(null); novaUnuBoja.setBackground(null);
									dole.getOblici().remove(i);
									dole.getOblici().add(i, novi);
								}
							}	
						}				
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Niste izabrali koji oblik menjate." , "Greska", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnIzbrisiSve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dole.getOblici().isEmpty()==true ){
					JOptionPane.showMessageDialog(contentPane, "Nema sta da se obrise." , "Greska", JOptionPane.INFORMATION_MESSAGE);
				}else{
					int rezultat=JOptionPane.showConfirmDialog(contentPane, "Izbrisi sve[OK/CANCEL]:", "Brisanje svega", JOptionPane.OK_CANCEL_OPTION);
					if(rezultat==JOptionPane.OK_OPTION){
						for(int i=dole.getOblici().size()-1;i>=0;i--){
							dole.getOblici().remove(i);
						}
					}
				}
			}
		});
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnClicked=="izaberi" && selektovanO==true){
					for(int i=dole.getOblici().size()-1;i>=0;i--){
						if(dole.getOblici().get(i) instanceof Tacka){
							pomocnaTacka=(Tacka)dole.getOblici().get(i);
							if(pomocnaTacka.isSelektovan()==true){
								int rezultat=JOptionPane.showConfirmDialog(contentPane, "Izbrisi tacku[OK/CANCEL]:", "Brisanje tacke", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									selektovanO=false;
									dole.getOblici().remove(i);
								}
							}
						}else if(dole.getOblici().get(i) instanceof Linija){
							pomocnaLinija=(Linija)dole.getOblici().get(i);
							if(pomocnaLinija.isSelektovan()==true){
								int rezultat=JOptionPane.showConfirmDialog(contentPane, "Izbrisi liniju[OK/CANCEL]:", "Brisanje linije", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									selektovanO=false;
									dole.getOblici().remove(i);
								}
							}
						}else if(dole.getOblici().get(i) instanceof Kvadrat){
							pomocniKvadrat=(Kvadrat)dole.getOblici().get(i);
							if(pomocniKvadrat.isSelektovan()==true){
								int rezultat=JOptionPane.showConfirmDialog(contentPane, "Izbrisi kvadrat[OK/CANCEL]:", "Brisanje kvadrata", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									selektovanO=false;
									dole.getOblici().remove(i);
								}
							}
						}else if(dole.getOblici().get(i) instanceof Krug){
							pomocniKrug=(Krug)dole.getOblici().get(i);
							if(pomocniKrug.isSelektovan()==true){
								int rezultat=JOptionPane.showConfirmDialog(contentPane, "Izbrisi krug[OK/CANCEL]:", "Brisanje kruga", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									selektovanO=false;
									dole.getOblici().remove(i);
								}
							}
						}else if(dole.getOblici().get(i) instanceof Pravougaonik){
							pomocniPrav=(Pravougaonik)dole.getOblici().get(i);
							if(pomocniPrav.isSelektovan()==true){
								int rezultat=JOptionPane.showConfirmDialog(contentPane, "Izbrisi pravougaonik[OK/CANCEL]:", "Brisanje pravougaonika", JOptionPane.OK_CANCEL_OPTION);
								if(rezultat==JOptionPane.OK_OPTION){
									selektovanO=false;
									dole.getOblici().remove(i);
								}
							}	
						}				
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Niste izabrali koji oblik brisete." , "Greska", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
}
