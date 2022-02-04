package com.sadeqtest.demo.model3;

import com.sadeqtest.demo.util.UtilityFunctions;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.Bag;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Link implements Serializable,Cloneable,Comparable<Link> {
    @Id
    @GeneratedValue(generator = "hibernate-gen")
    @GenericGenerator(name = "hibernate-gen",strategy = "uuid2")
    private String linkUUID;
    private String description;
    @ManyToMany
            @JoinTable(name = "USER_LINK",
            joinColumns = @JoinColumn(name = "LINK_UUID"),
            inverseJoinColumns = @JoinColumn(name ="USERNAME"))
    private Set<ApplicationUser> applicationUsers=new LinkedHashSet<>();
    private LocalDateTime creationTime=LocalDateTime.now();
    @OneToOne
    @JoinColumn(name = "LINK_OWNER")
    private ApplicationUser linkOwner;

    public String getLinkUUID() {
        return linkUUID;
    }

    public void setLinkUUID(String linkUUID) {
        this.linkUUID = linkUUID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ApplicationUser> getApplicationUsers() {
        return applicationUsers;
    }

    public void addApplicationUser(ApplicationUser applicationUser){
        this.applicationUsers.add(applicationUser);
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public ApplicationUser getLinkOwner() {
        return linkOwner;
    }

    public void setLinkOwner(ApplicationUser linkOwner) {
        this.linkOwner = linkOwner;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(linkUUID);
        hashCodeBuilder.append(creationTime);
        return hashCodeBuilder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==this)
            return true;
        if(!(obj instanceof Link))
            return false;
        Link rhs= (Link) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(linkUUID,rhs.linkUUID);
        equalsBuilder.append(creationTime,rhs.creationTime);
        return equalsBuilder.isEquals();
    }

    @Override
    public String toString() {
        return UtilityFunctions.toJSON(this);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Link link) {
        return link.creationTime.compareTo(this.creationTime);
    }
}
