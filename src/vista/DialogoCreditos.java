package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import constantes.Constantes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class DialogoCreditos {

	private JDialog jDialogCreditos = null;
	private JPanel jPanelCreditos = null;

	public DialogoCreditos(){
		this.jDialogCreditos = getDialogoCreditos();
		this.jDialogCreditos.setVisible(true);
	}
	
	private JDialog getDialogoCreditos() {
		if (jDialogCreditos == null) {
			jDialogCreditos = new JDialog();
			jDialogCreditos.setSize(new Dimension(Constantes.DIALOGO_CREDITOS_ANCHO, Constantes.DIALOGO_CREDITOS_ALTO));
			jDialogCreditos.setTitle(Constantes.DIALOGO_CREDITOS_TITULO);
			jDialogCreditos.setLocation(Constantes.DIALOGO_CREDITOS_POSX,Constantes.DIALOGO_CREDITOS_POSY);
			jDialogCreditos.setResizable(false);
			jDialogCreditos.setBackground(Color.black);
			jDialogCreditos.add(getPanelCreditos(), BorderLayout.CENTER);
			
		}
		return jDialogCreditos;
}
	
	private JPanel getPanelCreditos() {
		if (jPanelCreditos == null) {
			jPanelCreditos = new JPanel();
			jPanelCreditos.setBackground(Color.black);
			jPanelCreditos.setLayout(new BorderLayout());
			jPanelCreditos.add(getAboutVersionLabel(), BorderLayout.SOUTH);
			jPanelCreditos.add(getTextoCreditos(), BorderLayout.NORTH);
			
		}
		return jPanelCreditos;
	}
private JLabel getAboutVersionLabel() {
		
		JLabel aboutVersionLabel = new JLabel();
		aboutVersionLabel.setText(Constantes.DIALOGO_CREDITOS_VERSION);
		aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		return aboutVersionLabel;
	}

	private JTextArea getTextoCreditos() {
			JTextArea textoCreditos = new JTextArea();
			textoCreditos.setText("\n    Creado por: \n\n ");
			textoCreditos.setForeground(new Color(0, 0, 204));
			textoCreditos.setFont(new Font("Gisha", Font.BOLD, 12));
			textoCreditos.setForeground(Color.white);
			textoCreditos.setBackground(Color.black);
			textoCreditos.setEditable(false);
			return textoCreditos;
	}

}
