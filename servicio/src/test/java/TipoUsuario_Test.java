import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.entidades.TipoPregunta;
import ucab.dsw.entidades.TipoUsuario;

import java.util.List;

public class TipoUsuario_Test {

    @Test
    public void addTipoUsuario() throws Exception{
        ucab.dsw.servicio.TipoUsuarioORMWS servicio = new ucab.dsw.servicio.TipoUsuarioORMWS();
        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion( "Descripcion Tipo usuario" );
        tipoUsuarioDto.setEstatus("A");
        TipoUsuarioDto resultado = servicio.addTipoUsuario( tipoUsuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getTipoUsuario() throws Exception{
        ucab.dsw.servicio.TipoUsuarioORMWS servicio = new ucab.dsw.servicio.TipoUsuarioORMWS();
        List<TipoUsuario> tipoUsuario = servicio.getTipoUsuario();
        Assert.assertFalse("getTipoUsuario Test completo",tipoUsuario.isEmpty());
    }

    @Test
    public void  updateTipoUsuario() throws Exception
    {
        ucab.dsw.servicio.TipoUsuarioORMWS servicio = new ucab.dsw.servicio.TipoUsuarioORMWS();
        TipoUsuarioDto tipoUsuarioDto = new TipoUsuarioDto();
        tipoUsuarioDto.setDescripcion("Descripcion updateada");
        TipoUsuarioDto resultado = servicio.updateTipoUsuario(1, tipoUsuarioDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteTipoUsuario() throws Exception
    {
        ucab.dsw.servicio.TipoUsuarioORMWS servicio = new ucab.dsw.servicio.TipoUsuarioORMWS();
        TipoUsuarioDto resultado = servicio.deleteTipoUsuario(5);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

}
