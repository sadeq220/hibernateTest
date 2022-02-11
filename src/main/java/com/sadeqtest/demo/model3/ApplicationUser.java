package com.sadeqtest.demo.model3;

import com.sadeqtest.demo.util.UtilityFunctions;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class ApplicationUser implements Serializable,Cloneable {
    @Id
    private String username;
    private String password;
    @ManyToMany(mappedBy = "applicationUsers",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @SortNatural
    private SortedSet<Link> linkSet=new TreeSet<>();
    @Transient
    private SortedSet<Link> linkSetCounterpart;
    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(!(obj instanceof ApplicationUser))
            return false;
        ApplicationUser rhs= (ApplicationUser) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(this.username,rhs.username);
        return equalsBuilder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder=new HashCodeBuilder();
        hashCodeBuilder.append(this.username);
        return hashCodeBuilder.toHashCode();
    }

    /**
     * entity life cycle events,and corresponding callback methods
     * JPA @PostLoad : Executed after an entity has been loaded into the current persistence context
     *                 or an entity has been refreshed.
     */
    @PostLoad
    private void populateCounterpartSet(){
        this.linkSetCounterpart =Collections.unmodifiableSortedSet(linkSet);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SortedSet<Link> getUnmodifiableLinkSet() {
        return linkSetCounterpart;
    }

    public void addLink(Link link){
        this.linkSet.add(link);
        link.addApplicationUser(this);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return UtilityFunctions.toJSON(this);
    }
}
