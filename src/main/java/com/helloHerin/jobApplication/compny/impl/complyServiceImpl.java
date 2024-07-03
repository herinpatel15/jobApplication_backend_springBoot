package com.helloHerin.jobApplication.compny.impl;

import com.helloHerin.jobApplication.compny.CompanyRepository;
import com.helloHerin.jobApplication.compny.Compny;
import com.helloHerin.jobApplication.compny.CompnyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class complyServiceImpl implements CompnyService {

    private final CompanyRepository companyRepository;

    public complyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Compny> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Compny company, Long id) {
        Optional<Compny> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()) {
            Compny companyToUpdate = companyOptional.get();
            companyToUpdate.setName(company.getName());
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setJobs(company.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createCompany(Compny compny) {
        companyRepository.save(compny);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else  {
            return false;
        }
    }

    @Override
    public Compny getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
