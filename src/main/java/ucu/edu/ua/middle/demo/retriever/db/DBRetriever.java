package ucu.edu.ua.middle.demo.retriever.db;
import ucu.edu.ua.middle.demo.DemoRepository.DemoRepository;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.retriever.BaseRetriever;

public class DBRetriever extends BaseRetriever {


    private DemoRepository demoRepository;

    public DBRetriever(DemoRepository demoRepository){
        this.demoRepository = demoRepository;
    }

    @Override
    public void getData(String name, AllData allData) {
        if (demoRepository.getByDomain(name) != null){
            AllData refData = demoRepository.getByDomain(name);
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
