import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.entidades.Categoria;
import java.util.List;

public class CategoriaORM_Test {

    @Test
    public void addCategoryTest() throws Exception
    {
        ucab.dsw.servicio.CategoriaORM servicio = new ucab.dsw.servicio.CategoriaORM();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion("Descripcion de prueba unitaria");
        categoriaDto.setEstatus( "A" );
        CategoriaDto resultado = servicio.addCategory(categoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getCategoriesTest()  throws  Exception
    {
        ucab.dsw.servicio.CategoriaORM servicio = new ucab.dsw.servicio.CategoriaORM();
        List<Categoria> categorias = servicio.getCategories();
        Assert.assertFalse("getCategoriesTest completo", categorias.isEmpty());
    }

    @Test
    public void  updateCategoryTest() throws Exception
    {
        ucab.dsw.servicio.CategoriaORM servicio = new ucab.dsw.servicio.CategoriaORM();
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setDescripcion("Actualizacion de prueba unitaria");
        categoriaDto.setEstatus("A");
        CategoriaDto resultado = servicio.updateCategory(2, categoriaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteCategoryTest() throws Exception
    {
        ucab.dsw.servicio.CategoriaORM servicio = new ucab.dsw.servicio.CategoriaORM();
        CategoriaDto resultado = servicio.deleteCategory(2);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

}
