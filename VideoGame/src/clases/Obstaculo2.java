package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Obstaculo2 extends General {
	
	
	private int ancho;
	private int alto;
	private String indiceImagen;
	private boolean capturado;
	public Obstaculo2(int x, int y, int ancho, int alto, String indiceImagen) {
		super(x,y);
		
		this.ancho = ancho;
		this.alto = alto;
		this.indiceImagen = indiceImagen;
	}
	public void pintar(GraphicsContext graficos) {
		if (!capturado)
			graficos.drawImage(Juego.imagenes.get(indiceImagen), this.x, this.y+=2,this.ancho,this.alto);
		
		
	}

	public Rectangle obtenerRectangulo() {
		
		return new Rectangle(this.x, this.y, 120, 70);
		
	}

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
	
}
