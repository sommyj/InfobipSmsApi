/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hwr.model.response.send;

/**
 *
 * @author somto
 */
public class Status {
    private int groupId;
    private String groupName;
    private int id;   
    private String name;
    private String description;
    private String action;

    public Status() {
    }

    public Status(int id, int groupId, String groupName, String name, String description, String action) {
        this.id = id;
        this.groupId = groupId;
        this.groupName = groupName;
        this.name = name;
        this.description = description;
        this.action= action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
        return "Status{" + "groupId=" + groupId + ", groupName=" + groupName + ", id=" + id + ", name=" + name + ", description=" + description + ", action=" + action + '}';
    }
    
}
