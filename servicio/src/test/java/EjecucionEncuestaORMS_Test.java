import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.*;
import ucab.dsw.entidades.EjecucionEncuesta;
import java.util.List;

public class EjecucionEncuestaORMS_Test {

    @Test
    public void  addEjecucionTest() throws Exception
    {
        ucab.dsw.servicio.EjecucionEncuestaORMWS servicio = new ucab.dsw.servicio.EjecucionEncuestaORMWS();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto();
        ejecucionEncuestaDto.setRespuesta("Respuesta de Ejecucion Encuesta");
        ejecucionEncuestaDto.setEstatus("C");

        EncuestaDto encuestaDto = new EncuestaDto( 4);
        ejecucionEncuestaDto.setEncuestaDto(encuestaDto);

        PreguntaDto preguntaDto = new PreguntaDto( 1);
        ejecucionEncuestaDto.setPreguntaDto(preguntaDto);

        UsuarioDto usuario = new UsuarioDto( 22);
        ejecucionEncuestaDto.setUsuarioEncuestadoDto(usuario);

        OpcionDto opcionDto = new OpcionDto(1);
        ejecucionEncuestaDto.setOpcionDto((opcionDto));

        EjecucionEncuestaDto resultado = servicio.addEjecucionEncuesta(ejecucionEncuestaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void getEjecucionesTest()  throws  Exception
    {
        ucab.dsw.servicio.EjecucionEncuestaORMWS servicio = new ucab.dsw.servicio.EjecucionEncuestaORMWS();
        List<EjecucionEncuesta> ejecucionEncuestas = servicio.getEjecuciones();
        Assert.assertFalse("getEjecucionesTest completo", ejecucionEncuestas.isEmpty());
    }

    @Test
    public void  updateEjecucionTest() throws Exception
    {
        ucab.dsw.servicio.EjecucionEncuestaORMWS servicio = new ucab.dsw.servicio.EjecucionEncuestaORMWS();
        EjecucionEncuestaDto ejecucionEncuestaDto = new EjecucionEncuestaDto();
        ejecucionEncuestaDto.setRespuesta("Respuesta actualizada de Ejecucion Encuesta");
        ejecucionEncuestaDto.setEstatus("C");

        EncuestaDto encuestaDto = new EncuestaDto( 4);
        ejecucionEncuestaDto.setEncuestaDto(encuestaDto);

        PreguntaDto preguntaDto = new PreguntaDto( 1);
        ejecucionEncuestaDto.setPreguntaDto(preguntaDto);

        UsuarioDto usuario = new UsuarioDto( 22);
        ejecucionEncuestaDto.setUsuarioEncuestadoDto(usuario);

        OpcionDto opcionDto = new OpcionDto(1);
        ejecucionEncuestaDto.setOpcionDto((opcionDto));

        EjecucionEncuestaDto resultado = servicio.updateEjecucion(3, ejecucionEncuestaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteEjecucionTest() throws Exception
    {
        ucab.dsw.servicio.EjecucionEncuestaORMWS servicio = new ucab.dsw.servicio.EjecucionEncuestaORMWS();
        EjecucionEncuestaDto resultado = servicio.deleteEjecucion(3);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

}
