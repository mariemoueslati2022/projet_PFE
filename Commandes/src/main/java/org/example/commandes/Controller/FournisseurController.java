package org.example.commandes.Controller;

import org.example.commandes.Service.FournisseurService;
import org.example.commandes.Entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService FournisseurService;

    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = FournisseurService.getAllFournisseurs();
        return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long id) {
        Optional<Fournisseur> fournisseur = FournisseurService.getFournisseurById(id);
        return fournisseur.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<Fournisseur> getFournisseurByNom(@PathVariable String nom) {
        Fournisseur fournisseur = FournisseurService.getFournisseurByNom(nom);
        if (fournisseur != null) {
            return new ResponseEntity<>(fournisseur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/email")
    public ResponseEntity<List<Fournisseur>> getFournisseursByEmail(@RequestParam String email) {
        List<Fournisseur> fournisseurs = FournisseurService.getFournisseursByEmail(email);
        return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur savedFournisseur = FournisseurService.saveFournisseur(fournisseur);
        return new ResponseEntity<>(savedFournisseur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {
        Fournisseur updatedFournisseur = FournisseurService.updateFournisseur(id, fournisseur);
        if (updatedFournisseur != null) {
            return new ResponseEntity<>(updatedFournisseur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Long id) {
        Optional<Fournisseur> fournisseur = FournisseurService.getFournisseurById(id);
        if (fournisseur.isPresent()) {
            FournisseurService.deleteFournisseur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}