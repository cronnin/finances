package com.financesm.core;

import com.financesm.core.annotation.CampoDB;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by diogo.coelho on 07/04/2017.
 */

public class Util {

    public static String retornaMetodoName(String name){
        return name.substring(0,1).toUpperCase() + name.substring(1);
    }

    public static Long getDateValue(Class clazz, String fieldName, Object registro) {
        Date ret = null;
        try{
            ret = (Date)clazz.getDeclaredMethod("get" + Util.retornaMetodoName(fieldName), Date.class).invoke(registro);
        }
        catch (NoSuchMethodException ex){}
        catch (InvocationTargetException e) {}
        catch (IllegalAccessException e) {}

        if(ret != null)
            return ret.getTime();
        else
            return null;
    }

    public static Double getDoubleValue(Class clazz, String fieldName, Object registro) {
        Double ret = null;
        try{
            ret = (Double)clazz.getDeclaredMethod("get" + Util.retornaMetodoName(fieldName), Double.class).invoke(registro);
        }
        catch (NoSuchMethodException ex){}
        catch (InvocationTargetException e) {}
        catch (IllegalAccessException e) {}
        return ret;
    }

    public static Long getLongValue(Class clazz, String fieldName, Object registro) {
        Long ret = null;
        try{
            ret = (Long)clazz.getDeclaredMethod("get" + Util.retornaMetodoName(fieldName), Long.class).invoke(registro);
        }
        catch (NoSuchMethodException ex){}
        catch (InvocationTargetException e) {}
        catch (IllegalAccessException e) {}
        return ret;
    }

    public static String getStringValue(Class clazz, String fieldName, Object registro) {
        String ret = null;
        try{
            ret = (String)clazz.getDeclaredMethod("get" + Util.retornaMetodoName(fieldName), String.class).invoke(registro);
        }
        catch (NoSuchMethodException ex){}
        catch (InvocationTargetException e) {}
        catch (IllegalAccessException e) {}
        return ret;
    }

    public static List<CampoForm> getCampos(Class clazz){
        Field[] campos = clazz.getDeclaredFields();
        List<CampoForm> result = new ArrayList<CampoForm>();
        CampoDB c;
        for(Field f : campos) {

            c = f.getAnnotation(CampoDB.class);
            if (c != null) {
                result.add(new CampoForm(c, f.getName()));
            }
        }
        return result;
    }
}
