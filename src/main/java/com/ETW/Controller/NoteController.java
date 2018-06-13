package com.ETW.Controller;

import com.ETW.Bean.ResultBean;
import com.ETW.DAO.NoteRepository;
import com.ETW.Model.Note;
import com.ETW.Service.NoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Resource
    private NoteService noteService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean<Note> createNote(Note newNote) {
        System.out.println(newNote);
        Note note = noteService.createNote(newNote);
        return new ResultBean<>(note);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultBean<List<Note>> getNoteByOwner(@RequestParam(name = "userId", required = true) long userId) {
        return new ResultBean<>(noteService.getNotesByOwner(userId));
    }

}
