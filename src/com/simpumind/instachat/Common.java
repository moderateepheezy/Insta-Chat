package com.simpumind.instachat;

import java.util.ArrayList;
import java.util.List;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Patterns;

public class Common extends Application{
	public static String[] email_err;
	public static SharedPreferences prefs;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		List<String> emailList = getEmailList();
		
		email_err = emailList.toArray(new String[emailList.size()]);
	}

	private List<String> getEmailList() {
		// TODO Auto-generated method stub
		List<String> lst = new ArrayList<String>();
		Account[] accounts =  AccountManager.get(this).getAccounts();
		for(Account account : accounts){
			if(Patterns.EMAIL_ADDRESS.matcher(account.name).matches()){
				lst.add(account.name);
			}
		}
		return lst;
	}
}
