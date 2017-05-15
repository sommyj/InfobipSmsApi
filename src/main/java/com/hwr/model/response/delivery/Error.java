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
public class Error {
    private int groupId;
    private String groupName;
    private int id;
    private String name;
    private String description;
    private boolean permanent;

    public Error() {
    }

    public Error(int groupId, String groupName, int id, String name, String description, boolean permanent) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.id = id;
        this.name = name;
        this.description = description;
        this.permanent = permanent;
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

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    @Override
    public String toString() {
        return "Error{" + "groupId=" + groupId + ", groupName=" + groupName + ", id=" + id + ", name=" + name + ", description=" + description + ", permanent=" + permanent + '}';
    }
    
    
}
