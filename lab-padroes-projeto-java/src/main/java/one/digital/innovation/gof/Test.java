package one.digital.innovation.gof;

import one.digital.innovation.gof.facade.Facade;
import one.digital.innovation.gof.singleton.SingletonEager;
import one.digital.innovation.gof.singleton.SingletonLazy;
import one.digital.innovation.gof.singleton.SingletonLazyHolder;
import one.digital.innovation.gof.strategy.*;

public class Test {
    public static void main(String[] args){

        // Testes do singleton
        /*
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        
        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);
        holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);

         */

        // Testes do strategy
        /*
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();
        robo.mover();

        robo.setComportamento(defensivo);
        robo.mover();
        robo.mover();

        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();
         */

        // Teste do facade
        /*
        Facade facade = new Facade();
        facade.migrarCliente("João", "582750000");
         */

    } 
}
