package com.example.anime.Service.individualInformationDataService;

import com.example.anime.Entity.individualInformationDataEntity.AnnualPlanDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface AnnualPlanDataService {
    List<AnnualPlanDataEntity> getAnnualPlanData(String userName);

    Integer modifyAnnualPlanData(AnnualPlanDataEntity annualPlanDataEntity);

    Integer deleteAnnualPlanData(String userName, String location);

    Integer deleteAllAnnualPlanData(String userName);

    Integer addAnnualPlanData(AnnualPlanDataEntity annualPlanDataEntity);
}
