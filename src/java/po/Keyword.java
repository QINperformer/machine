package po;
// Generated 2017-6-4 21:32:42 by Hibernate Tools 4.3.1



/**
 * Keyword generated by hbm2java
 */
public class Keyword  implements java.io.Serializable {


     private Integer id;
     private Operation operation;
     private String word;

    public Keyword() {
    }

    public Keyword(Operation operation, String word) {
       this.operation = operation;
       this.word = word;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Operation getOperation() {
        return this.operation;
    }
    
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    public String getWord() {
        return this.word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }




}

