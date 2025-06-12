package org.example.commandes.Repository;

import org.example.commandes.Entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

    List<LigneCommande> findByCommandeId(Long commandeId);

    List<LigneCommande> findByArticleId(Long articleId);
}