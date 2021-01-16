package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoCategoria;


import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/categoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CategoriaORM  extends AplicacionBase{

    @POST
    @Path("/addcategory")
    public CategoriaDto addCategory(CategoriaDto categoriaDto){
        CategoriaDto resultado = new CategoriaDto();
        try {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = new Categoria();
            categoria.set_descripcion(categoriaDto.getDescripcion());
            categoria.set_estatus(categoriaDto.getEstatus());
            Categoria resul = dao.insert(categoria);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/getCategories")
    public List<Categoria> getCategories() {

        List<Categoria> categorias = null;
        try {
            DaoCategoria dao = new DaoCategoria();
            categorias = dao.findAll(Categoria.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return categorias;
    }

    @PUT
    @Path("/updateCategory/{id}")
    public CategoriaDto updateCategory(@PathParam("id") long id, CategoriaDto categoriaDto) {
        CategoriaDto resultado = new CategoriaDto();
        try {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(id, Categoria.class);
            categoria.set_descripcion(categoriaDto.getDescripcion());
            categoria.set_estatus(categoriaDto.getEstatus());
            Categoria resul = dao.update(categoria);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteCategory/{id}")
    public CategoriaDto deleteCategory(@PathParam("id") long id)
    {
        CategoriaDto resultado = new CategoriaDto();
        try
        {
            DaoCategoria dao = new DaoCategoria();
            Categoria categoria = dao.find(id, Categoria.class);
            Categoria resul = dao.delete(categoria);
            resultado.setId(resul.get_id());
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return resultado;
    }

}
