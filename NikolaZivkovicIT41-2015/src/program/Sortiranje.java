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

public class Sortiranje extends JFrame {
	private JButton btnDodajKvadratU,btnSortirajListuI;
	private JPanel contentPane,panel;
	private ArrayList<Kvadrat> kvadrati=new ArrayList<Kvadrat>();
	private JTextField xKoordStr,yKoordStr,duzinaStr;
	private JPanel panelKvadrata;
	private JTextArea sortK;
	private String kvLista="";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sortiranje frame = new Sortiranje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sortiranje() {
		Komponente();
		Operacije();
	}
	
	public void Komponente(){
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
		panel.setBackground(new Color(255, 255, 204));
		panel.setPreferredSize(new Dimension(250, 250));
		contentPane.add(panel);
		
		JLabel lblIzaberiteOpciju = new JLabel("Izaberite opciju:");
		lblIzaberiteOpciju.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblIzaberiteOpciju);
		
		btnDodajKvadratU = new JButton("Dodaj kvadrat u listu");
		btnDodajKvadratU.setPreferredSize(new Dimension(240, 50));
		btnDodajKvadratU.setBackground(new Color(0, 102, 255));
		btnDodajKvadratU.setForeground(new Color(255, 255, 255));
		btnDodajKvadratU.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(btnDodajKvadratU);
		
		btnSortirajListuI = new JButton("Sortiraj listu i prikazi");
		btnSortirajListuI.setForeground(new Color(255, 255, 255));
		btnSortirajListuI.setPreferredSize(new Dimension(240, 50));
		btnSortirajListuI.setFont(new Font("Arial", Font.BOLD, 16));
		btnSortirajListuI.setBackground(new Color(0, 102, 255));
		panel.add(btnSortirajListuI);
	}
	
	public void Operacije(){
		btnDodajKvadratU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelKvadrata=new JPanel();
				panelKvadrata.setPreferredSize(new Dimension(200,200));
				xKoordStr=new JTextField(5); yKoordStr=new JTextField(5);
				duzinaStr=new JTextField(5);
				panelKvadrata.add(new JLabel("Unesite x koordinatu kvadrata:")); panelKvadrata.add(xKoordStr);
				panelKvadrata.add(new JLabel("Unesite y koordinatu kvadrata:")); panelKvadrata.add(yKoordStr);
				panelKvadrata.add(new JLabel("Unesite duzinu stranice kvadrata:")); panelKvadrata.add(duzinaStr);
				int rezultat = JOptionPane.showConfirmDialog(contentPane, panelKvadrata,"Dodavanje kvadrata u listu", JOptionPane.OK_CANCEL_OPTION);
				if(rezultat==JOptionPane.OK_OPTION){
					int goreX=Integer.parseInt(xKoordStr.getText()); int goreY=Integer.parseInt(yKoordStr.getText());
					int duzina=Integer.parseInt(duzinaStr.getText());
					kvadrati.add(new Kvadrat(new Tacka(goreX,goreY),duzina));
				}
			}
		});
		btnSortirajListuI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kvadrati.isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "Lista je prazna.\nPrvo dodajte kvadrat u listu." , "Greska", JOptionPane.INFORMATION_MESSAGE);
				}else{
					Collections.sort(kvadrati, (duzina1,duzina2) -> duzina1.getDuzinaStranice() - duzina2.getDuzinaStranice());
					for(int i=0;i<kvadrati.size();i++){
						kvLista+=kvadrati.get(i)+"\n";
					}
					sortK=new JTextArea();
					sortK.setEditable(false);
					sortK.setText(kvLista);
					JOptionPane.showMessageDialog(contentPane, sortK , "Sortirana lista kvadrata", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

}
