package com.xxxxxxxxx.zzzzzzzzz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xxxxxxxxx.zzzzzzzzz.domain.formapago.gateways.FormaPagoRepository;
import com.xxxxxxxxx.zzzzzzzzz.domain.log.gateways.LoggerRepository;
import com.xxxxxxxxx.zzzzzzzzz.usecase.formapago.FormaPagoUseCase;

@Configuration
public class UseCaseConfigUtilitariosPertinencias {

    @Bean
    public FormaPagoUseCase crearFormaPagoUseCase(
            LoggerRepository log, FormaPagoRepository formaPago) {
        return new FormaPagoUseCase(formaPago, log);
    }

}
