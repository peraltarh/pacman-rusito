package titiritero;

/**
 * Esta abstracción es sólo a fin de poder abstraerse de la API gráfica de Java
 * y poder testear la solución facilmente.
 **/
public interface SuperficieDeDibujo {
	public void limpiar();
	public void actualizar();
	public Object getBuffer();
}
