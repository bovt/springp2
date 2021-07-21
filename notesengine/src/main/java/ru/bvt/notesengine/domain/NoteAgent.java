package ru.bvt.notesengine.domain;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "note_agent")
public class NoteAgent {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private long id; // login при аутентификации на notesengine


    @Column(name = "api_key", nullable = false, unique = false)
    private String apiKey; // пароль при аутентификации на notesengine

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(targetEntity = NoteBook.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "notebook")
    private NoteBook noteBook;

}
