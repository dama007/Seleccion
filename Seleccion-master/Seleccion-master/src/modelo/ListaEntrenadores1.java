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
public class ListaEntrenadores1 implements Serializable {
    
    private ObservableList<Entrenador1> lista;

    public ListaEntrenadores1() {
        lista = ObservableCollections.observableList(new ArrayList<Entrenador1>());
    }
    
    public void altaEntrenador(Entrenador1 e) {
        lista.add(e);
    }
    
     public void bajaEntrenador(Entrenador1 e) {
        lista.remove(e);
    }
    
    public boolean existeEntrenador(Entrenador1 e) {
        return lista.contains(e);
    }
    
   
    
    public ListaEntrenadores1 copia() {
        ListaEntrenadores1 copia = new ListaEntrenadores1();
        for (Entrenador1 e : lista) {
            copia.altaEntrenador(e);
        }
        return copia;
    }
    
    public ListaEntrenadores1 entrenadoresLibres(ListaEntrenadores1 ocupados) {
        ListaEntrenadores1 libres = new ListaEntrenadores1();
        for(Entrenador1 e : lista) {
            if (!ocupados.existeEntrenador(e)) {
                libres.altaEntrenador(e);
            }
        }
        return libres;
    }
    
    
    
    

    public static final String PROP_LISTA = "lista";

    public ObservableList<Entrenador1> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Entrenador1> lista) {
        ObservableList<Entrenador1> oldLista = this.lista;
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
