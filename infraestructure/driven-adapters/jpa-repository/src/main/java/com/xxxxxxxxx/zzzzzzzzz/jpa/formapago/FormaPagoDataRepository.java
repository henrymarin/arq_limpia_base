package com.xxxxxxxxx.zzzzzzzzz.jpa.formapago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FormaPagoDataRepository extends JpaRepository<FormaPagoData, Long> {

    @Query(value = "SELECT DISTINCT * FROM tbl_cyp_forma_pago" +
    " WHERE UPPER(fpag_nombre) = UPPER(:nombre)", nativeQuery = true)
    Optional<FormaPagoData> findByNombre(@Param("nombre") String nombre);
    
    
}
