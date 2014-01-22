package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import packModelo.Liga;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVerClasificacion = new JButton("Ver Clasificacion");
		btnVerClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new VerClasificacion();
			}
		});
		btnVerClasificacion.setBounds(10, 113, 274, 23);
		contentPane.add(btnVerClasificacion);
		
		JButton btnCalcularEstadisticas = new JButton("Calcular Estadisticas");
		btnCalcularEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new CalcularEstadisticas();
			}
		});
		btnCalcularEstadisticas.setBounds(10, 147, 274, 23);
		contentPane.add(btnCalcularEstadisticas);
		
		JButton btnCalcularFairplay = new JButton("Calcular Fairplay");
		btnCalcularFairplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Liga.getLiga().calcularFairplay();
			}
		});
		btnCalcularFairplay.setBounds(10, 181, 274, 23);
		contentPane.add(btnCalcularFairplay);
		
		JButton btnGestionarEquipos = new JButton("Gestionar Equipos");
		btnGestionarEquipos.setBounds(10, 11, 274, 23);
		contentPane.add(btnGestionarEquipos);
		
		JButton btnConfigurarTemporada = new JButton("Configurar Temporada");
		btnConfigurarTemporada.setBounds(10, 45, 274, 23);
		contentPane.add(btnConfigurarTemporada);
		
		JButton btnGestionarArbitros = new JButton("Gestionar Arbitros");
		btnGestionarArbitros.setBounds(10, 79, 274, 23);
		contentPane.add(btnGestionarArbitros);
	}
}
