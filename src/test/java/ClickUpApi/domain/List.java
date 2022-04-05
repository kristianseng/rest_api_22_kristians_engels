package ClickUpApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class List {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("task_count")
    private String taskCount;
    @JsonProperty("folder")
    private void getFolderId(Map<String,String> folder) {
        folderId = folder.get("id");
    }

    public String folderId;

    public String getFolderId() {return this.folderId;}

    public void setName(final String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(final String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(final String taskCount) {
        this.taskCount = taskCount;
    }
}