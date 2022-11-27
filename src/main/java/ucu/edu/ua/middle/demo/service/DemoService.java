package ucu.edu.ua.middle.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucu.edu.ua.middle.demo.retriever.DataRetriever;
import ucu.edu.ua.middle.demo.retriever.pdl.PDLDataRetriever;

import java.util.List;

@Component
public class DemoService {

    @Autowired
    private List<DataRetriever> retrievers;

    public String getInfo(String infoRequest) {

        for (DataRetriever retriever : retrievers) {
            retriever.getData(infoRequest);
        }

        return null;
    }
}
