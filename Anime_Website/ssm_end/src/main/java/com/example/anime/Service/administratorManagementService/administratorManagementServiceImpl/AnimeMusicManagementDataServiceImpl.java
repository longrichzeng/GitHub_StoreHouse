package com.example.anime.Service.administratorManagementService.administratorManagementServiceImpl;

import com.example.anime.Entity.administratorManagementEntity.AnimeMusicManagementDataEntity;
import com.example.anime.Service.administratorManagementService.AnimeMusicManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.administratorManagementDao.AnimeMusicManagementDataDao;

import java.util.List;

@Service
public class AnimeMusicManagementDataServiceImpl implements AnimeMusicManagementDataService {
    @Autowired
    private AnimeMusicManagementDataDao animeMusicManagementDataDao;

    @Override
    public List<AnimeMusicManagementDataEntity> getAnimeMusicData(){
        return animeMusicManagementDataDao.getAnimeMusicData();
    }

    @Override
    public List<AnimeMusicManagementDataEntity> getMusicDataByIndex(String musicRecommendIndex){
        return animeMusicManagementDataDao.getMusicDataByIndex(musicRecommendIndex);
    }

    @Override
    public List<AnimeMusicManagementDataEntity> getMusicDataByName(String musicName){
        return animeMusicManagementDataDao.getMusicDataByName(musicName);
    }

    @Override
    public Integer modifyAnimeMusicData(AnimeMusicManagementDataEntity animeMusicManagementDataEntity){
        return animeMusicManagementDataDao.modifyAnimeMusicData(animeMusicManagementDataEntity);
    }

    @Override
    public Integer deleteAnimeMusicData(String musicNumber){
        return animeMusicManagementDataDao.deleteAnimeMusicData(musicNumber);
    }

    @Override
    public Integer addAnimeMusicData(AnimeMusicManagementDataEntity animeMusicManagementDataEntity){
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        String musicNumber = generateNumberUtil.generateAnimeMusicNumber();
        animeMusicManagementDataEntity.setMusicNumber(musicNumber);
        String musicName = animeMusicManagementDataEntity.getMusicName();
        String musicType = animeMusicManagementDataEntity.getMusicType();
        String musicSinger = animeMusicManagementDataEntity.getMusicSinger();
        String musicRecommendIndex = animeMusicManagementDataEntity.getMusicRecommendIndex();
        if(musicName != null && musicType != null && musicSinger != null && musicRecommendIndex != null){
            return animeMusicManagementDataDao.addAnimeMusicData(animeMusicManagementDataEntity);
        }else{
            return animeMusicManagementDataDao.addAnimeMusicData(null);
        }

    }
}
