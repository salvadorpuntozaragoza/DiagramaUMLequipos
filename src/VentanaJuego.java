import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.CardLayout;

import Paneles.MenuJuego;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;

import Paneles.SeleccionPersonaje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private Soldier76 soldier76 = new Soldier76();
	private Reinhardt rein = new Reinhardt();
	private Ana ana = new Ana();
	
	private Jugadores seleccionado = new Soldier76();;
	JLabel lblPersonaje = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
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
	public VentanaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileOutputStream file = new FileOutputStream("archivos/texto.txt");
					ObjectOutputStream oos = new ObjectOutputStream(file);
					oos.writeObject(seleccionado);
					oos.close();
					file.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FileInputStream file = new FileInputStream("archivos/texto.txt");
					ObjectInputStream ois = new ObjectInputStream(file);
					seleccionado = (Jugadores) ois.readObject();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				panel.repaint();
				lblPersonaje.repaint();
				
			}
		});
		mnArchivo.add(mntmAbrir);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		MenuJuego pnlMainMenu = new MenuJuego();
		contentPane.add(pnlMainMenu, "MainMenu");
		pnlMainMenu.setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(100, 222, 117, 29);
		pnlMainMenu.add(btnJugar);
		
		SeleccionPersonaje seleccionPersonaje = new SeleccionPersonaje();
		contentPane.add(seleccionPersonaje, "SelectCharMenu");
		seleccionPersonaje.setLayout(null);
		
		JButton btnSoldier76 = new JButton("");
		btnSoldier76.setIcon(new ImageIcon("images/icon_soldier76.png"));
		btnSoldier76.setBounds(171, 448, 100, 100);
		seleccionPersonaje.add(btnSoldier76);
		
		JButton btnRein = new JButton("");
		btnRein.setIcon(new ImageIcon("images/icon_rein.png"));
		btnRein.setBounds(300, 448, 100, 100);
		seleccionPersonaje.add(btnRein);
		
		JButton btnAna = new JButton("");
		btnAna.setIcon(new ImageIcon("images/icon_ana.png"));
		btnAna.setBounds(429, 448, 100, 100);
		seleccionPersonaje.add(btnAna);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(294, 594, 117, 29);
		seleccionPersonaje.add(btnIniciar);
		
		panel = new JPanel();
		contentPane.add(panel, "Juego");
		panel.setLayout(null);
		
		
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) contentPane.getLayout();
				c.next(contentPane);
				c.show(contentPane,"SelectCharMenu");
			}
		});
		
		btnSoldier76.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
					ImageIcon image = new ImageIcon("images/Select_char_soldier.jpg");
					ImageIcon spray = new ImageIcon("images/spray_soldier76.png");
					seleccionPersonaje.setSpray(spray);
					seleccionPersonaje.setImage(image);
					seleccionPersonaje.setOpcion("Soldier76");
					seleccionado = soldier76;
					seleccionPersonaje.repaint();
				
			}
		});
		
		btnRein.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
					ImageIcon image = new ImageIcon("images/Select_char_Rein.jpg");
					ImageIcon spray = new ImageIcon("images/spray_rein.png");
					seleccionPersonaje.setSpray(spray);
					seleccionPersonaje.setImage(image);
					seleccionPersonaje.setOpcion("Rein");
					seleccionado = rein;
					seleccionPersonaje.repaint();
				
			}
		});
		
		btnAna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
					ImageIcon image = new ImageIcon("images/Select_char_ana.jpg");
					ImageIcon spray = new ImageIcon("images/spray_ana.png");
					seleccionPersonaje.setSpray(spray);
					seleccionPersonaje.setImage(image);
					seleccionPersonaje.setOpcion("Ana");
					seleccionado = ana;
					seleccionPersonaje.repaint();
				
			}
		});
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblPersonaje = new JLabel("");
				lblPersonaje.setBounds(seleccionado.getX(), seleccionado.getY(), seleccionado.getWeight(), seleccionado.getHeight());
				lblPersonaje.setIcon(seleccionPersonaje.getSpray());
				lblPersonaje.setOpaque(true);
				panel.add(lblPersonaje);
				
				CardLayout c  = (CardLayout) contentPane.getLayout();
				c.next(contentPane);
				c.show(contentPane, "Juego");
			}
		});
		
		panel.setFocusable(true);
		
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				int code = e.getKeyCode();
				
				if(code == KeyEvent.VK_UP){
					seleccionado.setY(seleccionado.getY()-seleccionado.getSpeed());
					lblPersonaje.setBounds(seleccionado.getX(),seleccionado.getY(),seleccionado.getHeight(),seleccionado.getWeight());
				}
				if(code == KeyEvent.VK_DOWN){
					seleccionado.setY(seleccionado.getY()+seleccionado.getSpeed());
					lblPersonaje.setBounds(seleccionado.getX(),seleccionado.getY(),seleccionado.getHeight(),seleccionado.getWeight());
				}
				if(code == KeyEvent.VK_LEFT){
					seleccionado.setX(seleccionado.getX() - seleccionado.getSpeed());
					lblPersonaje.setBounds(seleccionado.getX(),seleccionado.getY(),seleccionado.getHeight(),seleccionado.getWeight());
				}
				if(code == KeyEvent.VK_RIGHT){
					seleccionado.setX(seleccionado.getX() + seleccionado.getSpeed());
					lblPersonaje.setBounds(seleccionado.getX(),seleccionado.getY(),seleccionado.getHeight(),seleccionado.getWeight());
				}
				
				lblPersonaje.repaint();	
				panel.repaint();
			}
		});
		
		
		
	}
}
