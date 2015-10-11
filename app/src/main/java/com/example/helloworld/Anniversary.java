package com.example.helloworld;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by nobody on 2015-09-25.
 */
public class Anniversary implements Parcelable {
    private String title;
    private Calendar calendar;
    private boolean isSolar;

    public String getTitle() {
        return title;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public boolean getIsSolar() {
        return isSolar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeLong(calendar != null ? calendar.getTimeInMillis() : -1);
        dest.writeByte(isSolar ? (byte) 1 : (byte) 0);
    }

    public Anniversary(String title, Calendar calendar, boolean isSolar) {
        this.title = title;
        this.calendar = calendar;
        this.isSolar = isSolar;
    }

    protected Anniversary(Parcel in) {
        this.title = in.readString();
        long tmpCalendar = in.readLong();
//        this.calendar = tmpCalendar == -1 ? null : new GregorianCalendar().setTimeInMillis(tmpCalendar);
        if (tmpCalendar == -1) {
            this.calendar = null;
        } else {
            this.calendar = new GregorianCalendar();
            this.calendar.setTimeInMillis(tmpCalendar);
        }
        this.isSolar = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Anniversary> CREATOR = new Parcelable.Creator<Anniversary>() {
        public Anniversary createFromParcel(Parcel source) {
            return new Anniversary(source);
        }

        public Anniversary[] newArray(int size) {
            return new Anniversary[size];
        }
    };
}
