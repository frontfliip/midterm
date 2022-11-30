package ucu.edu.ua.middle.demo.retriever;

import ucu.edu.ua.middle.demo.allData.AllData;

public interface DataRetriever {

    void getData(String name, AllData allData);

    void setNext(DataRetriever dataRetriever);

}
