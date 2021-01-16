import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.Pregunta;

import java.util.List;

public class Pregunta_Test {

    @Test
    public void addPregunta() throws Exception{
        ucab.dsw.servicio.PreguntaORMWS servicio = new ucab.dsw.servicio.PreguntaORMWS();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta( "Hola como estas?" );
        preguntaDto.setFechacreacion( "2020/11/20" );
        preguntaDto.setEstatus( "A" );
        /*Tipo pregunta*/
        TipoPreguntaDto tipoPregunta = new TipoPreguntaDto( 1);
        preguntaDto.setTipoPreguntaDto( tipoPregunta );
        /*Subcategoria*/
        SubcategoriaDto subcategoriaDto = new SubcategoriaDto( 1);
        preguntaDto.setSubcategoriaDto( subcategoriaDto );
        /*Usuario*/
        UsuarioDto usuarioDto = new UsuarioDto(21);
        preguntaDto.setUsuarioDto( usuarioDto );
        PreguntaDto resultado = servicio.addPregunta( preguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }
    @Test
    public void updatePregunta() throws Exception{
        ucab.dsw.servicio.PreguntaORMWS servicio = new ucab.dsw.servicio.PreguntaORMWS();
        PreguntaDto preguntaDto = new PreguntaDto();
        preguntaDto.setPregunta("Pregunta Actualizada");
        preguntaDto.setFechacreacion("2020/03/28");
        preguntaDto.setEstatus("A");
        PreguntaDto resultado = servicio.updatePregunta(2,preguntaDto);
        Assert.assertNotEquals(resultado.getId(),0);
    }

    @Test
    public void deletePregunta() throws Exception{
        ucab.dsw.servicio.PreguntaORMWS servicio = new ucab.dsw.servicio.PreguntaORMWS();
        PreguntaDto resultado = servicio.deletePregunta(2);
        Assert.assertNotEquals(resultado.getId(),0);
    }

    @Test
    public void getPregunta() throws Exception{
        ucab.dsw.servicio.PreguntaORMWS servicio = new ucab.dsw.servicio.PreguntaORMWS();
        List<Pregunta> preguntas = servicio.getPregunta();
        Assert.assertFalse("Consulta preguntas",preguntas.isEmpty());

    }
}
