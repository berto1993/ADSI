package packVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JList;

import java.awt.Color;

import javax.swing.AbstractListModel;
import javax.swing.JButton;

import packModelo.Liga;

public class VerClasificacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerClasificacion frame = new VerClasificacion();
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
	public VerClasificacion() {
		setResizable(false);
		setTitle("Ver Clasificicaon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 246, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final String [] aux = Liga.getLiga().calcularClasificacion();
		
		JList list14 = new JList();
		list14.setModel(new AbstractListModel() {
			String[] values = new String []{aux[0],aux[1],aux[2]};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list14.setBackground(Color.GREEN);
		list14.setBounds(10, 11, 218, 64);
		contentPane.add(list14);
		
		JList list56 = new JList();
		list56.setBackground(Color.YELLOW);
		list56.setModel(new AbstractListModel() {
			String[] values = new String[] {aux[3], aux[4]};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list56.setBounds(10, 76, 218, 32);
		contentPane.add(list56);
		
		JList list717 = new JList();
		list717.setModel(new AbstractListModel() {
			String[] values = new String[] {aux[5], aux[6], aux[7], aux[8], aux[9], aux[10], aux[11], aux[12], aux[13], aux[14], aux[15], aux[16]};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list717.setBounds(10, 107, 218, 178);
		contentPane.add(list717);
		
		JList list1820 = new JList();
		list1820.setBackground(Color.RED);
		list1820.setModel(new AbstractListModel() {
			String[] values = new String[] {aux[17],aux[18],aux[19]};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list1820.setBounds(10, 285, 218, 48);
		contentPane.add(list1820);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(68, 344, 89, 23);
		contentPane.add(btnSalir);
	}
}
