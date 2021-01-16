package ucab.dsw.entidades;

import javax.persistence.*;

@Entity
@Table(name = "ejecucionencuesta")
public class EjecucionEncuesta extends EntidadBase{

    @Column(name = "respuesta")
    private String _respuesta;

    @Column(name = "estatus")
    private String _estatus;

    @ManyToOne
    @JoinColumn(name = "idEncuesta", nullable = false)
    private Encuesta _encuesta;

    @ManyToOne
    @JoinColumn(name = "idPregunta", nullable = false)
    private Pregunta _pregunta;

    @ManyToOne
    @JoinColumn(name = "idUsuario_Encuestado", nullable = false)
    private Usuario _usuarioEncuestado;

    @ManyToOne
    @JoinColumn(name = "idOpcion")
    private Opcion _opcion;

    public EjecucionEncuesta(long id) {
        super(id);
    }

    public EjecucionEncuesta() {
    }

    public String get_respuesta() {
        return _respuesta;
    }

    public void set_respuesta(String _respuesta) {
        this._respuesta = _respuesta;
    }

    @Override
    public String get_estatus() {
        return _estatus;
    }

    @Override
    public void set_estatus(String _estatus) {
        this._estatus = _estatus;
    }

    public Encuesta get_encuesta() {
        return _encuesta;
    }

    public void set_encuesta(Encuesta _encuesta) {
        this._encuesta = _encuesta;
    }

    public Pregunta get_pregunta() {
        return _pregunta;
    }

    public void set_pregunta(Pregunta _pregunta) {
        this._pregunta = _pregunta;
    }

    public Usuario get_usuarioEncuestado() {
        return _usuarioEncuestado;
    }

    public void set_usuarioEncuestado(Usuario _usuarioEncuestado) {
        this._usuarioEncuestado = _usuarioEncuestado;
    }

    public Opcion get_opcion() {
        return _opcion;
    }

    public void set_opcion(Opcion _opcion) {
        this._opcion = _opcion;
    }
}
