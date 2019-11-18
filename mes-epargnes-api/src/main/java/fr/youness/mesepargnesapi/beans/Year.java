package fr.youness.mesepargnesapi.beans;

import javax.persistence.*;
import java.util.Collection;

@Entity(name="year")
public class Year {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_year;
    private String value_year;
    private boolean isActive_year;
    //@ManyToMany
    //private Collection<TypeEpargne> type_epargne;

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

    //public Collection<TypeEpargne> getType_epargne() { return type_epargne; }

    //public void setType_epargne(Collection<TypeEpargne> type_epargne) { this.type_epargne = type_epargne; }
}
