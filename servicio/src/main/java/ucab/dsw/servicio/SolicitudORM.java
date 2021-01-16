package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoSolicitud;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.entidades.Solicitud;
import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.Usuario;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/solicitud" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SolicitudORM extends AplicacionBase{

    @POST
    @Path("/addsolicitud")
    public SolicitudDto addSolicitud(SolicitudDto solicitudDto){
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = new Solicitud();
            solicitud.set_nombre(solicitudDto.getNombre());
            solicitud.set_fecha(solicitudDto.getFecha());
            solicitud.set_estatus(solicitudDto.getEstatus());

            Subcategoria subcategoria = new Subcategoria(solicitudDto.getSubcategoriaDto().getId());
            solicitud.set_subcategoria(subcategoria);
            Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
            solicitud.set_usuario(usuario);

            Solicitud resul = dao.insert(solicitud);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/getSolicitudes")
    public List<Solicitud> getSolicitudes() {

        List<Solicitud> solicitudes = null;
        try {
            DaoSolicitud dao = new DaoSolicitud();
            solicitudes = dao.findAll(Solicitud.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return solicitudes;
    }

    @PUT
    @Path("/updateSolicitud/{id}")
    public SolicitudDto updateSolicitud(@PathParam("id") long id, SolicitudDto solicitudDto) {
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(id, Solicitud.class);
            solicitud.set_nombre(solicitudDto.getNombre());
            solicitud.set_fecha(solicitudDto.getFecha());
            solicitud.set_estatus(solicitudDto.getEstatus());

            Usuario usuario = new Usuario(solicitudDto.getUsuarioDto().getId());
            solicitud.set_usuario(usuario);

            Subcategoria subcategoria = new Subcategoria(solicitudDto.getSubcategoriaDto().getId());
            solicitud.set_subcategoria(subcategoria);

            Solicitud resul = dao.update(solicitud);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteSolicitud/{id}")
    public SolicitudDto deleteSolicitud(@PathParam("id") long id) {
        SolicitudDto resultado = new SolicitudDto();
        try {
            DaoSolicitud dao = new DaoSolicitud();
            Solicitud solicitud = dao.find(id, Solicitud.class);
            Solicitud resul = dao.delete(solicitud);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
