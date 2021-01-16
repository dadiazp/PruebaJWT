package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoOpcion;
import ucab.dsw.accesodatos.DaoPregunta;
import ucab.dsw.dtos.OpcionDto;
import ucab.dsw.dtos.PreguntaDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.*;
import java.util.List;

public class OpcionORMWS {
    @PUT
    @Path( "/addOpcion" )
    public OpcionDto addOpcion(OpcionDto opcionDto ) throws Exception {
        OpcionDto resultado = new OpcionDto();
        try
        {
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = new Opcion();
            opcion.set_descripcion( opcionDto.getDescripcion() );
            opcion.set_estatus( opcionDto.getEstatus() );
            /*Pregunta*/
            Pregunta pregunta = new Pregunta(opcionDto.getPreguntaDto().getId());
            opcion.set_pregunta( pregunta );
            Opcion resul = dao.insert( opcion );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }
    @PUT
    @Path("/updateOpcion/{id}")
    public OpcionDto updateOpcion(@PathParam("id") long id, OpcionDto opcionDto){
        OpcionDto resultado = new OpcionDto();

        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(id, Opcion.class);

            if(opcion!=null){
                opcion.set_descripcion(opcionDto.getDescripcion());
                opcion.set_estatus(opcionDto.getEstatus());
                Opcion resul = dao.update(opcion);
                resultado.setId(resul.get_id());
            }
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("deleteOpcion/{id}")
    public OpcionDto deleteOpcion (@PathParam("id") long id){
        OpcionDto resultado = new OpcionDto();

        try{
            DaoOpcion dao = new DaoOpcion();
            Opcion opcion = dao.find(id,Opcion.class);

            if(opcion != null){
                Opcion resul = dao.delete(opcion);
                resultado.setId(resul.get_id());
            }
        }catch(Exception ex){
            String problem = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/getOpcion")
    public List<Opcion> getOpcion(){
        List<Opcion> opciones = null;
        try{
            DaoOpcion dao= new DaoOpcion();
            opciones = dao.findAll(Opcion.class);
        }catch (Exception ex){
            String problem = ex.getMessage();
        }
        return opciones;
    }
}
