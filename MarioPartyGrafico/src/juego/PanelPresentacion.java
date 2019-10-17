package juego;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class PanelPresentacion extends JPanel {

	private ImageIcon ImagenFondo;
	public JButton Iniciar;
	private ImageIcon IniciarRoll;
	private ImageIcon IniciarPress;
	private ImageIcon IniciarIcon;
	private static HashMap<String,ImageIcon> listaImagenes= new HashMap<String, ImageIcon>();
	
	public PanelPresentacion() {
		
		setLayout(null);
		if(Iniciar == null)
			Iniciar = cargarBoton();
		
		Iniciar.setBounds(350, 400, 90, 90);
		Iniciar.setBorderPainted(false);
		Iniciar.setContentAreaFilled(false);
		Iniciar.setVerticalTextPosition(SwingConstants.BOTTOM);

		if(IniciarPress == null)
			IniciarPress = retornarImagen("/Presentacion/Iniciar_64.png");
		Iniciar.setPressedIcon(IniciarPress);
		
		if(IniciarRoll == null)
			IniciarRoll = retornarImagen("/Presentacion/Iniciar_72.png");
		Iniciar.setRolloverIcon(IniciarRoll);
		
		if(IniciarIcon == null)
			IniciarIcon = retornarImagen("/Presentacion/Iniciar_64.png");
		Iniciar.setIcon(IniciarIcon);
		
		Iniciar.setPreferredSize(new Dimension(90, 90));
		Iniciar.setVisible(true);
		add(Iniciar);
	}
	
	
	public void paintComponent(Graphics grafico) {
		super.paintComponent(grafico);
		Dimension tamanio = getSize();
		if(ImagenFondo == null)
			ImagenFondo = retornarImagen("/Presentacion/Presentacion2.png");
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
	
	private JButton cargarBoton() {
		JButton temp_Iniciar = new JButton("Iniciar");
		return temp_Iniciar;
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
