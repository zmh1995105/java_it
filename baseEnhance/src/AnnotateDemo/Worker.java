package AnnotateDemo;

@MyAnno(show1=1, per=Person.P1,
        anno2 = @MyAnno2, str2 = {"j", "b"})
@MyAnno3
public class Worker {
    @MyAnno3
    public void show(){};
    @MyAnno3
    public String name = "Jason";

}
