package com.example.anime.Service.individualInformationDataService;

import com.example.anime.Entity.individualInformationDataEntity.ExpandSkillsDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface ExpandSkillsDataService {
    List<ExpandSkillsDataEntity> getExpandSkillsData(String userName, String location);

    Integer modifyExpandSkillsData(ExpandSkillsDataEntity expandSkillsDataEntity);

    Integer deleteExpandSkillsData(String userName, String location);

    Integer deleteAllExpandSkillsData(String userName);

    Integer addExpandSkillsData(ExpandSkillsDataEntity expandSkillsDataEntity);
}
