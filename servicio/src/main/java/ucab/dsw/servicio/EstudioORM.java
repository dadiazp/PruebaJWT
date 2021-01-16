package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoEstudio;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.entidades.Estudio;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/estudio" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EstudioORM extends AplicacionBase{

    @POST
    @Path("/addestudio")
    public EstudioDto addEstudio(EstudioDto estudioDto){

        EstudioDto resultado = new EstudioDto();
        try {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = new Estudio();
            estudio.set_fechaCrecion(estudioDto.getFechaCreacion());
            estudio.set_estatus(estudioDto.getEstatus());

            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            estudio.set_usuario(usuario);

            Solicitud solicitud = new Solicitud(estudioDto.getSolicitud().getId());
            estudio.set_solicitud(solicitud);

            Estudio resul = dao.insert(estudio);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/getestudio")
    public List<Estudio> getEstudios() {

        List<Estudio> estudios = null;
        try {
            DaoEstudio dao = new DaoEstudio();
            estudios = dao.findAll(Estudio.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return estudios;
    }

    @PUT
    @Path("/updateestudio/{id}")
    public EstudioDto updateEstudio(@PathParam("id") long id, EstudioDto estudioDto){

        EstudioDto resultado = new EstudioDto();
        try {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = dao.find(id, Estudio.class);
            estudio.set_fechaCrecion(estudioDto.getFechaCreacion());
            estudio.set_estatus(estudioDto.getEstatus());

            Usuario usuario = new Usuario(estudioDto.getUsuario().getId());
            estudio.set_usuario(usuario);

            Solicitud solicitud = new Solicitud(estudioDto.getSolicitud().getId());
            estudio.set_solicitud(solicitud);

            Estudio resul = dao.update(estudio);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteestudio/{id}")
    public EstudioDto deleteEstudio(@PathParam("id") long id) {
        EstudioDto resultado = new EstudioDto();
        try {
            DaoEstudio dao = new DaoEstudio();
            Estudio estudio = dao.find(id, Estudio.class);
            Estudio resul = dao.delete(estudio);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;

    }
}
