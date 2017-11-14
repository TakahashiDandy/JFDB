# JFDB
Java Framework Database Connection. MySQL Java Framework.
is a lightweight, Robust, and Simple.

For you who are too tired for making MySQL connection. This is for you.

Beta Version Ongoing.

Usage in java code for connection:
Import TakahashiJFDB.jar
JFDBConfiguration config = new JFDBConfiguration(
                "Your Database Host", 
                "Your Database Username", 
                "Your Database password", 
                "Your Database Name");
JFDBCommand command = new JFDBCommand(config.getConnection());

Usage in java for DML:
String[] insertValues = {"63123","Takahashi", "Dandy"};
command.insertData("tablename",insertValues);

String[] ColumnTable = {"FirstName", "LastName"};
String[] UpdateValue = {"Takahashi", "Dandy"};
String whereClause = "employeenumber = 63123";
command.updateData("tablename",ColumnTable, UpdateValue, whereClause);

String whereClause = "employeenumber = 63123";
command.deleteData("tablename", whereClause);
