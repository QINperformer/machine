package po;
// Generated 2017-6-22 15:57:11 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Idea generated by hbm2java
 */
public class Idea  implements java.io.Serializable {


     private Integer iid;
     private String ideamessage;
     private Date ideaTime;

    public Idea() {
    }

	
    public Idea(String ideamessage) {
        this.ideamessage = ideamessage;
    }
    public Idea(String ideamessage, Date ideaTime) {
       this.ideamessage = ideamessage;
       this.ideaTime = ideaTime;
    }
   
    public Integer getIid() {
        return this.iid;
    }
    
    public void setIid(Integer iid) {
        this.iid = iid;
    }
    public String getIdeamessage() {
        return this.ideamessage;
    }
    
    public void setIdeamessage(String ideamessage) {
        this.ideamessage = ideamessage;
    }
    public Date getIdeaTime() {
        return this.ideaTime;
    }
    
    public void setIdeaTime(Date ideaTime) {
        this.ideaTime = ideaTime;
    }




}


