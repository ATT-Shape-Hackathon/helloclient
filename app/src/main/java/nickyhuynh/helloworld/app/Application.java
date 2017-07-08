package nickyhuynh.helloworld.app;

/**
 * Created by bummy on 7/8/17.
 */

public class Application extends android.app.Application {
    private static Application instance;
    public static Application getInstance() { return instance; }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
