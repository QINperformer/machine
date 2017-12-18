package po;
// Generated 2017-6-4 21:32:42 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Operation generated by hbm2java
 */
public class Operation  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String sentenceClass;
     private String operationClass;
     private Set keywords = new HashSet(0);

    public Operation() {
    }

	
    public Operation(String name, String sentenceClass) {
        this.name = name;
        this.sentenceClass = sentenceClass;
    }
    public Operation(String name, String sentenceClass, String operationClass, Set keywords) {
       this.name = name;
       this.sentenceClass = sentenceClass;
       this.operationClass = operationClass;
       this.keywords = keywords;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getSentenceClass() {
        return this.sentenceClass;
    }
    
    public void setSentenceClass(String sentenceClass) {
        this.sentenceClass = sentenceClass;
    }
    public String getOperationClass() {
        return this.operationClass;
    }
    
    public void setOperationClass(String operationClass) {
        this.operationClass = operationClass;
    }
    public Set getKeywords() {
        return this.keywords;
    }
    
    public void setKeywords(Set keywords) {
        this.keywords = keywords;
    }




}


