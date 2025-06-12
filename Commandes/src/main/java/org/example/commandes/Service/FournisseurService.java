package org.example.commandes.Service;

import org.example.commandes.Repository.FournisseurRepository;
import org.example.commandes.Entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository FournisseurRepository;

    public List<Fournisseur> getAllFournisseurs() {
        return FournisseurRepository.findAll();
    }

    public Optional<Fournisseur> getFournisseurById(Long id) {
        return FournisseurRepository.findById(id);
    }

    public Fournisseur getFournisseurByNom(String nom) {
        return FournisseurRepository.findByNom(nom);
    }

    public List<Fournisseur> getFournisseursByEmail(String email) {
        return FournisseurRepository.findByEmailContaining(email);
    }

    @Transactional
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return FournisseurRepository.save(fournisseur);
    }

    @Transactional
    public void deleteFournisseur(Long id) {
        FournisseurRepository.deleteById(id);
    }

    @Transactional
    public Fournisseur updateFournisseur(Long id, Fournisseur updatedFournisseur) {
        Optional<Fournisseur> fournisseurOpt = FournisseurRepository.findById(id);
        if (fournisseurOpt.isPresent()) {
            Fournisseur fournisseur = fournisseurOpt.get();


            return FournisseurRepository.save(fournisseur);
        }
        return null;
    }

}
