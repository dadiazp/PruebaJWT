import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.CategoriaDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.entidades.Subcategoria;

import java.util.List;

public class SubcategoriaORM_Test {

    @Test
    public void addSubcategoryTest() throws Exception
    {
        ucab.dsw.servicio.SubcategoriaORM servicio = new ucab.dsw.servicio.SubcategoriaORM();
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();
        subcategoriaDto.setDescripcion( "Descripcion de subcategoria" );
        subcategoriaDto.setEstatus( "A" );
        CategoriaDto categoriaDto = new CategoriaDto( 2);
        subcategoriaDto.setCategoriaDto(categoriaDto);
        SubcategoriaDto resultado = servicio.addSubcategory(subcategoriaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getSubcategoriesTest()  throws  Exception
    {
        ucab.dsw.servicio.SubcategoriaORM servicio = new ucab.dsw.servicio.SubcategoriaORM();
        List<Subcategoria> subcategorias = servicio.getSubcategories();
        Assert.assertFalse("getSubcategoriesTest completo", subcategorias.isEmpty());
    }

    @Test
    public void  updateSubcategoryTest() throws Exception
    {
        ucab.dsw.servicio.SubcategoriaORM servicio = new ucab.dsw.servicio.SubcategoriaORM();
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto();
        subcategoriaDto.setDescripcion("Actualizacion de subcategoria");
        subcategoriaDto.setEstatus("A");
        CategoriaDto categoriaDto = new CategoriaDto( 3);
        subcategoriaDto.setCategoriaDto(categoriaDto);
        SubcategoriaDto resultado = servicio.updateSubcategory(1, subcategoriaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteSubcategoryTest() throws Exception
    {
        ucab.dsw.servicio.SubcategoriaORM servicio = new ucab.dsw.servicio.SubcategoriaORM();
        SubcategoriaDto resultado = servicio.deleteSubcategory(4);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
