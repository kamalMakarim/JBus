package kamalMakarimJBusRD;


public abstract class Account extends Serializable implements FileParser
{
    public String email;
    public String name;
    public String password;
    

    public Account (int id, String name, String email, String password){
        super();
        this.name = name;
        this.email= email;
        this.password = password;
    }
    
    public String toString(){
        return "\naccountId: " + id + "\nemail: " + email + "\nname: " + name + "\npassword: " + password;
    }
}