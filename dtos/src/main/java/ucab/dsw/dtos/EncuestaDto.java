package ucab.dsw.dtos;

import java.util.Date;

public class EncuestaDto extends DtoBase{

    private Date fechaCreacion;

    private String estatus;

    private EstudioDto estudioDto;

    private UsuarioDto usuarioCreadorDto;

    private UsuarioDto usuarioAnalistaDto;

    public EncuestaDto(long id) throws Exception {
        super(id);
    }

    public EncuestaDto() {
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public EstudioDto getEstudioDto() {
        return estudioDto;
    }

    public void setEstudioDto(EstudioDto estudioDto) {
        this.estudioDto = estudioDto;
    }

    public UsuarioDto getUsuarioCreadorDto() {
        return usuarioCreadorDto;
    }

    public void setUsuarioCreadorDto(UsuarioDto usuarioCreadorDto) {
        this.usuarioCreadorDto = usuarioCreadorDto;
    }

    public UsuarioDto getUsuarioAnalistaDto() {
        return usuarioAnalistaDto;
    }

    public void setUsuarioAnalistaDto(UsuarioDto usuarioAnalistaDto) {
        this.usuarioAnalistaDto = usuarioAnalistaDto;
    }
}
