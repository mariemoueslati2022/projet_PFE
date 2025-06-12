package org.example.commandes.Service;

import org.example.commandes.Repository.LigneCommandeRepository;
import org.example.commandes.Entities.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public List<LigneCommande> getAllLignesCommande() {
        return ligneCommandeRepository.findAll();
    }

    public Optional<LigneCommande> getLigneCommandeById(Long id) {
        return ligneCommandeRepository.findById(id);
    }

    public List<LigneCommande> getLignesCommandeByCommande(Long commandeId) {
        return ligneCommandeRepository.findByCommandeId(commandeId);
    }

    public List<LigneCommande> getLignesCommandeByArticle(Long articleId) {
        return ligneCommandeRepository.findByArticleId(articleId);
    }

    @Transactional
    public LigneCommande saveLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    @Transactional
    public void deleteLigneCommande(Long id) {
        ligneCommandeRepository.deleteById(id);
    }

    @Transactional
    public LigneCommande updateLigneCommande(Long id, LigneCommande updatedLigneCommande) {
        Optional<LigneCommande> ligneCommandeOpt = ligneCommandeRepository.findById(id);
        if (ligneCommandeOpt.isPresent()) {
            LigneCommande ligneCommande = ligneCommandeOpt.get();

            return ligneCommandeRepository.save(ligneCommande);
        }
        return null;
    }

    @Transactional
    public List<LigneCommande> saveLignesCommande(List<LigneCommande> lignesCommande) {
        return ligneCommandeRepository.saveAll(lignesCommande);
    }
}
