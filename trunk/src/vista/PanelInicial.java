package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import constantes.Constantes;

public class PanelInicial extends JPanel{

	private static final long serialVersionUID = 1L;
	public PanelInicial(){
		super();
		initialize();
	}
	
	public void initialize(){
		setLayout(new GridBagLayout());
		setSize(Constantes.PANEL_INICIAL_ANCHO, Constantes.PANEL_INICIAL_ALTO);
        
	}
				
	@Override
	public void paintComponent(Graphics g){
		Dimension dimension = getSize();
		ImageIcon imagenFondo = new  ImageIcon(getClass().getResource(Constantes.IMAGEN_INTRO));
		g.drawImage(imagenFondo.getImage(),0, 0, dimension.width ,dimension.height , null);
		setOpaque(false);
		super.paintComponent(g);
	}

}