## Run Against Chrome
mvn clean test -Dbrowser=chrome -Durl="http://automationpractice.com/index.php"

## Run Against Firefox
mvn clean test -Dbrowser=firefox -Durl="http://automationpractice.com/index.php"


- logging -- Take care using lo4j

- taking screenshot on failed tests --Taken Care in hooks

- generation human readable report; -- cucumber reports 

- generating random values for insignificant test data, for example, for new user; --common utils

- WebDriver factory -- Taken Care

- encapsulation layers like test data, logic of tests, actions on web pages and so on - Taken care

- configurator:

 -- run tests in parallel mode;

 -- ability to run tests for different browsers/OS by configuring (we are working with OS);-- Yes same can be achieved for OS

 -- ability to run tests for different environments(urls) by configuring/by command-line. --Taken care

 -- reading test data from file, for example, the name of dress, size and color in the checkout test. -- Cucumber feature

