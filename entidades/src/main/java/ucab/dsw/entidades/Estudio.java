package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudio")
public class Estudio extends EntidadBase{

    @Column(name = "fechacreacion")
    @Temporal(value = TemporalType.DATE)
    private Date _fechaCrecion;

    @Column(name = "estatus")
    private String _estatus;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn(name = "idSolicitud", nullable = false)
    private Solicitud _solicitud;

    @OneToMany( mappedBy = "_estudio", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Encuesta> _encuestas;

    public Estudio(long id) {
        super(id);
    }

    public Estudio() {
    }

    public Date getFechaCrecion() {
        return _fechaCrecion;
    }

    public void setFechaCrecion(Date fechaCrecion) {
        this._fechaCrecion = fechaCrecion;
    }

    public String getEstatus() {
        return _estatus;
    }

    public void setEstatus(String estatus) {
        this._estatus = estatus;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Solicitud get_solicitud() {
        return _solicitud;
    }

    public void set_solicitud(Solicitud _solicitud) {
        this._solicitud = _solicitud;
    }

    public Date get_fechaCrecion() {
        return _fechaCrecion;
    }

    public void set_fechaCrecion(Date _fechaCrecion) {
        this._fechaCrecion = _fechaCrecion;
    }

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    public List<Encuesta> get_encuestas() {
        return _encuestas;
    }

    public void set_encuestas(List<Encuesta> _encuestas) {
        this._encuestas = _encuestas;
    }
    
}
