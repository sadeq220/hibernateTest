package com.sadeqtest.demo.model.joinColumnExample;

import javax.persistence.*;

@Entity
public class BusinessModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "namespace",updatable = false,insertable = false)
    private String namespace;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "namespace")
    /**
     * joinColumn just Specifies a column for joining an entity association or element collection.
     * if you want your joining column( typically foreign key) event on lazy loading just add column to your entity with
     *  updatable = false
     *  insertable = false
     *  just to assure a JPA about referential integrity
     */
    private BusinessDomain businessDomain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public BusinessDomain getBusinessDomain() {
        return businessDomain;
    }

    public void setBusinessDomain(BusinessDomain businessDomain) {
        this.businessDomain = businessDomain;
    }
}
