package com.example.aulajpa;

import com.example.aulajpa.domain.entities.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class AppTest {


    public static void main(String[] args) {

        EntityManagerFactory emf;
        EntityManager em;

        emf = Persistence.createEntityManagerFactory("ifpr_aula_jpa");

        em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        //*********
        transaction.begin();

        Veiculo v1 = new Veiculo();

        //v1.setCodigo(4L);

        v1.setModelo("Fusca");
        v1.setFabricante("VW");
        v1.setAnoFabricacao(1989);
        v1.setAnoModelo(1990);
        v1.setValor(new BigDecimal("5000.00"));

        em.persist(v1);

        //teste



        //*********
        transaction.commit();

        Veiculo v2 = em.find(Veiculo.class, 1);

        System.out.println(v2.getModelo() + "  " + v2.getFabricante());


    }

}
