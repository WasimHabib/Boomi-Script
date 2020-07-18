package json.date
//Service Now to Innotas date formatter
//print out empty string if null
import java.text.SimpleDateFormat

def boomiDateMasks = "yyyy-MM-dd HH:mm:ss"

//def someDt = "20131120 153022.22282"
//def innotasformatter = new SimpleDateFormat( "yyyyMMdd hhmmss.SSSSS" );
def someDt// = "2014-01-06 05:00:00"

def innotasformatter = new SimpleDateFormat( "MM/dd/yyyy hh:mm:ss" );
innotasformatter.setTimeZone( TimeZone.getTimeZone( "PST" ) );

SimpleDateFormat boomiformatter = new SimpleDateFormat( boomiDateMasks);
boomiformatter.setTimeZone( TimeZone.getTimeZone( "PST" ) );
def parsedDate
def innotasDt
if(someDt){
 parsedDate = boomiformatter.parse( someDt );
 innotasDt = innotasformatter.format( parsedDate );
}else {
    innotasDt = ""
}

println innotasDt
