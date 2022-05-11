package com.example.anime.Dao.administratorManagementDao;

import com.example.anime.Entity.administratorManagementEntity.LogBoardManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface LogBoardManagementDataDao {
    /**
     * 获取LogBoard对应数据表的所有数据
     * @return
     */
    List<LogBoardManagementDataEntity> getLogBoardData();

    /**
     * 根据执行时间获取LogBoard对应数据表的所有数据
     * @return
     */
    List<LogBoardManagementDataEntity> getLogBoardByTime(@Param("executor")String executor);

    /**
     * 据用户名称获取LogBoard对应数据表的所有数据
     * @return
     */
    List<LogBoardManagementDataEntity> getLogBoardByUsername(@Param("executionTime")String executionTime);

    /**
     * 存储日志的信息
     * @param
     * @return
     */
    Integer addLogBoard(LogBoardManagementDataEntity logBoardManagementDataEntity);

    /**
     * 删除日志的信息
     * @param
     * @return
     */
    Integer deleteLogBoardData(@Param("logNumber")String logNumber);
}
