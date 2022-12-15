package com.qa.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants 
{
public static final String REGISTER_PAGE_TITLE = "Register Account";
public static final String REGISTER_PAGE_URL_FRACTION = "route=account/register"; 

public static final String LOGIN_PAGE_TITLE = "Account Login";
public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";

public static final String ACCOUNTS_PAGE_TITLE = "Register Account";


public static final int DEFAULT_TIME_OUT = 5;

public static List<String> expectedAccountSectionList()
{
	List<String> expSectionAccList = new ArrayList<String>();
	expSectionAccList.add("My Account");
	expSectionAccList.add("My Orders");
	expSectionAccList.add("My Affiliate Account");
	expSectionAccList.add("Newsletter");
	return expSectionAccList;
}

}
