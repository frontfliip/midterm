package ucu.edu.ua.middle.demo.retriever.bf;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.retriever.BaseRetriever;
import ucu.edu.ua.middle.demo.retriever.pdl.PDLResponse;

public class BrandFetchRetriever extends BaseRetriever {

    private final String BRF_URL = "https://api.brandfetch.io/v2/brands/%s";
    private final String KEY_HEADER_NAME = "Authorization";
    private final String KEY_HEADER_VALUE = "Bearer tVX/P71ZtF+yeJ+JG+YWDf0J0KwDuUCgBISZ0z1nyj4=";

    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public void getData(String name, AllData allData) {

        String url = BRF_URL + String.format(BRF_URL, name);

        org.springframework.http.HttpHeaders headers = new HttpHeaders();
        headers.set(KEY_HEADER_NAME, KEY_HEADER_VALUE);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        BRFResponse exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, BRFResponse.class).getBody();


        if (allData.getName() == null){
            allData.setName("huita");
        }
        if (allData.getTwitter() == null){
            allData.setTwitter("huita");
        }
        if (allData.getFacebook() == null){
            allData.setFacebook("huita");
        }
        if (allData.getLogo() == null){
            allData.setLogo("huita");
        }
        if (allData.getIcon() == null){
            allData.setIcon("huita");
        }
        if (allData.getSize() == null){
            allData.setSize("huita");
        }
        if (allData.getEmployee_count() == null){
            allData.setEmployee_count("huita");
        }
        if (allData.getAddress() == null){
            allData.setAddress("huita");
        }

        if (next != null) {
            next.getData(name, allData);
        }

    }
}
