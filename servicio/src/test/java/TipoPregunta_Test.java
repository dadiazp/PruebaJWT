import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.TipoPregunta;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

public class TipoPregunta_Test {
    @Test
    public void addTipoPregunta() throws Exception{
        ucab.dsw.servicio.TipoPreguntaORMWS servicio = new ucab.dsw.servicio.TipoPreguntaORMWS();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion( "Descripcion test 1" );
        tipoPreguntaDto.setEstatus("A");
        TipoPreguntaDto resultado = servicio.addTipoPregunta( tipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getTipoPregunta() throws Exception{
        ucab.dsw.servicio.TipoPreguntaORMWS servicio = new ucab.dsw.servicio.TipoPreguntaORMWS();
        List<TipoPregunta> tipoPregunta = servicio.getTipoPregunta();
        Assert.assertFalse("getTipoPregunta Test completo",tipoPregunta.isEmpty());
    }

    @Test
    public void  updateTipoPregunta() throws Exception
    {
        ucab.dsw.servicio.TipoPreguntaORMWS servicio = new ucab.dsw.servicio.TipoPreguntaORMWS();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion("Descripcion updateada");
        TipoPreguntaDto resultado = servicio.updateTipoPregunta(2, tipoPreguntaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteTipoPregunta() throws Exception
    {
        ucab.dsw.servicio.TipoPreguntaORMWS servicio = new ucab.dsw.servicio.TipoPreguntaORMWS();
        TipoPreguntaDto resultado = servicio.deleteTipoPregutna(2);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

}
