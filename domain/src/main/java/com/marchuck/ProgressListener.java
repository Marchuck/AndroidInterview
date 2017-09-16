package com.marchuck;

/**
 * Project "AndroidInterview"
 * <p>
 * Created by Lukasz Marczak
 * on 16.09.2017.
 */

public interface ProgressListener {
    void update(long bytesRead, long contentLength, boolean done);
}
