package org.example.installations.Service;

import org.example.installations.Entities.Installation;
import org.example.installations.Repository.InstallationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstallationService {

    @Autowired
    private InstallationRepository installationRepository;

    public Installation saveInstallation(Installation installation) {
        return installationRepository.save(installation);
    }

    public List<Installation> getAllInstallations() {
        return installationRepository.findAll();
    }

    public Optional<Installation> getInstallationById(Long id) {
        return installationRepository.findById(id);
    }



    public void deleteInstallation(Long id) {
        installationRepository.deleteById(id);
    }
}
