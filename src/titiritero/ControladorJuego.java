package titiritero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Nicolas
 * Esta clase es la encargada de manejar todo el GameLoop. B�sicamente tiene una lista
 * de ObjetosVivos y una Dibujables que son recorridas en cada gameloop.
 */
public class ControladorJuego implements Runnable {
	
    private long intervaloSimulacion;
    private boolean estaEnEjecucion;
    private List<ObjetoVivo> objetosVivos;
    private List<Dibujable> dibujables;
    private List<MouseClickObservador> mouseClickObservadores;
    private SuperficieDeDibujo superficieDeDibujo;
    
    public void run() {
            this.comenzarJuego();
    }       
    
    public ControladorJuego(){
            this.objetosVivos = new ArrayList<ObjetoVivo>();
            this.dibujables = new ArrayList<Dibujable>();
            this.mouseClickObservadores = new ArrayList<MouseClickObservador>();
    }
    
    public boolean estaEnEjecucion(){
            return this.estaEnEjecucion;
    }
    
    public void comenzarJuego(){
            estaEnEjecucion = true;
            try{
                    while(estaEnEjecucion){
                            simular();
                            dibujar();
                            Thread.sleep(intervaloSimulacion);
                    }
            }
            catch (Exception e) {
                    e.printStackTrace();
            }
    }

    public void comenzarJuegoAsyn(){
            Thread thread = new Thread(this);
            thread.start();
    }

    /**
     * Le da comienzo al juego poniendo en marcha el gameloop.
     * @param cantidadDeCiclos cantidad de ciclos que debe correr el gameloop..  
     */
    public void comenzarJuego(int cantidadDeCiclos){
            int contador = 0;
            estaEnEjecucion = true;
            try{
                    while(contador < cantidadDeCiclos && estaEnEjecucion){
                            simular();
                            dibujar();
                            Thread.sleep(intervaloSimulacion);
                            contador++;
                    }
            }
            catch (Exception e) {
                    e.printStackTrace();
            }
    }
    
    /**
     * Detiene el juego provocando la salida del gameloop.
     */
    public void detenerJuego(){
            this.estaEnEjecucion = false;
    }
    
    public void agregarObjetoVivo(ObjetoVivo objetoVivo){
            objetosVivos.add(objetoVivo);
    }
    
    public void removerObjetoVivo(ObjetoVivo objetoVivo){
            objetosVivos.remove(objetoVivo);
    }

    public void agregarDibujable(Dibujable unDibujable){
            dibujables.add(unDibujable);
    }
    
    /**
     * Agrega un dibujable en la posicion especificada y remueve al que se encontraba ah�.
     **/
        public void agregarDibujable(Dibujable unDibujable, int posicion){
        	dibujables.remove(posicion);
            dibujables.add(posicion, unDibujable);
        }
        
        public void removerDibujable(Dibujable unDibujable){
                dibujables.remove(unDibujable);
        }
        
        public long getIntervaloSimulacion() {
                return intervaloSimulacion;
        }

        public void setIntervaloSimulacion(long intervaloSimulacion) {
                this.intervaloSimulacion = intervaloSimulacion;
        }
 
        private void dibujar() {
                Iterator<Dibujable> iterador = dibujables.iterator();
                while(iterador.hasNext()){
                        Dibujable dibujable = iterador.next();
                        dibujable.dibujar(this.superficieDeDibujo);
                }               
                this.superficieDeDibujo.actualizar();
        }
        
        /**
     * Ejecuta la simulacion recorriendo la coleccion de objetivos vivos.
     **/
    private void simular() {
            this.superficieDeDibujo.limpiar();
            Iterator<ObjetoVivo> iterador = objetosVivos.iterator();
            while(iterador.hasNext()){
                    iterador.next().vivir();
            }
    }

    public SuperficieDeDibujo getSuperficieDeDibujo() {
            return superficieDeDibujo;
    }

    public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
            this.superficieDeDibujo = superficieDeDibujo;
    }
    
    /**
     * Se encarga de derivar el manejo del evento click al objeto vista correspondiente
     * @param x posici�n horizontal del mouse
     * @param y posici�n vertial del mouse
     */
    public void despacharMouseClick(int x, int y){
            MouseClickObservador mouseClickObservador;
            Iterator<MouseClickObservador> iterador = this.mouseClickObservadores.iterator();
            while(iterador.hasNext()){
                    mouseClickObservador = iterador.next();
                    mouseClickObservador.MouseClick(x, y);
            }
    }
    
    public void agregarMouseClickObservador(MouseClickObservador unMouseClickObservador){
            this.mouseClickObservadores.add(unMouseClickObservador);
    }
    
    public void removerMouseClickObservador(MouseClickObservador unMouseClickObservador){
            this.mouseClickObservadores.remove(unMouseClickObservador);
    }
        
}
