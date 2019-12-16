package clases;

import java.util.HashMap;

import javax.swing.JOptionPane;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends General{
	
	private String indiceImagen;
	private int velocidad;
	private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	private int puntuacion = 0;
	private int vida = 1;
	
	//Coordenadas para el fragmento de la imagen a pintar
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	
	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public void mover(){
		if (this.x<=-70)
			this.x =680;
		if (this.x>=680)
			this.x =-70;
		
		if (Juego.derecha)
			this.x+=velocidad;
		
		if (Juego.izquierda)
			this.x-=velocidad;
		
		
		}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		graficos.fillText("Puntuacion " + puntuacion, 20, 380);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
			Rectangle coordenadasVolar[]= {
					new Rectangle(0, 288, 94, 96),
					new Rectangle(96,288, 96,96),
					new Rectangle(192,288, 96,96),
									
			};
			
			
			Animacion animacionVolar = new Animacion("volar",coordenadasVolar,0.09);
			animaciones.put("volar",animacionVolar);
			
			
	}
	
	public void verificarColisiones(Item item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
				
				if (!item.isCapturado())
					this.puntuacion++;
				item.setCapturado(true);				
		}
	}

	public void verificarColisiones(Obstaculo nubes) {
		if (this.obtenerRectangulo().intersects(nubes.obtenerRectangulo().getBoundsInLocal())) {
			
			if(!nubes.isCapturado()) {
				
				if (!nubes.isCapturado())
					this.vida--;
				if(vida<1 && vida>-1)	{	
					
					JOptionPane.showMessageDialog(null, "Su puntuacion:" + puntuacion);
					System.exit(0);
				}
			}
		}
	}

	public void verificarColisiones(Obstaculo2 nubesota) {
		if (this.obtenerRectangulo().intersects(nubesota.obtenerRectangulo().getBoundsInLocal())) {
			
			if (!nubesota.isCapturado()){
				
				if (!nubesota.isCapturado())
					this.vida--;
				if(vida<1 && vida>-1)	{	
					
					JOptionPane.showMessageDialog(null, "Su puntuacion es:" + puntuacion);
					System.exit(0);
				}
								
	}
		
	}
}
}
