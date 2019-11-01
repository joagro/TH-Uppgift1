package com.company;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 *This class links a Date object to a Pupil object and
 * provides a convenient way to calculate the time delta
 * in full days from the creation of the Pupil object.
 */
public class QueueDate implements Serializable {

    private Date startDate;

    private int pupilID;

    private SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

    private static final long serialVersionUID = 1L;

    /**
     * @param pupilID PupilID is an integer corresponding to a Pupil object
     */
    QueueDate(int pupilID) {
        this.startDate = new Date();
        this.pupilID = pupilID;

    }

    /**
     *
     * @param datestring datestring provides the designated date in the format
     *                   assigned by format
     *
     * @param pupilID PupilID is an integer corresponding to a Pupil object
     */

    QueueDate(String datestring, int pupilID) {

        Date date = new Date();

        try {
            date = format.parse(datestring);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.startDate = date;
        this.pupilID = pupilID;
    }

    /**
     *
     * @param date the endpoint for the delta you seek
     * @return time delta in whole days
     */

    public String getDaysSince(Date date) {
        long timediff = date.getTime() -startDate.getTime(); // - date.getTime();

        return "" + TimeUnit.DAYS.convert(timediff, TimeUnit.MILLISECONDS);
    }

    public String toString() {

        return startDate.toString();
    }

    public Date getStartDate(){
        return startDate;
    }

    public int getPupilID(){
        return pupilID;
    }


}
