import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.EstudioDto;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Estudio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class EstudioORM_Test {

    @Test
    public void addEstudioTest() throws Exception
    {
        ucab.dsw.servicio.EstudioORM servicio = new ucab.dsw.servicio.EstudioORM();
        EstudioDto estudioDto = new EstudioDto();

        DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        estudioDto.setFechaCreacion(fecha.parse("19-11-2020"));

        estudioDto.setEstatus( "C" );

        UsuarioDto usuarioDto = new UsuarioDto( 21);
        estudioDto.setUsuario(usuarioDto);

        SolicitudDto solicitudDto = new SolicitudDto(1);
        estudioDto.setSolicitud(solicitudDto);

        EstudioDto resultado = servicio.addEstudio(estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getEstudiosTest()  throws  Exception
    {
        ucab.dsw.servicio.EstudioORM servicio = new ucab.dsw.servicio.EstudioORM();
        List<Estudio> estudios = servicio.getEstudios();
        Assert.assertFalse("getEstudiosTest completo", estudios.isEmpty());
    }

    @Test
    public void updateEstudioTest() throws  Exception
    {
        ucab.dsw.servicio.EstudioORM servicio = new ucab.dsw.servicio.EstudioORM();
        EstudioDto estudioDto = new EstudioDto();

        DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        estudioDto.setFechaCreacion(fecha.parse("11-11-2020"));

        estudioDto.setEstatus( "C" );

        UsuarioDto usuarioDto = new UsuarioDto( 21);
        estudioDto.setUsuario(usuarioDto);

        SolicitudDto solicitudDto = new SolicitudDto(1);
        estudioDto.setSolicitud(solicitudDto);

        EstudioDto resultado = servicio.updateEstudio(2,estudioDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void deleteEstudioTest() throws Exception
    {
        ucab.dsw.servicio.EstudioORM servicio = new ucab.dsw.servicio.EstudioORM();
        EstudioDto resultado = servicio.deleteEstudio(3);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
