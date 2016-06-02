
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Persona1 implements Serializable, Comparable {
    
    private String nombre;   
    private String nacionalidad;   
    private Date nacimiento;

    public Persona1() {
        
        nombre = "";
        nacionalidad = "";
        nacimiento = new Date();
    }

    
    public Persona1(String nombre, String nacionalidad, Date nacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.nacimiento = nacimiento;
    }
    
    public String toString(String nombre){
    return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nombre);
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
        final Persona1 other = (Persona1) obj;
        return nombre.equalsIgnoreCase(other.getNombre());

    }
    

    public static final String PROP_NACIMIENTO = "nacimiento";

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        Date oldNacimiento = this.nacimiento;
        this.nacimiento = nacimiento;
        propertyChangeSupport.firePropertyChange(PROP_NACIMIENTO, oldNacimiento, nacimiento);
    }


    public static final String PROP_NACIONALIDAD = "nacionalidad";

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        String oldNacionalidad = this.nacionalidad;
        this.nacionalidad = nacionalidad;
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

    @Override
    public int compareTo(Object o) {
        Persona1 p = (Persona1) o;
        return this.nombre.compareTo(p.getNombre());
    }

    
}
