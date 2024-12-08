package com.esprit.microservereurekaclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200/")

@RestController
@RequestMapping("/Etudiant")

public class EtudiantRestAPI {

    private String hello = "Hello I'm An Etudiant";

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }

    @Autowired
    private EtudiantService etudiantService;


    @PostMapping(value = "/AddEtudiant", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Etudiant> createorganisation(@RequestBody Etudiant etudiant) {
        return new ResponseEntity<>(etudiantService.AddEtudiant(etudiant), HttpStatus.OK);
    }


    @PutMapping("/updateEtudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteetudiant(@PathVariable(value = "id") Long id) {
        String result = etudiantService.deleteEtudiant(id);
        return ResponseEntity.ok("Etudiant deleted successfully");
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Etudiant>> getetudiant() {
        List<Etudiant> etudiant = etudiantService.getAllEtudiant();
        if (etudiant != null) {
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Etudiant/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Etudiant> getEtudiant(@PathVariable("id") Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        return ResponseEntity.status(HttpStatus.OK).body(etudiant);
    }


}