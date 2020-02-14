# ALM Integration Java
A powerful & easy to use Test Automation Framework

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=alm-integration-java)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=ncloc)](https://sonarcloud.io/dashboard?id=alm-integration-java)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=alm-integration-java)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=alm-integration-java)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=security_rating)](https://sonarcloud.io/dashboard?id=alm-integration-java)
![CircleCI](https://img.shields.io/circleci/build/github/kaapiel/ALMIntegration-Java/master)
[![API](https://img.shields.io/badge/API-26%2B-green.svg?style=flat)](https://android-arsenal.com/api?level=26)

## Table of Contents
1. [Quick Start](#quick-start)
1. [Example usage](#examples)
1. [Questions](#report)
1. [Donate](#donate)
1. [License](#licence)
1. [Creators](#creators)

<h2 id="quick-start">Quick Start :chart_with_upwards_trend:</h2>
add your test cases on the framework to automate it!

<br/>

## ALM Integration Java

This is a Test Automation Framework (java) using ALM from HP. Through this framework you can create new 'Runs', 
update 'Test Instance' status, upload evidences and etc.

#### With This framework you can test: ####
* WEB
* WEBSERVICES
* MOBILE
* DATA BASE
* MAINFRAME

## Before we get started ##

* 1 - HMLEnv|TIEnv & NEW|OLD params
* 2 - XML Settings file - alm project, credentials...
* 3 - Estruturas & Tecnologias
* 4 - Estruturas de suites e testes
* 5 - Estruturas de execuções
* 6 - Evidências

## 1 - HMLEnv|TIEnv & NEW|OLD params ##

We use on this project XML files to define all kind of constants or mutable variables. 
Notice that there is two files in the structure, one called HMLEnv.xml and another one called TIEnv.xml. In this files
there is environment configurations (QA and integrated tests respectively). In case you need create more environment configuration files only follow the same model.

Notice also that there are two files, one called oldALM.xml and another one called newALM.xml. In these files we can find the 'test set id' from the ALM test suits. In case there is another ALM versions you can create new files.

- HMLEnv | TIEnv - In this XML we have the following information:
	- MainFrame
		- Credenciais
		- IP | PORTA
	- Banco de dados
		- Credenciais
		- IP | PORTA
	- Identificadores web
		- Credenciais
		- XPaths, Ids, etc
	- Identificadores web services
		- Credenciais | Client id
		- Endpoints
		
- newALM | oldALM - In this XML we have the following information:
	-  Sprint
		- Estória
			- Test Set Id
			
After execute the '.jar'generated file (it generate a file with all internal dependencies) you can pass theparameters of environment and ALM version to be run.

#### Ex.: 'java -jar JarName.java HMLEnv NEW'. ####
After create your tags structure of the ALM file (old or new), access http://pojo.sodhanalibrary.com/ to generate java objects and place it on the customization package.
			
			
			
## 2 - XML Settings File ##

On Settings.xml file you can find all projects general configuration. On the first tag called 'Env' you can find the test  environment value where we will execute our tests. This value must be excactly the files name, e.g. HMLEnv.

- Settings - In this XML we have the following information:
	- Enviroment
	- Configurations
		- ALM Configurations
			- Credenciais
			- Configurações
		- Evicências
			- Configurações
		- Email
			- Credenciais
			- HOST | PORTA
		- Paths
		- Mensagens



## 3 - Estruturas & Tecnologias ##

These are the technologies and structure used in this project:

+ Java 8, Log4j, JUnit, Apache POI, AShot QATools
+ Maven, Maven Assembly Plugin - jar-with-dependencies
+ Selenium, Serenity BDD, Appium
+ Hibernate, JDBC
+ PW3270 - Windows
- Notice that exist an ojdbc error on project. To solve it it is necessary to execute the following commandon the project directory:
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar -Dfile=./ojdbc8.jar -DgeneratePom=true


## 4 - Test Suits Structure ##

To the framework work properly, It is necessary some patterns:

- Test case (class) - SPRINTxx_ESTORIAxx_CTxxx.java
- Test suit (class) - Suit_SPRINTxx_ESTORIAxx.java


- All tests (@ Test) must inherit CustomerTestCase (that contain all @ Before and @ After methods) to manage the ALM integration (pass tests, upload evidencie, etc).
- On the end of each step (@ Step) it must use the ALM steps update method - updateRunStepStatus(getRunIdsList().get(stepOrder++)); Beyond that inside every exception treatment it must update the test (failed or passed) - currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
- All tests must contain @ Step("Step Description")



## 5 - Executions and Structure ##

Test Suit execution must be run through the following class:
#### PlayTestCases.java ####
- This class is responsible for execute all tests from suit. It will show only the results and evidences on ALM if executed directly from this class.
- Executed tests "unity" will notreflect on ALM, only on local evidences.
- Through the playSuit(testSetId, SuitClass) method the test is run. Use this method inside the void try catch of the PlayTestCases.java class



## 6 - Evidences ##

In execution time the evicences 'prints' are generated and stored on the folder called 'evidencias'.
After finish each test, generates a word (.odt) file with a predefined template.
In this file you can find all test 'prints' that the framework generated to create the evidences.

- On the Suit Test finish, it creates a folder called "evidenciasConsolidadas". Inside this folder is possible to see all executed test suits. It is also possible to see individualy each evidence separeted by "PASSED" or "FAILED" folders.
- On the end of all Test Suit is generated an excel file with all execution data: tests time, test passed percentage, error stacktrace, messages and so. This file is send automatically by email configured on the setting file.

## ADB ##

The mobile tests must be executed on command line through java. 
You can also run mobile tests on phisical devices without usb cable.
To get more commands, access http://adbshell.com/commands.
Following you can find some useful ABD commands (android):

- adb devices | adb tcpip 5555 | adb connect #.#.#.#
- adb shell input text "insert%syour%stext%shere"
- adb shell 'pm list packages -f |grep packageName
- adb shell monkey -p your.app.package.name -c android.intent.category.LAUNCHER 1

<h2 id="report">Questions & Issues :thinking:</h2>

This repository's issue tracker is only for bugs and feature requests.  

<br/>

<h2 id="donate">Donations :heart:</h2>

*This project needs you!* If you would like to support this project's further development, the creator of this project or the continuous maintenance of this project, *feel free to donate*. Your donation is highly appreciated (and I love food experiences). Thank you!

*PayPal*

- Do you ever though about paying a coffee, lunch or dinner for maintaining the project? [*So please click on this link*](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=gabriel_aguido@hotmail.com&lc=US&item_name=Donation+to+ALM+Integration+Java+Maintenance&no_note=0&cn=&currency_code=USD&bn=PP-DonationsBF:btn_donateCC_LG.gif:NonHosted), all donations are awesome!

<br/>

<h1 id="license">License :page_facing_up:</h1>

Copyright 2019 Gabriel Aguido Fraga

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

<br/>

<h2 id="creators">Special Thanks :heart:</h2>

These people rock!

- [Bruno Oshiro](https://www.linkedin.com/in/bruno-oshiro-nakamato-634a02b7) - Who thusted me to develop this solution to his project
- [Fernando Nascimento](https://www.linkedin.com/in/fernando-nascimento-89356542) - Who helped me developed and maintain this project
