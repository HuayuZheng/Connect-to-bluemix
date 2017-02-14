package com.example.s162077.helloworld;

import android.content.Context;

import com.cloudant.sync.documentstore.DocumentRevision;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by s162077 on 11-02-2017.
 */

public class Coordinate {
    private double x;
    private double y;
    private double z;

    private DocumentRevision rev;
    public DocumentRevision getDocumentRevision() {
        return rev;
    }

    private String type = DOC_TYPE;
    static final String DOC_TYPE = "com.cloudant.sync.example.task";//??????????????
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
/*
    private boolean completed;
    public boolean isCompleted() {
        return this.completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private String description;
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String desc) {
        this.description = desc;
    }

     @Override
    public String toString() {
        return "{ desc: " + getDescription() + ", completed: " + isCompleted() + "}";
    }
    */
    //??????????????

    public Map<String, Object> asMap() {
        // this could also be done by a fancy object mapper
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("x", getX());
        map.put("y", getY());
        map.put("z", getZ());
        return map;
    }

    public static Coordinate fromRevision(DocumentRevision rev) {
        Coordinate c = new Coordinate();
        c.rev = rev;
        // this could also be done by a fancy object mapper
        Map<String, Object> map = rev.getBody().asMap();
        if (map.containsKey("type") && map.get("type").equals(Coordinate.DOC_TYPE)) {
            c.setType((String) map.get("type")); //type到底是什么值啊
            return c;
        }
        return null;
    }

    public double getX() { return x;  }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
