
package seleccion;

import modelo.ListaEntrenadores1;
import modelo.ListaEquipos1;
import modelo.ListaJugadores1;
import utilidades.Fichero;
import vista.MenuPrincipal1;

/**
 *
 * @author usu21
 */
public class FootBall {

    public static ListaJugadores1 todosJugadores;
    public static Fichero ficheroJugadores;
    public static ListaEntrenadores1 todosEntrenadores;
    public static Fichero ficheroEntrenadores;
    public static ListaEquipos1 todosEquipos;
    public static Fichero ficheroEquipos;
    
    public static void main(String[] args) {
        
        ficheroJugadores = new Fichero("jugadores.xml");
        todosJugadores = (ListaJugadores1) ficheroJugadores.leer();
        if (todosJugadores == null) {
            todosJugadores = new ListaJugadores1();
        }
        ficheroEntrenadores = new Fichero("entrenadores.xml");
        todosEntrenadores = (ListaEntrenadores1) ficheroEntrenadores.leer();
        if (todosEntrenadores == null) {
            todosEntrenadores = new ListaEntrenadores1();
        }
        
        ficheroEquipos = new Fichero("equipos.xml");
        todosEquipos = (ListaEquipos1) ficheroEquipos.leer();
        if (todosEquipos == null) {
            todosEquipos = new ListaEquipos1();
        }
        MenuPrincipal1 mp = new MenuPrincipal1();
        mp.setVisible(true);
        
        
        
    }
    
}
