package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria extends EntidadBase {

    @Column(name = "descripcion")
    private String _descripcion;

    @Column(name = "estatus")
    private String _estatus;

    @OneToMany(mappedBy = "_categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subcategoria> _subcategorias;

    public Categoria() {

    }

    public Categoria(long id) {
        super(id);
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    public List<Subcategoria> get_subcategorias() {
        return _subcategorias;
    }

    public void set_subcategorias(List<Subcategoria> _subcategorias) {
        this._subcategorias = _subcategorias;
    }

}
