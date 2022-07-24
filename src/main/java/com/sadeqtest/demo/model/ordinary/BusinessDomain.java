package com.sadeqtest.demo.model.ordinary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
