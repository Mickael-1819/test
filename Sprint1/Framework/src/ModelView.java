package etu1819.framework;

import java.util.HashMap;

public class ModelView{
    String view;
    HashMap<String, Object> data = new HashMap<String, Object>();
    HashMap<String, Object > session = new HashMap<String, Object>();
    boolean isJson = false;
    boolean isInvalidate = false;
    String [] toInvalidate;

    public ModelView() {
    }
    

    // _ _ _ Methods _ _ _

    public void addSessionItem(String key, Object value){
        this.session.put(key, value);
    }

    public void addItem(String key, Object value){
        this.data.put(key, value);
    }


    // _ _ _ get set _ _ _ 
    

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }


    public HashMap<String, Object> getData() {
        return data;
    }


    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }


    public HashMap<String, Object> getSession() {
        return session;
    }


    public void setSession(HashMap<String, Object> session) {
        this.session = session;
    }


    public boolean getIsJson() {
        return isJson;
    }


    public void setIsJson(boolean isJson) {
        this.isJson = isJson;
    }


    public void setJson(boolean isJson) {
        this.isJson = isJson;
    }


    public boolean getIsInvalidate() {
        return isInvalidate;
    }


    public void setIsInvalidate(boolean isInvalidate) {
        this.isInvalidate = isInvalidate;
    }


    public String[] getToInvalidate() {
        return toInvalidate;
    }


    public void setToInvalidate(String[] toInvalidate) {
        this.toInvalidate = toInvalidate;
    }
    
}