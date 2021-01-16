package ucab.dsw.servicio;

import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.accesodatos.DaoEncuesta;
import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Encuesta;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import java.util.List;

public class EncuestaORM extends AplicacionBase {

    @POST
    @Path("/addencuesta")
    public EncuestaDto addEncuesta(EncuestaDto encuestaDto){

        EncuestaDto resultado = new EncuestaDto();
        try {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = new Encuesta();
            encuesta.set_fechaCreacion(encuestaDto.getFechaCreacion());
            encuesta.set_estatus(encuestaDto.getEstatus());

            Usuario usuarioCreador = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuarioCreador(usuarioCreador);

            Usuario usuarioAnalista = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioAnalista(usuarioAnalista);

            Estudio estudio = new Estudio(encuestaDto.getEstudioDto().getId());
            encuesta.set_estudio(estudio);

            Encuesta resul = dao.insert(encuesta);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/getencuestas")
    public List<Encuesta> getEncuestas() {

        List<Encuesta> encuestas = null;
        try {
            DaoEncuesta dao = new DaoEncuesta();
            encuestas = dao.findAll(Encuesta.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return encuestas;
    }

    @PUT
    @Path("/updateencuesta/{id}")
    public EncuestaDto updateEncuesta(@PathParam("id") long id, EncuestaDto encuestaDto){

        EncuestaDto resultado = new EncuestaDto();
        try {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(id, Encuesta.class);
            encuesta.set_fechaCreacion(encuestaDto.getFechaCreacion());
            encuesta.set_estatus(encuestaDto.getEstatus());

            Usuario usuarioCreador = new Usuario(encuestaDto.getUsuarioCreadorDto().getId());
            encuesta.set_usuarioCreador(usuarioCreador);

            Usuario usuarioAnalista = new Usuario(encuestaDto.getUsuarioAnalistaDto().getId());
            encuesta.set_usuarioAnalista(usuarioAnalista);

            Estudio estudio = new Estudio(encuestaDto.getEstudioDto().getId());
            encuesta.set_estudio(estudio);

            Encuesta resul = dao.update(encuesta);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteEncuesta/{id}")
    public EncuestaDto deleteEncuesta(@PathParam("id") long id) {
        EncuestaDto resultado = new EncuestaDto();
        try {
            DaoEncuesta dao = new DaoEncuesta();
            Encuesta encuesta = dao.find(id, Encuesta.class);
            Encuesta resul = dao.delete(encuesta);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;

    }
}
