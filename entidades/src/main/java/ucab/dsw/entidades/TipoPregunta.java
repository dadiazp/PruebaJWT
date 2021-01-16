package ucab.dsw.entidades;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "tipopregunta" )
public class TipoPregunta extends EntidadBase{

    public String get_descripcion() { return _descripcion; }

    public void set_descripcion( String _descripcion ) { this._descripcion = _descripcion; }

    @Column( name = "descripcion", nullable = false )
    private String _descripcion;

    public TipoPregunta( long id )
    {
        super( id );
    }

    public TipoPregunta()
    {

    }
}
