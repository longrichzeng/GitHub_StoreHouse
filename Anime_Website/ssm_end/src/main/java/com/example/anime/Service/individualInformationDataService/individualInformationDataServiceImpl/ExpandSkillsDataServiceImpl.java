package com.example.anime.Service.individualInformationDataService.individualInformationDataServiceImpl;

import com.example.anime.Entity.individualInformationDataEntity.ExpandSkillsDataEntity;
import com.example.anime.Service.individualInformationDataService.ExpandSkillsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.individualInformationDataDao.ExpandSkillsDataDao;

import java.util.List;

@Service
public class ExpandSkillsDataServiceImpl implements ExpandSkillsDataService {
    @Autowired
    private ExpandSkillsDataDao expandSkillsDataDao;

    @Override
    public List<ExpandSkillsDataEntity> getExpandSkillsData(String userName, String location){
        return expandSkillsDataDao.getExpandSkillsData(userName, location);
    }


    @Override
    public Integer modifyExpandSkillsData(ExpandSkillsDataEntity expandSkillsDataEntity){
        return expandSkillsDataDao.modifyExpandSkillsData(expandSkillsDataEntity);
    }

    @Override
    public Integer deleteExpandSkillsData(String userName, String location){
        return expandSkillsDataDao.deleteExpandSkillsData(userName, location);
    }

    @Override
    public Integer deleteAllExpandSkillsData(String userName){
        return expandSkillsDataDao.deleteAllExpandSkillsData(userName);
    }

    @Override
    public Integer addExpandSkillsData(ExpandSkillsDataEntity expandSkillsDataEntity){
        String userName = expandSkillsDataEntity.getUserName();
        String firstItemName = expandSkillsDataEntity.getFirstItemName();
        String firstItemData = expandSkillsDataEntity.getFirstItemData();
        String secondItemName = expandSkillsDataEntity.getSecondItemName();
        String secondItemData = expandSkillsDataEntity.getSecondItemData();
        String thirtItemName = expandSkillsDataEntity.getThirtItemName();
        String thirtItemData = expandSkillsDataEntity.getThirtItemData();
        String fourthItemName = expandSkillsDataEntity.getFourthItemName();
        String fourthItemData = expandSkillsDataEntity.getFourthItemData();
        String fifthItemName = expandSkillsDataEntity.getFifthItemName();
        String fifthItemData = expandSkillsDataEntity.getFifthItemData();
        if(userName != null && firstItemName != null && firstItemData != null && secondItemName != null &&
                secondItemData != null && thirtItemName != null && thirtItemData != null && fourthItemName != null &&
                fourthItemData != null && fifthItemName != null && fifthItemData != null) {
            return expandSkillsDataDao.addExpandSkillsData(expandSkillsDataEntity);
        }else{
            return expandSkillsDataDao.addExpandSkillsData(null);
        }
    }
}
