package com.example.aulajpa;

import com.example.aulajpa.domain.entities.Veiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;

public class AppTest {
    public static void main(String[] args) {
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("ifpr_aula_jpa");
        em = emf.createEntityManager();

        Veiculo v1 = new Veiculo();
        v1.setCodigo(4l);
        v1.setModelo("Fusca");
        v1.setFabricante("VW");
        v1.setAnoFabricacao(1989);
        v1.setAnoModelo(1990);

        em.persist(v1);
    }
}
