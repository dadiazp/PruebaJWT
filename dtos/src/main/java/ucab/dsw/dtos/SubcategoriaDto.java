package ucab.dsw.dtos;


import java.util.List;

public class SubcategoriaDto extends DtoBase{

    private String descripcion;

    private String estatus;

    private CategoriaDto categoriaDto;

    public SubcategoriaDto(long id) throws Exception {
        super(id);
    }

    public SubcategoriaDto() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public CategoriaDto getCategoriaDto() {
        return categoriaDto;
    }

    public void setCategoriaDto(CategoriaDto categoriaDto) {
        this.categoriaDto = categoriaDto;
    }
}

