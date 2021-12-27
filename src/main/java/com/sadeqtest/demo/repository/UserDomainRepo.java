package com.sadeqtest.demo.repository;

import com.sadeqtest.demo.securityDomain.LegalUserDomain;
import com.sadeqtest.demo.securityDomain.UserTestDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDomainRepo extends JpaRepository<UserTestDomain,Long> {
    @Query(value = "from LegalUserDomain")
    List<LegalUserDomain> getAllLegalUserDomains();
}
