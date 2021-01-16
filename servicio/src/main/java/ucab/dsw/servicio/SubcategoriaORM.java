package ucab.dsw.servicio;

import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.accesodatos.DaoCategoria;
import ucab.dsw.accesodatos.DaoSubcategoria;


import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.entidades.Categoria;
import ucab.dsw.entidades.Subcategoria;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/subcategoria" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class SubcategoriaORM  extends AplicacionBase {

    @POST
    @Path("/addsubcategory")
    public SubcategoriaDto addSubcategory(SubcategoriaDto subcategoriaDto) {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = new Subcategoria();
            subcategoria.set_descripcion(subcategoriaDto.getDescripcion());
            subcategoria.set_estatus(subcategoriaDto.getEstatus());
            Categoria categoria = new Categoria(subcategoriaDto.getCategoriaDto().getId());
            subcategoria.set_categoria(categoria);
            Subcategoria resul = dao.insert(subcategoria);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @GET
    @Path("/getSubcategories")
    public List<Subcategoria> getSubcategories() {

        List<Subcategoria> subcategorias = null;
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            subcategorias = dao.findAll(Subcategoria.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return subcategorias;
    }

    @PUT
    @Path("/updateSubcategory/{id}")
    public SubcategoriaDto updateSubcategory(@PathParam("id") long id, SubcategoriaDto subcategoriaDto) {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = dao.find(id, Subcategoria.class);
            subcategoria.set_descripcion(subcategoriaDto.getDescripcion());
            subcategoria.set_estatus(subcategoriaDto.getEstatus());
            Categoria categoria = new Categoria(subcategoriaDto.getCategoriaDto().getId());
            subcategoria.set_categoria(categoria);
            Subcategoria resul = dao.update(subcategoria);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }

    @DELETE
    @Path("/deleteSubcategory/{id}")
    public SubcategoriaDto deleteSubcategory(@PathParam("id") long id) {
        SubcategoriaDto resultado = new SubcategoriaDto();
        try {
            DaoSubcategoria dao = new DaoSubcategoria();
            Subcategoria subcategoria = dao.find(id, Subcategoria.class);
            Subcategoria resul = dao.delete(subcategoria);
            resultado.setId(resul.get_id());
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;

    }

}