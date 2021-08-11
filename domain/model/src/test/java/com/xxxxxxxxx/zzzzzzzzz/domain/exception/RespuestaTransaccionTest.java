package com.xxxxxxxxx.zzzzzzzzz.domain.exception;

import org.junit.Assert;
import org.junit.Test;

import com.xxxxxxxxx.zzzzzzzzz.domain.exception.RespuestaTransaccion;

public class RespuestaTransaccionTest {

    @Test
    public void test() {
        RespuestaTransaccion respuestaTransaccion = new RespuestaTransaccion();
        respuestaTransaccion.setCodigo(null);
        respuestaTransaccion.setMsgUsuario(null);
        respuestaTransaccion.setMsgTecnico(null);
        respuestaTransaccion.getCodigo();
        respuestaTransaccion.getMsgUsuario();
        respuestaTransaccion.getMsgTecnico();
        Assert.assertNotNull(respuestaTransaccion.toString());
    }

    @Test
    public void testGetRespuestaTransaccion() {
        Assert.assertNotNull(RespuestaTransaccion.getRespuestaTransaccion(null, null, null));
    }

}
