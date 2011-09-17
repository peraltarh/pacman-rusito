package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import constantes.Constantes;

public class AdaptadorDeTeclado extends KeyAdapter {
	ControladorPacMan controlador;
	@Override
	public  void keyPressed(KeyEvent e) {
        this.reaccionar(e.getKeyCode(), true);
    }	
	
	public AdaptadorDeTeclado(ControladorPacMan controlador){
		super();
		this.controlador = controlador;
	}
	
	public void reaccionar(int KeyCode, boolean sePresiono){
		switch(KeyCode){
		
			case KeyEvent.VK_UP: this.controlador.moverPacMan(Constantes.ARRIBA); break;	
				
	        case KeyEvent.VK_DOWN: this.controlador.moverPacMan(Constantes.ABAJO); break;
	        
	        case KeyEvent.VK_LEFT: this.controlador.moverPacMan(Constantes.IZQUIERDA); break;
	
	        case KeyEvent.VK_RIGHT: this.controlador.moverPacMan(Constantes.DERECHA); break;
	       
		}
	}
	
} // Fin AdaptadorDeTeclado.
