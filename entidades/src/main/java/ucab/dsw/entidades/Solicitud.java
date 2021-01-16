package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "solicitud")
public class Solicitud extends EntidadBase {

    @Column(name = "nombre")
    private String _nombre;

    @Column(name = "fecha")
    @Temporal(value = TemporalType.DATE)
    private Date _fecha;

    @Column(name = "estatus")
    private String _estatus;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario _usuario;

    @ManyToOne
    @JoinColumn(name = "idSubCategoria", nullable = false)
    private Subcategoria _subcategoria;

    @OneToMany( mappedBy = "_solicitud", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Estudio> _estudios;

    public Solicitud(long id) {
        super(id);
    }

    public Solicitud() {
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Date get_fecha() {
        return _fecha;
    }

    public void set_fecha(Date _fecha) {
        this._fecha = _fecha;
    }

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    public Usuario get_usuario() {
        return _usuario;
    }

    public void set_usuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Subcategoria getSubcategoria() {
        return _subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this._subcategoria = subcategoria;
    }

    public Subcategoria get_subcategoria() {
        return _subcategoria;
    }

    public void set_subcategoria(Subcategoria _subcategoria) {
        this._subcategoria = _subcategoria;
    }

    public List<Estudio> get_estudios() {
        return _estudios;
    }

    public void set_estudios(List<Estudio> _estudios) {
        this._estudios = _estudios;
    }
}
