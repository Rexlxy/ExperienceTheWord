package com.Util;

import com.ETW.Entity.UserEntity;
import com.ETW.Model.User;

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



}
