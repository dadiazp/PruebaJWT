package ucab.dsw.servicio;
import ucab.dsw.accesodatos.Dao;
import ucab.dsw.accesodatos.DaoUsuario;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.EntidadBase;
import ucab.dsw.entidades.TipoUsuario;
import ucab.dsw.entidades.Usuario;

import javax.decorator.Delegate;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class pruebaORMWS extends AplicacionBase {


    @PUT
    @Path("/adduser")
    public UsuarioDto addUser(UsuarioDto usuarioDto) {
        UsuarioDto resultado = new UsuarioDto();
        try {
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = new Usuario();
            usuario.set_nombre(usuarioDto.getNombre());
            usuario.set_apellido(usuarioDto.getApellido());
            usuario.set_estatus(usuarioDto.getEstatus());
            usuario.set_correoelectronico(usuarioDto.getCorreoelectronico());
            TipoUsuario tipoUsuario = new TipoUsuario(usuarioDto.getTipoUsuarioDto().getId());
            usuario.set_tipousuario(tipoUsuario);
            Usuario resul = dao.insert(usuario);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/consulta")
    public String consulta() {
        return "Epa";
    }

    @GET
    @Path("/getUsers")
    public List<Usuario> getUsers() {

        List<Usuario> usuarios = null;
        try {
            DaoUsuario dao = new DaoUsuario();
            usuarios = dao.findAll(Usuario.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return usuarios;
    }

    @PUT
    @Path("/updateUser/{id}")
    public UsuarioDto updateUser(@PathParam("id") long id, UsuarioDto usuarioDto) {
        UsuarioDto resultado = new UsuarioDto();
        try {
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = dao.find(id, Usuario.class);
            usuario.set_nombre(usuarioDto.getNombre());
            usuario.set_apellido(usuarioDto.getApellido());
            usuario.set_correoelectronico(usuarioDto.getCorreoelectronico());
            Usuario resul = dao.update(usuario);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteUser/{id}")
    public UsuarioDto deleteUser(@PathParam("id") long id)
    {
        UsuarioDto resultado = new UsuarioDto();
        try
        {
            DaoUsuario dao = new DaoUsuario();
            Usuario usuario = dao.find(id, Usuario.class);
            Usuario resul = dao.delete(usuario);
            resultado.setId(resul.get_id());
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return resultado;
    }
}
