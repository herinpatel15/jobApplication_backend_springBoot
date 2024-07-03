package com.helloHerin.jobApplication.compny;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompnyController {

    private final  CompnyService compnyService;

    public CompnyController(CompnyService compnyService) {
        this.compnyService = compnyService;
    }

    @GetMapping
    public ResponseEntity<List<Compny>> getAllCompany() {
        return new ResponseEntity<>(compnyService.getAllCompany(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Compny company, @PathVariable Long id) {
        compnyService.updateCompany(company, id);
        return new ResponseEntity<>("Company Update Successfully...", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Compny compny) {
        compnyService.createCompany(compny);
        return new ResponseEntity<>("Create Company successFully...", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        boolean check = compnyService.deleteCompanyById(id);
        if(check) {
            return new ResponseEntity<>("Delete Company Successfully...", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company Not Found...", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compny> getCompanyById(@PathVariable Long id) {
        Compny comp = compnyService.getCompanyById(id);
        if (comp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(comp, HttpStatus.OK);
        }
    }

}
