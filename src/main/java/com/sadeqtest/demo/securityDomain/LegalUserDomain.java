package com.sadeqtest.demo.securityDomain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LegalUserDomain extends UserTestDomain {
    private String nationalCode;
    private String realName;
    private String realLastName;

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealLastName() {
        return realLastName;
    }

    public void setRealLastName(String realLastName) {
        this.realLastName = realLastName;
    }
}
