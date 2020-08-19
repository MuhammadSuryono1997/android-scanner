package com.yono.applicationscanner.mvv.models;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yono.applicationscanner.mvv.response.ExampleResponse;

import java.util.ArrayList;

public class ExampleMainViewModels extends ViewModel {
    MutableLiveData<ArrayList<ExampleResponse>> exampleResponse;
    private ArrayList<ExampleResponse> exampleResponseArrayList;

    public ExampleMainViewModels(){
        exampleResponse = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<ExampleResponse>> getExampleResponse(){
        return exampleResponse;
    }

    private void init() {
        exampleResponseArrayList = new ArrayList<>();
        exampleResponseArrayList.add(
                new ExampleResponse(
                        "Asset Number One",
                        "https://www.pertamina.com/Media/Image/post/IMG-20180712-WA0003.jpg"
                )
        );
        exampleResponseArrayList.add(
                new ExampleResponse(
                        "Asset Number Two",
                        "https://www.pertamina.com/Media/Image/gallery/PGE_Pertamina_Kamojang.jpg"
                )
        );

        exampleResponse.setValue(exampleResponseArrayList);
    }
}
