package org.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;

public class ReportCommand implements Commands{
    private Catalog catalog;
    public ReportCommand(Catalog catalog){
        this.catalog=catalog;
    }
    public void execute(){ /*
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\a\\Downloads\\apache-freemarker-2.3.32-src\\src\\java\\freemaker\\template"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        Template temp = cfg.getTemplate("test.ftlh"); */
    }
}
