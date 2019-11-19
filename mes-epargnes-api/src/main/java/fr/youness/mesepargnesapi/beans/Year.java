package fr.youness.mesepargnesapi.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity(name="Year")
public class Year implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_year;
    private String value_year;
    private boolean isActive_year;

    @JsonIgnore @OneToMany(mappedBy = "year_epargne")
    private Collection<Epargne> epargnes;

    public Year() { }

    public Year(String value_year, boolean isActive_year) {
        this.value_year = value_year;
        this.isActive_year = isActive_year;
    }

    public Long getId_year() { return id_year; }

    public void setId_year(Long id_year) { this.id_year = id_year; }

    public String getValue_year() { return value_year; }

    public void setValue_year(String value_year) { this.value_year = value_year; }

    public boolean isActive_year() { return isActive_year; }

    public void setActive_year(boolean active_year) { isActive_year = active_year; }

    public Collection<Epargne> getEpargnes() { return epargnes; }

    public void setEpargnes(Collection<Epargne> epargnes) { this.epargnes = epargnes; }
}
