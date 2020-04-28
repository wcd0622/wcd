package server;

public interface Servlet {
    void inint() throws  Exception;
    void destory() throws  Exception;
    void service(Request request,Response response) throws  Exception;
}
