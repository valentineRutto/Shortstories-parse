package com.moringaschool.shortstories;
import com.parse.ParseClassName;

import com.parse.ParseObject;

/**
 * Created by valentine on 7/28/15.
 */
@ParseClassName("shortstories")
public class Shortstories extends ParseObject {
    public String getCategory(){
        return getString("Category");
    }
public void setCategory(String Category){
    put("Category",Category);
}

    public String getTitle() {
        return getString("title");
    }
public  void setTitle(String title)
    {
put("title",title);
    }
    public String getStory(){
        return getString("stories");
    }
    public void setStory(String Story){
        put("stories",Story);}
@Override
public String toString(){
return getString("Category")+"\n"+getString("title")+
        "\n"+getString("stories");
}


}


