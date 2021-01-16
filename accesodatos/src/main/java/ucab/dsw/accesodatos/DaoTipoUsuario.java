package ucab.dsw.accesodatos;

import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.TipoUsuario;

import javax.persistence.EntityManager;

public class DaoTipoUsuario extends Dao<TipoUsuario>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoTipoUsuario( )
    {
        super( _handler );
    }
}
