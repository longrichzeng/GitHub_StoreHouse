package com.example.anime.Service.administratorManagementService.administratorManagementServiceImpl;

import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Service.administratorManagementService.AnimeDrameManagementDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.administratorManagementDao.AnimeDrameManagementDataDao;

import java.io.File;
import java.util.List;

@Service
public class AnimeDrameManagementDataServiceImpl implements AnimeDrameManagementDataService {
    @Autowired
    private AnimeDrameManagementDataDao animeDrameManagementDataDao;

    @Override
    public List<AnimeDrameManagementDataEntity> getAnimeDrameData(){
        return animeDrameManagementDataDao.getAnimeDrameData();
    }

    @Override
    public List<AnimeDrameManagementDataEntity> getAnimeAboutType(String animeType){
        return animeDrameManagementDataDao.getAnimeAboutType(animeType);
    }

    @Override
    public List<AnimeDrameManagementDataEntity> getAnimeAboutIndex(String animeRecommendIndex){
        return animeDrameManagementDataDao.getAnimeAboutIndex(animeRecommendIndex);
    }

    @Override
    public List<AnimeDrameManagementDataEntity> getAnimeAboutName(String animeName){
        return animeDrameManagementDataDao.getAnimeAboutName(animeName);
    }

    @Override
    public Integer modifyAnimeDrameData(AnimeDrameManagementDataEntity animeDrameManagementDataEntity){
        return animeDrameManagementDataDao.modifyAnimeDrameData(animeDrameManagementDataEntity);
    }

    @Override
    public Integer deleteAnimeDrameData(String animeNumber){
        String imagePath = "F:\\Anime_Website\\vue_front\\src\\assets\\animeImage\\" + animeNumber + ".png";
        File file = new File(imagePath);
        //判断文件存不存在
        if(!file.exists()){
            System.out.println("删除文件失败："+ imagePath +"不存在！");
        }else{
            file.delete();
        }
        return animeDrameManagementDataDao.deleteAnimeDrameData(animeNumber);
    }

    @Override
    public Integer addAnimeDrameData(AnimeDrameManagementDataEntity animeDrameManagementDataEntity){
        String animeNumber = animeDrameManagementDataEntity.getAnimeNumber();
        String animeName = animeDrameManagementDataEntity.getAnimeName();
        String animeType = animeDrameManagementDataEntity.getAnimeType();
        String animeAuthor = animeDrameManagementDataEntity.getAnimeAuthor();
        String animePublishTime = animeDrameManagementDataEntity.getAnimePublishTime();
        String animeRecommendIndex = animeDrameManagementDataEntity.getAnimeRecommendIndex();
        if(animeNumber != null && animeName != null && animeType != null && animeAuthor != null &&
                animePublishTime != null && animeRecommendIndex != null){
            return animeDrameManagementDataDao.addAnimeDrameData(animeDrameManagementDataEntity);
        }else{
            return animeDrameManagementDataDao.addAnimeDrameData(null);
        }
    }
}
