package org.example.commandes.Controller;


import org.example.commandes.Service.LigneCommandeService;
import org.example.commandes.Entities.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lignes-commande")
public class LigneCommandeController {

    @Autowired
    private LigneCommandeService ligneCommandeService;

    @GetMapping
    public ResponseEntity<List<LigneCommande>> getAllLignesCommande() {
        List<LigneCommande> lignesCommande = ligneCommandeService.getAllLignesCommande();
        return new ResponseEntity<>(lignesCommande, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneCommande> getLigneCommandeById(@PathVariable Long id) {
        Optional<LigneCommande> ligneCommande = ligneCommandeService.getLigneCommandeById(id);
        return ligneCommande.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/commande/{commandeId}")
    public ResponseEntity<List<LigneCommande>> getLignesCommandeByCommande(@PathVariable Long commandeId) {
        List<LigneCommande> lignesCommande = ligneCommandeService.getLignesCommandeByCommande(commandeId);
        return new ResponseEntity<>(lignesCommande, HttpStatus.OK);
    }

    @GetMapping("/article/{articleId}")
    public ResponseEntity<List<LigneCommande>> getLignesCommandeByArticle(@PathVariable Long articleId) {
        List<LigneCommande> lignesCommande = ligneCommandeService.getLignesCommandeByArticle(articleId);
        return new ResponseEntity<>(lignesCommande, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LigneCommande> createLigneCommande(@RequestBody LigneCommande ligneCommande) {
        LigneCommande savedLigneCommande = ligneCommandeService.saveLigneCommande(ligneCommande);
        return new ResponseEntity<>(savedLigneCommande, HttpStatus.CREATED);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<LigneCommande>> createLignesCommande(@RequestBody List<LigneCommande> lignesCommande) {
        List<LigneCommande> savedLignesCommande = ligneCommandeService.saveLignesCommande(lignesCommande);
        return new ResponseEntity<>(savedLignesCommande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigneCommande> updateLigneCommande(@PathVariable Long id, @RequestBody LigneCommande ligneCommande) {
        LigneCommande updatedLigneCommande = ligneCommandeService.updateLigneCommande(id, ligneCommande);
        if (updatedLigneCommande != null) {
            return new ResponseEntity<>(updatedLigneCommande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLigneCommande(@PathVariable Long id) {
        Optional<LigneCommande> ligneCommande = ligneCommandeService.getLigneCommandeById(id);
        if (ligneCommande.isPresent()) {
            ligneCommandeService.deleteLigneCommande(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
