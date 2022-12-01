package ucu.edu.ua.middle.demo.retriever;


import ucu.edu.ua.middle.demo.allData.AllData;

public abstract class BaseRetriever implements DataRetriever {

    protected DataRetriever next;
    @Override
    public void setNext(DataRetriever dataRetriever) {
        this.next = dataRetriever;
    }


    protected boolean isFull(AllData allData){
        if (allData.getName() == null){
            return false;
        } else if (allData.getTwitter() == null) {
            return false;
        } else if (allData.getFacebook() == null) {
            return false;
        } else if (allData.getAddress() == null) {
            return false;
        } else if (allData.getLogo() == null) {
            return false;
        } else if (allData.getEmployee_count() == null) {
            return false;
        } else if (allData.getIcon() == null) {
            return false;
        } else if (allData.getSize() == null) {
            return false;
        } else if (allData.getDomain() == null) {
            return false;
        } else {return true;}
    }
}
