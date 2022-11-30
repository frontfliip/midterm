package ucu.edu.ua.middle.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.retriever.DataRetriever;
import ucu.edu.ua.middle.demo.retriever.bf.BrandFetchRetriever;
import ucu.edu.ua.middle.demo.retriever.pdl.PDLDataRetriever;

import java.util.List;

@Component
public class DemoService {

    public AllData getInfo(String infoRequest) {

        AllData allData = new AllData();

//        DataRetriever dbRetriever = new DBRetriever();
        DataRetriever pdlRetriever = new PDLDataRetriever();
        DataRetriever brandFetchRetriever = new BrandFetchRetriever();

        brandFetchRetriever.setNext(pdlRetriever);

        brandFetchRetriever.getData(infoRequest, allData);

        return allData;
    }
}
