
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import modelo.ListaJugadores1;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaEquipos1 implements Serializable {
  
    private ObservableList<Equipo1> lista;

    
    
    public ListaEquipos1() {
        lista = ObservableCollections.observableList(new ArrayList<Equipo1>());
    }
    
    
    public void altaEquipos(Equipo1 e) {
        lista.add(e);
    }
    
    public boolean existeEquipo(Equipo1 e) {
        return lista.contains(e);
    }
    
    
    public ListaEntrenadores1 entrenadoresOcupados() {
        ListaEntrenadores1 ocupados = new ListaEntrenadores1();
                for (Equipo1 e : lista) {
                    ocupados.altaEntrenador(e.getEntrenador());
                }
                return ocupados;
    }
    
    public ListaJugadores1 jugadoresOcupados() {
        ListaJugadores1 ocupados = new ListaJugadores1();
        for (Equipo1 e : lista) {
            for (Jugador1 j : e.getJugadores().getLista()) {
                ocupados.altaJugador(j);
            }
        }
        return ocupados;
    }
    
    
    

    public static final String PROP_LISTA = "lista";

    public ObservableList<Equipo1> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Equipo1> lista) {
        ObservableList<Equipo1> oldLista = this.lista;
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
