package com.ETW.Service;

import com.ETW.DAO.NoteRepository;
import com.ETW.DAO.UserRepository;
import com.ETW.Entity.NoteEntity;
import com.ETW.Entity.UserEntity;
import com.ETW.Model.Note;
import com.Util.ConvertUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Component
public class NoteService {

    @Resource
    private NoteRepository noteRepository;
    @Resource
    private UserRepository userRepository;

    public Note saveNote(Note noteModel) {
        NoteEntity noteEntity = new NoteEntity();
        ConvertUtil.modelToEntity(noteModel, noteEntity);
        NoteEntity newNote = noteRepository.save(noteEntity);
        ConvertUtil.entityToModel(newNote, noteModel);
        return noteModel;
    }

    public List<Note> getNotesByOwner(long userId) {
        List<NoteEntity> entityList = noteRepository.getNoteByOwner(userRepository.findById(userId).get());
        List<Note> modelList = new LinkedList<>();
        for (NoteEntity entity : entityList) {
            System.out.println(entity);
            Note model = new Note();
            ConvertUtil.entityToModel(entity, model);
            modelList.add(model);
        }
        return modelList;
    }

    public  boolean deleteNoteById(long noteId) {
        try {
            noteRepository.deleteById(noteId);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean ifNoteExists(long noteId) {
        if (noteRepository.findById(noteId).isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
