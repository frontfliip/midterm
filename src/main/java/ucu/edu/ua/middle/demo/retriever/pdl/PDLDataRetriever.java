package ucu.edu.ua.middle.demo.retriever.pdl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.retriever.BaseRetriever;

public class PDLDataRetriever extends BaseRetriever {

    private final String PDL_URL = "https://api.peopledatalabs.com/v5/company/search";
    private final String KEY_HEADER_NAME = "X-API-Key";
    private final String KEY_HEADER_VALUE = "838d73c251e8908e5451a5f390c96adc727c89c74dab1f96d0063d6dc22fb67d";
    private final String SQL_TEMPLATE = "SELECT NAME FROM COMPANY WHERE WEBSITE='%s'";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void getData(String name, AllData allData) {
        if (isFull(allData)){
            return;
        }
        String url = PDL_URL + "?sql=" + String.format(SQL_TEMPLATE, name);

        HttpHeaders headers = new HttpHeaders();
        headers.set(KEY_HEADER_NAME, KEY_HEADER_VALUE);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        PDLResponse exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, PDLResponse.class).getBody();

        if (allData.getName() == null){
            allData.setName(exchange.getData().get(0).getName());
        }
        if (allData.getDomain() == null){
            allData.setDomain(name);
        }
        if (allData.getTwitter() == null){
            allData.setTwitter(exchange.getData().get(0).getTwitter_url());
        }
        if (allData.getFacebook() == null){
            allData.setFacebook(exchange.getData().get(0).getFacebook_url());
        }
        if (allData.getSize() == null){
            allData.setSize(exchange.getData().get(0).getSize());
        }
        if (allData.getEmployee_count() == null){
            allData.setEmployee_count(exchange.getData().get(0).getEmployee_count());
        }
        if (allData.getAddress() == null){
            allData.setAddress(exchange.getData().get(0).getLocation().getStreet_address());
        }
        if (next != null) {
            next.getData(name, allData);
        }
    }

}

