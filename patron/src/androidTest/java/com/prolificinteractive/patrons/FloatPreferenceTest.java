package com.prolificinteractive.patrons;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class FloatPreferenceTest {

  private static final float DEFAULT_VALUE = 0;

  private static final float TEN = 10.0f;
  private static final float TWENTY = 20.0f;
  private static final float FORTY_TWO = 42.0f;

  private SharedPreferences prefs;

  @Before public void setUp() throws Exception {
    prefs = PreferenceManager.getDefaultSharedPreferences(InstrumentationRegistry.getContext());
  }

  @Test public void testGet() throws Exception {
    final FloatPreference pref = new FloatPreference(prefs, "float_test");
    pref.delete();
    assertThat(pref.get(), is(equalTo(DEFAULT_VALUE)));
    pref.set(TEN);
    pref.set(TWENTY);
    pref.set(FORTY_TWO);
    assertThat(pref.get(), is(equalTo(FORTY_TWO)));
    assertThat(pref.get(), is(not(equalTo(TEN))));
    assertThat(pref.get(), is(not(equalTo(TWENTY))));
  }
}
