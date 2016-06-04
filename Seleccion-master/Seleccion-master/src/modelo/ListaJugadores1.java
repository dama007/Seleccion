
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaJugadores1 implements Serializable {
    
    private ObservableList<Jugador1> lista;
    
    
    public ListaJugadores1() {    
        lista = ObservableCollections.observableList(new ArrayList<Jugador1>());
    }
    
    public void altaJugador(Jugador1 j) {
        lista.add(j);
    }
    
    public void bajaJugador(Jugador1 j) {
        lista.remove(j);
    }
    
    public boolean existeJugador(Jugador1 j) {
        return lista.contains(j);
    }
    
    public ListaJugadores1 jugadoresFiltrados(String patron) {
        ListaJugadores1 filtrados = new ListaJugadores1();
        for (Jugador1 j : lista) {
            if (j.getNombre().contains(patron)) {
                filtrados.altaJugador(j);
            }
        }
        return filtrados;
    }
    
    
    public ListaJugadores1 copia() {
        ListaJugadores1 copia = new ListaJugadores1();
        for (Jugador1 j : lista) {
            copia.altaJugador(j);
        }
        return copia;
    }
    
    public ListaJugadores1 jugadoresLibres(ListaJugadores1 ocupados) {
        ListaJugadores1 libres = new ListaJugadores1();
        for (Jugador1 j : lista) {
            if (!ocupados.existeJugador(j)) {
            libres.altaJugador(j);
            }
        }
        return libres;
    }
    
    
    
    public ListaJugadores1 jugadoresPorNacionalidad(String nacionalidad) {
        ListaJugadores1 result = new ListaJugadores1();
        for (Jugador1 j : lista) {
            if (j.getNacionalidad().equals(nacionalidad)) {
                result.altaJugador(j);
            }
        }
        return result;
    }

    public static final String PROP_LISTA = "lista";

    public ObservableList<Jugador1> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Jugador1> lista) {
        ObservableList<Jugador1> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
}


    
    
    

   

    

