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

    public Note createNote(Note noteModel) {
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
}
