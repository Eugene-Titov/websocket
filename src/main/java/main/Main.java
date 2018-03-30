package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.ChatServlet;
import servlets.MyServlet;

import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {

        ClassLoader.getSystemResource("html/hello.html");

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.setContextPath("/");
        context.addServlet(new ServletHolder(new MyServlet()),"/");
        context.addServlet(new ServletHolder(new ChatServlet()), "/chat");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("resources");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[] {resourceHandler, context});
        server.setHandler(handlerList);

        server.start();
        Logger.getGlobal().info("Server started");
        server.join();
    }

}
