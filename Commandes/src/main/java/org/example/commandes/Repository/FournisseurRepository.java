package org.example.commandes.Repository;

import org.example.commandes.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    Fournisseur findByNom(String nom);

    List<Fournisseur> findByEmailContaining(String email);
}