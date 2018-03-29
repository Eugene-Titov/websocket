package template;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

import static java.lang.ClassLoader.getSystemResource;

public class Share {
    public static String getHtmlPage(String name, Map<String,String> values) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        ClassTemplateLoader loader = new ClassTemplateLoader(new Share().getClass(), "/html" );
        configuration.setTemplateLoader(loader);
        Template tmp = configuration.getTemplate(name);
        Writer file = new StringWriter();
        tmp.process(values, file);
        file.flush();
        return file.toString();
    }
}
