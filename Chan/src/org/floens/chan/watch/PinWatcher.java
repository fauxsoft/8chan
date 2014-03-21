package org.floens.chan.watch;

import java.util.List;

import org.floens.chan.loader.Loader;
import org.floens.chan.model.Pin;
import org.floens.chan.model.Post;
import org.floens.chan.service.PinnedService;
import org.floens.chan.utils.Logger;

import com.android.volley.VolleyError;

public class PinWatcher implements Loader.LoaderListener {
    private static final String TAG = "PinWatcher";
    
    private final Pin pin;
    private Loader loader;
    
    private long startTime;

    public PinWatcher(Pin pin) {
        this.pin = pin;
        
//        loader = new Loader(this);
    }
    
    public void destroy() {
        
    }

    @Override
    public void onError(VolleyError error) {
        Logger.test("PinWatcher onError: ", error);
    }
    
    @Override
    public void onData(List<Post> result, boolean append) {
        int count = result.size();
        
        Logger.test("PinWatcher onData");
        Logger.test("Post size: " + count);
        
        if (pin.watchLastCount <= 0) {
            pin.watchLastCount = pin.watchNewCount;
        }
        
        pin.watchNewCount = count;
        
        Logger.test("Load time: " + (System.currentTimeMillis() - startTime) + "ms");
        
        PinnedService.callOnPinsChanged();
    }
    
    
}