package ucab.dsw.dtos;

public class PreguntaDto extends DtoBase{

    public PreguntaDto(long id) throws Exception {
        super(id);
    }

    public PreguntaDto() {
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public TipoPreguntaDto getTipoPreguntaDto() {
        return tipoPreguntaDto;
    }

    public void setTipoPreguntaDto(TipoPreguntaDto tipoPreguntaDto) {
        this.tipoPreguntaDto = tipoPreguntaDto;
    }

    public SubcategoriaDto getSubcategoriaDto() {
        return subcategoriaDto;
    }

    public void setSubcategoriaDto(SubcategoriaDto subcategoriaDto) {
        this.subcategoriaDto = subcategoriaDto;
    }

    public UsuarioDto getUsuarioDto() { return usuarioDto; }

    public void setUsuarioDto(UsuarioDto usuarioDto) { this.usuarioDto = usuarioDto; }

    private String estatus;
    private String fechacreacion;
    private String pregunta;
    private TipoPreguntaDto tipoPreguntaDto;
    private SubcategoriaDto subcategoriaDto;
    private UsuarioDto usuarioDto;
}
