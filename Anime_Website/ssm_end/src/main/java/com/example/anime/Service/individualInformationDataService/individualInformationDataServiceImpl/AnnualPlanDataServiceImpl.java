package com.example.anime.Service.individualInformationDataService.individualInformationDataServiceImpl;

import com.example.anime.Entity.individualInformationDataEntity.AnnualPlanDataEntity;
import com.example.anime.Service.individualInformationDataService.AnnualPlanDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.individualInformationDataDao.AnnualPlanDataDao;

import java.util.List;

@Service
public class AnnualPlanDataServiceImpl implements AnnualPlanDataService {
    @Autowired
    private AnnualPlanDataDao annualPlanDataDao;

    @Override
    public List<AnnualPlanDataEntity> getAnnualPlanData(String userName){
        return annualPlanDataDao.getAnnualPlanData(userName);
    }

    @Override
    public Integer modifyAnnualPlanData(AnnualPlanDataEntity annualPlanDataEntity){
        return annualPlanDataDao.modifyAnnualPlanData(annualPlanDataEntity);
    }

    @Override
    public Integer deleteAnnualPlanData(String userName, String location){
        return annualPlanDataDao.deleteAnnualPlanData(userName, location);
    }
    @Override
    public Integer deleteAllAnnualPlanData(String userName){
        return annualPlanDataDao.deleteAllAnnualPlanData(userName);
    }

    @Override
    public Integer addAnnualPlanData(AnnualPlanDataEntity annualPlanDataEntity){
        String userName = annualPlanDataEntity.getUserName();
        String location = annualPlanDataEntity.getLocation();
        String planContent = annualPlanDataEntity.getPlanContent();
        String planNotes = annualPlanDataEntity.getPlanNotes();
        String planGenerateDate = annualPlanDataEntity.getPlanGenerateDate();
        if(userName != null && location != null && planContent != null && planNotes != null &&
                planGenerateDate != null) {
            return annualPlanDataDao.addAnnualPlanData(annualPlanDataEntity);
        }else{
            return annualPlanDataDao.addAnnualPlanData(null);
        }
    }
}
