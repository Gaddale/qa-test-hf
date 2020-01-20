# Web-Automation-Test Challenge

## Tools used

* Selenium, Cucumber and TestNG
* Log4J for logging
* Cucumber html for reporting

## Execution

* Default browser is `chrome` and default url is `http://automationpractice.com/index.php` 
* Run against chrome `mvn verify -Dbrowser='chrome'` 
* Run against firefox `mvn verify -Dbrowser='firefox'` 
* Run against specific url `mvn verify -Dbrowser='chrome' -Durl='https://google.co.in'`

## Logging

* Captured logging under file `log/logging.log`

## Reporting

* Cucumber html reports `target/cucumber-html-reports/overview-features.html`

## Note(Challenges in achieving parallel execution)

* Tried using `Cucumber & Junit` with `maven-surefire-plugin`. I am able to achieve parallel execution, but it was very flaky.
* Tried using `TestNGCucumberRunner` with `TestNG.xml`. I am able to launch 3 threads of browser instances, but the execution was 
  happening on only one browser instance, because `Webdriver` object is static. This can be fixed using `ThreadLocal` implementation.
* Parallel execution needs lot of exploration which in turn will consume lot of time.
* I had achieved parallel execution in my previous company using tools `Cucumber, Capybara and Ruby` with `Selenium grid` and it was working flawlessly.    
