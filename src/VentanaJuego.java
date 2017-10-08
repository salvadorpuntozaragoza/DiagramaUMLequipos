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


public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private ImageIcon campo = new ImageIcon("/images/cancha.png");
	private ImageIcon soldier76 = new ImageIcon("/images/soldier76.jpg");

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
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mnArchivo.add(mntmAbrir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		MenuJuego pnlMainMenu = new MenuJuego();
		contentPane.add(pnlMainMenu, "MainMenu");
		pnlMainMenu.setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(38, 106, 117, 29);
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
		
		JPanel panel = new JPanel();
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
					seleccionPersonaje.repaint();
				
			}
		});
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel lblPersonaje = new JLabel("");
				lblPersonaje.setBounds(100, 287, 150, 150);
				lblPersonaje.setIcon(seleccionPersonaje.getSpray());
				lblPersonaje.setOpaque(true);
				panel.add(lblPersonaje);
				
				CardLayout c  = (CardLayout) contentPane.getLayout();
				c.next(contentPane);
				c.show(contentPane, "Juego");
			}
		});
		
	}
}
