package com.xxxxxxxxx.zzzzzzzzz.api.rest.pago;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xxxxxxxxx.zzzzzzzzz.api.rest.util.Constantes;
import com.xxxxxxxxx.zzzzzzzzz.api.rest.util.errors.BadRequestAlertException;
import com.xxxxxxxxx.zzzzzzzzz.api.rest.util.errors.HeaderUtil;
import com.xxxxxxxxx.zzzzzzzzz.aspectos.Trazable;
import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.FormaPago;
import com.xxxxxxxxx.zzzzzzzzz.usecase.formapago.FormaPagoUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "formapago", description = "the message API")
public class FormasPagoService {

	
    private static final String ERROR = "Error: {}";
    private final Logger log = LoggerFactory.getLogger(FormasPagoService.class);
    private String parametroDeEntrada = "FormaPago";
    private String nombreDeLaEntidad = "FormaPagoData";
    private final FormaPagoUseCase useCase;

    /**
     * Constructor
     *
     * @param localUseCase localUseCase
     */
    public FormasPagoService(FormaPagoUseCase localUseCase) {
        this.useCase = localUseCase;
    }

    /**
     * Metodo para crear la forma de pago
     * @param dto FormaPago
     * @return FormaPago
     * @throws URISyntaxException Exception
     */
    @Operation(summary = "Get a message by id", description = "Return a message", responses = {
    		@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = FormaPago.class))),
    		@ApiResponse(responseCode = "400", description = "Invalid id supplied"),
    		@ApiResponse(responseCode = "404", description = "Message not found") }
    	)
    @PostMapping("/formapago")
    @Trazable(getDescripcion="descripcion-x",getModulo="modulo-x",getOperacion="operacion-x",getTabla="tabla-x")
    public ResponseEntity<FormaPago> createFormaPago(@RequestBody FormaPago dto) throws URISyntaxException {
        log.debug("REST request to save FormaPago : {}", dto);
        if (dto.getId() != null) {
            throw new BadRequestAlertException("A new FormaPago cannot already have an ID", nombreDeLaEntidad,
                    "idexists");
        }
        FormaPago result = useCase.save(dto);
        return ResponseEntity.created(new URI("/FormaPago/" + result.getId())).headers(HeaderUtil
                .createEntityCreationAlert(Constantes.NOMBRE_APLICACION, nombreDeLaEntidad, result.getId().toString()))
                .body(result);
    }

    /**
     * Metodo para actualizar la forma de pago
     * @param dto FormaPago
     * @return FormaPago
     * @throws URISyntaxException Exception
     */
    @PutMapping("/formapago")
    public ResponseEntity<FormaPago> updateFormaPago(@RequestBody FormaPago dto) throws URISyntaxException {
        log.debug("REST request to update FormaPago : {}", dto);
        if (dto.getId() == null) {
            throw new BadRequestAlertException("Invalid id", nombreDeLaEntidad, "idnull");
        }
        FormaPago result = useCase.save(dto);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(Constantes.NOMBRE_APLICACION,
                nombreDeLaEntidad, dto.getId().toString())).body(result);
    }

    /**
     * Metodo que retorna una foram de pago
     * @param id Long
     * @return FormaPago
     */
    @GetMapping("/formapago/{id}")
    public ResponseEntity<FormaPago> getFormaPago(@PathVariable Long id) {
        log.debug("REST request to get FormaPago : {}", id);
        FormaPago dto = useCase.findOne(id);
        if (Objects.nonNull(dto)) {
            return ResponseEntity.ok().headers(
                    HeaderUtil.createAlert(Constantes.NOMBRE_APLICACION, Constantes.MENSAJE_EXITO, parametroDeEntrada))
                    .body(dto);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Metodo que elimina una foram de pago
     * @param id Long
     * @return Void
     */
    @DeleteMapping("/formapago/{id}")   
    public ResponseEntity<Void> deleteFormaPago(@PathVariable Long id) {
        log.debug("REST request to delete FormaPago : {}", id);
        try {
            useCase.delete(id);
        } catch (EmptyResultDataAccessException ex) {
            log.info(ERROR, ex);
            throw new BadRequestAlertException("Item to delete NOT Exists anymore", nombreDeLaEntidad, "Dto NULL");
        }
        return ResponseEntity.noContent().headers(
                HeaderUtil.createEntityDeletionAlert(Constantes.NOMBRE_APLICACION, nombreDeLaEntidad, id.toString()))
                .build();
    }

    /**
     * Metodo que retorna todas las formas de pago
     * @return List<FormaPago>
     */
    @GetMapping("/formapago-todos")
    public ResponseEntity<List<FormaPago>> getAll() {
        try {
            log.debug("REST request to get all FormaPago");
            List<FormaPago> losDtos = useCase.findAll();
            return ResponseEntity.ok().headers(
                    HeaderUtil.createAlert(Constantes.NOMBRE_APLICACION, Constantes.MENSAJE_EXITO, parametroDeEntrada))
                    .body(losDtos);
        } catch (Exception e) {
            log.info(ERROR, e);
            return ResponseEntity.ok().headers(
                    HeaderUtil.createAlert(Constantes.NOMBRE_APLICACION, Constantes.MENSAJE_EXITO, parametroDeEntrada))
                    .body(new ArrayList<>());
        }
    }
    
    
}
