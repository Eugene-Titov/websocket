package template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

public class Share {
    public static String getHtmlPage(String name, Map<String,String> values) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        InputStream f = Share.class.getResourceAsStream("html/" + name);
        Template template = configuration.
        Writer file = new StringWriter();
        template.process(values, file);
        file.flush();
        return file.toString();
    }
}
