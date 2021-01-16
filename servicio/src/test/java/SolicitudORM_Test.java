import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.SolicitudDto;
import ucab.dsw.dtos.SubcategoriaDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Solicitud;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class SolicitudORM_Test {

    @Test
    public void addSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.SolicitudORM servicio = new ucab.dsw.servicio.SolicitudORM();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre( "Nombre de solicitud" );

        DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        solicitudDto.setFecha(fecha.parse("19-11-2020"));

        solicitudDto.setEstatus( "A" );

        UsuarioDto usuarioDto = new UsuarioDto( 21);
        solicitudDto.setUsuarioDto(usuarioDto);

        SubcategoriaDto subcategoriaDto = new SubcategoriaDto(1);
        solicitudDto.setSubcategoriaDto(subcategoriaDto);
        SolicitudDto resultado = servicio.addSolicitud(solicitudDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getSolicitudesTest()  throws  Exception
    {
        ucab.dsw.servicio.SolicitudORM servicio = new ucab.dsw.servicio.SolicitudORM();
        List<Solicitud> solicitudes = servicio.getSolicitudes();
        Assert.assertFalse("getSolicitudesTest completo", solicitudes.isEmpty());
    }

    @Test
    public void  updateSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.SolicitudORM servicio = new ucab.dsw.servicio.SolicitudORM();
        SolicitudDto solicitudDto = new SolicitudDto();
        solicitudDto.setNombre("Actualizacion de solicitud");
        solicitudDto.setEstatus("A");

        DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        solicitudDto.setFecha(fecha.parse("29-11-2020"));

        UsuarioDto usuarioDto = new UsuarioDto( 21);
        solicitudDto.setUsuarioDto(usuarioDto);

        SubcategoriaDto subcategoriaDto = new SubcategoriaDto( 3);
        solicitudDto.setSubcategoriaDto(subcategoriaDto);

        SolicitudDto resultado = servicio.updateSolicitud(1, solicitudDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteSolicitudTest() throws Exception
    {
        ucab.dsw.servicio.SolicitudORM servicio = new ucab.dsw.servicio.SolicitudORM();
        SolicitudDto resultado = servicio.deleteSolicitud(4);
        Assert.assertNotEquals(resultado.getId(), 0);
    }
}
