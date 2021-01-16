package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEjecucionEncuesta;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.EjecucionEncuestaDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/ejecucionencuesta" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EjecucionEncuestaORMWS extends AplicacionBase{

    @POST
    @Path("/addejecucionencuesta")
    public EjecucionEncuestaDto addEjecucionEncuesta(EjecucionEncuestaDto ejecucionEncuestaDto){

        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = new EjecucionEncuesta();
            ejecucionEncuesta.set_respuesta(ejecucionEncuestaDto.getRespuesta());
            ejecucionEncuesta.set_estatus(ejecucionEncuestaDto.getEstatus());

            Encuesta encuesta = new Encuesta(ejecucionEncuestaDto.getEncuestaDto().getId());
            ejecucionEncuesta.set_encuesta(encuesta);

            Pregunta pregunta = new Pregunta(ejecucionEncuestaDto.getPreguntaDto().getId());
            ejecucionEncuesta.set_pregunta(pregunta);

            Usuario usuario = new Usuario(ejecucionEncuestaDto.getUsuarioEncuestadoDto().getId());
            ejecucionEncuesta.set_usuarioEncuestado(usuario);

            Opcion opcion = new Opcion(ejecucionEncuestaDto.getOpcionDto().getId());
            ejecucionEncuesta.set_opcion(opcion);

            EjecucionEncuesta resul = dao.insert(ejecucionEncuesta);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/getejecucionencuesta")
    public List<EjecucionEncuesta> getEjecuciones() {

        List<EjecucionEncuesta> ejecucionEncuestas = null;
        try {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            ejecucionEncuestas = dao.findAll(EjecucionEncuesta.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return ejecucionEncuestas;
    }

    @PUT
    @Path("updateejecucionencuesta/{id}")
    public EjecucionEncuestaDto updateEjecucion(@PathParam("id") long id, EjecucionEncuestaDto ejecucionEncuestaDto){

        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = dao.find(id, EjecucionEncuesta.class);
            ejecucionEncuesta.set_respuesta(ejecucionEncuestaDto.getRespuesta());
            ejecucionEncuesta.set_estatus(ejecucionEncuestaDto.getEstatus());

            Encuesta encuesta = new Encuesta(ejecucionEncuestaDto.getEncuestaDto().getId());
            ejecucionEncuesta.set_encuesta(encuesta);

            Pregunta pregunta = new Pregunta(ejecucionEncuestaDto.getPreguntaDto().getId());
            ejecucionEncuesta.set_pregunta(pregunta);

            Usuario usuario = new Usuario(ejecucionEncuestaDto.getUsuarioEncuestadoDto().getId());
            ejecucionEncuesta.set_usuarioEncuestado(usuario);

            Opcion opcion = new Opcion(ejecucionEncuestaDto.getOpcionDto().getId());
            ejecucionEncuesta.set_opcion(opcion);

            EjecucionEncuesta resul = dao.insert(ejecucionEncuesta);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteejecucion/{id}")
    public EjecucionEncuestaDto deleteEjecucion(@PathParam("id") long id) {
        EjecucionEncuestaDto resultado = new EjecucionEncuestaDto();
        try {
            DaoEjecucionEncuesta dao = new DaoEjecucionEncuesta();
            EjecucionEncuesta ejecucionEncuesta = dao.find(id, EjecucionEncuesta.class);
            EjecucionEncuesta resul = dao.delete(ejecucionEncuesta);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
