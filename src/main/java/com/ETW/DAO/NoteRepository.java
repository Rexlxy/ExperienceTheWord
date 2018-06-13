package com.ETW.DAO;

import com.ETW.Entity.NoteEntity;
import com.ETW.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    List<NoteEntity> getNoteByOwner(UserEntity owner);
}
