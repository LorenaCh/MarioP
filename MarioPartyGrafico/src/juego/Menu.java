package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel {
	
	private ImageIcon ImagenFondo;
	private HashMap<String,ImageIcon> listaImagenes= new HashMap<String, ImageIcon>();
	private JButton AgregarJugador;
	private JButton IniciarPartida;
	private JLabel lblPersonaje;
	private JLabel lblJugador;
	public Menu() {
		
		setLayout(null);
		
		AgregarJugador = new JButton("AgregarJugador");
		AgregarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AgregarJugador.setBounds(32, 21, 172, 38);
		AgregarJugador.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(AgregarJugador);
		
		IniciarPartida = new JButton("Iniciar Partida");
		IniciarPartida.setBounds(533, 21, 185, 38);
		add(IniciarPartida);
		
		lblJugador = new JLabel("Jugador");
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJugador.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblJugador.setHorizontalTextPosition(SwingConstants.CENTER);
		lblJugador.setBounds(55, 139, 66, 28);
		add(lblJugador);
		
		lblPersonaje = new JLabel("Personaje");
		lblPersonaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPersonaje.setBounds(240, 142, 84, 23);
		add(lblPersonaje);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(55, 207, 48, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(55, 259, 48, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(55, 311, 48, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(55, 362, 48, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(55, 412, 48, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(55, 461, 48, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(240, 207, 48, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(240, 259, 48, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(240, 311, 48, 14);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(240, 362, 48, 14);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(240, 412, 48, 14);
		add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(240, 461, 48, 14);
		add(lblNewLabel_11);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(461, 203, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(461, 255, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(461, 302, 89, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(461, 358, 89, 23);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(461, 408, 89, 23);
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(461, 457, 89, 23);
		btnNewButton_5.setVisible(false);
		add(btnNewButton_5);
	}
	
	public void paintComponent(Graphics grafico) {
		super.paintComponent(grafico);
		Dimension tamanio = getSize();
		if(ImagenFondo == null)
			ImagenFondo = retornarImagen("/Menu/Menu.jpg");
		grafico.drawImage(ImagenFondo.getImage(), 0, 0, tamanio.width,tamanio.height,null);

	}
	
	private ImageIcon cargarImagen(String ruta) {
		try {
			ImageIcon temp_Imagen = new ImageIcon(getClass().getResource(ruta));
			return temp_Imagen;
		}catch(Exception e) {
			System.out.println("No se pudo cargar la imagen");
			return null;
		}
	}
	
	private ImageIcon retornarImagen(String imagen_a_buscar) {
		ImageIcon retorno = listaImagenes.get(imagen_a_buscar);
		if(retorno == null) {
			retorno = cargarImagen(imagen_a_buscar);
			listaImagenes.put(imagen_a_buscar, retorno);
		}
		
		return retorno;
	}

}
