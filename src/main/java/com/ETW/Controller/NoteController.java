package com.ETW.Controller;

import com.ETW.Bean.ResultBean;
import com.ETW.DAO.NoteRepository;
import com.ETW.Model.Note;
import com.ETW.Service.NoteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Resource
    private NoteService noteService;

    // create a new note
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultBean<Note> createNote(Note newNote) {
        Note note = noteService.saveNote(newNote);
        return new ResultBean<>(note);
    }

    // find all notes of a user
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultBean<List<Note>> getNoteByOwner(@RequestParam(name = "userId", required = true) long userId) {
        return new ResultBean<>(noteService.getNotesByOwner(userId));
    }

    // delete a note
    @RequestMapping(value = "/{noteId}", method = RequestMethod.DELETE)
    public ResultBean<Boolean> deleteNote(@PathVariable(value = "noteId") long noteId) {
        if (! noteService.ifNoteExists(noteId)) {
          return new ResultBean(1, "Failed: the note doesn't exist");
        }
        return new ResultBean<>(noteService.deleteNoteById(noteId));
    }

    // update a note
    @RequestMapping(value = "/{noteId}", method = RequestMethod.POST)
    public ResultBean<Note> updateNote(@PathVariable(value = "noteId") long id,  Note updatedNote) {
        updatedNote.setId(id);
        Note note = noteService.saveNote(updatedNote);
        return new ResultBean<>(note);
    }
}
