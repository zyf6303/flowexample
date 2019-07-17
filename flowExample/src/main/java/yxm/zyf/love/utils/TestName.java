package yxm.zyf.love.utils;

import java.lang.reflect.Field;

public class TestName {
    
   // private final static String templateModel="{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}";//模板
    
    private final static String templateinfo="{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}";//信息
    
    public static Object getObjectPropertyValue(Object obj,String propertyName)throws Exception{
        Field field=obj.getClass().getField(propertyName);
        return field.get(obj);
    }
    
    public static void main(String[] args) throws Exception {
        dataObject da=new dataObject("test");
        System.out.println(getObjectPropertyValue(da, "name"));
    }
   
}
class dataObject{
    public String name;
    dataObject(String s){
        this.name=s;
    }
    
    
}


class templateshow{
    public String propertyKey;
    
    public String inKey;
    
    
    
}