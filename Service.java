public class Service {
    String name; 
    Double price;
    String IDService;

    public Service(String IDService, String name, Double price){
        this.IDService = IDService;
        this.price = price;
        this.name = name;
    }

    public void setIDService(String IDService){
        this.IDService = IDService;
    }
    public String getIDService(){
        return IDService;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPrice(Double price){
    this.price = price;
    }
    public Double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return getIDService()+" "+getName()+" "+getPrice();
    }
}
