import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.Opcion;
import ucab.dsw.entidades.Pregunta;

import java.util.List;

public class Opcion_Test {
    @Test
    public void addPregunta() throws Exception{
        ucab.dsw.servicio.OpcionORMWS servicio = new ucab.dsw.servicio.OpcionORMWS();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion( "Descripcion agregada" );
        opcionDto.setEstatus( "A" );
        /*Pregunta*/
        PreguntaDto preguntaDto = new PreguntaDto( 1);
        opcionDto.setPreguntaDto( preguntaDto );
        OpcionDto resultado = servicio.addOpcion( opcionDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }
    @Test
    public void updateOpcion() throws Exception{
        ucab.dsw.servicio.OpcionORMWS servicio = new ucab.dsw.servicio.OpcionORMWS();
        OpcionDto opcionDto = new OpcionDto();
        opcionDto.setDescripcion("Descripcion Actualizada");
        opcionDto.setEstatus("I");
        OpcionDto resultado = servicio.updateOpcion(2,opcionDto);
        Assert.assertNotEquals(resultado.getId(),0);
    }
    @Test
    public void deleteOpcion() throws Exception{
        ucab.dsw.servicio.OpcionORMWS servicio = new ucab.dsw.servicio.OpcionORMWS();
        OpcionDto resultado = servicio.deleteOpcion(2);
        Assert.assertNotEquals(resultado.getId(),0);
    }
    @Test
    public void getOpcion() throws Exception{
        ucab.dsw.servicio.OpcionORMWS servicio = new ucab.dsw.servicio.OpcionORMWS();
        List<Opcion> opciones = servicio.getOpcion();
        Assert.assertFalse("Consulta preguntas",opciones.isEmpty());

    }
}
