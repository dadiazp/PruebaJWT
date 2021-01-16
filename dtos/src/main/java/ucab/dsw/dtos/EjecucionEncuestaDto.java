package ucab.dsw.dtos;

public class EjecucionEncuestaDto extends DtoBase
{
    private String respuesta;

    private String estatus;

    private EncuestaDto encuestaDto;

    private PreguntaDto preguntaDto;

    private UsuarioDto usuarioEncuestadoDto;

    private OpcionDto opcionDto;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public EncuestaDto getEncuestaDto() {
        return encuestaDto;
    }

    public void setEncuestaDto(EncuestaDto encuestaDto) {
        this.encuestaDto = encuestaDto;
    }

    public PreguntaDto getPreguntaDto() {
        return preguntaDto;
    }

    public void setPreguntaDto(PreguntaDto preguntaDto) {
        this.preguntaDto = preguntaDto;
    }

    public UsuarioDto getUsuarioEncuestadoDto() {
        return usuarioEncuestadoDto;
    }

    public void setUsuarioEncuestadoDto(UsuarioDto usuarioEncuestadoDto) {
        this.usuarioEncuestadoDto = usuarioEncuestadoDto;
    }

    public OpcionDto getOpcionDto() {
        return opcionDto;
    }

    public void setOpcionDto(OpcionDto opcionDto) {
        this.opcionDto = opcionDto;
    }
}
