package ucab.dsw.dtos;

public class OpcionDto extends DtoBase{

    public OpcionDto(long id) throws Exception {
        super(id);
    }

    public OpcionDto() {
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion( String descripcion )
    {
        this.descripcion = descripcion;
    }

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus( String estatus )
    {
        this.estatus = estatus;
    }

    public PreguntaDto getPreguntaDto() {
        return preguntaDto;
    }

    public void setPreguntaDto(PreguntaDto preguntaDto) {
        this.preguntaDto = preguntaDto;
    }

    private String estatus;
    private PreguntaDto preguntaDto;
    private String descripcion;

}
