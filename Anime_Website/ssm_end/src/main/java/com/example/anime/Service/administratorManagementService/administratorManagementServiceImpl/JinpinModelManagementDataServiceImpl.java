package com.example.anime.Service.administratorManagementService.administratorManagementServiceImpl;

import com.example.anime.Entity.administratorManagementEntity.JinpinModelManagementDataEntity;
import com.example.anime.Service.administratorManagementService.JinpinModelManagementDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.administratorManagementDao.JinpinModelManagementDataDao;

import java.util.List;

@Service
public class JinpinModelManagementDataServiceImpl implements JinpinModelManagementDataService {
    @Autowired
    private JinpinModelManagementDataDao jinpinModelManagementDataDao;

    @Override
    public List<JinpinModelManagementDataEntity> getJinpinModelData(){
        return jinpinModelManagementDataDao.getJinpinModelData();
    }

    @Override
    public List<JinpinModelManagementDataEntity> getJinpinDataByIndex(String jinPinRecommendIndex){
        return jinpinModelManagementDataDao.getJinpinDataByIndex(jinPinRecommendIndex);
    }

    @Override
    public List<JinpinModelManagementDataEntity> getJinpinDataByName(String jinPinName){
        return jinpinModelManagementDataDao.getJinpinDataByName(jinPinName);
    }

    @Override
    public Integer modifyJinpinModelData(JinpinModelManagementDataEntity jinpinModelManagementDataEntity){
        return jinpinModelManagementDataDao.modifyJinpinModelData(jinpinModelManagementDataEntity);
    }

    @Override
    public Integer deleteJinpinModelData(String jinPinNumber){
        return jinpinModelManagementDataDao.deleteJinpinModelData(jinPinNumber);
    }

    @Override
    public Integer addJinpinModelData(JinpinModelManagementDataEntity jinpinModelManagementDataEntity){
        String jinPinNumber = jinpinModelManagementDataEntity.getJinPinNumber();
        String jinPinName = jinpinModelManagementDataEntity.getJinPinName();
        String jinPinType = jinpinModelManagementDataEntity.getJinPinType();
        String jinPinManufacturer = jinpinModelManagementDataEntity.getJinPinManufacturer();
        String jinPinPrice = jinpinModelManagementDataEntity.getJinPinPrice();
        String jinPinRecommendIndex = jinpinModelManagementDataEntity.getJinPinRecommendIndex();
        if(jinPinNumber != null && jinPinName != null && jinPinType != null && jinPinManufacturer != null &&
                jinPinPrice != null && jinPinRecommendIndex != null){
            return jinpinModelManagementDataDao.addJinpinModelData(jinpinModelManagementDataEntity);
        }else{
            return jinpinModelManagementDataDao.addJinpinModelData(null);
        }
    }
}
