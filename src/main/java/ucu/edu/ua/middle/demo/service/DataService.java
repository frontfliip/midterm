package ucu.edu.ua.middle.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucu.edu.ua.middle.demo.repository.DataRepository;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.retriever.DataRetriever;
import ucu.edu.ua.middle.demo.retriever.bf.BrandFetchRetriever;
import ucu.edu.ua.middle.demo.retriever.db.DBRetriever;
import ucu.edu.ua.middle.demo.retriever.pdl.PDLDataRetriever;

import java.util.List;

@Component
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    public AllData getInfo(String infoRequest) {

        AllData allData = new AllData();

        DataRetriever dbRetriever = new DBRetriever(dataRepository);
        DataRetriever pdlRetriever = new PDLDataRetriever();
        DataRetriever brandFetchRetriever = new BrandFetchRetriever();

        dbRetriever.setNext(pdlRetriever);
        pdlRetriever.setNext(brandFetchRetriever);

        dbRetriever.getData(infoRequest, allData);

        if (dataRepository.getByDomain(infoRequest) == null){
            dataRepository.save(allData);
        }

        return allData;
    }

    public List<AllData> getAll() {
        return dataRepository.findAll();
    }

    public void add(AllData info) {
        if (dataRepository.getByDomain(info.getDomain()) == null){
            dataRepository.save(info);
        }

    }
}
