package com.sadeqtest.demo.model.joinColumnExample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusinessDomain {
    @Id
    private String namespace;

    private String algorithmFamily;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getAlgorithmFamily() {
        return algorithmFamily;
    }

    public void setAlgorithmFamily(String algorithmFamily) {
        this.algorithmFamily = algorithmFamily;
    }
}
