package info.thecodinglive.listenerExample;

public class Admin {
    private String name = "나관리";
    private String email = "admin@company.com";

    public Admin(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





}
