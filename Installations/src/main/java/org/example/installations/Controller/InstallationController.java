package org.example.installations.Controller;

import org.example.installations.Entities.Installation;
import org.example.installations.Service.InstallationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/installations")
public class InstallationController {

    @Autowired
    private InstallationService installationService;

    @PostMapping
    public Installation createInstallation(@RequestBody Installation installation) {
        return installationService.saveInstallation(installation);
    }

    @GetMapping
    public List<Installation> getAllInstallations() {
        return installationService.getAllInstallations();
    }

    @GetMapping("/{id}")
    public Optional<Installation> getInstallationById(@PathVariable Long id) {
        return installationService.getInstallationById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteInstallation(@PathVariable Long id) {
        installationService.deleteInstallation(id);
    }
}
