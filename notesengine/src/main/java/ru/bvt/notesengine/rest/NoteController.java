package ru.bvt.notesengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bvt.notesengine.domain.*;
import ru.bvt.notesengine.rest.dto.NoteFullDto;
import ru.bvt.notesengine.repository.NoteRepository;
import ru.bvt.notesengine.service.NoteServiceSimple;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NoteController {

    private final NoteServiceSimple service;

    @Autowired
    public NoteController(NoteServiceSimple service) {
        this.service = service;
    }


    @PostMapping("/notes")
    public void createOrSaveNote(@RequestBody NoteFullDto newNoteDTO) {
        service.createOrSaveNote(newNoteDTO);
    }

    @GetMapping("/notes")
    public List<NoteFullDto> getAllNotes() {
        return service.getAllNotes();
    }
}
