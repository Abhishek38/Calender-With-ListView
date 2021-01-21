package com.example.calenderlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    List<ListModel> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<EventDay> events = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        RecyclerView recyclerView=findViewById(R.id.listRecycler);
        recyclerView.setVisibility(View.INVISIBLE);

        events.add(new EventDay(calendar, R.drawable.dot));
        events.add(new EventDay(calendar, R.drawable.dot, Color.parseColor("#228B22")));
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setEvents(events);
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                Date date = eventDay.getCalendar().getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                String formattedDate = dateFormat.format(date);
                events.add(new EventDay(eventDay.getCalendar(), R.drawable.dot));
                calendarView.setEvents(events);
                getData(formattedDate, eventDay);
                ListAdapter adapter=new ListAdapter(data,getApplicationContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
               // data.clear();
                Log.d("abhi",""+data.size()+"");

                recyclerView.setVisibility(View.VISIBLE);
            }
        });

    }

    private void getData(String day, EventDay eventDay) {
        HashMap<String, List<ListModel>> map = new HashMap<>();

        if(!map.containsKey(day))
        {
            List<ListModel> link1 = new ArrayList<>();
            link1.addAll(getStringData(eventDay));
            map.put(day,link1);
        }else
        {
            List<ListModel> events = map.get(day);
            events.addAll(getStringData(eventDay));
            map.put(day,events);

        }



    }

    private List<ListModel> getStringData(EventDay eventDay) {
        data.clear();


            switch (eventDay.getCalendar().get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SUNDAY:
                    ListModel model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ebayimg.com%2F00%2Fs%2FMTUwMFgxMDU0%2Fz%2FuWoAAOSwUKxYdeOM%2F%24_57.JPG&f=1&nofb=1",
                            "Ghee");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.-G8jQz5IQ2mhZJ-GPVSYWQHaE8%26pid%3DApi&f=1",
                            "Butter");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.Y-XDWKPWVK_H6yoXKxxGOQAAAA%26pid%3DApi&f=1",
                            "Cheese");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.fSWMYr8sf0KadAgystGIUAHaLm%26pid%3DApi&f=1",
                            "ButterMilk");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.5MrAefkhkd03gDtfJDPwaAHaHa%26pid%3DApi&f=1",
                            "Dhai Cup");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP._TS9y7BcGgoskrMHxYFLgQAAAA%26pid%3DApi&f=1",
                            "Lassi");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.KPNkZWeRcNebELwXflM7YQHaHF%26pid%3DApi&f=1",
                            "Paneer");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ebayimg.com%2F00%2Fs%2FMTUwMFgxMDU0%2Fz%2FuWoAAOSwUKxYdeOM%2F%24_57.JPG&f=1&nofb=1",
                            "Ghee");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.-G8jQz5IQ2mhZJ-GPVSYWQHaE8%26pid%3DApi&f=1",
                            "Butter");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.Y-XDWKPWVK_H6yoXKxxGOQAAAA%26pid%3DApi&f=1",
                            "Cheese");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.fSWMYr8sf0KadAgystGIUAHaLm%26pid%3DApi&f=1",
                            "ButterMilk");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.5MrAefkhkd03gDtfJDPwaAHaHa%26pid%3DApi&f=1",
                            "Dhai Cup");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP._TS9y7BcGgoskrMHxYFLgQAAAA%26pid%3DApi&f=1",
                            "Lassi");
                    data.add(model);
                    model = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.KPNkZWeRcNebELwXflM7YQHaHF%26pid%3DApi&f=1",
                            "Paneer");
                    data.add(model);
                    break;

                default:
                    ListModel model1 = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.5MrAefkhkd03gDtfJDPwaAHaHa%26pid%3DApi&f=1",
                            "Dhai Cup");
                    data.add(model1);
                    model1 = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP._TS9y7BcGgoskrMHxYFLgQAAAA%26pid%3DApi&f=1",
                            "Lassi");
                    data.add(model1);
                    model1 = new ListModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.KPNkZWeRcNebELwXflM7YQHaHF%26pid%3DApi&f=1",
                            "Paneer");
                    data.add(model1);
                    break;

            }


        return data;
    }

}