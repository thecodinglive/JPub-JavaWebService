package info.thecodinglive.javaConfig;

public class Company {
    private String name;

    Company(String name) {
        this.name = name;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }
}
