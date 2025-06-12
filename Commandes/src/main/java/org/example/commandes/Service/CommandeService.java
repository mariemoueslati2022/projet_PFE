package org.example.commandes.Service;

import org.example.commandes.Repository.CommandeRepository;
import org.example.commandes.Entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    public List<Commande> getCommandesByFournisseur(Long fournisseurId) {
        return commandeRepository.findByFournisseurId(fournisseurId);
    }

    public List<Commande> getCommandesByStatut(String statut) {
        return commandeRepository.findByStatut(statut);
    }

    public List<Commande> getCommandesByDateRange(Date debut, Date fin) {
        return commandeRepository.findByDateCommandeBetween(debut, fin);
    }


    @Transactional
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    @Transactional
    public Commande updateStatutCommande(Long id, String statut) {
        Optional<Commande> commandeOpt = commandeRepository.findById(id);
        if (commandeOpt.isPresent()) {
            Commande commande = commandeOpt.get();
            return commandeRepository.save(commande);
        }
        return null;
    }


    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande createCommande(Commande commande) {
    }

    public Commande updateCommande(Long id, Commande commande) {
    }
}
