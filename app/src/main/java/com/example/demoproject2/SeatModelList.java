package com.example.demoproject2;

import java.util.List;

public class SeatModelList {
    private List<SeatModel> allSeatModels;

    public SeatModelList(List<SeatModel> allSeatModels) {
        this.allSeatModels = allSeatModels;
    }
    public SeatModelList(){

    }
    public List<SeatModel> getAllSeatModels() {
        return allSeatModels;
    }

    public void setAllSeatModels(List<SeatModel> allSeatModels) {
        this.allSeatModels = allSeatModels;
    }
}
