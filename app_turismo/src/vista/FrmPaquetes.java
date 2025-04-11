package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Paquetes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmPaquetes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdDestino;
	private JTextField txtIdOrigen;
	private JTextField txtFechaVenta;
	private JTextField txtHoraVenta;
	private JTextField txtHoraSalida;
	private JTextField txtFechaEjecucion;
	private JTextField txtObservaciones;
	private JTextField txtPrecio;
	private JTextField txtMatricula;
	private JTextField txtIdCliente;
	private JTextField txtIdAgencia;
	private JTextField txtIdMedio;
	private JTextField txtIdPromotor;
	private JTextField txtCodigo;

	Paquetes cr = new Paquetes();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPaquetes frame = new FrmPaquetes();
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
	public FrmPaquetes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lgestion = new JLabel("Gestión de paquetes");
		Lgestion.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
		Lgestion.setBounds(190, 25, 167, 20);
		contentPane.add(Lgestion);
		
		JLabel LidDestino = new JLabel("Id del destino");
		LidDestino.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidDestino.setBounds(37, 162, 86, 17);
		contentPane.add(LidDestino);
		
		JLabel LidOrigen = new JLabel("Id del origen");
		LidOrigen.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidOrigen.setBounds(37, 217, 86, 17);
		contentPane.add(LidOrigen);
		
		JLabel LfechaVenta = new JLabel("Fecha de venta");
		LfechaVenta.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LfechaVenta.setBounds(37, 271, 86, 17);
		contentPane.add(LfechaVenta);
		
		JLabel LhoraVenta = new JLabel("Hora de venta");
		LhoraVenta.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LhoraVenta.setBounds(37, 323, 86, 17);
		contentPane.add(LhoraVenta);
		
		JLabel LhoraSalida = new JLabel("Hora de salida");
		LhoraSalida.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LhoraSalida.setBounds(37, 377, 86, 17);
		contentPane.add(LhoraSalida);
		
		JLabel LfechaEjecucion = new JLabel("Fecha de ejecución");
		LfechaEjecucion.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LfechaEjecucion.setBounds(37, 431, 120, 17);
		contentPane.add(LfechaEjecucion);
		
		JLabel Lobservaciones = new JLabel("Observaciones");
		Lobservaciones.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lobservaciones.setBounds(37, 486, 97, 17);
		contentPane.add(Lobservaciones);
		
		JLabel Lprecio = new JLabel("Precio");
		Lprecio.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lprecio.setBounds(311, 107, 46, 17);
		contentPane.add(Lprecio);
		
		txtIdDestino = new JTextField();
		txtIdDestino.setBounds(167, 159, 86, 20);
		contentPane.add(txtIdDestino);
		txtIdDestino.setColumns(10);
		
		txtIdOrigen = new JTextField();
		txtIdOrigen.setBounds(167, 214, 86, 20);
		contentPane.add(txtIdOrigen);
		txtIdOrigen.setColumns(10);
		
		txtFechaVenta = new JTextField();
		txtFechaVenta.setBounds(167, 268, 86, 20);
		contentPane.add(txtFechaVenta);
		txtFechaVenta.setColumns(10);
		
		txtHoraVenta = new JTextField();
		txtHoraVenta.setBounds(167, 320, 86, 20);
		contentPane.add(txtHoraVenta);
		txtHoraVenta.setColumns(10);
		
		txtHoraSalida = new JTextField();
		txtHoraSalida.setBounds(167, 374, 86, 20);
		contentPane.add(txtHoraSalida);
		txtHoraSalida.setColumns(10);
		
		txtFechaEjecucion = new JTextField();
		txtFechaEjecucion.setBounds(167, 428, 86, 20);
		contentPane.add(txtFechaEjecucion);
		txtFechaEjecucion.setColumns(10);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(167, 483, 86, 20);
		contentPane.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(420, 106, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(240, 248, 255));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.create(Integer.parseInt(txtCodigo.getText()), Integer.parseInt(txtIdDestino.getText()), Integer.parseInt(txtIdOrigen.getText()), 
						txtFechaVenta.getText(), txtHoraVenta.getText(), txtHoraSalida.getText(), txtFechaEjecucion.getText(), txtObservaciones.getText(), 
						txtMatricula.getText(), txtPrecio.getText(), Integer.parseInt(txtIdCliente.getText()), Integer.parseInt(txtIdAgencia.getText()), 
						Integer.parseInt(txtIdMedio.getText()), Integer.parseInt(txtIdPromotor.getText()));
			}
		});
		btnRegistrar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnRegistrar.setBounds(130, 566, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(240, 248, 255));
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodigo.setText("");
				txtIdDestino.setText("");
				txtIdOrigen.setText("");
				txtFechaVenta.setText("");
				txtHoraVenta.setText("");
				txtHoraSalida.setText("");
				txtFechaEjecucion.setText("");
				txtObservaciones.setText("");
				txtMatricula.setText("");
				txtPrecio.setText("");
				txtIdCliente.setText("");
				txtIdAgencia.setText("");
				txtIdMedio.setText("");
				txtIdPromotor.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnLimpiar.setBounds(298, 566, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel Lmatricula = new JLabel("Matrícula");
		Lmatricula.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lmatricula.setBounds(311, 163, 63, 14);
		contentPane.add(Lmatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(420, 159, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel LidCliente = new JLabel("Id del cliente");
		LidCliente.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidCliente.setBounds(311, 219, 86, 14);
		contentPane.add(LidCliente);
		
		JLabel LidAgencia = new JLabel("Id de la agencia");
		LidAgencia.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidAgencia.setBounds(311, 273, 99, 15);
		contentPane.add(LidAgencia);
		
		JLabel LidMedios = new JLabel("Id del medio");
		LidMedios.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidMedios.setBounds(311, 325, 86, 14);
		contentPane.add(LidMedios);
		
		JLabel LidPromotor = new JLabel("Id del promotor");
		LidPromotor.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		LidPromotor.setBounds(311, 379, 99, 14);
		contentPane.add(LidPromotor);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(420, 216, 86, 20);
		contentPane.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		txtIdAgencia = new JTextField();
		txtIdAgencia.setBounds(420, 270, 86, 20);
		contentPane.add(txtIdAgencia);
		txtIdAgencia.setColumns(10);
		
		txtIdMedio = new JTextField();
		txtIdMedio.setBounds(420, 322, 86, 20);
		contentPane.add(txtIdMedio);
		txtIdMedio.setColumns(10);
		
		txtIdPromotor = new JTextField();
		txtIdPromotor.setBounds(420, 376, 86, 20);
		contentPane.add(txtIdPromotor);
		txtIdPromotor.setColumns(10);
		
		JLabel Lcodigo = new JLabel("Código del paquete");
		Lcodigo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		Lcodigo.setBounds(37, 109, 120, 17);
		contentPane.add(Lcodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(167, 106, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO BORRAR.png"));
		btnBorrar.setBackground(new Color(240, 248, 255));
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.delete(Integer.parseInt(txtCodigo.getText()));
			}
		});
		btnBorrar.setBounds(420, 538, 55, 57);
		contentPane.add(btnBorrar);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO CONSULTAR.png"));
		btnConsultar.setBackground(new Color(240, 248, 255));
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.readOne(Integer.parseInt(txtCodigo.getText()), txtIdDestino, txtIdOrigen, txtFechaVenta, txtHoraVenta, txtHoraSalida, txtFechaEjecucion, 
						txtObservaciones, txtPrecio, txtMatricula, txtIdCliente, txtIdAgencia, txtIdMedio, txtIdPromotor);
			}
		});
		btnConsultar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnConsultar.setBounds(420, 402, 55, 57);
		contentPane.add(btnConsultar);
		
		JButton btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\LOGO ACTUALIZAR.png"));
		btnActualizar.setBackground(new Color(240, 248, 255));
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cr.update(Integer.parseInt(txtCodigo.getText()), Integer.parseInt(txtIdDestino.getText()), Integer.parseInt(txtIdOrigen.getText()), 
						txtFechaVenta.getText(), txtHoraVenta.getText(), txtHoraSalida.getText(), txtFechaEjecucion.getText(), txtObservaciones.getText(), 
						txtMatricula.getText(), txtPrecio.getText(), Integer.parseInt(txtIdCliente.getText()), Integer.parseInt(txtIdAgencia.getText()), 
						Integer.parseInt(txtIdMedio.getText()), Integer.parseInt(txtIdPromotor.getText()));
			}
		});
		btnActualizar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		btnActualizar.setBounds(420, 470, 55, 57);
		contentPane.add(btnActualizar);
	}
}
