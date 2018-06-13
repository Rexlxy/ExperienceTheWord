package com.Util;

import com.ETW.Entity.NoteEntity;
import com.ETW.Entity.UserEntity;
import com.ETW.Model.Note;
import com.ETW.Model.User;
import com.ETW.Service.NoteService;
import com.ETW.Service.UserService;

public class ConvertUtil {

    public static void modelToEntity(User model, UserEntity entity) {

        if (model.getId() != 0) {
            entity.setId(model.getId());
        }
        if (model.getPassword() != null) {
            entity.setPassword(model.getPassword());
        }

        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        entity.setUsername(model.getUsername());
        entity.setImage(model.getImage());

    }

    public static void entityToModel(UserEntity entity, User model) {
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setImage(entity.getImage());

        // set dates
        if (entity.getDateCreated() != null) {
            long dateCreated = entity.getDateCreated().getTime();
            model.setDateCreated(DateUtil.millisToString(dateCreated));
        } else {
            model.setDateCreated("");
        }

        if (entity.getDateModified() != null) {
            long dateModified = entity.getDateModified().getTime();
            model.setDateModified(DateUtil.millisToString(dateModified));
        } else {
            model.setDateModified("");
        }
    }

    public static void entityToModel(NoteEntity entity, Note model) {
        model.setId(entity.getId());
        model.setContent(entity.getContent());
        model.setOwnerId(entity.getOwner().getId());
        model.setStartIndex(entity.getStartIndex());
        model.setTitle(entity.getTitle());
        model.setSelectedString(entity.getSelectedString());

        // set dates
        if (entity.getDateCreated() != null) {
            long dateCreated = entity.getDateCreated().getTime();
            model.setDateCreated(DateUtil.millisToString(dateCreated));
        } else {
            model.setDateCreated("");
        }

        if (entity.getDateModified() != null) {
            long dateModified = entity.getDateModified().getTime();
            model.setDateModified(DateUtil.millisToString(dateModified));
        } else {
            model.setDateModified("");
        }
    }

    public static void modelToEntity(Note model, NoteEntity entity) {
        entity.setId(model.getId());
        entity.setContent(model.getContent());
        entity.setSelectedString(model.getSelectedString());
        entity.setStartIndex(model.getStartIndex());
        entity.setTitle(model.getTitle());
        entity.setOwner(UserService.staticUserRepo.findById(model.getOwnerId()).get());
    }

}
