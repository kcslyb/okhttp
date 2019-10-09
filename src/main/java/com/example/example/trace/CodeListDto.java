package com.example.example.trace;

import java.util.List;

/**
 * @author kcs
 * @date 2019-10-09 15:03
 **/
public class CodeListDto {

    private List<CodePackageDto> list;

    private List<CodeStatisticsDto> statisticsList;

    public List<CodePackageDto> getList() {
        return list;
    }

    public void setList(List<CodePackageDto> list) {
        this.list = list;
    }

    public List<CodeStatisticsDto> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<CodeStatisticsDto> statisticsList) {
        this.statisticsList = statisticsList;
    }
}
