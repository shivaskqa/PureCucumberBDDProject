package com.virtusa.bdd.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(features= {"src\\main\\java\\com\\virtusa\\bdd\\features"},
glue= {"com.virtusa.bdd.stepdefinitions"},
monochrome=true,
tags= "@logintest,@companytest,@contacttest",
plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
dryRun=false)


public class TestRunner {
	
	
	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\virtusa\\bdd\\config\\extent-config.xml"));
	 }	
	

}
