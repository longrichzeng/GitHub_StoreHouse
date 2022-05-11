package com.example.anime.Controller.administratorManagementController;

import com.example.anime.Dao.administratorManagementDao.NotesManagementDataDao;
import com.example.anime.Entity.administratorManagementEntity.NotesManagementDataEntity;
import com.example.anime.Service.administratorManagementService.NotesManagementDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("administrator")
public class NotesManagementDataController {
    @Autowired
    private NotesManagementDataService notesManagementDataService;

    @RequestMapping("getNotesInforData")
    @ResponseBody
    public List<NotesManagementDataEntity> getNotesInforData(){
        return notesManagementDataService.getNotesInforData();
    }

    @RequestMapping("getNotesInforDataByTitle")
    @ResponseBody
    public List<NotesManagementDataEntity> getNotesInforDataByTitle(String notesTitle){
        return notesManagementDataService.getNotesInforDataByTitle(notesTitle);
    }

    @RequestMapping("modifyNotesInforData")
    @ResponseBody
    public Integer modifyNotesInforData(NotesManagementDataEntity notesManagementDataEntity){
        return notesManagementDataService.modifyNotesInforData(notesManagementDataEntity);
    }

    @RequestMapping("getNotesInforDataByTime")
    @ResponseBody
    public List<NotesManagementDataEntity> getNotesInforDataByTime(String formationTime){
        System.out.println(formationTime);
        return notesManagementDataService.getNotesInforDataByTime(formationTime);
    }

    @RequestMapping("addNotesInforData")
    @ResponseBody
    public Integer addNotesInforData(NotesManagementDataEntity notesManagementDataEntity){
        return notesManagementDataService.addNotesInforData(notesManagementDataEntity);
    }

    @RequestMapping("deleteNotesInforData")
    @ResponseBody
    public Integer deleteNotesInforData(String notesId){
        return notesManagementDataService.deleteNotesInforData(notesId);
    }
}
