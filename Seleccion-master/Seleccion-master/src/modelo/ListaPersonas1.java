/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ListaPersonas1 implements Serializable {
    
    private ObservableList<Persona1> lista;
    

    
    
    public ListaPersonas1() {
        lista = ObservableCollections.observableList(new ArrayList<Persona1>());
    }
    
    public void altaPersona(Persona1 p) {
        lista.add(p);
    }
    
    
    public void eliminarPersona(Persona1 p) {
        lista.remove(p);
    }
    
    
    
    

    public static final String PROP_LISTA = "lista";

    public ObservableList<Persona1> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Persona1> lista) {
        ObservableList<Persona1> oldLista = this.lista;
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
