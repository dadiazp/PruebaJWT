import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.EncuestaDto;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Encuesta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class EncuestaORM_Test{

    @Test
    public void addEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.EncuestaORM servicio = new ucab.dsw.servicio.EncuestaORM();
        EncuestaDto encuestaDto = new EncuestaDto();

        DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        encuestaDto.setFechaCreacion(fecha.parse("06-11-2020"));

        encuestaDto.setEstatus( "C" );

        UsuarioDto usuarioCreadorDto = new UsuarioDto( 21);
        encuestaDto.setUsuarioCreadorDto(usuarioCreadorDto);

        UsuarioDto usuarioAnalistaDto = new UsuarioDto( 22);
        encuestaDto.setUsuarioAnalistaDto(usuarioAnalistaDto);

        EstudioDto estudioDto = new EstudioDto(2);
        encuestaDto.setEstudioDto(estudioDto);

        EncuestaDto resultado = servicio.addEncuesta(encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getEncuestasTest()  throws  Exception
    {
        ucab.dsw.servicio.EncuestaORM servicio = new ucab.dsw.servicio.EncuestaORM();
        List<Encuesta> encuestas = servicio.getEncuestas();
        Assert.assertFalse("getEncuestasTest completo", encuestas.isEmpty());
    }

    @Test
    public void updateEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.EncuestaORM servicio = new ucab.dsw.servicio.EncuestaORM();
        EncuestaDto encuestaDto = new EncuestaDto();

        DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        encuestaDto.setFechaCreacion(fecha.parse("01-10-2020"));

        encuestaDto.setEstatus( "C" );

        UsuarioDto usuarioCreadorDto = new UsuarioDto( 22);
        encuestaDto.setUsuarioCreadorDto(usuarioCreadorDto);

        UsuarioDto usuarioAnalistaDto = new UsuarioDto( 21);
        encuestaDto.setUsuarioAnalistaDto(usuarioAnalistaDto);

        EstudioDto estudioDto = new EstudioDto(2);
        encuestaDto.setEstudioDto(estudioDto);

        EncuestaDto resultado = servicio.updateEncuesta(4, encuestaDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteEncuestaTest() throws Exception
    {
        ucab.dsw.servicio.EncuestaORM servicio = new ucab.dsw.servicio.EncuestaORM();
        EncuestaDto resultado = servicio.deleteEncuesta(5);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
