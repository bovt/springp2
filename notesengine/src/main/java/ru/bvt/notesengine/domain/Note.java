package ru.bvt.notesengine.domain;

import ru.bvt.notesengine.rest.dto.NoteFullDto;

import javax.persistence.*;
import javax.validation.constraints.Null;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne(targetEntity = NoteBook.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "notebook")
    private NoteBook noteBook;

    @Column(name = "text", nullable = false, unique = true)
    private String text;

    public Note(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", name='" + text + '\'' +
                '}';
    }

}
