package ucab.dsw.entidades;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "pregunta" )
public class Pregunta extends EntidadBase{
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Column( name = "pregunta" )
    public String pregunta;

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechaCreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Column( name = "fechacreacion" )
    public String fechacreacion;

    @Override
    public String get_estatus()
    {
        return _estatus;
    }

    @Override
    public void set_estatus( String _estatus )
    {
        this._estatus = _estatus;
    }

    @Column( name = "estatus" )
    private String _estatus;

    @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionEncuestas;

    public TipoPregunta get_tipopregunta()
    {
        return _tipopregunta;
    }

    public void set_tipopregunta( TipoPregunta _tipopregunta )
    {
        this._tipopregunta = _tipopregunta;
    }

    public Subcategoria get_subcatgeria()
    {
        return _subcategoria;
    }

    public void set_subcategoria( Subcategoria _subcategoria )
    {
        this._subcategoria = _subcategoria;
    }

    public Usuario get_usuario() { return _usuario; }

    public void set_usuario(Usuario _usuario) { this._usuario = _usuario; }

    @ManyToOne
    @JoinColumn( name = "idSubcategoria" )
    private Subcategoria _subcategoria;

    @ManyToOne
    @JoinColumn( name = "idTipoPregunta" )
    private TipoPregunta _tipopregunta;

    @ManyToOne
    @JoinColumn( name = "idUsuario" )
    private Usuario _usuario;

    @OneToMany( mappedBy = "_pregunta", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Opcion> _opciones;

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public List<EjecucionEncuesta> get_ejecucionEncuestas() {
        return _ejecucionEncuestas;
    }

    public void set_ejecucionEncuestas(List<EjecucionEncuesta> _ejecucionEncuestas) {
        this._ejecucionEncuestas = _ejecucionEncuestas;
    }

    public Subcategoria get_subcategoria() {
        return _subcategoria;
    }

    public Pregunta(long id )
    {
        super( id );
    }

    public Pregunta()
    {

    }
}
