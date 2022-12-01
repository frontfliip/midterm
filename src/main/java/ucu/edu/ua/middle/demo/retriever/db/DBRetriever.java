package ucu.edu.ua.middle.demo.retriever.db;
import ucu.edu.ua.middle.demo.repository.DataRepository;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.retriever.BaseRetriever;

public class DBRetriever extends BaseRetriever {
    private DataRepository dataRepository;

    public DBRetriever(DataRepository dataRepository){
        this.dataRepository = dataRepository;
    }

    @Override
    public void getData(String name, AllData allData) {
        if (dataRepository.getByDomain(name) != null){
            AllData refData = dataRepository.getByDomain(name);
            allData.setName(refData.getName());
            allData.setDomain(refData.getDomain());
            allData.setTwitter(refData.getTwitter());
            allData.setFacebook(refData.getFacebook());
            allData.setLogo(refData.getLogo());
            allData.setIcon(refData.getIcon());
            allData.setSize(refData.getSize());
            allData.setEmployee_count(refData.getEmployee_count());
            allData.setAddress(refData.getAddress());
            return;
        }
        if (next != null){
            next.getData(name, allData);
        }
    }
}
