package com.sadeqtest.demo.model3;

import com.sadeqtest.demo.util.UtilityFunctions;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.SortNatural;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
public class ApplicationUser implements Serializable,Cloneable {
    @Id
    private String username;
    private String password;
    @ManyToMany(mappedBy = "applicationUsers",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @SortNatural
    private SortedSet<Link> linkSet=new TreeSet<>();

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

    public SortedSet<Link> getLinkSet() {
        return linkSet;
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
