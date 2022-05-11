package com.example.anime.Service.individualInformationDataService.individualInformationDataServiceImpl;

import com.example.anime.Entity.individualInformationDataEntity.ProfessionalSkillDataEntity;
import com.example.anime.Service.individualInformationDataService.ProfessionalSkillDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.individualInformationDataDao.ProfessionalSkillDataDao;

import java.util.List;

@Service
public class ProfessionalSkillDataServiceImpl implements ProfessionalSkillDataService {
    @Autowired
    private ProfessionalSkillDataDao professionalSkillDataDao;

    @Override
    public List<ProfessionalSkillDataEntity> getProfessionalSkillData(String userName, String location){
        return professionalSkillDataDao.getProfessionalSkillData(userName, location);
    }

    @Override
    public Integer modifyProfessionalSkillData(ProfessionalSkillDataEntity professionalSkillDataEntity){
        return professionalSkillDataDao.modifyProfessionalSkillData(professionalSkillDataEntity);
    }

    @Override
    public Integer deleteProfessionalSkillData(String userName, String location){
        return professionalSkillDataDao.deleteProfessionalSkillData(userName, location);
    }

    @Override
    public Integer deleteAllProfessionalSkillData(String userName){
        return professionalSkillDataDao.deleteAllProfessionalSkillData(userName);
    }

    @Override
    public Integer addProfessionalSkillData(ProfessionalSkillDataEntity professionalSkillDataEntity){
        String userName = professionalSkillDataEntity.getUserName();
        String firstItemName = professionalSkillDataEntity.getFirstItemName();
        String firstItemData = professionalSkillDataEntity.getFirstItemData();
        String secondItemName = professionalSkillDataEntity.getSecondItemName();
        String secondItemData = professionalSkillDataEntity.getSecondItemData();
        String thirtItemName = professionalSkillDataEntity.getThirtItemName();
        String thirtItemData = professionalSkillDataEntity.getThirtItemData();
        String fourthItemName = professionalSkillDataEntity.getFourthItemName();
        String fourthItemData = professionalSkillDataEntity.getFourthItemData();
        String fifthItemName = professionalSkillDataEntity.getFifthItemName();
        String fifthItemData = professionalSkillDataEntity.getFifthItemData();
        String sixthItemName = professionalSkillDataEntity.getSixthItemName();
        String sixthItemData = professionalSkillDataEntity.getSecondItemData();
        if(userName != null && firstItemName != null && firstItemData != null && secondItemName != null &&
                secondItemData != null && thirtItemName != null && thirtItemData != null && fourthItemName != null &&
                fourthItemData != null && fifthItemName != null && fifthItemData != null && sixthItemName != null && sixthItemData != null) {
            return professionalSkillDataDao.addProfessionalSkillData(professionalSkillDataEntity);
        }else{
            return professionalSkillDataDao.addProfessionalSkillData(null);
        }
    }
}
