package ucu.edu.ua.middle.demo.retriever.bf;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.retriever.BaseRetriever;

public class BrandFetchRetriever extends BaseRetriever {

    @Override
    public void getData(String name, AllData allData) {
        if (isFull(allData)){
            return;
        }
        BRFResponse brfResponse = new BRFResponse();
        Unirest.setTimeouts(0, 0);
        try {
            HttpResponse<String> response = Unirest.get("https://api.brandfetch.io/v2/brands/" + name).header("Authorization", "Bearer tVX/P71ZtF+yeJ+JG+YWDf0J0KwDuUCgBISZ0z1nyj4=").asString();
            JSONObject responseJson = new JSONObject(response.getBody());

            JSONArray links = responseJson.getJSONArray("links");
            for (int i = 0; i < links.length(); i++) {
                JSONObject currLink = links.getJSONObject(i);
                if (currLink.get("name").toString().equals("facebook")){
                    brfResponse.setFacebook(currLink.get("url").toString());
                }
                if (currLink.get("name").toString().equals("twitter")){
                    brfResponse.setTwitter(currLink.get("url").toString());
                }
            }

            JSONArray logos = responseJson.getJSONArray("logos");
            for (int i = 0; i < logos.length(); i++) {
                if (logos.getJSONObject(i).get("type").toString().equals("icon")){
                    brfResponse.setIcon(logos.getJSONObject(i).getJSONArray("formats").getJSONObject(0).get("src").toString());
                }
                if (logos.getJSONObject(i).get("type").toString().equals("logo")){
                    brfResponse.setLogo(logos.getJSONObject(i).getJSONArray("formats").getJSONObject(0).get("src").toString());
                }
            }

            brfResponse.setName(responseJson.get("name").toString());

        } catch (UnirestException e) {throw new RuntimeException();}


        if (allData.getName() == null){
            allData.setName(brfResponse.getName());
        }
        if (allData.getTwitter() == null){
            allData.setTwitter(brfResponse.getTwitter());
        }
        if (allData.getFacebook() == null){
            allData.setFacebook(brfResponse.getFacebook());
        }
        if (allData.getLogo() == null){
            allData.setLogo(brfResponse.getLogo());
        }
        if (allData.getIcon() == null){
            allData.setIcon(brfResponse.getIcon());
        }
        if (next != null) {
            next.getData(name, allData);
        }
    }
}
