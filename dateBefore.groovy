import java.text.SimpleDateFormat


String sprint = "com.atlassian.greenhopper.service.sprint.Sprint c539552[name=GVaR2 - 20130906,closed=true,startDate=2013-08-23T12:29:27.562-04:00,endDate=2013-09-06T12:29:27.562-04:00,completeDate=2013-09-09T11:27:07.485-04:00,id=287]"//ExecutionManager.getCurrent().getProperty( "sprint" )
String jiraStartDate = "2013-12-06T16:05:34.000-0500"//ExecutionManager.getCurrent().getProperty( "jiraStartDate" )
sprint = sprint.substring(sprint.indexOf("endDate=") + 8, sprint.indexOf("completeDate="))
boomiDt = sprint.replaceAll("T", " ")

jiraStartDate = jiraStartDate.replaceAll("T", " ")

SimpleDateFormat boomiformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
def innotasformatter = new SimpleDateFormat("MM/dd/yyyy");
Date parsedDate = boomiformatter.parse(boomiDt);
Date startParsedDate = boomiformatter.parse(jiraStartDate);

if (startParsedDate.after(parsedDate)) {
    sprint = "null"
} else {
    sprint = innotasformatter.format(parsedDate);
}
print sprint
