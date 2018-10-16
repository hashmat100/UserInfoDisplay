package com.sample11.main;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.sample11.main.network.BaseListener;
import com.sample11.main.network.GetAlbumInfoVO;
import com.sample11.main.network.GetUserInfoVO;
import com.sample11.main.network.UserInfoHttpClient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Ashmath Khan on 17-10-2018.
 */
@RunWith(AndroidJUnit4.class)
public class NetworkApiTest {
    private Context instrumentationCtx;
    public final CountDownLatch latch = new CountDownLatch(1);

    @Before
    public void setup() {
        instrumentationCtx = InstrumentationRegistry.getContext();
    }


    @Test
    public void getUserInfoApiChecks() throws InterruptedException {
        UserInfoHttpClient.getInstance(instrumentationCtx).getUserInfo(new BaseListener<List<GetUserInfoVO>>() {
            @Override
            public void onResponse(List<GetUserInfoVO> response) {
                assertNotNull(response);
                assertNotEquals(response.size(), 0);
                latch.countDown();
            }

            @Override
            public void onFailure(int error) {

                assertNotNull(null);
                latch.countDown();
            }
        });
        latch.await();
    }

    @Test
    public void getAlbumInfoApiChecks() throws InterruptedException {
        UserInfoHttpClient.getInstance(instrumentationCtx).getAlbumInfo(new BaseListener<List<GetAlbumInfoVO>>() {
            @Override
            public void onResponse(List<GetAlbumInfoVO> response) {
                assertNotNull(response);
                assertNotEquals(response.size(), 0);
                latch.countDown();
            }

            @Override
            public void onFailure(int error) {
                assertNotNull(null);
                latch.countDown();
            }
        });
        latch.await();
    }
}
