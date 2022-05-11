package com.example.anime.Service.individualInformationDataService;

import com.example.anime.Entity.individualInformationDataEntity.ProfessionalSkillDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface ProfessionalSkillDataService {
    List<ProfessionalSkillDataEntity> getProfessionalSkillData(String userName, String location);

    Integer modifyProfessionalSkillData(ProfessionalSkillDataEntity professionalSkillDataEntity);

    Integer deleteProfessionalSkillData(String userName, String location);

    Integer deleteAllProfessionalSkillData(String userName);

    Integer addProfessionalSkillData(ProfessionalSkillDataEntity professionalSkillDataEntity);
}
