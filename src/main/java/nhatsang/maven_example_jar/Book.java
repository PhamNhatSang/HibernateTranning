package nhatsang.maven_example_jar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "books")
public class Book{
    @Id
    @GeneratedValue
    private int id;
   
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    public Book() {}
    
  
	
	

    
}

