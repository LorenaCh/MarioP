package juego;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ErrorAlAgregarJugador extends JDialog {

	private JPanel contentPanel;
	private JLabel lblMensaje;
	private JButton btnNewButton;
	private juego.Menu menu;
	
	public ErrorAlAgregarJugador(juego.Menu menu) {
		setModal(true);
		this.menu = menu;
		contentPanel = new JPanel();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 399, 113);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblMensaje = new JLabel("Cantidad de Jugadores Maximo");
		lblMensaje.setBounds(10, 14, 58, 14);
		contentPanel.add(lblMensaje);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(278, 42, 89, 23);
		contentPanel.add(btnNewButton);
		//setLocationRelativeTo(menu);
		
		setVisible(true);
	}
}
