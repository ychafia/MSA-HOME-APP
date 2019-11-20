package fr.youness.mesepargnesapi.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity(name="Type_epargne")
public class TypeEpargne implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_type;
    private String value_type;

    @JsonIgnore
    @OneToMany(mappedBy="type_epargne")
    private Collection<Epargne> epargnes;

    public TypeEpargne() { }

    public TypeEpargne(String value_type) {
        this.value_type = value_type;
    }

    public Long getId_type() { return id_type; }

    public void setId_type(Long id_type) {
        this.id_type = id_type;
    }

    public String getValue_type() {
        return value_type;
    }

    public void setValue_type(String year) {
        this.value_type = year;
    }

    public Collection<Epargne> getEpargnes() {
        return epargnes;
    }

    public void setEpargnes(Collection<Epargne> epargnes) {
        this.epargnes = epargnes;
    }
}
