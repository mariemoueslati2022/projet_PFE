package org.example.commandes.Controller;

import org.example.commandes.Service.CommandeService;
import org.example.commandes.Entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService CommandeService;

    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        List<Commande> commandes = CommandeService.getAllCommandes();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Optional<Commande> commande = CommandeService.getCommandeById(id);
        return commande.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/fournisseur/{fournisseurId}")
    public ResponseEntity<List<Commande>> getCommandesByFournisseur(@PathVariable Long fournisseurId) {
        List<Commande> commandes = CommandeService.getCommandesByFournisseur(fournisseurId);
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/statut/{statut}")
    public ResponseEntity<List<Commande>> getCommandesByStatut(@PathVariable String statut) {
        List<Commande> commandes = CommandeService.getCommandesByStatut(statut);
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Commande>> getCommandesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date debut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fin) {
        List<Commande> commandes = CommandeService.getCommandesByDateRange(debut, fin);
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        Commande savedCommande = CommandeService.saveCommande(commande);
        return new ResponseEntity<>(savedCommande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        Optional<Commande> existingCommande = CommandeService.getCommandeById(id);
        if (existingCommande.isPresent()) {
            Commande updatedCommande = CommandeService.saveCommande(commande);
            return new ResponseEntity<>(updatedCommande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}/statut")
    public ResponseEntity<Commande> updateStatutCommande(@PathVariable Long id, @RequestParam String statut) {
        Commande updatedCommande = CommandeService.updateStatutCommande(id, statut);
        if (updatedCommande != null) {
            return new ResponseEntity<>(updatedCommande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        Optional<Commande> commande = CommandeService.getCommandeById(id);
        if (commande.isPresent()) {
            CommandeService.deleteCommande(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
