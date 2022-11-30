package ucu.edu.ua.middle.demo.retriever;


public abstract class BaseRetriever implements DataRetriever {

    protected DataRetriever next;
    @Override
    public void setNext(DataRetriever dataRetriever) {
        this.next = dataRetriever;
    }

}
