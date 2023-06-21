public abstract class User {
    String name; 
    String phone;
    String CPF;
    
    public User(String CPF, String phone, String name){
        this.CPF = CPF;
        this.phone = phone;
        this.name = name;
    }

    public void setCPF(String CPF){
       this.CPF = CPF;
    }
    public String getCPF(){
       return CPF;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }


    @Override
    public String toString(){
        return getCPF()+" "+getName()+" "+getPhone();
    }
}
