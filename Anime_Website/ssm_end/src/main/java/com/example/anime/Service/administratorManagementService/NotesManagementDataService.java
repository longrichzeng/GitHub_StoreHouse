package com.example.anime.Service.administratorManagementService;

import com.example.anime.Entity.administratorManagementEntity.NotesManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface NotesManagementDataService {
    List<NotesManagementDataEntity> getNotesInforData();

    List<NotesManagementDataEntity> getNotesInforDataByTitle(String notesTitle);

    Integer modifyNotesInforData(NotesManagementDataEntity notesManagementDataEntity);

    List<NotesManagementDataEntity> getNotesInforDataByTime(String formationTime);

    Integer addNotesInforData(NotesManagementDataEntity notesManagementDataEntity);

    Integer deleteNotesInforData(String notesId);
}
