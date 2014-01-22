package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

import packModelo.Liga;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalcularEstadisticas extends JFrame {

	private JPanel contentPane;
	private String[] jornadas = null;
	private	String[] equipos = null;
	private String[] jugadores = null;
	private String[] incidencias = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcularEstadisticas frame = new CalcularEstadisticas();
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
	public CalcularEstadisticas() {
		setResizable(false);
		setTitle("Calcular Fairplay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JList list_Equipos = new JList(incidencias);
		
		
		JLabel lblTemporada = new JLabel("Temporada:");
		lblTemporada.setBounds(10, 11, 58, 14);
		contentPane.add(lblTemporada);
		
		final JComboBox comboBoxTemporada = new JComboBox();
		comboBoxTemporada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (comboBoxTemporada.getSelectedIndex() != -1)
				jornadas = Liga.getLiga().obtenerJornadas(comboBoxTemporada.getSelectedIndex());
			}
		});
		comboBoxTemporada.setBounds(76, 8, 134, 20);
		contentPane.add(comboBoxTemporada);
		
		JLabel lblJornada = new JLabel("Jornada:");
		lblJornada.setBounds(10, 36, 46, 14);
		contentPane.add(lblJornada);
		
		final JComboBox comboBoxJornada = new JComboBox(jornadas);
		comboBoxJornada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (comboBoxJornada.getSelectedIndex() != -1)
				{
					equipos = Liga.getLiga().obtenerEquiposPuntos(comboBoxTemporada.getSelectedIndex(), comboBoxJornada.getSelectedIndex());
				}
			}
		});
		comboBoxJornada.setBounds(76, 33, 134, 20);
		contentPane.add(comboBoxJornada);
		
		jugadores = Liga.getLiga().obtenerJugadores(comboBoxTemporada.getSelectedIndex(), comboBoxJornada.getSelectedIndex(), list_Equipos.getSelectedValue().toString());
		
		final JComboBox comboBoxJugador = new JComboBox(jugadores);
		comboBoxJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				incidencias = Liga.getLiga().obtenerIncidenciasJugador(comboBoxTemporada.getSelectedIndex(), comboBoxJornada.getSelectedIndex(),list_Equipos.getSelectedValue().toString(), comboBoxJugador.getSelectedItem().toString());
			}
		});
		
		
		comboBoxJugador.setBounds(233, 33, 134, 20);
		contentPane.add(comboBoxJugador);
		
		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setBounds(233, 11, 46, 14);
		contentPane.add(lblJugador);
		
		JScrollPane scrollPaneEquipos = new JScrollPane();
		scrollPaneEquipos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneEquipos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneEquipos.setBounds(10, 70, 199, 185);
		contentPane.add(scrollPaneEquipos);
	
		scrollPaneEquipos.setViewportView(list_Equipos);
		
		
		
		JScrollPane scrollPaneIncidencias = new JScrollPane();
		scrollPaneIncidencias.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneIncidencias.setBounds(232, 70, 135, 185);
		contentPane.add(scrollPaneIncidencias);
		
		JList list_Incidencias = new JList(incidencias);
		scrollPaneIncidencias.setViewportView(list_Incidencias);
	}
	
}
