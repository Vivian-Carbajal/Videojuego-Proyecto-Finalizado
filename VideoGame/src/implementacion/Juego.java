package implementacion;

import java.util.ArrayList;
import java.util.HashMap;


import clases.Item;
import clases.JugadorAnimado;
import clases.Obstaculo;
import clases.Obstaculo2;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;

	private JugadorAnimado jugadorAnimado;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static HashMap<String, Image> imagenes; 
	
	
	
	private Obstaculo2 nubesota;
	private Obstaculo2 nubesota2;
	private Obstaculo2 nubesota3;
	private Obstaculo2 nubesota4;
	private Obstaculo2 nubesota5;
	private Obstaculo2 nubesota6;
	private Obstaculo2 nubesota7;
	private Obstaculo2 nubesota8;
	private Obstaculo2 nubesota9;
	private Obstaculo2 nubesota10;
	private Obstaculo2 nubesota11;
	private Obstaculo2 nubesota12;
	private Obstaculo2 nubesota13;
	private Obstaculo2 nubesota14;
	private Obstaculo2 nubesota15;
		
	private Obstaculo nubes;
	private Obstaculo nubes2;
	private Obstaculo nubes3;
	private Obstaculo nubes4;
	private Obstaculo nubes5;
	private Obstaculo nubes6;
	private Obstaculo nubes7;
	private Obstaculo nubes8;
	private Obstaculo nubes9;
	private Obstaculo nubes10;
	private Obstaculo nubes11;
	private Obstaculo nubes12;
	private Obstaculo nubes13;
	private Obstaculo nubes14;
	private Obstaculo nubes15;
	
	
	private Item heart;
	private Item heart2;
	private Item heart3;
	private Item heart4;
	private Item heart5;
	private Item heart6;
	private Item heart7;
	private Item heart8;
	private Item heart9;
	private Item heart10;
	private Item heart11;
	private Item heart12;
	private Item heart13;
	private Item heart14;
	private Item heart15;
	private Item heart16;
	private Item heart17;
	private Item heart18;
	private Item heart19;
	private Item heart20;
	private Item heart21;
	private Item heart22;
	private Item heart23;
	private Item heart24;
	private Item heart25;
	
	
	
	//MAPA

	private ArrayList<Tile> tiles;

	private int[][] mapa = {
			{1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3},
			{2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4,2,4},
			
			
	};

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("Dragon Tales");
		gestionarEventos();
		ventana.show();
		cicloJuego();
	}

	public void inicializarComponentes() {
		//jugador = new Jugador(-50,400,"goku",1);
		jugadorAnimado = new JugadorAnimado(280,280,"Dragon",5, "volar");
		root = new Group();
		escena = new Scene(root,640,400);
		canvas  = new Canvas(640,400);
		imagenes = new HashMap<String,Image>();
		
		
		
		
		heart = new Item(300,20,20,25,"Heart");
		heart2 = new Item(450,-100,20,25,"Heart");
		heart3 = new Item(350,-250,20,25,"Heart");
		heart4 = new Item(150,-390,20,25,"Heart");
		heart5 = new Item(370,-510,20,25,"Heart");
		heart6 = new Item(190,-730,20,25,"Heart");
		heart7 = new Item(320,-940,20,25,"Heart");
		heart8 = new Item(230,-1110,20,25,"Heart");
		heart9 = new Item(236,-1350,20,25,"Heart");
		heart10 = new Item(250,-1555,20,25,"Heart");
		heart11 = new Item(340,-1700,20,25,"Heart");
		heart12 = new Item(450,-1930,20,25,"Heart");
		heart13 = new Item(350,-2050,20,25,"Heart");
		heart14 = new Item(250,-2270,20,25,"Heart");
		heart15 = new Item(370,-2485,20,25,"Heart");
		heart16 = new Item(190,-2615,20,25,"Heart");
		heart17 = new Item(620,-2870,20,25,"Heart");
		heart18 = new Item(489,-3090,20,25,"Heart");
		heart19 = new Item(36,-3190,20,25,"Heart");
		heart20 = new Item(340,-3760,20,25,"Heart");
		heart21 = new Item(370,-3885,20,25,"Heart");
		heart22 = new Item(190,-4015,20,25,"Heart");
		heart23 = new Item(620,-4270,20,25,"Heart");
		heart24 = new Item(489,-4490,20,25,"Heart");
		heart25 = new Item(36,-4690,20,25,"Heart");
		
		
		nubes = new Obstaculo(30,-100,150,90,"Nube");
		nubes2 = new Obstaculo(160,-500,150,90,"Nube");
		nubes3 = new Obstaculo(60,-1000,150,90,"Nube");
		nubes4 = new Obstaculo(520,-1500,150,90,"Nube");
		nubes5 = new Obstaculo(15,-2000,150,90,"Nube");
		nubes6 = new Obstaculo(90,-2500,150,90,"Nube");
		nubes7 = new Obstaculo(490,-2700,150,90,"Nube");
		nubes8 = new Obstaculo(250,-3200,150,90,"Nube");
		nubes9 = new Obstaculo(200,-3500,150,90,"Nube");
		nubes10 = new Obstaculo(300,-4000,150,90,"Nube");
		nubes11 = new Obstaculo(120,-4500,150,90,"Nube");
		nubes12 = new Obstaculo(60,-5000,150,90,"Nube");
		nubes13 = new Obstaculo(122,-5500,150,90,"Nube");
		nubes14 = new Obstaculo(290,-5500,150,90,"Nube");
		nubes15 = new Obstaculo(300,-6000,150,90,"Nube");
		
		
		nubesota = new Obstaculo2(490,-100,120,70,"Nubes");
		nubesota2 = new Obstaculo2(320,-400,120,70,"Nubes");
		nubesota3 = new Obstaculo2(320,-700,120,70,"Nubes");
		nubesota4 = new Obstaculo2(500,-1000,120,70,"Nubes");
		nubesota5 = new Obstaculo2(134,-1700,120,70,"Nubes");
		nubesota6 = new Obstaculo2(345,-2300,120,70,"Nubes");
		nubesota7 = new Obstaculo2(30,-2700,120,70,"Nubes");
		nubesota8 = new Obstaculo2(540,-3300,120,70,"Nubes");
		nubesota9 = new Obstaculo2(245,-3700,120,70,"Nubes");
		nubesota10 = new Obstaculo2(436,-4300,120,70,"Nubes");
		nubesota11 = new Obstaculo2(35,-4700,120,70,"Nubes");
		nubesota12 = new Obstaculo2(109,-5300,120,70,"Nubes");
		nubesota13 = new Obstaculo2(567,-5700,120,70,"Nubes");
		nubesota14 = new Obstaculo2(392,-6300,120,70,"Nubes");
		nubesota15 = new Obstaculo2(333,-6400,120,70,"Nubes");
		
		
		cargarImagenes();
		cargarTiles();
	}
	
//CARGARA IMAGENES
	public void cargarImagenes() {
		imagenes.put("Dragon", new Image("Dragon.png"));
		imagenes.put("Nube", new Image("Nube.png"));
		imagenes.put("Heart", new Image("Heart.png"));
		imagenes.put("Tiles2", new Image("Tiles2.png"));
		imagenes.put("Buho", new Image("Buho.png"));
		imagenes.put("Nubes", new Image("Nube2.png"));
	}

	public void pintar() {
		graficos.setFill(Color.WHITE);
		graficos.fillRect(0, 0, 640, 400);
		graficos.setFill(Color.BLACK);
		
		

		///Pintar tiles
		for (int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		jugadorAnimado.pintar(graficos);

		
		
		nubes.pintar(graficos);
		
		nubes3.pintar(graficos);
		nubes4.pintar(graficos);
		nubes5.pintar(graficos);
		nubes6.pintar(graficos);
		nubes7.pintar(graficos);
		nubes8.pintar(graficos);
		nubes9.pintar(graficos);
		nubes10.pintar(graficos);
		nubes11.pintar(graficos);
		nubes12.pintar(graficos);
		nubes13.pintar(graficos);
		nubes14.pintar(graficos);
		nubes15.pintar(graficos);
		
		
		
		heart.pintar(graficos);
		heart2.pintar(graficos);
		heart3.pintar(graficos);
		heart4.pintar(graficos);
		heart5.pintar(graficos);
		heart6.pintar(graficos);
		heart7.pintar(graficos);
		heart8.pintar(graficos);
		heart9.pintar(graficos);
		heart10.pintar(graficos);
		heart11.pintar(graficos);
		heart12.pintar(graficos);
		heart13.pintar(graficos);
		heart14.pintar(graficos);
		heart15.pintar(graficos);
		heart16.pintar(graficos);
		heart17.pintar(graficos);
		heart18.pintar(graficos);
		heart19.pintar(graficos);
		heart20.pintar(graficos);
		heart21.pintar(graficos);
		heart22.pintar(graficos);
		heart23.pintar(graficos);
		heart24.pintar(graficos);
		heart25.pintar(graficos);
		
		
		nubesota.pintar(graficos);
		nubesota2.pintar(graficos);
		nubesota3.pintar(graficos);
		nubesota4.pintar(graficos);
		nubesota5.pintar(graficos);
		nubesota6.pintar(graficos);
		nubesota7.pintar(graficos);
		nubesota8.pintar(graficos);
		nubesota9.pintar(graficos);
		nubesota10.pintar(graficos);
		nubesota11.pintar(graficos);
		nubesota12.pintar(graficos);
		nubesota13.pintar(graficos);
		nubesota14.pintar(graficos);
		nubesota15.pintar(graficos);
		
		

	}

	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*320, j*-320, "Tiles2",0));
			}
		}
	}

	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "RIGHT": //derecha
							derecha=true;
							break;
						case "LEFT": //derecha
							izquierda=true;
						break;
						
					}
			}
		});

		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					derecha=false;
					break;
				case "LEFT": //izquierda
					izquierda=false;
				break;
				
			}

			}

		});

	}

	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);

			}

		};
		animationTimer.start(); //Inicia el ciclo
	}

	public void actualizar(double t) {
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		jugadorAnimado.verificarColisiones(heart);
		jugadorAnimado.verificarColisiones(heart2);
		jugadorAnimado.verificarColisiones(heart3);
		jugadorAnimado.verificarColisiones(heart4);
		jugadorAnimado.verificarColisiones(heart5);
		jugadorAnimado.verificarColisiones(heart6);
		jugadorAnimado.verificarColisiones(heart7);
		jugadorAnimado.verificarColisiones(heart8);
		jugadorAnimado.verificarColisiones(heart9);
		jugadorAnimado.verificarColisiones(heart10);
		jugadorAnimado.verificarColisiones(heart11);
		jugadorAnimado.verificarColisiones(heart12);
		jugadorAnimado.verificarColisiones(heart13);
		jugadorAnimado.verificarColisiones(heart14);
		jugadorAnimado.verificarColisiones(heart15);
		jugadorAnimado.verificarColisiones(heart16);
		jugadorAnimado.verificarColisiones(heart17);
		jugadorAnimado.verificarColisiones(heart18);
		jugadorAnimado.verificarColisiones(heart19);
		jugadorAnimado.verificarColisiones(heart20);
		jugadorAnimado.verificarColisiones(heart21);
		jugadorAnimado.verificarColisiones(heart22);
		jugadorAnimado.verificarColisiones(heart23);
		jugadorAnimado.verificarColisiones(heart24);
		jugadorAnimado.verificarColisiones(heart25);
		
		jugadorAnimado.verificarColisiones(nubes);
		jugadorAnimado.verificarColisiones(nubes2);
		jugadorAnimado.verificarColisiones(nubes3);
		jugadorAnimado.verificarColisiones(nubes4);
		jugadorAnimado.verificarColisiones(nubes5);
		jugadorAnimado.verificarColisiones(nubes6);
		jugadorAnimado.verificarColisiones(nubes7);
		jugadorAnimado.verificarColisiones(nubes8);
		jugadorAnimado.verificarColisiones(nubes9);
		jugadorAnimado.verificarColisiones(nubes10);
		jugadorAnimado.verificarColisiones(nubes11);
		jugadorAnimado.verificarColisiones(nubes12);
		jugadorAnimado.verificarColisiones(nubes13);
		jugadorAnimado.verificarColisiones(nubes14);
		jugadorAnimado.verificarColisiones(nubes15);
		
		
		jugadorAnimado.verificarColisiones(nubesota);
		jugadorAnimado.verificarColisiones(nubesota2);
		jugadorAnimado.verificarColisiones(nubesota3);
		jugadorAnimado.verificarColisiones(nubesota4);
		jugadorAnimado.verificarColisiones(nubesota5);
		jugadorAnimado.verificarColisiones(nubesota6);
		jugadorAnimado.verificarColisiones(nubesota7);
		jugadorAnimado.verificarColisiones(nubesota8);
		jugadorAnimado.verificarColisiones(nubesota9);
		jugadorAnimado.verificarColisiones(nubesota10);
		jugadorAnimado.verificarColisiones(nubesota11);
		jugadorAnimado.verificarColisiones(nubesota12);
		jugadorAnimado.verificarColisiones(nubesota13);
		jugadorAnimado.verificarColisiones(nubesota14);
		jugadorAnimado.verificarColisiones(nubesota15);
	}

}
