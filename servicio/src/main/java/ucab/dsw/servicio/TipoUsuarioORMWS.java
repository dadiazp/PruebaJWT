package ucab.dsw.servicio;
import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.accesodatos.DaoTipoUsuario;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.TipoUsuario;

import javax.ws.rs.*;
import java.util.List;

public class TipoUsuarioORMWS {

    @PUT
    @Path( "/addtipopusuario" )
    public TipoUsuarioDto addTipoUsuario(TipoUsuarioDto tipoUsuarioDto )
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.set_descripcion( tipoUsuarioDto.getDescripcion() );
            tipoUsuario.set_estatus( tipoUsuarioDto.getEstatus() );
            TipoUsuario resul = dao.insert( tipoUsuario );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/getTipoUsuario")
    public List<TipoUsuario> getTipoUsuario() {

        List<TipoUsuario> tipoUsuario = null;
        try {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            tipoUsuario = dao.findAll(TipoUsuario.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return tipoUsuario;
    }

    @PUT
    @Path("/updateTipoUsuario/{id}")
    public TipoUsuarioDto updateTipoUsuario(@PathParam("id") long id, TipoUsuarioDto tipoUsuarioDto) {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = dao.find(id, TipoUsuario.class);

            if (tipoUsuario != null) {
                tipoUsuario.set_descripcion(tipoUsuarioDto.getDescripcion());
                TipoUsuario resul = dao.update(tipoUsuario);
                resultado.setId(resul.get_id());
            }

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteTipoUsuario/{id}")
    public TipoUsuarioDto deleteTipoUsuario(@PathParam("id") long id)
    {
        TipoUsuarioDto resultado = new TipoUsuarioDto();
        try
        {
            DaoTipoUsuario dao = new DaoTipoUsuario();
            TipoUsuario tipoUsuario = dao.find(id, TipoUsuario.class);

            if(tipoUsuario != null)
            {
                TipoUsuario resul = dao.delete(tipoUsuario);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
