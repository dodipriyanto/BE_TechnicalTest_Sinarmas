package DefenderArcade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DefenderArcade {

    int arcadeMechine = 0;

    public int countArcades(List<String> times) throws ParseException {
        //time list for getting all listing
        List<Date> timeList = new ArrayList<>();

        //initiate lastemploye time
        Date lastEmployeStopTime = null;

        //get each line
        for (int i = 0; i < times.size(); i++) {
            //split, getting startTime
            String employeePlayStart = (times.get(i) + " ").split(" ")[0];
            //cast string to date with timeFormat function
            Date employeePlayStartTIme = timeFormat(employeePlayStart);

            //split, getting stopTime
            String employeeStop = (times.get(i) + " ").split(" ")[1];
            //cast string to date with timeFormat function
            Date employeeStopTime = timeFormat(employeeStop);

            //add to list
            timeList.add(employeeStopTime);

            //get last inserted stop time
            if (i > 0) {
                lastEmployeStopTime = timeList.get(i - 1);
            }

            if (lastEmployeStopTime != null) {
                //if last inserted lastEmployeStopTime bigger than new employeePlayStartTime, boss must buy new arcadeMechine
                if (lastEmployeStopTime.getTime() > employeePlayStartTIme.getTime()) {
                    arcadeMechine += 1;
                }
            }

        }

        return arcadeMechine;
    }

    static Date timeFormat(String timeString) {
        String time = "";
        String timeStringResult = "";

        if (timeString.length() <= 3) {
            time = '0' + timeString;
            timeStringResult = time.substring(0, 2) + ":" + time.substring(2, time.length());
        } else {
            timeStringResult = timeString.substring(0, 2) + ":" + timeString.substring(2, timeString.length());
        }

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date result = null;
        try {
            result = df.parse(timeStringResult);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return result;
    }
}
