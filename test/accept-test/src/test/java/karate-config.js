function fn() {
    var config = {
//        baseUrl: 'https://negocios-inversion-int-dev.apps.ambientesbc.com/horus/payment-order/',
//        baseUrl: 'https://negocios-inversion-int-qa.apps.ambientesbc.com/horus/payment-order/',
//        baseUrl : 'http://localhost:8080/payment-order/',
//        baseUrl : 'http://localhost:8080/payment-order/',
	          baseUrl : '#{baseUrl}#'
    };
    return config;
}