package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MyServlet;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {

        Server server = new Server(9000);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new MyServlet()),"/");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[] {context});
        server.setHandler(handlerList);

        server.start();
        Logger.getGlobal().info("Server started");
        server.join();
    }

}
