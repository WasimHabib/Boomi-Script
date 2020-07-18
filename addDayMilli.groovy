import java.text.DateFormat
import java.text.SimpleDateFormat

//GROOVY BOOMI Script to add a day using Milliseconds from 1970
// not using Joda Time, no jar installed in atom library and Boomi atom is hosted by the customer


def inDate = "2013-11-17T21:20:58"

// one day
def oneDay = 86400000
//days to adjust date
def setDay = 10
DateFormat formatter ;
Date date;

def innotasformatter = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" );
def newInnotasformatter = new SimpleDateFormat( "MM/dd/yyyy hh:mm:ss aa z" );
date = innotasformatter.parse(inDate);
outDate = newInnotasformatter.format(date)
long milliDate = date.time

println date
println outDate
println milliDate
endMilli = milliDate + (oneDay * setDay)
println   endMilli

date = new Date(milliDate)
date = new Date(endMilli)
if(setDay>0) {
println newInnotasformatter.format(date)
}
//Written for Boomi with properties set

//import java.util.Properties;
//import java.io.InputStream;
//import com.boomi.execution.ExecutionManager;
//import com.boomi.execution.ExecutionUtil;


//import java.text.DateFormat
//import java.text.SimpleDateFormat

//
//logger = ExecutionUtil.getBaseLogger();
//
//def today = ExecutionManager.getCurrent().getProperty( "taskStartDate" )
//def setDay = ExecutionManager.getCurrent().getProperty( "setDay" )
//setDayInt = Integer.parseInt(setDay)
//
////Set day in milliseconds
//def oneDay = 86400000
////set input formatter
//def innotasformatter = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" );
////set output formatter
//def newInnotasformatter = new SimpleDateFormat( "MM/dd/yyyy hh:mm:ss aa z" );
//
////set default date
//Date date;
//
//def updatedTaskDate
//def startDay
//def innotasTaskDate
////Convert date to milliseconds and add passed in day
//if (today) {
//    date = innotasformatter.parse(today);
//    outDate = newInnotasformatter.format(date)
//    long milliDate = date.time
//    long endMilli = milliDate + (oneDay * setDay)
//
//    date = new Date(endMilli)
//    innotasTaskDate = date
//    if(setDay>0) {
//        updatedTaskDate = newInnotasformatter.format(date)
//    }
//}
//ExecutionManager.getCurrent().setProperty( "innotasTaskDate", startDay )
//ExecutionManager.getCurrent().setProperty( "updatedTaskDate", updatedTaskDate )
//
//
//for( int i = 0; i < dataContext.getDataCount(); i++ ) {
//    InputStream is = dataContext.getStream(i);
//    Properties props = dataContext.getProperties(i);
//
//    dataContext.storeStream(is, props);
//}
