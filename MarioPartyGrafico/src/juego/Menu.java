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
	private int cantJugadores;
	private JLabel [] Jugadores;
	private JLabel [] Personajes;
	public Menu() {
		cantJugadores = 0;
		Jugadores = new JLabel[6];
		for(int i=0;i<6;i++) {
			String et="Jugador";
			et+=i;
			Jugadores[i]=new JLabel(et);
		}
		
		Personajes = new JLabel[6];
		setLayout(null);
		
		AgregarJugador = new JButton("AgregarJugador");
		AgregarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AgregarJugador.setBounds(32, 21, 172, 38);
		AgregarJugador.setAlignmentX(Component.CENTER_ALIGNMENT);
		AgregarJugador.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cantJugadores == 6) {
					abrirErrorJugadores();
				}else {
					
				}
				
			}
		});
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
		
		Jugadores[0].setBounds(55, 207, 48, 14);
		Jugadores[0].setVisible(false);
		add(Jugadores[0]);
		
		Jugador2.setBounds(55, 259, 48, 14);
		Jugador2.setVisible(false);
		add(Jugador2);
		
		Jugador3.setBounds(55, 311, 48, 14);
		Jugador3.setVisible(false);
		add(Jugador3);
		
		Jugador4.setBounds(55, 362, 48, 14);
		Jugador4.setVisible(false);
		add(Jugador4);
		
		Jugador5.setBounds(55, 412, 48, 14);
		Jugador5.setVisible(false);
		add(Jugador5);
		
		Jugador6.setBounds(55, 461, 48, 14);
		Jugador6.setVisible(false);
		add(Jugador6);
		
		Personaje1.setBounds(240, 207, 48, 14);
		Personaje1.setVisible(false);
		add(Personaje1);
		
		JLabel Personaje2 = new JLabel("Personaje2");
		Personaje2.setBounds(240, 259, 48, 14);
		Personaje2.setVisible(false);
		add(Personaje2);
		
		JLabel Personaje3 = new JLabel("Personaje3");
		Personaje3.setBounds(240, 311, 48, 14);
		Personaje3.setVisible(false);
		add(Personaje3);
		
		JLabel Personaje4 = new JLabel("Personaje4");
		Personaje4.setBounds(240, 362, 48, 14);
		Personaje4.setVisible(false);
		add(Personaje4);
		
		JLabel Personaje5 = new JLabel("Personaje5");
		Personaje5.setBounds(240, 412, 48, 14);
		Personaje5.setVisible(false);
		add(Personaje5);
		
		JLabel Personaje6 = new JLabel("Personaje6");
		Personaje6.setBounds(240, 461, 48, 14);
		Personaje6.setVisible(false);
		add(Personaje6);
		
		JButton QuitarJugador1 = new JButton("Quitar");
		QuitarJugador1.setBounds(461, 203, 89, 23);
		QuitarJugador1.setVisible(false);
		add(QuitarJugador1);
		
		JButton QuitarJugador2 = new JButton("Quitar");
		QuitarJugador2.setBounds(461, 255, 89, 23);
		QuitarJugador2.setVisible(false);
		add(QuitarJugador2);
		
		JButton QuitarJugador3 = new JButton("Quitar");
		QuitarJugador3.setBounds(461, 302, 89, 23);
		QuitarJugador3.setVisible(false);
		add(QuitarJugador3);
		
		JButton QuitarJugador4 = new JButton("Quitar");
		QuitarJugador4.setBounds(461, 358, 89, 23);
		QuitarJugador4.setVisible(false);
		add(QuitarJugador4);
		
		JButton QuitarJugador5 = new JButton("Quitar");
		QuitarJugador5.setBounds(461, 408, 89, 23);
		QuitarJugador5.setVisible(false);
		add(QuitarJugador5);
		
		JButton QuitarJugador6 = new JButton("Quitar");
		QuitarJugador6.setBounds(461, 457, 89, 23);
		QuitarJugador6.setVisible(false);
		add(QuitarJugador6);
	}
	
	public void paintComponent(Graphics grafico) {
		System.out.println("Hola4");
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
	private void abrirErrorJugadores() {
		new ErrorAlAgregarJugador(this);
	}
}
