//import com.boomi.execution.ExecutionUtil;
//
//
//import com.boomi.execution.ExecutionManager

import java.text.ParseException
import java.text.SimpleDateFormat

//def someDt = ExecutionManager.getCurrent().getProperty( "taskCompleteDate" )

def taskCompleteDate = "20141202 130022"

//def innotasDt = taskCompleteDate.replace("T"," ")


Date parsedDate = null
def  newParsedDate = null
taskCompleteDate = taskCompleteDate.replace("T"," ")
try {


    if( taskCompleteDate ==null || taskCompleteDate =="" ) {
        parsedDate = null
    }
    else {
        SimpleDateFormat inFt= new SimpleDateFormat ( "yyyyMMdd HHmmss");

        parsedDate = inFt.parse( taskCompleteDate )
        inFt.applyPattern("MM/dd/yyyy hh:mm:ss a");

        newParsedDate = inFt.format(parsedDate);
        println newParsedDate

    }

}
catch (ParseException e) {
}

println newParsedDate
