package com.helloHerin.jobApplication.compny;

import java.util.List;

public interface CompnyService {
    List<Compny> getAllCompany();
    boolean updateCompany(Compny company, Long id);
    void createCompany(Compny company);
    boolean deleteCompanyById(Long id);
    Compny getCompanyById(Long id);
}
