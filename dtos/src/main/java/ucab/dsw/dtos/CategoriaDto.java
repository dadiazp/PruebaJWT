package ucab.dsw.dtos;


import java.util.List;

public class CategoriaDto extends DtoBase{

    private String descripcion;

    private String estatus;

    private List<SubcategoriaDto> subcategorias;

    public CategoriaDto(long id) throws Exception {
        super(id);
    }

    public CategoriaDto() {
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

    public List<SubcategoriaDto> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<SubcategoriaDto> subcategorias) {
        this.subcategorias = subcategorias;
    }
}
