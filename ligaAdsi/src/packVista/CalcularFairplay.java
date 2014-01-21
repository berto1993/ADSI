package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class CalcularFairplay extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(String[] jugadores, String[] equipos) {
				try {
					CalcularFairplay frame = new CalcularFairplay(jugadores, equipos);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Create the frame.
	 * @param equipos 
	 * @param jugadores 
	 */
	public CalcularFairplay(final String[] jugadores, final String[] equipos) {
		setResizable(false);
		setTitle("Calcular Fairplay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneJugador = new JScrollPane();
		scrollPaneJugador.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneJugador.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneJugador.setBounds(10, 36, 175, 184);
		contentPane.add(scrollPaneJugador);
		
		JList list_Jugador = new JList();
		list_Jugador.setModel(new AbstractListModel() {
			String[] values = jugadores;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneJugador.setViewportView(list_Jugador);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(257, 36, 175, 184);
		contentPane.add(scrollPane);
		
		JList list_Equipo = new JList();
		list_Equipo.setModel(new AbstractListModel() {
			String[] values = equipos;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list_Equipo);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setBounds(10, 11, 46, 14);
		contentPane.add(lblJugador);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(257, 11, 46, 14);
		contentPane.add(lblEquipo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(170, 231, 89, 23);
		contentPane.add(btnSalir);
	}

}
