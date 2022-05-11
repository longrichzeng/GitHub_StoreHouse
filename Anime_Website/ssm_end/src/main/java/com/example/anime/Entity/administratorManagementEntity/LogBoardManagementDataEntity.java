package com.example.anime.Entity.administratorManagementEntity;

public class LogBoardManagementDataEntity {
    private String logNumber;
    private String executor;
    private String executeEvent;
    private String accessInterface;
    private String remark;
    private String executionTime;

    public String getLogNumber() {
        return logNumber;
    }

    public void setLogNumber(String logNumber) {
        this.logNumber = logNumber;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getExecuteEvent() {
        return executeEvent;
    }

    public void setExecuteEvent(String executeEvent) {
        this.executeEvent = executeEvent;
    }

    public String getAccessInterface() {
        return accessInterface;
    }

    public void setAccessInterface(String accessInterface) {
        this.accessInterface = accessInterface;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }
}
