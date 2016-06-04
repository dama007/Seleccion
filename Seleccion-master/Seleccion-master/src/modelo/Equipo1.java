
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Equipo1 implements Serializable {
    
    private String nombre;   
    private String pais;    
    private Entrenador1 entrenador;    
    private ListaJugadores1 jugadores;

    public Equipo1() {
        
        nombre = "";
        pais = "";
        entrenador = new Entrenador1();
        jugadores = new ListaJugadores1();
                
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipo1 other = (Equipo1) obj;
        return this.nombre.equalsIgnoreCase(other.getNombre());
    }
    
    
    
    

    public static final String PROP_JUGADORES = "jugadores";

    public ListaJugadores1 getJugadores() {
        return jugadores;
    }

    public void setJugadores(ListaJugadores1 jugadores) {
        ListaJugadores1 oldJugadores = this.jugadores;
        this.jugadores = jugadores;
        propertyChangeSupport.firePropertyChange(PROP_JUGADORES, oldJugadores, jugadores);
    }


    public static final String PROP_ENTRENADOR = "entrenador";

    public Entrenador1 getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador1 entrenador) {
        Entrenador1 oldEntrenador = this.entrenador;
        this.entrenador = entrenador;
        propertyChangeSupport.firePropertyChange(PROP_ENTRENADOR, oldEntrenador, entrenador);
    }


    public static final String PROP_NACIONALIDAD = "nacionalidad";

    public String getNacionalidad() {
        return pais;
    }

    public void setNacionalidad(String nacionalidad) {
        String oldNacionalidad = this.pais;
        this.pais = nacionalidad;
        propertyChangeSupport.firePropertyChange(PROP_NACIONALIDAD, oldNacionalidad, nacionalidad);
    }

    public static final String PROP_NOMBRE = "nombre";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
