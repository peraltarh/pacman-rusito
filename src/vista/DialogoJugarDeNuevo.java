package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import constantes.Constantes;

public class DialogoJugarDeNuevo {

	private JDialog jDialogoJugarDeNuevo = null;
	private JPanel jPanelJugarDeNuevo = null;
	private JButton botonJugarDeNuevo = null;
	private JButton botonSalir = null;
	private String mensaje = null;

	public DialogoJugarDeNuevo(String mensaje){
		this.mensaje = mensaje;
		this.jDialogoJugarDeNuevo = getDialogoJugarDeNuevo();
		this.jDialogoJugarDeNuevo.setVisible(true);	
	}
	
	private JDialog getDialogoJugarDeNuevo() {
		if (jDialogoJugarDeNuevo == null) {
			jDialogoJugarDeNuevo = new JDialog();
			jDialogoJugarDeNuevo.setSize(new Dimension(Constantes.DIALOGO_JUGAR_DE_NUEVO_ANCHO, Constantes.DIALOGO_JUGAR_DE_NUEVO_ALTO));
			jDialogoJugarDeNuevo.setTitle(Constantes.DIALOGO_JUGAR_DE_NUEVO_TITULO);
			jDialogoJugarDeNuevo.setLocation(Constantes.DIALOGO_JUGAR_DE_NUEVO_POSX,Constantes.DIALOGO_JUGAR_DE_NUEVO_POSY);
			jDialogoJugarDeNuevo.setResizable(false);
			jDialogoJugarDeNuevo.setBackground(Color.black);
			jDialogoJugarDeNuevo.setContentPane(getPanelJugarDeNuevo());		
		}
		return jDialogoJugarDeNuevo;
}
	
	private JPanel getPanelJugarDeNuevo() {
		if (jPanelJugarDeNuevo == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridwidth = 1;
			gridBagConstraints.ipadx = 36;
			gridBagConstraints.ipady = 3;
			gridBagConstraints.gridy = 3;			
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.ipady = 3;
			gridBagConstraints1.gridheight = 0;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.gridy = 3;
			GridBagLayout gridBagLayout  = new GridBagLayout();
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.ipadx = 5;
			gridBagConstraints2.ipady = 13;
			gridBagConstraints2.gridwidth = 2;
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.insets = new Insets(17, 0, 19, 0);
			gridBagConstraints2.gridy = 0;
			jPanelJugarDeNuevo = new JPanel();
			jPanelJugarDeNuevo.setBackground(Color.black);
			jPanelJugarDeNuevo.setLayout(gridBagLayout);
			jPanelJugarDeNuevo.add(getBotonJugarDeNuevo(), gridBagConstraints1);
			jPanelJugarDeNuevo.add(getBotonSalir(), gridBagConstraints);
			jPanelJugarDeNuevo.add(getMensaje(), gridBagConstraints2);
		}
		return jPanelJugarDeNuevo;
	}

	public JButton getBotonJugarDeNuevo() {
		if (botonJugarDeNuevo  == null) {
			botonJugarDeNuevo = new JButton("Jugar de Nuevo");
			botonJugarDeNuevo.setBackground(new Color(0, 0, 51));
			botonJugarDeNuevo.setForeground(Color.white);
			botonJugarDeNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
						jDialogoJugarDeNuevo.setVisible(false);	
				}
			});
		}
		return botonJugarDeNuevo;
	}
	
	private JButton getBotonSalir() {
		if (botonSalir  == null) {
			botonSalir = new JButton("Salir");
			botonSalir.setBackground(new Color(0, 0, 51));
			botonSalir.setForeground(Color.white);
			botonSalir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			botonSalir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.exit(0);
				}
			});
		}
		return botonSalir;
	}

	private JLabel getMensaje() {
			
		JLabel mensajeTexto = new JLabel();
		mensajeTexto.setText(this.mensaje);
		mensajeTexto.setForeground(new Color(0, 0, 204));
		mensajeTexto.setFont(new Font("Gisha", Font.BOLD, 16));
		mensajeTexto.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeTexto.setHorizontalTextPosition(SwingConstants.CENTER);
		mensajeTexto.setForeground(Color.white);
		mensajeTexto.setBackground(Color.black);
		return mensajeTexto;
	}
}
