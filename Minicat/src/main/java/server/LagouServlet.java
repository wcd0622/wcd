package server;

import java.io.IOException;

public class LagouServlet extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) throws Exception {
        String content = "<h1>LagouServlet get</h1>";
        try {
            response.output(HttpProtocolUtil.getHttpHeader200(content.getBytes().length)+content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(Request request, Response response) throws Exception {
        String content = "<h1>LagouServlet post</h1>";
        try {
            response.output(HttpProtocolUtil.getHttpHeader200(content.getBytes().length)+content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void inint() throws Exception {

    }

    @Override
    public void destory() throws Exception {

    }
}
