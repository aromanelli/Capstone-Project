package info.romanelli.udacity.capstone.reddit.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import info.romanelli.udacity.capstone.reddit.data.DataRepository;
import info.romanelli.udacity.capstone.util.AppExecutors;
import info.romanelli.udacity.capstone.util.FirebaseAnalyticsManager;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)public class NewPostEntityITest {

    private static final String TAG = NewPostEntityITest.class.getSimpleName();

    @Test
    public void testNewPosts() throws InterruptedException {

        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("info.romanelli.udacity.capstone", appContext.getPackageName());

        FirebaseAnalyticsManager.$(appContext);

        final AtomicBoolean flag = new AtomicBoolean(false);

        try {

            // Initial cleanup ...
            DataRepository.$(appContext).clearDatabase();
            Thread.sleep(5000); // Hacky, but works ok for testing purposes only

            final LiveData<List<NewPostEntity>> newPosts1 = DataRepository.$(appContext).getNewPosts();
            final Observer<List<NewPostEntity>> obs1 = newPostEntities -> {
                Log.d(TAG, "testNewPosts: delete");

                Assert.assertNotNull(newPostEntities);
                Assert.assertEquals(0, newPostEntities.size());

                flag.set(true);
            };

            try {
                newPosts1.observeForever(obs1);
                int waitCounter = 0;
                while (!flag.get()) {
                    Thread.sleep(250);
                    waitCounter++;
                    if (waitCounter % 4 == 0) {
                        Log.d(TAG, "delete check: Waiting for completion ... [" + (waitCounter / 4) + "]");
                    }
                    if (waitCounter > 120) { // 250 * 120 = 30,000ms == 30 seconds
                        Assert.fail("Interrupted while waiting for response back!");
                        break;
                    }
                }
            } finally {
                AppExecutors.$().mainUI().execute(() -> newPosts1.removeObserver(obs1));
            }

            ///////////////////////////////////////////////////////////////////////////

            NewPostEntity entity1 = new NewPostEntity();
            Assert.assertNotNull(entity1.getId());
            entity1.setId("9sizd6");
            entity1.setAuthor("DrunkShroom");
            entity1.setCreated(1540888306L);
            entity1.setSubreddit("gaming");
            entity1.setSubreddit_pre("r/gaming");
            entity1.setSubreddit_icon("https://b.thumbs.redditm…z1F1GrrJLCL8oi2Gz0Ak.png");
            entity1.setTitle("Nintendo switch turbo controller?");
            entity1.setText("Anyone know a decent 3rd… rather than holding it");
            entity1.setUrl("https://www.reddit.com/r…switch_turbo_controller/");
            DataRepository.$(appContext).addNewPost(entity1);

            final int[] retryCounter = {0};
            flag.set(false);
            final LiveData<List<NewPostEntity>> newPosts2 = DataRepository.$(appContext).getNewPosts();
            final Observer<List<NewPostEntity>> obs2 = newPostEntities -> {
                Log.d(TAG, "testNewPosts: insert");

                Assert.assertNotNull(newPostEntities);

                // Gets called twice, first with 0 size, second with non-zero size
                if (newPostEntities.size() == 0 && retryCounter[0] == 0) {
                    Log.d(TAG, "testNewPosts: insert - zero pass thru");
                    retryCounter[0] += 1;
                    return;
                }

                Assert.assertEquals(1, newPostEntities.size());

                NewPostEntity entity2 = newPostEntities.get(0);
                Assert.assertNotNull(entity2);
                Assert.assertEquals(entity1, entity2); // Testing equals() method in NewPostEntity

                Assert.assertEquals(entity1.getId(), entity2.getId());
                Assert.assertEquals(entity1.getAuthor(), entity2.getAuthor());
                Assert.assertEquals(entity1.getCreated(), entity2.getCreated());
                Assert.assertEquals(entity1.getSubreddit(), entity2.getSubreddit());
                Assert.assertEquals(entity1.getSubreddit_pre(), entity2.getSubreddit_pre());
                Assert.assertEquals(entity1.getSubreddit_icon(), entity2.getSubreddit_icon());
                Assert.assertEquals(entity1.getTitle(), entity2.getTitle());
                Assert.assertEquals(entity1.getText(), entity2.getText());
                Assert.assertEquals(entity1.getUrl(), entity2.getUrl());

                flag.set(true);
            };

            try {
                newPosts2.observeForever(obs2);
                int waitCounter = 0;
                while (!flag.get()) {
                    Thread.sleep(250);
                    waitCounter++;
                    if (waitCounter % 4 == 0) {
                        Log.d(TAG, "add check: Waiting for completion ... [" + (waitCounter / 4) + "]");
                    }
                    if (waitCounter > 120) { // 250 * 120 = 30,000ms == 30 seconds
                        Assert.fail("Interrupted while waiting for response back!");
                        break;
                    }
                }
            } finally {
                AppExecutors.$().mainUI().execute(() -> newPosts2.removeObserver(obs2));
            }

        } finally {
            // Post testing cleanup ...
            DataRepository.$(appContext).clearDatabase();
        }

    }

}
