package ru.bvt.tgnotesagent.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.bvt.tgnotesagent.model.NoteVO;


@FeignClient(name = "note-client", url = "localhost:8080")
//@FeignClient("note-client") Пока не заработало, буду отлаживать
//TODO: Наладить подтягивание из конфига

public interface NoteFeignClientBotEdition {

    @PostMapping("/notes")
    void createOrSaveNote(NoteVO note);


}