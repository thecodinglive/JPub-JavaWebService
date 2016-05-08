package loaderExample;

public class JpServlet {
    public String sayHello(String name){
        System.out.println("hello" + name);

        return JpServlet.class.getName();
    }

    public JpServlet() {
    }
}
