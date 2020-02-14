# Framework de automação de testes em Java
A powerful & easy to use Test Automation Framework

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=alm-integration-java)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=ncloc)](https://sonarcloud.io/dashboard?id=alm-integration-java)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=alm-integration-java)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=alm-integration-java)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=alm-integration-java&metric=security_rating)](https://sonarcloud.io/dashboard?id=alm-integration-java)
![CircleCI](https://img.shields.io/circleci/build/github/kaapiel/ALMIntegration-Java/master)

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

## 3 - Estruturas & Tecnologias ##

These are the technologies and structure used in this project:

+ Java 8, Log4j, JUnit, Apache POI, AShot QATools
+ Maven, Maven Assembly Plugin - jar-with-dependencies
+ Selenium, Serenity BDD, Appium
+ Hibernate, JDBC
+ PW3270 - Windows
- Notice that exist an ojdbc error on project. To solve it it is necessary to execute the following commandon the project directory:
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar -Dfile=./ojdbc8.jar -DgeneratePom=true

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

<h1 id="license">License :page_facing_up:</h1>

Copyright 2020 QAlenium

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
