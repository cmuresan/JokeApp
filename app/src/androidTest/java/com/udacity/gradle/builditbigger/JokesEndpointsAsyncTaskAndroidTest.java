package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class JokesEndpointsAsyncTaskAndroidTest {

    @SuppressWarnings("unchecked")
    @Test
    public void verifyAsyncTaskResponse() {
        final CountDownLatch latch = new CountDownLatch(1);
        Context context = InstrumentationRegistry.getContext();
        String name = "Cristian";

        JokesEndpointsAsyncTask task = new JokesEndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertTrue(!TextUtils.isEmpty(result));
                latch.countDown();
            }
        };
        task.execute(new Pair<>(context, name));
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}