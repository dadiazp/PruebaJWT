package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import java.util.List;

public class TipoPreguntaORMWS {

    @PUT
    @Path( "/addtipopregunta" )
    public TipoPreguntaDto addTipoPregunta(TipoPreguntaDto tipoPreguntaDto )
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();
            tipoPregunta.set_descripcion( tipoPreguntaDto.getDescripcion() );
            tipoPregunta.set_estatus( tipoPreguntaDto.getEstatus() );
            TipoPregunta resul = dao.insert( tipoPregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }

    @GET
    @Path("/getTipoPregunta")
    public List<TipoPregunta> getTipoPregunta() {

        List<TipoPregunta> tipoPregunta = null;
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            tipoPregunta = dao.findAll(TipoPregunta.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return tipoPregunta;
    }

    @PUT
    @Path("/updateTipoPregunta/{id}")
    public TipoPreguntaDto updateTipoPregunta(@PathParam("id") long id, TipoPreguntaDto tipoPreguntaDto) {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(id, TipoPregunta.class);

            if (tipoPregunta != null) {
                tipoPregunta.set_descripcion(tipoPreguntaDto.getDescripcion());
                TipoPregunta resul = dao.update(tipoPregunta);
                resultado.setId(resul.get_id());
            }

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteTipoPregunta/{id}")
    public TipoPreguntaDto deleteTipoPregutna(@PathParam("id") long id)
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(id, TipoPregunta.class);

            if(tipoPregunta != null)
            {
                TipoPregunta resul = dao.delete(tipoPregunta);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
