package loaderExample;

import java.io.*;
import java.lang.Object;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JpubClassLoader extends ClassLoader implements BasicClassLoader{
    private String classPath;
    private String contextPath;
    private String libPath;
    private Object obj;
    private URLClassLoader urlCl;

    public JpubClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public void init(){
         contextPath = "d:path";
         classPath = contextPath.concat(File.separator).concat("WEB-INF")
                .concat(File.separator).concat("classes");
         libPath = contextPath.concat(File.separator).concat("WEB-INF")
                .concat(File.separator).concat("lib");

        File classes = new File(classPath);
        List<URL> urlList = new ArrayList<>();

        if(classes.exists()){
            try{
                urlList.add(classes.toURI().toURL());
            }catch (MalformedURLException me){
                me.printStackTrace();
            }
        }
        File lib = new File(libPath);
        if(lib.exists()){
            try{
                FileFilter ff = new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        boolean result =  false;
                        if(pathname.getName().endsWith(".jar")){
                            result = true;
                        }
                        return result;
                    }
                };
                File[] jarList = lib.listFiles(ff);
                for(File file : jarList){
                    urlList.add( file.toURI().toURL());
                }
            }catch(MalformedURLException e){
                e.printStackTrace();
            }
        }
        URL[] urls = new URL[urlList.size()];
        for(int i = 0; i < urls.length; i++){
            urls[i] = urlList.get(i);
        }
        urlCl = new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
        Thread.currentThread().setContextClassLoader(urlCl);
    }

    @Override
    public Class<?> load(String name) {
        Class targetClass = null;
        try{
           // targetClass = urlCl.loadClass( name );
          //  urlCl urlCl1 = (urlCl1)URLCL
        }
        return null;
    }

    @Override
    public void run() {

    }

    @Override
    public void unload() {
        try{
            close();
        }catch(IOException ioe){

        }

    }

    @Override
    public void close() throws IOException {

    }
}
