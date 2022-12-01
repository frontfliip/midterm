package ucu.edu.ua.middle.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucu.edu.ua.middle.demo.DemoRepository.DemoRepository;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.retriever.DataRetriever;
import ucu.edu.ua.middle.demo.retriever.bf.BrandFetchRetriever;
import ucu.edu.ua.middle.demo.retriever.db.DBRetriever;
import ucu.edu.ua.middle.demo.retriever.pdl.PDLDataRetriever;

import java.util.List;

@Component
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public AllData getInfo(String infoRequest) {

        AllData allData = new AllData();

        DataRetriever dbRetriever = new DBRetriever(demoRepository);
        DataRetriever pdlRetriever = new PDLDataRetriever();
        DataRetriever brandFetchRetriever = new BrandFetchRetriever();

        dbRetriever.setNext(pdlRetriever);
        pdlRetriever.setNext(brandFetchRetriever);

        dbRetriever.getData(infoRequest, allData);

        if (demoRepository.getByDomain(infoRequest) == null){
            demoRepository.save(allData);
        }

        return allData;
    }
}
