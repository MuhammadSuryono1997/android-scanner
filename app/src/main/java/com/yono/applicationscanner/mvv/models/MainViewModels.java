package com.yono.applicationscanner.mvv.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yono.applicationscanner.mvv.response.ExampleResponse;

import java.util.ArrayList;

public class MainViewModels extends ViewModel {
    MutableLiveData<ArrayList<ExampleResponse>> exampleLastUpdate;
    private ArrayList<ExampleResponse> exampleResponseArrayList;

    public MainViewModels(){
        exampleLastUpdate = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<ExampleResponse>> getLastUpdate(){
        return exampleLastUpdate;
    }

    private void init() {
            exampleResponseArrayList = new ArrayList<>();
            exampleResponseArrayList.add(new
                    ExampleResponse("Example Number One",
                    "https://www.pertamina.com/media/31c8e548-60a6-461c-adc7-d228c001d8af/Aktifitas%20Pengeboran.jpg"));

            exampleResponseArrayList.add(new
                ExampleResponse("Example Number Two",
                "https://www.pertamina.com/Media/Image/gallery/PGE_Pertamina_Kamojang.jpg"));


            exampleLastUpdate.setValue(exampleResponseArrayList);
    }
}
