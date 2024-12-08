package com.esprit.microservereurekaclient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;


    @Autowired
    private ModelMapper mapper;

    public Etudiant AddEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Etudiant newEtudiant) {

            Etudiant existingEtudiant = etudiantRepository.findById(newEtudiant.getIdEtudiant()).get();
            existingEtudiant.setNomEt(newEtudiant.getNomEt());
            existingEtudiant.setPrenomEt(newEtudiant.getPrenomEt());
            existingEtudiant.setCin(newEtudiant.getCin());
            existingEtudiant.setEcole(newEtudiant.getEcole());
            existingEtudiant.setDateNaissance(newEtudiant.getDateNaissance());

            return etudiantRepository.save(existingEtudiant);

    }

    public String deleteEtudiant(Long id) {
        if (etudiantRepository.findById(id).isPresent()) {
            etudiantRepository.deleteById(id);
            return "Etudiant supprimé";
        } else
            return "Etudiant non supprimé";
    }

    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }



}

