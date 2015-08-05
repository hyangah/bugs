/*
 * Copyright 2015 The Go Authors. All rights reserved.
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file.
 */

package org.golang.example.bind;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import go.myLib.MyLib;

public class MainActivity extends Activity {
    private static Button button;
    private static MyLib.Timer timer;

    class Events extends MyLib.Events.Stub {
        @Override
        public void OnTrigger() {
            Log.d("MyApp", "Fire!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        timer = MyLib.NewTimer();

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timer.AddListener(new Events());
                timer.Start();
            }
        });
    }
}
