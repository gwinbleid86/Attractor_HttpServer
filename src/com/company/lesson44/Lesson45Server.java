package com.company.lesson44;

import com.company.server.ContentType;
import com.company.server.RouteHandler;
import com.company.server.Utils;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lesson45Server extends Lesson44Server{
    public List<User> users = new ArrayList<>();
    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/login",this::loginGet);
        registerPost("/login",this::loginPost);
        users.add(new User("qwe@qwe.qwe","qweqwe"));
    }
    private void loginGet(HttpExchange exchange){
        Path path = makeFilePath("login.html");
        sendFile(exchange,path, ContentType.TEXT_HTML);
    }
    protected void registerPost(String route, RouteHandler handler){
        getRoutes().put("POST " + route,handler);
    }
    private void loginPost(HttpExchange exchange){
        String cType = getContentType(exchange);
        String raw = getBody(exchange);
        Map<String,String> parsed = Utils.parseUrlEncoded(raw,"&");
        String fmt = "Необработанные данные:%s\n"
                +"Content-type:%s\n"
                +"После обработки:%s";
        String data = String.format(fmt,raw,cType,parsed);
        var user = users.stream().filter(c -> c.getEmail().equals(parsed.get("email"))).collect(Collectors.toList()).get(0);

        try {
            redirect303(exchange,"/profile",user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    protected String getContentType(HttpExchange exchange) {
        return exchange.getRequestHeaders()
                .getOrDefault("Content-type", List.of(""))
                .get(0);
    }
    protected String getBody(HttpExchange exchange){
        InputStream input = exchange.getRequestBody();
        Charset utf8 = StandardCharsets.UTF_8;
        InputStreamReader isr = new InputStreamReader(input,utf8);
        try(BufferedReader reader = new BufferedReader(isr)){
            return reader.lines().collect(Collectors.joining(""));
        }catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }
    protected void redirect303(HttpExchange exchange,String path, User user){
        try{
            exchange.getResponseHeaders().add("Location",path);
            exchange.sendResponseHeaders(303,0);
            renderTemplate(exchange,"profile.html",user);
            exchange.getResponseBody().close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
