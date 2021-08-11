package com.xxxxxxxxx.zzzzzzzzz.aspectos;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.Trazabilidad;
import com.xxxxxxxxx.zzzzzzzzz.domain.trazabilidad.gateways.TrazabilidadRepository;
import com.xxxxxxxxx.zzzzzzzzz.domain.util.TrazableObject;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TrazableAspect {

	private static final String USER_HEADER = "preferred_username";
	private static final int 	UNO = 1;
	private static final String SIN_IP = "0:0:0:0:0:0:0:1";
	private static final String UNKNOWN = "unknown";
	private static final String IP_LOCAL = "127.0.0.1";
	private static final String ERROR = "Error en TrazableAspect, {}";
	private final Logger 		log = LoggerFactory.getLogger(TrazableAspect.class);
	private static final String TOKEN_MOCK = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldUIEJ1aWxkZX"
	+ "IiLCJpYXQiOjE2MjI2NDc2MzUsImV4cCI6MTY1NDE4MzYzNSwiYXVkIjoid3d3LmV4YW1wbGUuY29tIiwic3ViIjoianJvY2tldEBleGFtcGxlL"
	+ "mNvbSIsIkdpdmVuTmFtZSI6IkpvaG5ueSIsInByZWZlcnJlZF91c2VybmFtZSI6IkhtTWFyaW4iLCJFbWFpbCI6Impyb2NrZXRAZXhhbXBsZS5"
	+ "jb20iLCJSb2xlIjpbIk1hbmFnZXIiLCJQcm9qZWN0IEFkbWluaXN0cmF0b3IiXX0.AucvRKrb7BCMOwihQhaIem2xszPSo5Tx-DrEOiRUlJQ";
	private static final String UTF_8 = "UTF-8";	
	private static final String[] HEADERS_IP = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };
	//--
	@Autowired private HttpServletRequest httpServletRequest;
	@Autowired private TrazabilidadRepository trazabilidadRepo;
	

	@Around("execution(* com.bancolombia.causacionpagos.api.rest.*.*.*(..))")
	public Object around(ProceedingJoinPoint point) {
		// --
		httpServletRequest.getHeader("sessionGuid");
		httpServletRequest.getHeader("Authorization");
		// --
		Object result = null;
		try {
			result = point.proceed();
			MethodSignature signature = (MethodSignature) point.getSignature();
			Method method = signature.getMethod();
			Object[] listaDeObjetos = point.getArgs();
			// --
			Trazable trazable = method.getAnnotation(Trazable.class);
			if (trazable != null && listaDeObjetos != null && listaDeObjetos.length > 0) {
				for (Object object : listaDeObjetos) {
					if (object instanceof TrazableObject) {
						trazabilidadRepo.save(creartraza(object, trazable));
						break;
					}
				}
			}
		} catch (Throwable e) {
			log.error(ERROR, e);
		}
		return result;
	}

	private Trazabilidad creartraza(Object object,Trazable trazable) throws UnsupportedEncodingException {
		Trazabilidad dto = new Trazabilidad();
		dto.setIp(getIpAddress());
		dto.setUsuario(decodeToken(TOKEN_MOCK).get(USER_HEADER).getAsString());
		dto.setFechaRegistro(LocalDateTime.now());		
		dto.setValorNuevo(((TrazableObject) object).obtenerJson());
		dto.setTabla(trazable.getTabla());
		dto.setOperacion(trazable.getOperacion());
		dto.setFuncionalidad(trazable.getModulo());
		return dto;
	}

	public String getIpAddress() {
		String direccionIPFinal = "";
		String ipRemota = httpServletRequest.getRemoteAddr();
		for (String header : HEADERS_IP) {
			String ip = httpServletRequest.getHeader(header);
			if (ip != null && ip.length() != 0 && !UNKNOWN.equalsIgnoreCase(ip)) {
				direccionIPFinal = ip;
			}
		}
		return SIN_IP.equals(ipRemota) ? IP_LOCAL : direccionIPFinal;
	}
	
	public JsonObject decodeToken(String token) throws UnsupportedEncodingException{
		String[] pieces = token.split("\\.");
		String b64payload = pieces[UNO];
		String jsonString = new String(Base64.decodeBase64(b64payload), UTF_8);
		return new Gson().fromJson(jsonString,JsonObject.class);
	}

	
}
