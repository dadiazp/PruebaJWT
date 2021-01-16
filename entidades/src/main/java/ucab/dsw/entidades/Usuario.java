package ucab.dsw.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "usuario" )
public class Usuario extends EntidadBase
{
    @Column( name = "nombre" )
    private String _nombre;

    public String get_nombre()
    {
        return _nombre;
    }

    public void set_nombre( String _nombre )
    {
        this._nombre = _nombre;
    }

    public String get_apellido()
    {
        return _apellido;
    }

    public void set_apellido( String _apellido )
    {
        this._apellido = _apellido;
    }

    public String get_correoelectronico()
    {
        return _correoelectronico;
    }

    public void set_correoelectronico( String _correoelectronico )
    {
        this._correoelectronico = _correoelectronico;
    }

    public TipoUsuario get_tipousuario()
    {
        return _tipousuario;
    }

    public void set_tipousuario( TipoUsuario _tipousuario )
    {
        this._tipousuario = _tipousuario;
    }

    @Column( name = "apellido" )
    private String _apellido;

    @Column( name = "correoelectronico" )
    private String _correoelectronico;

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

    @ManyToOne
    @JoinColumn( name = "idTipoUsuario" )
    private TipoUsuario _tipousuario;

    @OneToMany( mappedBy = "_usuario", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Solicitud> _solicitudes;

    @OneToMany( mappedBy = "_usuario", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Estudio> _estudios;

    @OneToMany( mappedBy = "_usuarioCreador", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuestasCreadas;

    @OneToMany( mappedBy = "_usuarioAnalista", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuestasAAnalizar;

    @OneToMany( mappedBy = "_usuarioEncuestado", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<EjecucionEncuesta> _ejecucionEncuestas;

    public List<Encuesta> get_encuestasCreadas() {
        return _encuestasCreadas;
    }

    public void set_encuestasCreadas(List<Encuesta> _encuestasCreadas) {
        this._encuestasCreadas = _encuestasCreadas;
    }

    public List<Encuesta> get_encuestasAAnalizar() {
        return _encuestasAAnalizar;
    }

    public void set_encuestasAAnalizar(List<Encuesta> _encuestasAAnalizar) {
        this._encuestasAAnalizar = _encuestasAAnalizar;
    }

    public List<EjecucionEncuesta> get_ejecucionEncuestas() {
        return _ejecucionEncuestas;
    }

    public void set_ejecucionEncuestas(List<EjecucionEncuesta> _ejecucionEncuestas) {
        this._ejecucionEncuestas = _ejecucionEncuestas;
    }

    public List<Solicitud> get_solicitudes() {
        return _solicitudes;
    }

    public void set_solicitudes(List<Solicitud> _solicitudes) {
        this._solicitudes = _solicitudes;
    }

    public List<Estudio> get_estudios() {
        return _estudios;
    }

    public void set_estudios(List<Estudio> _estudios) {
        this._estudios = _estudios;
    }

    public Usuario(long id )
    {
        super( id );
    }

    public Usuario()
    {

    }
}
