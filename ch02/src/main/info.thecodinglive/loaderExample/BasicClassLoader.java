package loaderExample;

import java.io.Closeable;

public interface BasicClassLoader extends Closeable {
    public void init();
    public Class<?> load(String name);
    public void run();
    public void unload();
}
