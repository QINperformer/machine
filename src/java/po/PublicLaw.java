package po;
// Generated 2017-6-22 15:00:49 by Hibernate Tools 4.3.1



/**
 * PublicLaw generated by hbm2java
 */
public class PublicLaw  implements java.io.Serializable {


     private Integer lid;
     private String strip;
     private String genre;
     private String content;

    public PublicLaw() {
    }

    public PublicLaw(String strip, String genre, String content) {
       this.strip = strip;
       this.genre = genre;
       this.content = content;
    }
   
    public Integer getLid() {
        return this.lid;
    }
    
    public void setLid(Integer lid) {
        this.lid = lid;
    }
    public String getStrip() {
        return this.strip;
    }
    
    public void setStrip(String strip) {
        this.strip = strip;
    }
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }




}


