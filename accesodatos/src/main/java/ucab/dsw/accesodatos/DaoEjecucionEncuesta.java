package ucab.dsw.accesodatos;

import ucab.dsw.entidades.EjecucionEncuesta;

import javax.persistence.EntityManager;

public class DaoEjecucionEncuesta extends Dao<EjecucionEncuesta>{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoEjecucionEncuesta( )
    {
        super( _handler );
    }
}
