package titiritero.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import titiritero.Dibujable;
import titiritero.Posicionable;
import titiritero.SuperficieDeDibujo;
import vista.Posicion;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;


/*
 * Esta clase representa una imagen JPG abstrayendo al usuario de los detalles de Java2D
 * Simplemente requiere de una referencia al nombre del archivo JPG
 */
public class Imagen implements Dibujable{
	
	public Imagen(){
		Imagen.escala = 25;		
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
	}
	    
	public String getNombreArchivoImagen() {
		return nombreArchivoImagen;
	}

	/**
	 * Estable la imagen con la que se dibujará el objeto.
	 * @param nombreArchivoImagen es el nombre del archivo que contiene l a imagen. Se espera que dicho archivo sea .jpg y esté ubicado en....
	 */
	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		this.nombreArchivoImagen = nombreArchivoImagen;
		InputStream in = getClass().getResourceAsStream(this.nombreArchivoImagen);
		JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
		try{
			this.imagen = decoder.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){

		}			
	}
	
	public Posicionable getPosicionable() {
		return posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = new Posicion(posicionable);
	}
	
	public static void setEscala(int escala){
		Imagen.escala = escala;		
	}
	
	public static int getEscala(){
		return Imagen.escala;
	}
	
	private String nombreArchivoImagen;
    private BufferedImage imagen;
    private Posicionable posicionable;
    private static int escala;

}
