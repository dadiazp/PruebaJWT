package ucab.dsw.accesodatos;

import ucab.dsw.entidades.Solicitud;

import javax.persistence.EntityManager;

public class DaoSolicitud extends Dao<Solicitud> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();


    public DaoSolicitud( )
    {
        super( _handler );
    }
}
