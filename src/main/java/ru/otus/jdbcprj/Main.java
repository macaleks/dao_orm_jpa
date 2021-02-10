package ru.otus.jdbcprj;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import ru.otus.jdbcprj.shell.ShellCommands;

import java.sql.SQLException;

@SpringBootApplication
public class Main {


    public static void main(String[] args) throws InterruptedException, SQLException {
        ApplicationContext context = SpringApplication.run(Main.class);
        Console.main(args);
    }

}
