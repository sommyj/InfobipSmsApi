/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.model.response.delivery;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author somto
 */
//@XmlRootElement
public class Status {
    private int groupID;
    private String groupName;
    private int id;
    private String name;
    private String description;
    private String action;

    public Status() {
    }

    public Status(int groupID, String groupName, int id, String name, String description, String action) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.id = id;
        this.name = name;
        this.description = description;
        this.action = action;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Status{" + "groupID=" + groupID + ", groupName=" + groupName + ", id=" + id + ", name=" + name + ", description=" + description + ", action=" + action + '}';
    }
    
    
}
