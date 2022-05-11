package com.example.anime.Service.individualInformationDataService.individualInformationDataServiceImpl;

import com.example.anime.Entity.individualInformationDataEntity.PersonalInformationDataEntity;
import com.example.anime.Service.individualInformationDataService.PersonalInformationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.individualInformationDataDao.PersonalInformationDataDao;

import java.util.List;

@Service
public class PersonalInformationDataServiceImpl implements PersonalInformationDataService {
    @Autowired
    private PersonalInformationDataDao personalInformationDataDao;

    @Override
    public List<PersonalInformationDataEntity> getPersonalInformationData(String userName, String location){
        return personalInformationDataDao.getPersonalInformationData(userName, location);
    }

    @Override
    public Integer modifyPersonalInformationData(PersonalInformationDataEntity personalInformationDataEntity){
        return personalInformationDataDao.modifyPersonalInformationData(personalInformationDataEntity);
    }

    @Override
    public Integer deletePersonalInformationData(String userName, String location){
        return personalInformationDataDao.deletePersonalInformationData(userName, location);
    }

    @Override
    public Integer deleteAllPersonalInformationData(String userName){
        return personalInformationDataDao.deleteAllPersonalInformationData(userName);
    }

    @Override
    public Integer addPersonalInformationData(PersonalInformationDataEntity personalInformationDataEntity){
        String userName = personalInformationDataEntity.getUserName();
        String firstItemName = personalInformationDataEntity.getFirstItemName();
        String firstItemData = personalInformationDataEntity.getFirstItemData();
        String secondItemName = personalInformationDataEntity.getSecondItemName();
        String secondItemData = personalInformationDataEntity.getSecondItemData();
        String thirtItemName = personalInformationDataEntity.getThirtItemName();
        String thirtItemData = personalInformationDataEntity.getThirtItemData();
        String fourthItemName = personalInformationDataEntity.getFourthItemName();
        String fourthItemData = personalInformationDataEntity.getFourthItemData();
        String fifthItemName = personalInformationDataEntity.getFifthItemName();
        String fifthItemData = personalInformationDataEntity.getFifthItemData();
        if(userName != null && firstItemName != null && firstItemData != null && secondItemName != null &&
                secondItemData != null && thirtItemName != null && thirtItemData != null && fourthItemName != null &&
                fourthItemData != null && fifthItemName != null && fifthItemData != null) {
            return personalInformationDataDao.addPersonalInformationData(personalInformationDataEntity);
        }else{
            return personalInformationDataDao.addPersonalInformationData(null);
        }
    }
}
