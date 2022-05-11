package com.example.anime.Service.individualInformationDataService;

import com.example.anime.Entity.individualInformationDataEntity.PersonalInformationDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface PersonalInformationDataService {
    List<PersonalInformationDataEntity> getPersonalInformationData(String userName, String location);

    Integer modifyPersonalInformationData(PersonalInformationDataEntity personalInformationDataEntity);

    Integer deletePersonalInformationData(String userName, String location);

    Integer deleteAllPersonalInformationData(String userName);

    Integer addPersonalInformationData(PersonalInformationDataEntity personalInformationDataEntity);
}
