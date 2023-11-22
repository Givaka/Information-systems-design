package com.example.isd;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class UserResourceParser {
    private ArrayList<User> users;

    public UserResourceParser(){
        users = new ArrayList<>();
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public boolean parse(String xmlData){
        boolean status      = true,
                inEntry     = false;
        User currentUser    = null;
        String textValue    = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

            factory.setNamespaceAware(true);

            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if ("user".equalsIgnoreCase(tagName)){
                            inEntry     = true;
                            currentUser = new User();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(inEntry){
                            if ("user".equalsIgnoreCase(tagName)){
                                users.add(currentUser);
                                inEntry     = false;
                            } else if ("name".equalsIgnoreCase(tagName)) currentUser.setName(textValue);
                            else if ("age".equalsIgnoreCase(tagName)) currentUser.setAge(textValue);
                        }
                    break;
                    default:
                }
                eventType = xpp.next();
            }
        } catch (Exception e){
            status = false;
            e.printStackTrace();
        }

        return status;
    }
}
