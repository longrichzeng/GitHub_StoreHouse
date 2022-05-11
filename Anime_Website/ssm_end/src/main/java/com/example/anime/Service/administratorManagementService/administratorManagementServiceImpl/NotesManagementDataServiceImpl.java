package com.example.anime.Service.administratorManagementService.administratorManagementServiceImpl;

import com.example.anime.Dao.administratorManagementDao.NotesManagementDataDao;
import com.example.anime.Entity.administratorManagementEntity.NotesManagementDataEntity;
import com.example.anime.Service.administratorManagementService.NotesManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesManagementDataServiceImpl implements NotesManagementDataService {
    @Autowired
    private NotesManagementDataDao notesManagementDataDao;

    @Override
    public List<NotesManagementDataEntity> getNotesInforData(){
        return notesManagementDataDao.getNotesInforData();
    }

    @Override
    public List<NotesManagementDataEntity> getNotesInforDataByTitle(String notesTitle){
        return notesManagementDataDao.getNotesInforDataByTitle(notesTitle);
    }

    @Override
    public Integer modifyNotesInforData(NotesManagementDataEntity notesManagementDataEntity){
        return notesManagementDataDao.modifyNotesInforData(notesManagementDataEntity);
    }

    @Override
    public List<NotesManagementDataEntity> getNotesInforDataByTime(String formationTime){
        return notesManagementDataDao.getNotesInforDataByTime(formationTime);
    }

    @Override
    public Integer addNotesInforData(NotesManagementDataEntity notesManagementDataEntity){
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        notesManagementDataEntity.setNotesId(generateNumberUtil.generateNotesNumber());
        return notesManagementDataDao.addNotesInforData(notesManagementDataEntity);
    }

    @Override
    public Integer deleteNotesInforData(String notesId){
        return notesManagementDataDao.deleteNotesInforData(notesId);
    }
}
