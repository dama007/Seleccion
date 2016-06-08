
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Entrenador1 extends Persona1 {
    
    private String numLicencia;   
    private int exp;

    public Entrenador1() {
        super();
        numLicencia = "";
    }
    
    
    

    public static final String PROP_EXP = "exp";

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        int oldExp = this.exp;
        this.exp = exp;
        propertyChangeSupport.firePropertyChange(PROP_EXP, oldExp, exp);
    }

    public static final String PROP_NUMLICENCIA = "numLicencia";

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        String oldNumLicencia = this.numLicencia;
        this.numLicencia = numLicencia;
        propertyChangeSupport.firePropertyChange(PROP_NUMLICENCIA, oldNumLicencia, numLicencia);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
