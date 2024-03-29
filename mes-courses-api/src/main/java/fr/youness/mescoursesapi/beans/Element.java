package fr.youness.mescoursesapi.beans;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_element;
    private String libelle;
    private Boolean isDone;
    private int zone;
    @Column(nullable = false, updatable = false) @CreationTimestamp
    private Date updated_timestamp;

    public Element() {}

    public Element(String libelle, Boolean isDone, int zone) {
        this.libelle = libelle;
        this.isDone = isDone;
        this.zone = zone;
    }

    public Long getId_element() { return id_element; }

    public void setId_element(Long id_element) { this.id_element = id_element; }

    public String getLibelle() { return libelle; }

    public void setLibelle(String libelle) { this.libelle = libelle; }

    public Boolean getDone() { return isDone; }

    public void setDone(Boolean done) { isDone = done; }

    public int getZone() { return zone; }

    public void setZone(int zone) { this.zone = zone; }
}
