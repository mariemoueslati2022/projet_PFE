package org.example.commandes.Repository;

import org.example.commandes.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

    List<Commande> findByFournisseurId(Long fournisseurId);

    List<Commande> findByStatut(String statut);

    List<Commande> findByDateCommandeBetween(Date debut, Date fin);
}