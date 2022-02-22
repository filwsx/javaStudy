package com.filwsx.JavaStudyAdvanced.Annotation;

/**
 * @author filwsx
 * @date 2022-02-22 16:30
 */
public class Boy {
    private Long id;

    public Boy(){
        this.id = 198419890604L;
    }

    public Boy(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }
}
