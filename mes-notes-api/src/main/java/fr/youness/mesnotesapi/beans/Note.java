package fr.youness.mesnotesapi.beans;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_note;
    private String title_note;
    private String description_note;
    private boolean completed_note;
    private Date recall_date_note;
    @Column(nullable = false, updatable = false) @CreationTimestamp
    private Date updated_timestamp;

    public Note() { }

    public Note(String title_note, String description_note, boolean completed_note, Date recall_date_note) {
        this.title_note = title_note;
        this.description_note = description_note;
        this.completed_note = completed_note;
        this.recall_date_note = recall_date_note;
    }

    public Long getId_note() { return id_note; }

    public void setId_note(Long id_note) { this.id_note = id_note; }

    public String getTitle_note() { return title_note; }

    public void setTitle_note(String title_note) { this.title_note = title_note; }

    public String getDescription_note() { return description_note; }

    public void setDescription_note(String description_note) { this.description_note = description_note; }

    public boolean isCompleted_note() { return completed_note; }

    public void setCompleted_note(boolean completed_note) { this.completed_note = completed_note; }

    public Date getRecall_date_note() { return recall_date_note; }

    public void setRecall_date_note(Date recall_date_note) { this.recall_date_note = recall_date_note; }
}
