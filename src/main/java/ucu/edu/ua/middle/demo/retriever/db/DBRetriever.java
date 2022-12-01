package ucu.edu.ua.middle.demo.retriever.db;

import org.springframework.beans.factory.annotation.Autowired;
import ucu.edu.ua.middle.demo.DemoRepository.DemoRepository;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.retriever.BaseRetriever;

//public class DBRetriever extends BaseRetriever {
//
//
//
//    @Override
//    public void getData(String name, AllData allData) {
//        if (demoRepository.getByDomain(name) != null){
//            allData = demoRepository.getByDomain(name);
//        }
//        if (next != null){
//            next.getData(name, allData);
//        }
//    }
//}
