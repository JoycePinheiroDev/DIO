package subsistema2.cep;

import one.digital.innovation.gof.singleton.SingletonEager;

public class CepApi {
    private static CepApi instancia = new CepApi();

    private CepApi(){
        super();
    }

    public static CepApi getInstancia(){
        return instancia;
    }

    public String recuperarEstado(String cep){
        return "PB";
    }

    public String recuperarCidade(String cep){
        return "Itapororoca";
    }
}
