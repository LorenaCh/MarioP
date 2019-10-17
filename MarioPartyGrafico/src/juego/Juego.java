package juego;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Juego implements Runnable{
	
	//Defino el nombre del juego. La ventana
	private static final String NOMBRE = "Mario Party";
	
	private static int aps = 0; //Actualizaciones por segundo
	private static int fps = 0; //Frames por segundo 
	
	//Creo la ventana principal
	private static JFrame ventana;
	
	//Tamaño de la ventana
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	
	//Panel de Presentacion
	PanelPresentacion panelPresentacion = new PanelPresentacion();
	
	//Thread
	private static Thread miThread;
	//volatile: No podra utilizarse en forma simultaneamente en los dos threads(main y miThread)
	private static volatile boolean enFuncionamiento = false;
	

	
	public Juego() {

		//Se define el nombre de la ventan
		ventana=new JFrame(NOMBRE);
		
		//Se define las dimensiones de la ventana
		ventana.setSize(new Dimension(ANCHO, ALTO));
		
		//Se define que cuando se apriete la cruz se cierre el juego
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//El usuario no podra agrandar o achicar la ventana del juego
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout(0, 0));
		//ventana.setLayout(null);
				
		//Posicion de la ventana dentro del escritorio
		ventana.setLocationRelativeTo(null);
		ventana.add(panelPresentacion);
		ventana.setVisible(true);
		panelPresentacion.Iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPresentacion.setVisible(false);
				Menu menu = new Menu();
				ventana.add(menu);
			}
		});
		panelPresentacion.setVisible(true);
		
	}


	@Override
	public void run() {
		
		//Thread 1 : main; Thread 2: miThread
		//System.out.println("El thread 2 (miThread) se esta ejecutando con exito");
			
		//FPS
		final int NS_POR_SEGUNDO =  1000000000;
		final byte ACTXSEG_OBJETIVO = 60;
		final double NS_POR_ACTULIZACION = NS_POR_SEGUNDO/ACTXSEG_OBJETIVO;
			
		long referenciaActualizacion = System.nanoTime();
			
		long referenciaContador= System.nanoTime();
				
		double tiempoTranscurrido;
				
		//Cant de tiempo que ha transcurrido luego de una actualizacion
		double delta=0;
				
		while(enFuncionamiento) {
			//Inicia cronometro
			final long inicioBucle = System.nanoTime();
					
			//Cuanto ha pasado entre referenciaActualizacion y inicioBucle
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
					
			delta+=  tiempoTranscurrido/NS_POR_ACTULIZACION;
					
			//Actualizar se ejecutara cada 60 veces por segundos
			while(delta >= 1) {
				actualizar();
				delta--;
		}
					
		mostrar();
					
		if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
			ventana.setTitle(NOMBRE+ " || APS: " + aps + " || FPS: " + fps);
							
			//Asi solo tenemos los numeros que lo hace por segundo
			aps=0;
			fps=0;
			referenciaContador=System.nanoTime();
		}
				}
		
	}
	
	//synchronized: Se asegura que los dos metodos no puede modificar de forma simultanea el atributo volatile
	private synchronized void iniciar() {
			
		enFuncionamiento = true;
			
		//Se crea el thread y se ejecuta en esta. Graficos sirve para identificar el thread
		miThread = new Thread(this,"Graficos");
			
		//Inicia el thread. Lo pone en ejecucion. todo lo que esta en run secuencialmente
		miThread.start();
			
	}
		
	private synchronized void detener() {
		enFuncionamiento = false;
			
		try {
			//.stop cierra el hilo de forma abrupta => join: no para inmediatamente el thread, sino que lo hace cuando termine la ejecucion
			miThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	//lo necesario para actualizar las variables del juego. Ej posicion
	private void actualizar() {
		aps++;
	}
		
	//metodos necesarios para dibujar los graficos
	private void mostrar() {
		fps++;
	}
	
	public static void main(String[] args) {
		new Juego().iniciar();
	}
	
}
