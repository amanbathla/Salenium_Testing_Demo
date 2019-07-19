set projectLocation=C:\Users\AmanBathla\Downloads\AMHI Selenium\AMHI Selenium\Apollo_Demo\Apolo_Demo\com.ibm.ApolloDemo\com.ibm.ApolloDemo
cd %projectLocation%
set classpath=%projectLocation%\target\*;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause