package ucab.dsw.dtos;

public class TipoPreguntaDto extends DtoBase{

    public TipoPreguntaDto()
    {
    }

    public TipoPreguntaDto( long id ) throws Exception
    {
        super( id );
    }

    private String descripcion;

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

    private String estatus;

}
