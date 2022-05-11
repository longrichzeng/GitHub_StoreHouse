package com.example.anime.Dao.administratorManagementDao;

import com.example.anime.Entity.administratorManagementEntity.NotesManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface NotesManagementDataDao {
    /**
     * 获取笔记的所有信息
     * @return
     */
    List<NotesManagementDataEntity> getNotesInforData();

    /**
     * 根据笔记标题获取笔记的所有信息
     * @return
     */
    List<NotesManagementDataEntity> getNotesInforDataByTitle(@Param("notesTitle")String notesTitle);

    /**
     * 修改笔记的所有信息
     * @param notesManagementDataEntity
     * @return
     */
    Integer modifyNotesInforData(NotesManagementDataEntity notesManagementDataEntity);

    /**
     * 通过时间获取笔记的所有信息
     * @param formationTime
     * @return
     */
    List<NotesManagementDataEntity> getNotesInforDataByTime(@Param("formationTime")String formationTime);

    /**
     * 添加笔记的所有信息
     * @param notesManagementDataEntity
     * @return
     */
    Integer addNotesInforData(NotesManagementDataEntity notesManagementDataEntity);

    /**
     * 删除笔记的所有信息
     * @param notesId
     * @return
     */
    Integer deleteNotesInforData(@Param("notesId")String notesId);
}
