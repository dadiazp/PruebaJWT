package ucab.dsw.dtos;

import ucab.dsw.entidades.Subcategoria;
import ucab.dsw.entidades.Usuario;

import javax.persistence.*;
import java.util.Date;

public class SolicitudDto extends DtoBase{

    private String nombre;

    private Date fecha;

    private String estatus;

    private UsuarioDto usuario;

    private SubcategoriaDto subcategoria;

    public SolicitudDto(long id) throws Exception {
        super(id);
    }

    public SolicitudDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public UsuarioDto getUsuarioDto() {
        return usuario;
    }

    public void setUsuarioDto(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public SubcategoriaDto getSubcategoriaDto() {
        return subcategoria;
    }

    public void setSubcategoriaDto(SubcategoriaDto subcategoria) {
        this.subcategoria = subcategoria;
    }
}
