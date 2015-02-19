package edu.uniandes.ecos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Hello world!
 *
 */
public class Main extends HttpServlet {

    public static String texto = "";

    public static void main(String[] args) throws Exception {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new Main()), "/*");
        server.start();
        server.join();
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
         PrintWriter pagina=resp.getWriter();
        resp.setContentType("text/html");
        String valor = req.getParameter("elementos");        
        App app = new App();        
        App.llenarDatos(valor);
        PrintWriter out = resp.getWriter();
        out.print("AVG =" + App.getAvg()+ "\n");
        out.print("VAR2 =" + App.getVar2()+ "\n");
        out.print("VAR =" + App.getVar()+ "\n");
        out.print("VS =" + App.getVs()+ "\n");
        out.print("S =" + App.getS()+ "\n");
        out.print("M =" + App.getM()+ "\n");
        out.print("L =" + App.getL()+ "\n");
        out.print("VL =" + App.getVl()+ "\n");
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getParameter("elementos") != null){
            showHome(req, resp);
        }else{
        PrintWriter out = resp.getWriter();
        out.print("<html>\n"
                + "<body>\n"
                + "<form action=\"/Main\" method=\"POST\">\n"
                +"Ingrese los datos separados por comas \nEjemplo: 1.2,2,3,15,6,18,5\n"
                + "<br/>\n"
                + "Datos: <input type=\"text\" name=\"elementos\">\n"
                + "<br />\n"
                + "<input type=\"submit\" value=\"Submit\" />\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>");
        }        
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        
    }
}
